package com.sahand.issuer.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.MessageInterpolator;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

import org.hibernate.validator.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ValueFormatterMessageInterpolator;
import org.slf4j.Logger;

import com.sahand.acquirer.data.InstituteInformation;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.common.util.message.Messages;
import com.sahand.common.util.message.ResponseGenerator;
import com.sahand.common.util.message.StatusCode;
import com.sahand.issuer.data.MissingTransactionIdValidation;
import com.sahand.issuer.data.MissingTransactionInformation;
import com.sahand.issuer.message.IssuerAuthorizerSetupRequest;
import com.sahand.issuer.message.IssuerAuthorizerSetupResponse;

public class ValidationMissingSetupAuditor {

	private static Logger logger = SahandLogger.getSahandLogger(ValidationMissingSetupAuditor.class);

	private static Validator validator;
	private static Configuration<?> configuration;

	static {
		/* Configuration<?> */configuration = Validation.byDefaultProvider()
				.configure();
		ValidatorFactory factory = configuration.messageInterpolator(
				new ValueFormatterMessageInterpolator(configuration
						.getDefaultMessageInterpolator()))
				.buildValidatorFactory();
		/* Validator */validator = factory.getValidator();
	}
	
	@AroundInvoke
	public Object validate(InvocationContext context) throws Exception {
		
		try {
			IssuerAuthorizerSetupResponse response = null;
			IssuerAuthorizerSetupRequest request = (IssuerAuthorizerSetupRequest)context.getParameters()[0];
			
			String methodName = context.getMethod().getName();
			logger.debug("Method invoked : "+methodName);
			
			if (methodName.equals("registerMissingTransaction")){
				response = registerMissingTransaction(request);
			}
			else if (methodName.equals("registerMissingTransactionRedeem")){
				response = registerMissingTransaction(request);
			}
			else if (methodName.equals("modifyMissingTransaction")){
				response = updateMissingTransaction(request);
			}
			else if (methodName.equals("deleteMissingTransaction")){
				response = deleteMissingTransaction(request);
			}
			else if (methodName.equals("confirmMissingTransactions")){
				response = confirmeMissingTransaction(request);
			}
			
			if (response != null)
				return response;

			return context.proceed();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private IssuerAuthorizerSetupResponse registerMissingTransaction(
			IssuerAuthorizerSetupRequest request) {
		
		IssuerAuthorizerSetupResponse response = null;
		List<IssuerAuthorizerSetupResponse> responses = new ArrayList<IssuerAuthorizerSetupResponse>();
		
		responses.add(missingValidator(request.getMissingTransactionInformation(),Default.class));
		logger.debug("After validate missing transaction : "+responses);
	
		responses.add(instituteValidator(request.getInstitute(),Default.class));
		logger.debug("After validate institute : "+responses);
			
		response = generateResponse(responses);
		
		return response;
	}
	
	private IssuerAuthorizerSetupResponse updateMissingTransaction(
			IssuerAuthorizerSetupRequest request) {
		
		IssuerAuthorizerSetupResponse response = null;
		List<IssuerAuthorizerSetupResponse> responses = new ArrayList<IssuerAuthorizerSetupResponse>();
		
		responses.add(missingValidator(request.getMissingTransactionInformation(),MissingTransactionIdValidation.class));
		logger.debug("After validate missing transaction : "+responses);
	
		response = generateResponse(responses);
		
		return response;
	}
	
	private IssuerAuthorizerSetupResponse confirmeMissingTransaction(
			IssuerAuthorizerSetupRequest request) {
		
		IssuerAuthorizerSetupResponse response = null;
		List<IssuerAuthorizerSetupResponse> responses = new ArrayList<IssuerAuthorizerSetupResponse>();
		
		responses.add(missingValidator(request.getMissingTransactionInformation(),MissingTransactionIdValidation.class));
		logger.debug("After validate missing transaction : "+responses);
	
		response = generateResponse(responses);
		
		return response;
	}

	
	private IssuerAuthorizerSetupResponse deleteMissingTransaction(
			IssuerAuthorizerSetupRequest request) {
		
		IssuerAuthorizerSetupResponse response = null;
		List<IssuerAuthorizerSetupResponse> responses = new ArrayList<IssuerAuthorizerSetupResponse>();
		
		responses.add(missingValidator(request.getMissingTransactionInformation(),MissingTransactionIdValidation.class));
		logger.debug("After validate missing transaction : "+responses);
	
		response = generateResponse(responses);
		
		return response;
	}
	
	private IssuerAuthorizerSetupResponse instituteValidator(
			InstituteInformation instituteDto,Class...classes ) {
		
		IssuerAuthorizerSetupResponse response = null;
		Set<ConstraintViolation<InstituteInformation>> constraint ;

			constraint = validator.validate(instituteDto,classes);

		Messages messages = new Messages();
		boolean check = false;
		if(constraint != null){
			
			check = extractValidationMessages(constraint,messages);
		}
		if(check){
			response = new IssuerAuthorizerSetupResponse();
			response.setStatusCode(StatusCode.FAILED);
			response.setMessages(messages);
		}
		return response;
		
	}
	
	private IssuerAuthorizerSetupResponse missingValidator(
			MissingTransactionInformation missingTransactionInfo,Class...classes ) {
		
		IssuerAuthorizerSetupResponse response = null;
		Set<ConstraintViolation<MissingTransactionInformation>> constraint ;

			constraint = validator.validate(missingTransactionInfo,classes);

		Messages messages = new Messages();
		boolean check = false;
		if(constraint != null){
			
			check = extractValidationMessages(constraint,messages);
		}
		if(check){
			response = new IssuerAuthorizerSetupResponse();
			response.setStatusCode(StatusCode.FAILED);
			response.setMessages(messages);
		}
		return response;
		
	}
	
	public <T> boolean  extractValidationMessages(
			Set<ConstraintViolation<T>> constraintCustomer,Messages messages) {
		boolean check = false;
		MessageInterpolator  messageInterpolator = configuration.getDefaultMessageInterpolator();
		
		for (ConstraintViolation<T> constraintViolation : constraintCustomer) {
			String template = constraintViolation.getMessageTemplate();
			MessageInterpolatorContext interpolatorContext = new MessageInterpolatorContext(constraintViolation.getConstraintDescriptor(), null);
			logger.debug("Template messages : "+template);
			template = messageInterpolator.interpolate(template, interpolatorContext);
			logger.debug("Template messages after interpolate : "+template);
//			logger.debug(constraintViolation.getMessage()+"Template messages ------------------>: "+);
//			logger.debug("Template messages ------------------>: "+dd.interpolate(template, ss,new Locale("fa"))+"   "+constraintViolation.getMessage());
			Messages msg = ResponseGenerator.getMessageText(template,ResponseGenerator.getValidateResourcebundle());
			messages.getResponseText_pri().add(msg.getResponseText_pri().get(0));
			messages.getResponseText_sec().add(msg.getResponseText_sec().get(0));
			check = true;
		}
		return check;
	}
	
	private IssuerAuthorizerSetupResponse generateResponse(
			List<IssuerAuthorizerSetupResponse> responses) {
		IssuerAuthorizerSetupResponse response = null;
		Messages messages = new Messages();
		for (IssuerAuthorizerSetupResponse issuerAuthorizerSetupResponse : responses) {
			
			if(issuerAuthorizerSetupResponse != null){
				
				response = new IssuerAuthorizerSetupResponse();
				response.setStatusCode(StatusCode.FAILED);
				List<String> primary = new ArrayList<String>();
				List<String> secondary = new ArrayList<String>();
				primary = issuerAuthorizerSetupResponse.getMessages().getResponseText_pri();
				secondary = issuerAuthorizerSetupResponse.getMessages().getResponseText_sec();
				
				for (String pri : primary) {
					messages.getResponseText_pri().add(pri);
				}
				for (String sec : secondary) {
					messages.getResponseText_sec().add(sec);
				}
				response.setMessages(messages);
				
			}
		}
		return response;
	}

}
