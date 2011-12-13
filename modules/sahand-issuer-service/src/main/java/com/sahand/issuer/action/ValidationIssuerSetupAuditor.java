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

import com.sahand.acquirer.data.InstituteIdValidation;
import com.sahand.acquirer.data.InstituteInformation;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.common.util.message.Messages;
import com.sahand.common.util.message.ResponseGenerator;
import com.sahand.common.util.message.StatusCode;
import com.sahand.issuer.data.CardIdValidation;
import com.sahand.issuer.data.CardInformation;
import com.sahand.issuer.data.CardTypeIdValidation;
import com.sahand.issuer.data.CardTypeInformation;
import com.sahand.issuer.data.MemberIdValidation;
import com.sahand.issuer.data.MemberInformation;
import com.sahand.issuer.data.ProgramIdValidation;
import com.sahand.issuer.data.ProgramInformation;
import com.sahand.issuer.data.partnersValidation;
import com.sahand.issuer.message.IssuerSetupRequest;
import com.sahand.issuer.message.IssuerSetupResponse;

public class ValidationIssuerSetupAuditor {
	
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
			IssuerSetupResponse response = null;
			IssuerSetupRequest request = (IssuerSetupRequest)context.getParameters()[0];
			
			String methodName = context.getMethod().getName();
			logger.debug("Method invoked : "+methodName);
			
			if (methodName.equals("registerProgram")){
				response = registerProgram(request);
			}
			else if (methodName.equals("editProgram")){
				response = editProgram(request);
			}
			else if (methodName.equals("removeProgram")){
				response = removeProgram(request);
			}
			else if (methodName.equals("addProgramPartner")){
				response = addProgramPartner(request);
			}
			else if (methodName.equals("editProgramPartner")){
				response = editProgramPartner(request);
			}
			else if (methodName.equals("registerMemberInformation")){
				response = registerMemberInformation(request);
			}
			else if (methodName.equals("editMemberInformation")){
				response = editMemberInformation(request);
			}
			else if (methodName.equals("assignCardToMember")){
				response = assignCardToMember(request);
			}
			else if (methodName.equals("editMemberCard")){
				response = editMemberCard(request);
			}
			else if (methodName.equals("registerCardType")){
				response = registerCardType(request);
			}
			else if (methodName.equals("editCardType")){
				response = editCardType(request);
			}
			else if (methodName.equals("registerCreditOrganization")){
				response = registerCreditOrganization(request);
			}
			else if (methodName.equals("editCreditOrganization")){
				response = editCreditOrganization(request);
			}
			if (response != null)
				return response;

			return context.proceed();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private IssuerSetupResponse editCreditOrganization(
			IssuerSetupRequest request) {
		IssuerSetupResponse response = null;
		List<IssuerSetupResponse> responses = new ArrayList<IssuerSetupResponse>();
		
		responses.add(instituteValidator(request.getInstitute(),InstituteIdValidation.class));
		logger.debug("After validate institution information : "+responses);
	
/*		response = generateResponse(responses);*/
		
		return response;
	}

	private IssuerSetupResponse registerCreditOrganization(
			IssuerSetupRequest request) {
		IssuerSetupResponse response = null;
		List<IssuerSetupResponse> responses = new ArrayList<IssuerSetupResponse>();
		
		responses.add(instituteValidator(request.getInstitute(),Default.class));
		logger.debug("After validate institution information : "+responses);
	
/*		response = generateResponse(responses);*/
		
		return response;

	}

	private IssuerSetupResponse editCardType(IssuerSetupRequest request) {
		
		IssuerSetupResponse response = null;
		List<IssuerSetupResponse> responses = new ArrayList<IssuerSetupResponse>();
		
		responses.add(cardTypeValidator(request.getCardType(),CardTypeIdValidation.class ));
		logger.debug(" After validate card type information : "+responses);
		
/*		response = generateResponse(responses);*/
		
		return response;
	}

	private IssuerSetupResponse registerCardType(IssuerSetupRequest request) {
		
		IssuerSetupResponse response = null;
		List<IssuerSetupResponse> responses = new ArrayList<IssuerSetupResponse>();
		
		responses.add(cardTypeValidator(request.getCardType(),Default.class ));
		logger.debug("After validate card type information : "+responses);
/*		response = generateResponse(responses);*/
		
		return response;

	}

	private IssuerSetupResponse editMemberCard(IssuerSetupRequest request) {
		
		IssuerSetupResponse response = null;
		List<IssuerSetupResponse> responses = new ArrayList<IssuerSetupResponse>();
		
		responses.add(cardValidator(request.getCard(), CardIdValidation.class ));
		logger.debug("After validate card information : "+responses);

/*		response = generateResponse(responses);*/		
		return response;
	}

