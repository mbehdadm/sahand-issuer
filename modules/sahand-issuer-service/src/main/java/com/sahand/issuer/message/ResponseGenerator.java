package com.sahand.issuer.message;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.slf4j.Logger;

import com.sahand.common.util.logger.SahandLogger;
import com.sahand.common.util.message.Messages;
import com.sahand.common.util.message.ResponseHeader;
import com.sahand.common.util.message.StatusCode;

public class ResponseGenerator {

	private static Logger logger = SahandLogger.getSahandLogger(ResponseGenerator.class);

	private static final String PRIMARY = "fa";
	private static final String SECONDARY = "en";
	private static final String MESSAGE_RESOURCEBUNDLE = "Messages";
	private static final String VALIDATE_RESOURCEBUNDLE = "ValidatorMessages";


	public static ResponseHeader generate(StatusCode code, String key,Class clazz,
			String... message) {
		ResponseHeader response = new ResponseHeader(); 	
		try{
			response = (ResponseHeader)clazz.newInstance();
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.setStatusCode(code);

		response.setMessages(getMessageText(key,MESSAGE_RESOURCEBUNDLE));

		logger.debug("Generate reponse : "+response);

		return response;

	}

	public static ResponseHeader generate(StatusCode code, String key,Class clazz){
		ResponseHeader response = new ResponseHeader(); 	
		try{
			response = (ResponseHeader)clazz.newInstance();
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.setStatusCode(code);

		response.setMessages(getMessageText(key,MESSAGE_RESOURCEBUNDLE));

		logger.debug("Generate reponse : "+response);

		return response;

	}
	public static Messages getMessageText(String key,String bundleRS){

		List<String> primaries = new ArrayList<String>();
		List<String> secondaries = new ArrayList<String>();
		
		String replacement = "";
		key = key.replaceAll("[{}]", replacement);
		
		String[] split = key.split(" ");
		key = split[0];
		String exdt = "";
		if(split.length > 1)
			exdt = split[1];
		
				
		logger.info("Key after adjust : "+key);
		ResourceBundle  bundle = ResourceBundle.getBundle(bundleRS, new Locale(PRIMARY));
		primaries.add((String)bundle.getObject(key)+exdt);

		bundle = ResourceBundle.getBundle(bundleRS, new Locale(SECONDARY));
		secondaries.add((String)bundle.getObject(key)+exdt);

		Messages messages = new Messages();
		messages.getResponseText_pri().addAll(primaries);
		messages.getResponseText_sec().addAll(secondaries);

		return messages;

	}

	public static String getMessagesResourcebundle() {
		return MESSAGE_RESOURCEBUNDLE;
	}

	public static String getValidateResourcebundle() {
		return VALIDATE_RESOURCEBUNDLE;
	}

	//	public static AuthenticationResponse authentication(StatusCode failed,
	//			String key, String message) {
	//		AuthenticationResponse response = new AuthenticationResponse();
	//		response.setStatusCode(failed);
	//		
	//		response.setMessages(getMessageText(key,MESSAGE_RESOURCEBUNDLE));
	//
	//		logger.debug("Generate reponse : "+response);
	//		
	//	return response;
	//	}



}
