package com.sahand.issuer.action;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.sahand.acquirer.action.AcquirerRepository;
import com.sahand.common.util.logger.SahandLogger;

@Stateless
public class AuthorizerManagementImpl {

	private static Logger logger = SahandLogger.getSahandLogger(MemberManagementImpl.class);

	@Inject
	@AcquirerRepository
	EntityManager entityManager;
	



}
