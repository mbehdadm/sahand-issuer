package com.sahand.issuer.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.issuer.config.TLVParse;
import com.sahand.issuer.data.MissingTransactionInformation;
import com.sahand.issuer.enumeration.MissingTransactionStatus;
import com.sahand.issuer.enumeration.ProcessCode;
import com.sahand.issuer.enumeration.TLV;
import com.sahand.issuer.exception.IssuerException;
import com.sahand.issuer.model.MemberCard;
import com.sahand.issuer.model.MissingTransaction;
import com.sahand.issuer.model.MissingTransactionId;
import com.sahand.issuer.model.Transaction;

@Stateless
public class MissingTransactionManagement {
	

	private static Logger logger = SahandLogger.getSahandLogger(MemberManagementImpl.class);
	
	@Inject
	@AcquirerRepository
	EntityManager entityManager;
	
	@EJB
	private MemberCardManagementImpl memberCardManagementImpl;
	@EJB
	private TransactionManagement transactionManagement;

	public MissingTransactionInformation convertFrom(MissingTransaction missingTransaction,
			MissingTransactionInformation missingTransactionInformation
			) {
		if (missingTransactionInformation == null)
			missingTransactionInformation = new MissingTransactionInformation();
		
		

	}

	public MissingTransaction convertFrom(MissingTransactionInformation missingTransactionInformation,MissingTransaction missingTransaction) 
	{
		if (missingTransaction == null)
			missingTransaction = new MissingTransaction();
		
		String refrenceData = createRefrenceData(missingTransactionInformation);
		logger.info(" refrence data is ************ " + refrenceData);
		missingTransaction.setMissProgramRefrenceData(refrenceData);
		missingTransaction.setMissProgramId(missingTransactionInformation.getMissProgramId());
		
		missingTransaction.setMissAmount(missingTransactionInformation.getMissAmount());
		missingTransaction.setMissCardAcceptorId(missingTransactionInformation.getMissCardAcceptorId());
		missingTransaction.setMissTerminalId(missingTransactionInformation.getMissTerminalId());
		missingTransaction.setMissMTI(missingTransactionInformation.getMissMTI());
		missingTransaction.setMissPan(missingTransactionInformation.getMissPan());
		missingTransaction.setMissProcessCode(missingTransactionInformation.getMissProcessCode());
		missingTransaction.setMissDescription(missingTransactionInformation.getMissDescription());
//		missingTransaction.setMissStatus(missingTransactionInformation.getMissStatus());
//		missingTransaction.setMissStatusDate(new Date(System.currentTimeMillis()));
		missingTransaction.setMissStatusDate(missingTransactionInformation.getMissStatusDate());
		missingTransaction.setMissDateLocalTransaction(missingTransactionInformation.getMissDateLocalTransaction());
		
		return missingTransaction;
	}
	
