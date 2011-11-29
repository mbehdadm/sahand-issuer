package com.sahand.issuer.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;

import com.sahand.acquirer.action.AcquirerRepository;
import com.sahand.common.util.SequenceGenerator;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.issuer.config.IssuerConfigLoader;
import com.sahand.issuer.data.CardInformation;
import com.sahand.issuer.exception.IssuerException;
import com.sahand.issuer.model.MemberCard;


@Stateless
public class MemberCardManagementImpl {

	private static Logger logger = SahandLogger.getSahandLogger(MemberCardManagementImpl.class);
	
	@Inject
	@AcquirerRepository
	EntityManager entityManager;


	public CardInformation convertFrom(MemberCard memberCard,CardInformation cardInformation) {
		if(cardInformation == null)
			cardInformation = new CardInformation();
		cardInformation.setCycleBeginDate(memberCard.getCycleBeginDate());
		cardInformation.setCycleLength(memberCard.getCycleLength());
		cardInformation.setExpirationDate(memberCard.getExpirationDate());
		cardInformation.setFloorLimit(memberCard.getFloorLimit());
		cardInformation.setIssueDate(memberCard.getIssueDate());
		cardInformation.setIssueReason(memberCard.getIssueReason());
		cardInformation.setLastTransactionDate(memberCard.getLastTransactionDate());
		cardInformation.setOpenToBuy(memberCard.getOpenToBuy());
		cardInformation.setPan(memberCard.getPan());
		cardInformation.setPanCvv(memberCard.getPanCvv());
		cardInformation.setPanPvv(memberCard.getPanPvv());
		cardInformation.setPinBlock(memberCard.getPinBlock());
		cardInformation.setServiceCode(memberCard.getServiceCode());
		cardInformation.setStatus(memberCard.getStatus());
		cardInformation.setStatusDate(memberCard.getStatusDate());
		cardInformation.setStatusReason(memberCard.getStatusReason());
		cardInformation.setTrack1(memberCard.getTrack1());
		cardInformation.setTrack2(memberCard.getTrack2());
		cardInformation.setTrack3(memberCard.getTrack3());
		return cardInformation;
	}
	
	public MemberCard convertFrom(CardInformation cardInformation,MemberCard memberCard) {
		if(memberCard == null)
			memberCard = new MemberCard();
		memberCard.setCycleBeginDate(cardInformation.getCycleBeginDate());
		memberCard.setCycleLength(cardInformation.getCycleLength());
		memberCard.setExpirationDate(cardInformation.getExpirationDate());
		memberCard.setFloorLimit(cardInformation.getFloorLimit());
		memberCard.setIssueDate(cardInformation.getIssueDate());
		memberCard.setIssueReason(cardInformation.getIssueReason());
		memberCard.setLastTransactionDate(cardInformation.getLastTransactionDate());
		memberCard.setOpenToBuy(cardInformation.getOpenToBuy());
		memberCard.setPan(cardInformation.getPan());
		memberCard.setPanCvv(cardInformation.getPanCvv());
		memberCard.setPanPvv(cardInformation.getPanPvv());
		memberCard.setPinBlock(cardInformation.getPinBlock());
		memberCard.setServiceCode(cardInformation.getServiceCode());
		memberCard.setStatus(cardInformation.getStatus());
		memberCard.setStatusDate(cardInformation.getStatusDate());
		memberCard.setStatusReason(cardInformation.getStatusReason());
		memberCard.setTrack1(cardInformation.getTrack1());
		memberCard.setTrack2(cardInformation.getTrack2());
		memberCard.setTrack3(cardInformation.getTrack3());
		return memberCard;
		
	}

	
	
