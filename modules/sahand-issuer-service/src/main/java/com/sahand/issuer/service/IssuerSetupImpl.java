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
import com.sahand.issuer.action.MemberSetupProcessorImpl;
import com.sahand.issuer.action.ProgramSetupProcessorImpl;
import com.sahand.issuer.message.IssuerSetupRequest;
import com.sahand.issuer.message.IssuerSetupResponse;

@Stateless
@WebServlet
public class IssuerSetupImpl implements IssuerSetup {

	private static Logger logger = SahandLogger.getSahandLogger(IssuerSetupImpl.class);
	
	
	@Resource
	private WebServiceContext wsContext;

	@EJB
	private ProgramSetupProcessorImpl programSetupProcessor;
	
	@EJB
	private MemberSetupProcessorImpl memberSetupProcessor;
	
	public IssuerSetupResponse addProgram(IssuerSetupRequest request) {
		IssuerSetupResponse response = new IssuerSetupResponse();
		
		MessageContext mc = wsContext.getMessageContext();	
	    HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
	    String ip = req.getRemoteAddr();
	    logger.debug("Client Ip : "+ip);
	    request.setClientIpAddress(ip);
		
	    response = programSetupProcessor.programFactory(request,OperationType.CREATE);
	    
	    return response;
	}

	@Override
	public IssuerSetupResponse editProgram(IssuerSetupRequest request) {
		IssuerSetupResponse response = new IssuerSetupResponse();
		
		MessageContext mc = wsContext.getMessageContext();	
	    HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
	    String ip = req.getRemoteAddr();
	    logger.debug("Client Ip : "+ip);
	    request.setClientIpAddress(ip);
		
	    response = programSetupProcessor.programFactory(request,OperationType.UPDATE);
	    
	    return response;
	}

	@Override
	public IssuerSetupResponse removeProgram(IssuerSetupRequest request) {
		IssuerSetupResponse response = new IssuerSetupResponse();
		
		MessageContext mc = wsContext.getMessageContext();	
	    HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
	    String ip = req.getRemoteAddr();
	    logger.debug("Client Ip : "+ip);
	    request.setClientIpAddress(ip);
		
	    response = programSetupProcessor.programFactory(request,OperationType.DELETE);
	    
	    return response;
	}

	@Override
	public IssuerSetupResponse registerMemberInformation(
			IssuerSetupRequest request) {
		IssuerSetupResponse response = new IssuerSetupResponse();
		
		MessageContext mc = wsContext.getMessageContext();	
	    HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
	    String ip = req.getRemoteAddr();
	    logger.debug("Client Ip : "+ip);
	    request.setClientIpAddress(ip);
		
	    response = memberSetupProcessor.memberFactory(request,OperationType.CREATE);
	    
	    return response;
	}

	@Override
	public IssuerSetupResponse editMemberInformation(IssuerSetupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IssuerSetupResponse assignCardToMember(IssuerSetupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IssuerSetupResponse editMemberCard(IssuerSetupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IssuerSetupResponse modifyCardStatus(IssuerSetupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
