package com.sahand.issuer.action;

import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;

import com.sahand.common.util.logger.SahandLogger;

@Stateless
public class AuthorizerManagementImpl {

	private static Logger logger = SahandLogger.getSahandLogger(MemberManagementImpl.class);

	@Inject
	@AcquirerRepository
	EntityManager entityManager;
	



}
