package com.sahand.issuer.action;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import org.slf4j.Logger;

import com.sahand.acquirer.data.InstituteInformation;
import com.sahand.common.util.enumeration.OperationType;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.common.util.message.ResponseGenerator;
import com.sahand.common.util.message.StatusCode;
import com.sahand.issuer.data.MissingTransactionInformation;
import com.sahand.issuer.enumeration.ProcessCode;
import com.sahand.issuer.enumeration.RegisterarType;
import com.sahand.issuer.exception.IssuerException;
import com.sahand.issuer.message.IssuerAuthorizerSetupRequest;
import com.sahand.issuer.message.IssuerAuthorizerSetupResponse;
import com.sahand.issuer.message.IssuerSetupResponse;
import com.sahand.issuer.model.MissingTransaction;

@Stateless
public class MissingSetupProcessorImpl {

	private static Logger logger = SahandLogger.getSahandLogger(AuthorizerSetupProcessorImpl.class);

	@Resource
	private SessionContext context;
	
	private MissingTransaction missingTransaction;
	@EJB
	private MissingTransactionManagement missingTransactionManagement;
	
	public IssuerAuthorizerSetupResponse missingFactory(IssuerAuthorizerSetupRequest request,ProcessCode processCode,OperationType type){
		IssuerAuthorizerSetupResponse response = new IssuerAuthorizerSetupResponse();
		try{
			MissingTransactionInformation missingTransactionInformation = request.getMissingTransactionInformation();
			logger.debug(" operation type :"+type);
			
			if (type == OperationType.CREATE) {
				
				RegisterarType registerarType = request.getRegisterarType();
				InstituteInformation instituteInformation = request.getInstitute();

				logger.info(" registerar type : " + registerarType);
				
				if (registerarType == RegisterarType.INSTITUT)
					missingTransactionManagement.isMemberCardDependToInstitute(
							missingTransactionInformation.getMissPan(),
							instituteInformation.getId(),
							missingTransactionInformation.getMissProgramId());

				missingTransactionInformation = createMissingTransaction(missingTransactionInformation, processCode);
			
			}else if (type == OperationType.UPDATE){
				
				missingTransactionInformation = updateMissingTransaction(missingTransactionInformation);
				
			}else if (type == OperationType.DELETE){
				
				deleteMissingTransaction(missingTransactionInformation);
				
			}else
				throw new IssuerException("operation.type.not.defind");
			
		} catch (IssuerException e) {
			context.setRollbackOnly();
			response = (IssuerAuthorizerSetupResponse)ResponseGenerator.generate(StatusCode.FAILED,e.getMessage(),IssuerSetupResponse.class);
		}catch (Exception e) {
			e.printStackTrace();
			context.setRollbackOnly();
			response = (IssuerAuthorizerSetupResponse)ResponseGenerator.generate(StatusCode.FAILED,"unkwnown.error.occured",IssuerSetupResponse.class);
		}
		return response;
	}
	
	private MissingTransactionInformation createMissingTransaction(MissingTransactionInformation missingTransactionInformation,ProcessCode processCode)throws Exception{
		
		missingTransaction = missingTransactionManagement.create(missingTransactionInformation,processCode);
		logger.debug(missingTransaction.toString());
		missingTransactionManagement.persist(missingTransaction);
		missingTransactionInformation = missingTransactionManagement.convertFrom(missingTransaction, missingTransactionInformation);
		return missingTransactionInformation;
	}
	
	private MissingTransactionInformation updateMissingTransaction(MissingTransactionInformation missingTransactionInformation)throws Exception{
		
		missingTransaction = missingTransactionManagement.edit(missingTransactionInformation);
		logger.debug(missingTransaction.toString());
		missingTransactionManagement.update(missingTransaction);
		missingTransactionInformation = missingTransactionManagement.convertFrom(missingTransaction, missingTransactionInformation);
		return missingTransactionInformation;
	
	}
	
	private void deleteMissingTransaction(MissingTransactionInformation missingTransactionInformation)throws Exception{
		
		missingTransaction = missingTransactionManagement.find(missingTransactionInformation);
		logger.debug(missingTransaction.toString());
		missingTransactionManagement.delete(missingTransaction);
	
	}
}
