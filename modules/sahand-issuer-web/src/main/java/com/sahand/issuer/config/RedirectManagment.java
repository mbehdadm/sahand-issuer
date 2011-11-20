package com.sahand.issuer.config;

import javax.inject.Named;
import javax.inject.Singleton;

import org.primefaces.context.RequestContext;
import org.slf4j.Logger;

import com.sahand.common.util.logger.SahandLogger;


@Named
@Singleton
public class RedirectManagment {

	private static Logger logger = SahandLogger.getSahandLogger(RedirectManagment.class);
	
	
	public void systemRedirect(int number){
		try{
			logger.debug("Target number : "+ number);
			RequestContext requestContext = RequestContext.getCurrentInstance();
			String action = "/home.xhtml";
			switch (number) {
			
			case 0:  action = SecurityConfigLoader.getValue("credit.acceptor") ; break;

			case 1:  action = SecurityConfigLoader.getValue("shanli.acceptor") ; break;
				
			case 2:  action = SecurityConfigLoader.getValue("shanli.holer");break;
						
			case 3:  action = SecurityConfigLoader.getValue("payment.acceptor");break;
				
			case 4:  action = SecurityConfigLoader.getValue("booking.system");break;
				
			case 5:  action = SecurityConfigLoader.getValue("reporting");break;
	
		}
		if(requestContext != null)
			requestContext.addCallbackParam("url", action);
		logger.debug("Target action : "+ action);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
