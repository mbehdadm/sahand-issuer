package com.sahand.issuer.action;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import org.slf4j.Logger;

import com.sahand.acquirer.data.InstituteInformation;
import com.sahand.acquirer.model.Institute;
import com.sahand.common.util.enumeration.OperationType;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.common.util.message.ResponseGenerator;
import com.sahand.common.util.message.StatusCode;
import com.sahand.issuer.data.CardTypeInformation;
import com.sahand.issuer.exception.IssuerException;
import com.sahand.issuer.message.IssuerSetupRequest;
import com.sahand.issuer.message.IssuerSetupResponse;
import com.sahand.issuer.model.CardType;
import com.sahand.issuer.model.CreditOrganization;


@Stateless
public class CardSetupProcessorImpl {


	private static Logger logger = SahandLogger.getSahandLogger(CardSetupProcessorImpl.class);

	@Resource
	private SessionContext context;

	private Institute institute;
	private CreditOrganization organization;
	private CardType cardType;
	
	@EJB
	private CreditOrganizationManagementImpl creditOrganizationManagement;
	
	@EJB
	private CardTypeManagementImpl cardTypeManagement;


	public IssuerSetupResponse cardTypeFactory(IssuerSetupRequest request,
			OperationType type) {
		IssuerSetupResponse response = new IssuerSetupResponse();
		try {
			CardTypeInformation cardTypeInformation = request.getCardType();
			String key = null;
			logger.debug("Operation type : "+type);
			if(type == OperationType.UPDATE){
				key = "card.type.update.success";
//				institute = creditOrganizationManagement.find(request.getInstitute().getId());
//				if(institute == null)
//					throw new IssuerException("institute.not.find");
				cardTypeInformation = editCardType(cardTypeInformation);
				
			}
			else if(type == OperationType.CREATE){
				institute = creditOrganizationManagement.find(request.getInstitute().getId());
				if(institute == null)
					throw new IssuerException("institute.not.find");
				key = "card.type.create.success";
				cardTypeInformation = createCardType(cardTypeInformation);
				
			}
			else if(type == OperationType.DELETE){
				key = "card.type.delete.success";
				deleteCardType(cardTypeInformation.getId());
			}
			else{
				throw new IssuerException("operation.type.not.define");

			}

			response = (IssuerSetupResponse)ResponseGenerator.generate(StatusCode.SUCCESSFUL, key,IssuerSetupResponse.class);
			response.setCardType(cardTypeInformation);

		} catch (IssuerException e) {
			context.setRollbackOnly();
			response = (IssuerSetupResponse)ResponseGenerator.generate(StatusCode.FAILED,e.getMessage(),IssuerSetupResponse.class);
		}catch (Exception e) {
			e.printStackTrace();
			context.setRollbackOnly();
			response = (IssuerSetupResponse)ResponseGenerator.generate(StatusCode.FAILED,"unkwnown.error.occured",IssuerSetupResponse.class);
		}
		return response;
	}

	public CardTypeInformation createCardType(
			CardTypeInformation cardTypeInformation) throws Exception{
		cardType = cardTypeManagement.create(cardTypeInformation);
		logger.debug(cardType.toString());
		cardType.setInstitution(institute);
		cardTypeManagement.persist(cardType);
		cardTypeInformation = cardTypeManagement.convertFrom(cardType,cardTypeInformation);
		return cardTypeInformation;
	}

	private CardTypeInformation editCardType(
			CardTypeInformation cardTypeInformation) throws Exception{
		cardType = cardTypeManagement.edit(cardTypeInformation);
		logger.debug(cardType.toString());
//		cardType.setInstitution(institute);
		cardTypeManagement.update(cardType);
		cardTypeInformation = cardTypeManagement.convertFrom(cardType,cardTypeInformation);
		return cardTypeInformation;
	}

	public void deleteCardType(Integer id) throws Exception{
		cardTypeManagement.delete(id);
		
	}

	
	public IssuerSetupResponse creditOrganizationFactory(
			IssuerSetupRequest request, OperationType type) {
		IssuerSetupResponse response = new IssuerSetupResponse();
		try {
			InstituteInformation instituteInformation = request.getInstitute();
			String key = null;
			logger.debug("Operation type : "+type);
			if(type == OperationType.UPDATE){
				key = "credit.institute.update.success";
				institute = creditOrganizationManagement.find(request.getInstitute().getId());
				if(institute == null)
					throw new IssuerException("institute.not.find");
				instituteInformation = editCreditOrganization(instituteInformation);
				
			}
			else if(type == OperationType.CREATE){
				institute = creditOrganizationManagement.find(request.getInstitute().getId());
				if(institute == null)
					throw new IssuerException("institute.not.find");
				key = "credit.institute.create.success";
				instituteInformation = createCreditOrganization(instituteInformation);
				
			}
			else if(type == OperationType.DELETE){
				key = "card.type.delete.success";
				deleteCreditOrganization(instituteInformation.getId());
			}
			else{
				throw new IssuerException("operation.type.not.define");

			}

			response = (IssuerSetupResponse)ResponseGenerator.generate(StatusCode.SUCCESSFUL, key,IssuerSetupResponse.class);
			response.setInstitute(instituteInformation);

		} catch (IssuerException e) {
			context.setRollbackOnly();
			response = (IssuerSetupResponse)ResponseGenerator.generate(StatusCode.FAILED,e.getMessage(),IssuerSetupResponse.class);
		}catch (Exception e) {
			e.printStackTrace();
			context.setRollbackOnly();
			response = (IssuerSetupResponse)ResponseGenerator.generate(StatusCode.FAILED,"unkwnown.error.occured",IssuerSetupResponse.class);
		}
		return response;
	}




	public InstituteInformation createCreditOrganization(
			InstituteInformation instituteInformation) throws Exception{
		institute = creditOrganizationManagement.create(instituteInformation);
		organization = creditOrganizationManagement.create_(instituteInformation);
		logger.debug(institute.toString());
		logger.debug(organization.toString());
		organization.setInstitution(institute);
		creditOrganizationManagement.persist(institute);
		creditOrganizationManagement.persist_(organization);
		instituteInformation = creditOrganizationManagement.convertFrom(institute,organization,instituteInformation);
		return instituteInformation;
	}



	public InstituteInformation editCreditOrganization(
			InstituteInformation instituteInformation) throws Exception{
		institute = creditOrganizationManagement.edit(instituteInformation);
		organization = creditOrganizationManagement.edit_(instituteInformation);
		logger.debug(institute.toString());
		logger.debug(organization.toString());
		organization.setInstitution(institute);
		creditOrganizationManagement.update(institute);
		creditOrganizationManagement.update_(organization);
		instituteInformation = creditOrganizationManagement.convertFrom(institute,organization,instituteInformation);
		return instituteInformation;
	}


	public void deleteCreditOrganization(String id) throws Exception{
		creditOrganizationManagement.delete_(id);
		
	}






}
