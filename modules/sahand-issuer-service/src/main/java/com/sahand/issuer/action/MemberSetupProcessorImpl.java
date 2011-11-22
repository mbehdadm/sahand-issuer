package com.sahand.issuer.action;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import org.slf4j.Logger;

import com.sahand.acquirer.exception.AcquirerException;
import com.sahand.common.util.enumeration.OperationType;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.common.util.message.ResponseGenerator;
import com.sahand.common.util.message.StatusCode;
import com.sahand.issuer.data.MemberInformation;
import com.sahand.issuer.data.ProgramInformation;
import com.sahand.issuer.exception.IssuerException;
import com.sahand.issuer.message.IssuerSetupRequest;
import com.sahand.issuer.message.IssuerSetupResponse;
import com.sahand.issuer.model.Members;
import com.sahand.issuer.model.Program;


@Stateless
public class MemberSetupProcessorImpl {


	private static Logger logger = SahandLogger.getSahandLogger(MemberSetupProcessorImpl.class);

	@Resource
	private SessionContext context;

	@EJB
	private MemberManagementImpl memberManagement;
	private Members members;

	public IssuerSetupResponse memberFactory(IssuerSetupRequest request,
			OperationType type) {
		IssuerSetupResponse response = new IssuerSetupResponse();
		try {
			MemberInformation memberInformation = request.getMember();
			String key = null;
			logger.debug("Operation type : "+type);
			if(type == OperationType.UPDATE){
				key = "member.update.success";
				members = memberManagement.find(memberInformation.getMemberId());
				if(members == null)
					throw new AcquirerException("member.not.find");
				memberInformation = editMember(memberInformation);

			}
			else if(type == OperationType.CREATE){
				key = "member.create.success";
				memberInformation = createMember(memberInformation);	
			}
			else if(type == OperationType.DELETE){
				key = "program.delete.success";
				members = memberManagement.find(memberInformation.getMemberId());
				if(members == null)
					throw new AcquirerException("program.not.find");
				deleteMember(memberInformation.getMemberId());
			}

			response = (IssuerSetupResponse)ResponseGenerator.generate(StatusCode.SUCCESSFUL, key,IssuerSetupResponse.class);
			response.setMember(memberInformation);

		} catch (IssuerException e) {
			context.setRollbackOnly();
			response = (IssuerSetupResponse)ResponseGenerator.generate(StatusCode.FAILED,e.getMessage(),IssuerSetupResponse.class);
		}catch (Exception e) {
			e.printStackTrace();
			context.setRollbackOnly();
			response = (IssuerSetupResponse)ResponseGenerator.generate(StatusCode.FAILED,"unkwnown.error.occured",IssuerSetupResponse.class);
		}
		return response;
	}

	// Member create - edit
	public MemberInformation createMember(MemberInformation memberInformation) throws Exception{

		members = memberManagement.create(memberInformation);
		logger.debug(members.toString());
		memberManagement.persist(members);
		memberInformation = memberManagement.convertFrom(members,memberInformation);
		return memberInformation;
	}
	public MemberInformation editMember(MemberInformation memberInformation) throws Exception{
		members = memberManagement.edit(memberInformation);
		logger.debug(members.toString());
		memberManagement.update(members);
		memberInformation = memberManagement.convertFrom(members,memberInformation);
		return memberInformation;
	}
	public void deleteMember(Long memberId) throws Exception{
		memberManagement.delete(memberId);
	}





}
