package com.sahand.issuer.action;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;

import com.sahand.common.util.logger.SahandLogger;
import com.sahand.common.util.message.StatusCode;
import com.sahand.issuer.config.DateConvertor;
import com.sahand.issuer.data.MissingTransactionInformation;
import com.sahand.issuer.enumeration.MissingTransactionStatus;
import com.sahand.issuer.enumeration.RegisterarType;
import com.sahand.issuer.exception.IssuerException;
import com.sahand.issuer.initializer.MissingTransactionProcessor;
import com.sahand.issuer.message.IssuerAuthorizerSetupRequest;
import com.sahand.issuer.message.IssuerAuthorizerSetupResponse;
import com.sahand.issuer.message.IssuerSetupResponse;
import com.sahand.issuer.model.MissingTransaction;
import com.sahand.issuer.services.missingTransaction.AuthorizerRequest;
import com.sahand.issuer.services.missingTransaction.AuthorizerResponse;
import com.sahand.issuer.services.missingTransaction.MissingTransactionService;
import com.sahand.issuer.services.missingTransaction.TransactionData;

@Stateless
public class AuthorizerSetupProcessorImpl {

	private static Logger logger = SahandLogger.getSahandLogger(AuthorizerSetupProcessorImpl.class);

	@Resource
	private SessionContext context;
	@EJB
	private MissingTransactionManagement missingTransactionManagement;
	
	private MissingTransaction missingTransaction;

	/**
	 * @param request
	 * @return
	 */
	public IssuerAuthorizerSetupResponse authorizerFactory(
			IssuerAuthorizerSetupRequest request) {
		IssuerAuthorizerSetupResponse response = new IssuerAuthorizerSetupResponse();
		try {
			MissingTransactionInformation missingTransactionInformation = request
					.getMissingTransactionInformation();

			confirmeMissingTransaction(missingTransactionInformation);

		} catch (IssuerException e) {
			context.setRollbackOnly();
			response = (IssuerAuthorizerSetupResponse) ResponseGenerator
					.generate(StatusCode.FAILED, e.getMessage(),
							IssuerSetupResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
			context.setRollbackOnly();
			response = (IssuerAuthorizerSetupResponse) ResponseGenerator
					.generate(StatusCode.FAILED, "unkwnown.error.occured",
							IssuerSetupResponse.class);
		}

	}

	private String confirmeMissingTransaction(
			MissingTransactionInformation missingTransactionInformation) {

		missingTransaction = missingTransactionManagement
				.find(missingTransactionInformation);
		logger.debug(missingTransaction.toString());
		return confirm(missingTransaction);
	}

	/**
	 * @param missingTransaction
	 * @return
	 */
	private String confirm(MissingTransaction missingTransaction)throws Exception {

		XMLGregorianCalendar xgc;
		MissingTransactionService missingTransactionService = MissingTransactionProcessor
				.getService();
		AuthorizerRequest request = new AuthorizerRequest();
		AuthorizerResponse response = new AuthorizerResponse();
		TransactionData data = new TransactionData();

		data.setPAN(missingTransaction.getMissPan());
		data.setAmountTxn(BigDecimal.valueOf(missingTransaction.getMissAmount()));
		data.setCardAcceptorId(missingTransaction.getMissCardAcceptorId());

		data.setMTI(missingTransaction.getMissMTI().shortValue());
		data.setProcessCode(missingTransaction.getMissProcessCode().longValue());
		data.setProgramId(missingTransaction.getMissProgramId().longValue());
		data.setTerminalId(missingTransaction.getMissTerminalId());
		data.setRefrenceData(missingTransaction.getMissProgramRefrenceData());

		// data.setMissingTrnId(myMissing.getId().getMissTransactionId());

		Date locMisTrnDt = missingTransaction.getMissDateLocalTransaction();
		Date misTrnDt = missingTransaction.getId().getMissTransactionDate();

		xgc = DateConvertor.convertDateToXMLGr(locMisTrnDt);
		data.setLocalMissingTrnDate(xgc);

		xgc = DateConvertor.convertDateToXMLGr(misTrnDt);
		data.setDateMissingTrn(xgc);

		request.setTrnasactionData(data);

		/**
 * call service from authorizer		
 */
		response = missingTransactionService.confirmManualMissingTransaction(request);

/**
 * update missingTransaction after confirm it as a transaction		
 */
		if (!response.getMissingResponse().equals(null)) {
			if (response.getMissingResponse().equals(String.valueOf("00"))) {
				missingTransaction.setMissStatus(MissingTransactionStatus.confirmed.toValue());
				missingTransaction.setMissStatusDate(new Date(System.currentTimeMillis()));
			} else {
				missingTransaction.setMissStatus(MissingTransactionStatus.notConfirmed.toValue());
				missingTransaction.setMissStatusDate(new Date(System.currentTimeMillis()));
			}
			Date transactionDt = DateConvertor.convertXMLGrToDate(response.getTransactionDate());
			missingTransaction.setTransactionDate(transactionDt);
			missingTransaction.setTransactionid(response.getTransactionId());

			missingTransactionManagement.update(missingTransaction);

		}
		if (response.getMyResponse() != null) {
			return response.getMissingResponse() + " : "+ response.getMyResponse();
		} else {
			return response.getMissingResponse();
		}

	}

}