	public MemberCard edit(CardInformation cardInformation) throws Exception {

		MemberCard memberCard = null;
		try {

			memberCard = find(cardInformation.getPan());
			if(memberCard == null)
				throw new IssuerException("member.card.not.find");

			memberCard = checkAndConvertFrom(cardInformation,memberCard);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return memberCard;
	}
	

	public MemberCard create(CardInformation cardInformation) throws Exception {

		MemberCard memberCard = null;
		try {

			memberCard = checkAndConvertFrom(cardInformation,memberCard);
			
			String pan = "";
			if(cardInformation.isAutoGenerate()){
				MemberCard memberCard_  = new MemberCard();
				while(memberCard_ != null){
//					String key = IssuerConfigLoader.getValue("member-seq");
//					memberID = memberInformation.getMemberId() == null ? new String() : String.valueOf(memberInformation.getMemberId());
//					memberID = SequenceGenerator.sequenceGenerator(entityManager, Members.class, memberID,key);
					memberCard_ = find(pan);
				}
			}
			else{
				MemberCard memberCard_ = find(cardInformation.getPan());
				if(memberCard_ != null)
					throw new IssuerException("duplicate.member.card.exist");
			}
			memberCard.setPan(pan);


		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return memberCard;
	}
	
	
	
	public MemberCard find(String pan) throws Exception {
		MemberCard memberCard = null;
		try {

			memberCard = entityManager.find(MemberCard.class, pan);


		} catch (Exception e) {
			e.printStackTrace();

		}
		return memberCard;
	}

	public void persist(MemberCard memberCard) throws Exception {
		try {

			entityManager.persist(memberCard);
			entityManager.flush();

		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("member.card.persist.exception");

		}
		
	}
	
	public void update(MemberCard memberCard) throws Exception {
		try {

			entityManager.merge(memberCard);


		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("member.card.update.exception");

		}
		
	}
	
	public void delete(String pan) throws Exception {
		MemberCard memberCard = null;
		try {

			memberCard = find(pan);
			if(memberCard == null)
				throw new IssuerException("member.card.not.find");
			entityManager.remove(memberCard);

		} catch (IssuerException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("member.card.delete.exception");

		}
		
	}
	
	public MemberCard checkAndConvertFrom(CardInformation cardInformation,MemberCard memberCard) throws Exception{
		
		if(memberCard == null)
			memberCard = new MemberCard();
		
		memberCard.setCycleBeginDate(cardInformation.getCycleBeginDate());
		memberCard.setCycleLength(cardInformation.getCycleLength());
		memberCard.setExpirationDate(cardInformation.getExpirationDate());
		memberCard.setFloorLimit(cardInformation.getFloorLimit());
		memberCard.setIssueDate(cardInformation.getIssueDate());
		memberCard.setIssueReason(cardInformation.getIssueReason());
		memberCard.setLastTransactionDate(cardInformation.getLastTransactionDate());
		memberCard.setOpenToBuy(cardInformation.getOpenToBuy());
		memberCard.setPan(cardInformation.getPan());
		memberCard.setPanCvv(cardInformation.getPanCvv());
		memberCard.setPanPvv(cardInformation.getPanPvv());
		memberCard.setPinBlock(cardInformation.getPinBlock());
		memberCard.setServiceCode(cardInformation.getServiceCode());
		memberCard.setStatus(cardInformation.getStatus());
		memberCard.setStatusDate(cardInformation.getStatusDate());
		memberCard.setStatusReason(cardInformation.getStatusReason());
		memberCard.setTrack1(cardInformation.getTrack1());
		memberCard.setTrack2(cardInformation.getTrack2());
		memberCard.setTrack3(cardInformation.getTrack3());
		
		logger.debug(memberCard.toString());
		return memberCard;
		
	}

	public MemberCard getMemberCard(String pan) throws Exception {
		MemberCard memberCard = null;

		try {

			memberCard = find(pan);
			if(memberCard == null)
				throw new IssuerException("member.card.not.find");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return memberCard;
	}
	
	public MemberCard getMemberCard(String pan, String isid, String pgid) {

		try {
			String q = " select MEMBRCARD.* from MEMBRCARD,MEMBER where MEMBER.MMID=MEMBRCARD.MMID and MEMBER.ISID in "
					+ "(select isid from PROGPARTNR where PROGPARTNR.pgid = :pgid and PROGPARTNR.PTTYPE=3 and isid= :isid)and MEMBRCARD.MCPAN= :pan";
			Query query = entityManager.createNativeQuery(q, MemberCard.class);
			query.setParameter("pgid", pgid);
			query.setParameter("isid", isid);
			query.setParameter("pan", pan);
			return (MemberCard) (query.getSingleResult());
		
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	
	
//	tempMemberCard.setStatusReason(Byte.parseByte("1"));
//	// set statusReason = New Card Request
//	tempMemberCard.setIssueReason(Byte.parseByte("1"));
//	tempMemberCard.setMemberCardStatusClass(memberCardStatusClass);
//	tempMemberCard.setStatusDate(new Date());
//	tempMemberCard.setIssueDate(new Date());
//	
//	tempMemberCard.setServiceCode(cardTypeHome.getInstance().getDefaultServiceCode().intValue());
//	
//	Calendar now = Calendar.getInstance();
//	if (deliveryDate != null)
//	    now.setTime(deliveryDate);
//	now.add(Calendar.YEAR, +memberCardExpireDuration);
//	tempMemberCard.setExpirationDate(now.getTime());
//	
//	tempMemberCard.setPanCvv(cardUtil.createCardCVV());
//	tempMemberCard.setPanPvv(cardUtil.createCardPVV());
//	
//	// tempMemberCard.setServiceCode(Integer.parseInt(cardUtil.createServiceCode()));
//	tempMemberCard.setServiceCode(cardTypeHome.getInstance()
//				.getDefaultServiceCode().intValue());
//	
//	tempMemberCard.setCardType(memberCardHome.getInstance().getCardType());
//	tempMemberCard.setPan(cardUtil.createCardPan(cardTypeHome
//				.getInstance().getInstitution().getIin(), cardTypeHome
//				.getCardTypeId()
//				+ "", panSeq));
//	
//	SimpleDateFormat dateformat = new SimpleDateFormat("yyMM");
//	tempMemberCard.setTrack1(cardUtil.createCardTrack1(tempMemberCard.getPan(), member.getLatinName(),
//				 (new StringBuilder(dateformat.format(tempMemberCard.getExpirationDate()))).toString(),
//				 tempMemberCard.getServiceCode().toString(),
//				tempMemberCard.getPanPvv(), tempMemberCard.getPanCvv()));
//	
//	tempMemberCard.setTrack2(cardUtil.createCardTrack2(tempMemberCard.getPan(),
//				 (new StringBuilder(dateformat.format(tempMemberCard.getExpirationDate()))).toString(),
//				 tempMemberCard.getServiceCode().toString(),
//				tempMemberCard.getPanPvv(), tempMemberCard.getPanCvv()));
//	
//	
//	
//	
//	
//	
//	
//	




}
