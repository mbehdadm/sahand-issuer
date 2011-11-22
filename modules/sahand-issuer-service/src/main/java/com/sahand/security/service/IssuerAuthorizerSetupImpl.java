package com.sahand.security.service;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.slf4j.Logger;

import com.sahand.common.util.enumeration.OperationType;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.issuer.action.AuthorizerSetupProcessorImpl;
import com.sahand.issuer.action.MemberSetupProcessorImpl;
import com.sahand.issuer.action.ProgramSetupProcessorImpl;
import com.sahand.issuer.message.IssuerAuthorizerSetupRequest;
import com.sahand.issuer.message.IssuerAuthorizerSetupResponse;
import com.sahand.issuer.message.IssuerSetupRequest;
import com.sahand.issuer.message.IssuerSetupResponse;

@Stateless
@WebServlet
public class IssuerAuthorizerSetupImpl implements IssuerAuthorizerSetup {

	private static Logger logger = SahandLogger.getSahandLogger(IssuerAuthorizerSetupImpl.class);
	
	
	@Resource
	private WebServiceContext wsContext;

	@EJB
	private AuthorizerSetupProcessorImpl authorizerSetupProcessor;

	@Override
	public IssuerAuthorizerSetupResponse registerMissingTransaction(
			IssuerAuthorizerSetupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IssuerAuthorizerSetupResponse registerMissingTransactionRedeem(
			IssuerAuthorizerSetupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IssuerAuthorizerSetupResponse confirmMissingTransactions(
			IssuerAuthorizerSetupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IssuerAuthorizerSetupResponse deleteMissingTransaction(
			IssuerAuthorizerSetupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