	public MissingTransaction create(MissingTransactionInformation missingTransactionInformation,ProcessCode processCode){

		MissingTransaction missingTransaction = null;
		
		try {

			missingTransaction = checkAndConvertFrom(missingTransactionInformation,
					missingTransaction,
					processCode,
					MissingTransactionStatus.register);

			MissingTransactionId id = new MissingTransactionId();
			id.setMissTransactionDate(new Date(System.currentTimeMillis()));
			missingTransaction.setId(id);

			return missingTransaction;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public MissingTransaction checkAndConvertFrom(MissingTransactionInformation missingTransactionInformation,MissingTransaction missingTransaction,
			ProcessCode processCode,MissingTransactionStatus status) 
	{
		if (missingTransaction == null)
			missingTransaction = new MissingTransaction();
		
		String refrenceData = createRefrenceData(missingTransactionInformation);
		logger.info(" refrence data is ************ " + refrenceData);
		
		missingTransaction.setMissProgramRefrenceData(refrenceData);
		missingTransaction.setMissProgramId(missingTransactionInformation.getMissProgramId());
		
		missingTransaction.setMissAmount(missingTransactionInformation.getMissAmount());
		missingTransaction.setMissCardAcceptorId(missingTransactionInformation.getMissCardAcceptorId());
		missingTransaction.setMissTerminalId("P9999999");
		missingTransaction.setMissMTI(Integer.valueOf(new String("0220")));
		missingTransaction.setMissPan(missingTransactionInformation.getMissPan());
		missingTransaction.setMissProcessCode(Integer.valueOf(String.valueOf(processCode.toValue())));
		missingTransaction.setMissDescription(missingTransactionInformation.getMissDescription());
		missingTransaction.setMissStatus(status.toValue());
		missingTransaction.setMissStatusDate(new Date(System.currentTimeMillis()));
		missingTransaction.setMissDateLocalTransaction(missingTransactionInformation.getMissDateLocalTransaction());
		
		if (!checkFactorNumber(missingTransaction))
			throw new IssuerException("duplicate.FactorNumber.exist");
		
		return missingTransaction;
	}
	
	public boolean isMemberCardDependToInstitute(String pan, String isid, String pgid) {

		MemberCard card = memberCardManagementImpl.getMemberCard(pan, isid , pgid);
		if (card == null)
			return false;
		else
			return  true;
	}
	
	private boolean checkFactorNumber(MissingTransaction missingTransaction) {

		TLVParse pars = new TLVParse();
		String factor = pars.getTarget(missingTransaction.getMissProgramRefrenceData(),TLV.FactorNumber);
		System.out.println("factor is :" + factor);

		if (factor != null) {
			List<Transaction> trnList = transactionManagement
					.checkUniqueFactorNum(
							missingTransaction.getMissTerminalId(),
							missingTransaction.getMissCardAcceptorId(), factor);
			if (!trnList.isEmpty()) {
				logger.info("trnList.size() is :" + trnList.size());
				if (trnList.size() > 0) {
					logger.info("******* FactorNumberIsNotUnique and we cant register this missingTransaction *******");
					throw new IssuerException("duplicate.FactorNumber.exist");
				}
			}
		}
	}

	private String createRefrenceData(
			MissingTransactionInformation missingTransactionInfo) {
		List<String> refrenceDataList = new ArrayList<String>();

		StringBuffer refrenceData = new StringBuffer();

		refrenceDataList.add(missingTransactionInfo.getFactorNumber());
		String factorNum = missingTransactionInfo.getFactorNumber();

		refrenceDataList.add(missingTransactionInfo.getVoucherNumber());
		String voucherNum = missingTransactionInfo.getVoucherNumber();

		refrenceDataList.add(missingTransactionInfo.getIntroducerCardNumber());
		String introducerCardNum = missingTransactionInfo
				.getIntroducerCardNumber();

		refrenceDataList.add(missingTransactionInfo.getNumOfBox());
		String numOfBox = missingTransactionInfo.getNumOfBox();

		refrenceDataList.add(missingTransactionInfo.getPointOfFactor());
		String pointOfFactor = missingTransactionInfo.getPointOfFactor();

		refrenceDataList.add(missingTransactionInfo.getGiftType());
		String giftType = missingTransactionInfo.getGiftType();

		refrenceDataList.add(missingTransactionInfo.getGiftQuantity());
		String giftQuantity = missingTransactionInfo.getGiftQuantity();

		refrenceDataList.add(missingTransactionInfo.getGoodCode());
		String goodCode = missingTransactionInfo.getGoodCode();

		refrenceDataList.add(missingTransactionInfo.getAuthorizerType());
		String authorizerType = missingTransactionInfo.getAuthorizerType();

		refrenceDataList.add(missingTransactionInfo.getPinCharge());
		String pinCharge = missingTransactionInfo.getPinCharge();

		refrenceDataList.add(missingTransactionInfo.getPlaque());
		String plaque = missingTransactionInfo.getPlaque();

		refrenceDataList.add(missingTransactionInfo.getSecondPan());
		String secondPan = missingTransactionInfo.getSecondPan();

		refrenceDataList.add(missingTransactionInfo.getGuaranteeType());
		String guaranteeType = missingTransactionInfo.getGuaranteeType();

		refrenceDataList.add(missingTransactionInfo.getGuaranteeBeginDate());
		String guaranteeBeginDate = missingTransactionInfo
				.getGuaranteeBeginDate();

		refrenceDataList.add(missingTransactionInfo.getGuaranteeEndDate());
		String guaranteeEndDate = missingTransactionInfo.getGuaranteeEndDate();

		refrenceDataList.add(missingTransactionInfo.getGuaranteeLife());
		String guaranteeLife = missingTransactionInfo.getGuaranteeLife();

		refrenceDataList.add(missingTransactionInfo.getGuaranteeSerialNo());
		String guaranteeSerialNo = missingTransactionInfo
				.getGuaranteeSerialNo();

		refrenceDataList.add(missingTransactionInfo
				.getIntervalBetweenInstalment());
		String intervalBetweenInstalment = missingTransactionInfo
				.getIntervalBetweenInstalment();

		refrenceDataList.add(missingTransactionInfo.getPrepayment());
		String prepayment = missingTransactionInfo.getPrepayment();

		refrenceDataList.add(missingTransactionInfo.getAmountOfInstalment());
		String amountOfInstalment = missingTransactionInfo
				.getAmountOfInstalment();

		refrenceDataList.add(missingTransactionInfo.getNumOfInstalment());
		String numOfInstalment = missingTransactionInfo.getNumOfInstalment();

		refrenceDataList.add(missingTransactionInfo.getFirstDateOfPayment());
		String firstDateOfPayment = missingTransactionInfo
				.getFirstDateOfPayment();

		/*
		 * for (String rdf : refrenceDataList ){ if ((rdf != null) &&
		 * (rdf.length() != 0))
		 * 
		 * }
		 */
		if ((factorNum != null) && (factorNum.length() != 0)) {
			refrenceData.append(TLV.FactorNumber.toValue()
					+ String.format("%02d", factorNum.length()) + factorNum);
		}
		if ((voucherNum != null) && (voucherNum.length() != 0)) {
			refrenceData.append(TLV.VoucherNumber.toValue()
					+ String.format("%02d", voucherNum.length()) + voucherNum);
		}
		if ((introducerCardNum != null) && (introducerCardNum.length() != 0)) {
			refrenceData.append(TLV.IntroducerCardNumber.toValue() + ""
					+ String.format("%02d", introducerCardNum.length())
					+ introducerCardNum);
		}
		if ((numOfBox != null) && (numOfBox.length() != 0)) {
			refrenceData.append(TLV.NumberOfBox.toValue() + ""
					+ String.format("%02d", numOfBox.length()) + numOfBox);
		}
		if ((pointOfFactor != null) && (pointOfFactor.length() != 0)) {
			refrenceData.append(TLV.PointOfFactor.toValue() + ""
					+ String.format("%02d", pointOfFactor.length())
					+ pointOfFactor);
		}
		if ((giftQuantity != null) && (giftQuantity.length() != 0)) {
			refrenceData.append(TLV.GiftQuantity.toValue() + ""
					+ String.format("%02d", giftQuantity.length())
					+ giftQuantity);
		}
		if ((giftType != null) && (giftType.length() != 0)) {
			refrenceData.append(TLV.GiftType.toValue() + ""
					+ String.format("%02d", giftType.length()) + giftType);
		}

		if ((plaque != null) && (plaque.length() != 0)) {
			refrenceData.append(TLV.Plaque.toValue() + ""
					+ String.format("%02d", plaque.length()) + plaque);
		}
		if ((pinCharge != null) && (pinCharge.length() != 0)) {
			refrenceData.append(TLV.PinCharge.toValue() + ""
					+ String.format("%02d", pinCharge.length()) + pinCharge);
		}
		if ((authorizerType != null) && (authorizerType.length() != 0)) {
			refrenceData.append(TLV.AuthorizerType.toValue() + ""
					+ String.format("%02d", authorizerType.length())
					+ authorizerType);
		}
		if ((goodCode != null) && (goodCode.length() != 0)) {
			refrenceData.append(TLV.GoodCode.toValue() + ""
					+ String.format("%02d", goodCode.length()) + goodCode);
		}

		if ((secondPan != null) && (secondPan.length() != 0)) {
			refrenceData.append(TLV.whoPanGetPeresent.toValue() + ""
					+ String.format("%02d", secondPan.length()) + secondPan);
		}

		if ((guaranteeType != null) && (guaranteeType.length() != 0)) {
			refrenceData.append(TLV.GuaranteeType.toValue() + ""
					+ String.format("%02d", guaranteeType.length())
					+ guaranteeType);
		}

		if ((guaranteeBeginDate != null) && (guaranteeBeginDate.length() != 0)) {
			refrenceData.append(TLV.GuarantyBeginDate.toValue() + ""
					+ String.format("%02d", guaranteeBeginDate.length())
					+ guaranteeBeginDate);
		}

		if ((guaranteeEndDate != null) && (guaranteeEndDate.length() != 0)) {
			refrenceData.append(TLV.GuarantyEndDate.toValue() + ""
					+ String.format("%02d", guaranteeEndDate.length())
					+ guaranteeEndDate);
		}

		if ((guaranteeLife != null) && (guaranteeLife.length() != 0)) {
			refrenceData.append(TLV.GuarantyLife.toValue() + ""
					+ String.format("%02d", guaranteeLife.length())
					+ guaranteeLife);
		}
		if ((guaranteeSerialNo != null) && (guaranteeSerialNo.length() != 0)) {
			refrenceData.append(TLV.GuarantySerialNo.toValue() + ""
					+ String.format("%02d", guaranteeSerialNo.length())
					+ guaranteeSerialNo);
		}
		if ((intervalBetweenInstalment != null)
				&& (intervalBetweenInstalment.length() != 0)) {
			refrenceData.append(TLV.IntervalBetweenInstalment.toValue()
					+ ""
					+ String.format("%02d", intervalBetweenInstalment.length())
					+ intervalBetweenInstalment);
		}
		if ((prepayment != null) && (prepayment.length() != 0)) {
			refrenceData.append(TLV.Prepayment.toValue() + ""
					+ String.format("%02d", prepayment.length()) + prepayment);
		}
		if ((amountOfInstalment != null) && (amountOfInstalment.length() != 0)) {
			refrenceData.append(TLV.AmountOfInstalment.toValue() + ""
					+ String.format("%02d", amountOfInstalment.length())
					+ amountOfInstalment);
		}
		if ((numOfInstalment != null) && (numOfInstalment.length() != 0)) {
			refrenceData.append(TLV.NumOfInstalment.toValue() + ""
					+ String.format("%02d", numOfInstalment.length())
					+ numOfInstalment);
		}
		if ((firstDateOfPayment != null) && (firstDateOfPayment.length() != 0)) {
			refrenceData.append(TLV.FirstDateOfPayment.toValue() + ""
					+ String.format("%02d", firstDateOfPayment.length())
					+ firstDateOfPayment);
		}
		return refrenceData.toString();
	}
	
	
	public MissingTransaction persist(MissingTransaction miss) {

		logger.info(" persist MissingTransaction ");
		try {
			miss.getId().setMissTransactionId(
					((BigDecimal) entityManager.createNativeQuery(
							"SELECT MISSINGTRN_SEQ.NEXTVAL FROM DUAL")
							.getSingleResult()).longValue());

			entityManager.persist(miss);
			entityManager.flush();
			return miss;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(MissingTransaction missingTransaction){
		try {

			entityManager.merge(missingTransaction);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("MissingTransaction.update.exception");
		}
	}
	
	public void delete(MissingTransaction missingTransaction) {

		try {
	
			entityManager.remove(missingTransaction);
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("MissingTransaction.delete.exception");
		}
	}
	
	public MissingTransaction find(MissingTransactionInformation missingTransactionInformation){
		
		try {
			MissingTransactionId id = new MissingTransactionId();

			if (missingTransactionInformation.getMissTransactionId() == null) 
				throw new IssuerException("Missingtransaction.id.is.Null");
			
			if (missingTransactionInformation.getMissTransactionDate() == null)
				throw new IssuerException("Missingtransaction.date.is.Null");

			id.setMissTransactionDate(missingTransactionInformation.getMissTransactionDate());
			id.setMissTransactionId(missingTransactionInformation.getMissTransactionId());
			MissingTransaction missingTransaction = null;
			missingTransaction = entityManager.find(MissingTransaction.class,id);
			if (missingTransaction == null)
				throw new IssuerException("MissingTransaction.not.found");
			return missingTransaction;
		} catch (IssuerException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("missingTransaction.find.exception");
		}
	}
	
	public MissingTransaction find(MissingTransactionId missingTransactionId){
		try {
		
			MissingTransaction missingTransaction = null;
			missingTransaction = entityManager.find(MissingTransaction.class,missingTransactionId);
			
			return missingTransaction;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MissingTransaction edit(MissingTransactionInformation missingTransactionInformation){

		MissingTransaction missing = find(missingTransactionInformation);

		if (missing.getMissStatus() == MissingTransactionStatus.confirmed.toValue()) 
			throw new IssuerException("aren't.permission.delete.confirmedMissingTransaction");
	
		missing.setMissStatus(MissingTransactionStatus.suspended.toValue());
		
		return missing;
	}
	
	
}
