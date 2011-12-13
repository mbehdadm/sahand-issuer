package com.sahand.issuer.service;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.jboss.wsf.spi.annotation.WebContext;
import org.slf4j.Logger;

import com.sahand.common.util.enumeration.OperationType;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.issuer.action.CardSetupProcessorImpl;
import com.sahand.issuer.action.MemberSetupProcessorImpl;
import com.sahand.issuer.action.ProgramSetupProcessorImpl;
import com.sahand.issuer.action.ValidationMissingSetupAuditor;
import com.sahand.issuer.message.IssuerSetupRequest;
import com.sahand.issuer.message.IssuerSetupResponse;

@Stateless
@WebServlet
@WebContext(contextRoot="switch-issuer")
@Interceptors(/*Login,*/ValidationMissingSetupAuditor.class/*,authenticate*/)
public class IssuerSetupImpl implements IssuerSetup {

	private static Logger logger = SahandLogger.getSahandLogger(IssuerSetupImpl.class);
	
	
	@Resource
	private WebServiceContext wsContext;

	@EJB
	private ProgramSetupProcessorImpl programSetupProcessor;
	
	@EJB
	private MemberSetupProcessorImpl memberSetupProcessor;
	
	@EJB
	private CardSetupProcessorImpl cardSetupProcessor;
	
	
	public IssuerSetupResponse registerProgram(IssuerSetupRequest request) {
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
	public IssuerSetupResponse addProgramPartner(IssuerSetupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IssuerSetupResponse editProgramPartner(IssuerSetupRequest request) {
		// TODO Auto-generated method stub
		return null;
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
		IssuerSetupResponse response = new IssuerSetupResponse();
		
		MessageContext mc = wsContext.getMessageContext();	
	    HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
	    String ip = req.getRemoteAddr();
	    logger.debug("Client Ip : "+ip);
	    request.setClientIpAddress(ip);
		
	    response = memberSetupProcessor.memberFactory(request,OperationType.UPDATE);
	    
	    return response;
	}

	@Override
	public IssuerSetupResponse assignCardToMember(IssuerSetupRequest request) {
		IssuerSetupResponse response = new IssuerSetupResponse();
		
		MessageContext mc = wsContext.getMessageContext();	
	    HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
	    String ip = req.getRemoteAddr();
	    logger.debug("Client Ip : "+ip);
	    request.setClientIpAddress(ip);
		
	    response = memberSetupProcessor.memberCardFactory(request,OperationType.CREATE);
	    
	    return response;
	}

	@Override
	public IssuerSetupResponse editMemberCard(IssuerSetupRequest request) {
		IssuerSetupResponse response = new IssuerSetupResponse();
		
		MessageContext mc = wsContext.getMessageContext();	
	    HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
	    String ip = req.getRemoteAddr();
	    logger.debug("Client Ip : "+ip);
	    request.setClientIpAddress(ip);
		
	    response = memberSetupProcessor.memberCardFactory(request,OperationType.UPDATE);
	    
	    return response;
	}

	@Override
	public IssuerSetupResponse registerCardType(IssuerSetupRequest request) {
		IssuerSetupResponse response = new IssuerSetupResponse();
		
		MessageContext mc = wsContext.getMessageContext();	
	    HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
	    String ip = req.getRemoteAddr();
	    logger.debug("Client Ip : "+ip);
	    request.setClientIpAddress(ip);
		
	    response = cardSetupProcessor.cardTypeFactory(request,OperationType.CREATE);
	    
	    return response;
	}

	@Override
	public IssuerSetupResponse editCardType(IssuerSetupRequest request) {
		IssuerSetupResponse response = new IssuerSetupResponse();
		
		MessageContext mc = wsContext.getMessageContext();	
	    HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
	    String ip = req.getRemoteAddr();
	    logger.debug("Client Ip : "+ip);
	    request.setClientIpAddress(ip);
		
	    response = cardSetupProcessor.cardTypeFactory(request,OperationType.UPDATE);
	    
	    return response;
	}

	@Override
	public IssuerSetupResponse registerCreditOrganization(
			IssuerSetupRequest request) {
		IssuerSetupResponse response = new IssuerSetupResponse();
		
		MessageContext mc = wsContext.getMessageContext();	
	    HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
	    String ip = req.getRemoteAddr();
	    logger.debug("Client Ip : "+ip);
	    request.setClientIpAddress(ip);
		
	    response = cardSetupProcessor.creditOrganizationFactory(request,OperationType.CREATE);
	    
	    return response;
	}

	@Override
	public IssuerSetupResponse editCreditOrganization(IssuerSetupRequest request) {
		IssuerSetupResponse response = new IssuerSetupResponse();
		
		MessageContext mc = wsContext.getMessageContext();	
	    HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
	    String ip = req.getRemoteAddr();
	    logger.debug("Client Ip : "+ip);
	    request.setClientIpAddress(ip);
		
	    response = cardSetupProcessor.creditOrganizationFactory(request,OperationType.UPDATE);
	    
	    return response;
	}

	


	
}
