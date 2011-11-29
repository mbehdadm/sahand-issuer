package com.sahand.issuer.service;

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
import com.sahand.common.util.message.ResponseGenerator;
import com.sahand.issuer.action.AuthorizerSetupProcessorImpl;
import com.sahand.issuer.action.MemberSetupProcessorImpl;
import com.sahand.issuer.action.MissingSetupProcessorImpl;
import com.sahand.issuer.action.ProgramSetupProcessorImpl;
import com.sahand.issuer.enumeration.ProcessCode;
import com.sahand.issuer.enumeration.RegisterarType;
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
	@EJB
	private MissingSetupProcessorImpl missingSetupProcessorImpl;

	@Override
	public IssuerAuthorizerSetupResponse registerMissingTransaction(
			IssuerAuthorizerSetupRequest request) {
		
		IssuerAuthorizerSetupResponse response = new IssuerAuthorizerSetupResponse();
		MessageContext mc = wsContext.getMessageContext();	
	    HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
	    String ip = req.getRemoteAddr();
	    logger.debug("Client Ip : "+ip);
	    request.setClientIpAddress(ip);
	    
		response = missingSetupProcessorImpl.missingFactory(request,ProcessCode.LoyaltyIssuePoints,OperationType.CREATE);
		return response;
	}

	@Override
	public IssuerAuthorizerSetupResponse registerMissingTransactionRedeem(
			IssuerAuthorizerSetupRequest request) {
		
		IssuerAuthorizerSetupResponse response = new IssuerAuthorizerSetupResponse();
		MessageContext mc = wsContext.getMessageContext();	
	    HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
	    String ip = req.getRemoteAddr();
	    logger.debug("Client Ip : "+ip);
	    request.setClientIpAddress(ip);
	    
		response = missingSetupProcessorImpl.missingFactory(request,ProcessCode.LoyaltyPointsRedemption,OperationType.CREATE);
		return response;
	}

	@Override
	public IssuerAuthorizerSetupResponse modifyMissingTransaction(
			IssuerAuthorizerSetupRequest request) {
		
		IssuerAuthorizerSetupResponse response = new IssuerAuthorizerSetupResponse();
		MessageContext mc = wsContext.getMessageContext();	
	    HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
	    String ip = req.getRemoteAddr();
	    logger.debug("Client Ip : "+ip);
	    request.setClientIpAddress(ip);
	    
		response = missingSetupProcessorImpl.missingFactory(request,ProcessCode.DontCare,OperationType.UPDATE);
		return response;
	}

	@Override
	public IssuerAuthorizerSetupResponse deleteMissingTransaction(
			IssuerAuthorizerSetupRequest request) {
		
		IssuerAuthorizerSetupResponse response = new IssuerAuthorizerSetupResponse();
		MessageContext mc = wsContext.getMessageContext();	
	    HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
	    String ip = req.getRemoteAddr();
	    logger.debug("Client Ip : "+ip);
	    request.setClientIpAddress(ip);
	    
		response = missingSetupProcessorImpl.missingFactory(request,ProcessCode.DontCare,OperationType.Delete);
		return response;
	}
	
	@Override
	public IssuerAuthorizerSetupResponse confirmMissingTransactions(
			IssuerAuthorizerSetupRequest request) {
	
		IssuerAuthorizerSetupResponse response = new IssuerAuthorizerSetupResponse();
		MessageContext mc = wsContext.getMessageContext();	
	    HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
	    String ip = req.getRemoteAddr();
	    logger.debug("Client Ip : "+ip);
	    request.setClientIpAddress(ip);
	    
	    response = authorizerSetupProcessor.authorizerFactory(request);
		return response;
	}



	
}
