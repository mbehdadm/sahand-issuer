package com.sahand.issuer.action;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import org.slf4j.Logger;

import com.sahand.common.util.logger.SahandLogger;


@Stateless
public class AuthorizerSetupProcessorImpl {


	private static Logger logger = SahandLogger.getSahandLogger(AuthorizerSetupProcessorImpl.class);

	@Resource
	private SessionContext context;




}
