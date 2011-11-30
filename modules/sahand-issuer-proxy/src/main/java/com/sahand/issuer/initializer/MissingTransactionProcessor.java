package com.sahand.issuer.initializer;

import java.io.Serializable;
import java.net.URL;

import javax.xml.namespace.QName;

import org.slf4j.Logger;

import com.sahand.common.util.logger.SahandLogger;
import com.sahand.common.util.reader.CommonConfigLoader;
import com.sahand.issuer.services.missingTransaction.MissingTransactionService;
import com.sahand.issuer.services.missingTransaction.MissingTransactionPortService;

public class MissingTransactionProcessor implements Serializable{
		

	private static final long serialVersionUID = 1L;

		private final  static Logger logger = SahandLogger.getSahandLogger(MissingTransactionProcessor.class);
		
		static MissingTransactionService service;
		
		static MissingTransactionPortService portService;
		
		
		public static boolean initService(){
			try {
				String urlPath ;
				if(CommonConfigLoader.getConfiguration() == null )
					urlPath = CommonConfigLoader.getConfiguration().getProperty("missingTransaction-wsdl");
				else{
					CommonConfigLoader.defaultInit();
					urlPath = CommonConfigLoader.getConfiguration_Default().getProperty("missingTransaction-wsdl");
				}
				URL url = new URL(urlPath);
				logger.info("Administration Service URL : "+url);
				QName qname = new QName("http://service.loyalty.authorizer.sahand.com/", "MissingTransactionService");

				portService = new MissingTransactionPortService(url,qname);
				service = portService.getPort(MissingTransactionService.class);
				if(service == null){
					return false;
				}
				logger.debug(":::::::::"+service+":::::::::");
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			
			
		}
		
		public static MissingTransactionService getService(){
			if(initService())
				return service;
			return null;
		}
		
//		public static UserAdministrationRs getUserList(UserAdministrationRq request) {
//			try{
//				logger.info("Send Request to Get-User-List...");
//				if(!initService()){
//					logger.info("Unable to get Administration port ...");
////					StatusMessages.instance().addFromResourceBundle(Severity.INFO, "service.invoke.failed");
//					return null;
//				}
//				// setConnectTimeout()
//				int time = 5000;
//		    	String timeout = CommonConfigLoader.getCONFIGURATION_DEFAULT().getProperty("time-out");
//		    	if(timeout != null && timeout.length() > 0){
//		    		time = Integer.valueOf(timeout);
//		    	}
//		    	
//		    	
//		    	Map<String, Object> ctxt = ((BindingProvider)service).getRequestContext();
//		    	ctxt.put(JAXWSProperties.CONNECT_TIMEOUT, timeout);
//		    	ctxt.put("com.sun.xml.ws.request.timeout", timeout);		    	
//		    	
//		    	return  service.getUserList(request);
//				
//			}catch (Exception e) {
//				e.printStackTrace();
//				logger.error(e.getMessage());
//				return null;
//			}
//		}




}