	private IssuerSetupResponse assignCardToMember(IssuerSetupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	private IssuerSetupResponse editMemberInformation(IssuerSetupRequest request) {
		
		IssuerSetupResponse response = null;
		List<IssuerSetupResponse> responses = new ArrayList<IssuerSetupResponse>();
		
		responses.add(memberValidator(request.getMember(), MemberIdValidation.class ));
		logger.debug("After validate card information : "+responses);

/*		response = generateResponse(responses);*/		
		return response;

	}

	private IssuerSetupResponse registerMemberInformation(
			IssuerSetupRequest request) {
	
		IssuerSetupResponse response = null;
		List<IssuerSetupResponse> responses = new ArrayList<IssuerSetupResponse>();
		
		responses.add(memberValidator(request.getMember(), MemberIdValidation.class ));
		logger.debug("After validate card information : "+responses);

/*		response = generateResponse(responses);*/		
		return response;

	}

	private IssuerSetupResponse editProgramPartner(IssuerSetupRequest request) {
		
		IssuerSetupResponse response = null;
		List<IssuerSetupResponse> responses = new ArrayList<IssuerSetupResponse>();
		
		responses.add(programValidator(request.getProgram(), ProgramIdValidation.class,partnersValidation.class ));
		logger.debug("After validate program information and programPartner information : "+responses);

/*		response = generateResponse(responses);*/		
		return response;

	}

	private IssuerSetupResponse addProgramPartner(IssuerSetupRequest request) {

		IssuerSetupResponse response = null;
		List<IssuerSetupResponse> responses = new ArrayList<IssuerSetupResponse>();
		
		responses.add(programValidator(request.getProgram(), ProgramIdValidation.class,partnersValidation.class ));
		logger.debug("After validate program information : "+responses);

/*		response = generateResponse(responses);*/		
		return response;
		
	}

	private IssuerSetupResponse removeProgram(IssuerSetupRequest request) {
		
		IssuerSetupResponse response = null;
		List<IssuerSetupResponse> responses = new ArrayList<IssuerSetupResponse>();
		
		responses.add(programValidator(request.getProgram(), ProgramIdValidation.class ));
		logger.debug("After validate program information : "+responses);

/*		response = generateResponse(responses);*/		
		return response;
	}

	private IssuerSetupResponse editProgram(IssuerSetupRequest request) {
		
		IssuerSetupResponse response = null;
		List<IssuerSetupResponse> responses = new ArrayList<IssuerSetupResponse>();
		
		responses.add(programValidator(request.getProgram(), ProgramIdValidation.class ));
		logger.debug("After validate program information : "+responses);

/*		response = generateResponse(responses);*/		
		return response;
	}

	private IssuerSetupResponse registerProgram(
			IssuerSetupRequest request) {
		
		IssuerSetupResponse response = null;
		List<IssuerSetupResponse> responses = new ArrayList<IssuerSetupResponse>();
		
		responses.add(programValidator(request.getProgram(), Default.class ));
		logger.debug("After validate program information : "+responses);

/*		response = generateResponse(responses);*/		
		return response;

	}
	
	private IssuerSetupResponse instituteValidator(
			InstituteInformation instituteDto,Class...classes ) {
		
		IssuerSetupResponse response = null;
		Set<ConstraintViolation<InstituteInformation>> constraint ;

			constraint = validator.validate(instituteDto,classes);

		Messages messages = new Messages();
		boolean check = false;
		if(constraint != null){
			
			check = extractValidationMessages(constraint,messages);
		}
		if(check){
			response = new IssuerSetupResponse();
			response.setStatusCode(StatusCode.FAILED);
			response.setMessages(messages);
		}
		return response;
		
	}
	
	private IssuerSetupResponse cardTypeValidator(
			CardTypeInformation cardTypeInformation,Class...classes ) {
		
		IssuerSetupResponse response = null;
		Set<ConstraintViolation<CardTypeInformation>> constraint ;

			constraint = validator.validate(cardTypeInformation,classes);

		Messages messages = new Messages();
		boolean check = false;
		if(constraint != null){
			
			check = extractValidationMessages(constraint,messages);
		}
		if(check){
			response = new IssuerSetupResponse();
			response.setStatusCode(StatusCode.FAILED);
			response.setMessages(messages);
		}
		return response;
		
	}
	
	private IssuerSetupResponse cardValidator(
			CardInformation cardInformation,Class...classes ) {
		
		IssuerSetupResponse response = null;
		Set<ConstraintViolation<CardInformation>> constraint ;

			constraint = validator.validate(cardInformation , classes);

		Messages messages = new Messages();
		boolean check = false;
		if(constraint != null){
			
			check = extractValidationMessages(constraint,messages);
		}
		if(check){
			response = new IssuerSetupResponse();
			response.setStatusCode(StatusCode.FAILED);
			response.setMessages(messages);
		}
		return response;
		
	}

	private IssuerSetupResponse memberValidator(
			MemberInformation memberInformation , Class...classes ) {
		
		IssuerSetupResponse response = null;
		Set<ConstraintViolation<MemberInformation>> constraint ;

			constraint = validator.validate(memberInformation , classes);

		Messages messages = new Messages();
		boolean check = false;
		if(constraint != null){
			
			check = extractValidationMessages(constraint,messages);
		}
		if(check){
			response = new IssuerSetupResponse();
			response.setStatusCode(StatusCode.FAILED);
			response.setMessages(messages);
		}
		return response;
		
	}
	
	private IssuerSetupResponse programValidator(
			ProgramInformation programInformation , Class...classes ) {
		
		IssuerSetupResponse response = null;
		Set<ConstraintViolation<ProgramInformation>> constraint ;

			constraint = validator.validate(programInformation , classes);

		Messages messages = new Messages();
		boolean check = false;
		if(constraint != null){
			
			check = extractValidationMessages(constraint,messages);
		}
		if(check){
			response = new IssuerSetupResponse();
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



}
