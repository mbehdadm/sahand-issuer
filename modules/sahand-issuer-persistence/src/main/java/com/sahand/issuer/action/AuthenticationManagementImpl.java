package com.sahand.issuer.action;

import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.sahand.acquirer.action.AcquirerRepository;
import com.sahand.acquirer.action.AuthenticationManagement;
import com.sahand.acquirer.action.AuthenticationManagementImpl;
import com.sahand.acquirer.config.AcquirerConfigLoader;
import com.sahand.acquirer.model.UserSession;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.common.util.message.RequestHeader;
import com.sahand.issuer.exception.IssuerException;

@Stateless
public class AuthenticationManagementImpl implements AuthenticationManagement {

	private static Logger logger = SahandLogger.getSahandLogger(AuthenticationManagementImpl.class);
	
	
	@Inject
	@AcquirerRepository
	EntityManager entityManager;
	
	public boolean isSessionValid(RequestHeader header) throws Exception {
		boolean check = false;
		try {
			logger.debug(header.toString());
			UserSession session = (UserSession)/*pm.getEntityManager()*/entityManager.createNamedQuery("validate.session")
					.setParameter(1, header.getUserName())
					.setParameter(2, header.getSessionId())
					.getSingleResult();
			if(session == null)
				throw new IssuerException("session.not.find");
			
			String timeout = AcquirerConfigLoader.getValue("session-timeout");
			if(timeout != null){
//				timeout = "30";
				long time = Long.valueOf(timeout)*60*1000;
				if(time == 0)
					return true;
				Date newDate = new Date();
				logger.debug("Now Time : "+newDate);
				Date loginDate = session.getLogonDate();
				logger.debug("Login date : "+loginDate);
				Date logoutDate = session.getLogofDate();
				logger.debug("Logout date : "+ logoutDate);
				if(logoutDate != null){
					logger.debug("Logout date : "+logoutDate);
					return false;
				}
					
				
				time += loginDate.getTime();
				logger.debug("Time : "+time);
				logger.debug("Login Time : "+newDate.getTime());
				if(time < newDate.getTime())
				 check = true;
			}
			logger.debug("IS session valid : "+check);
			
		} catch (IssuerException e) {
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
		
		}
		return check;
	}

}
