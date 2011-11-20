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
			
			case 0:  action = IssuerConfigLoader.getValue("credit.acceptor") ; break;

			case 1:  action = IssuerConfigLoader.getValue("shanli.acceptor") ; break;
				
			case 2:  action = IssuerConfigLoader.getValue("shanli.holer");break;
						
			case 3:  action = IssuerConfigLoader.getValue("payment.acceptor");break;
				
			case 4:  action = IssuerConfigLoader.getValue("booking.system");break;
				
			case 5:  action = IssuerConfigLoader.getValue("reporting");break;
	
		}
		if(requestContext != null)
			requestContext.addCallbackParam("url", action);
		logger.debug("Target action : "+ action);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
