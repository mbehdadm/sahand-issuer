package com.sahand.issuer.action;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import org.slf4j.Logger;

import com.sahand.common.util.enumeration.OperationType;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.common.util.message.ResponseGenerator;
import com.sahand.common.util.message.StatusCode;
import com.sahand.issuer.data.CardInformation;
import com.sahand.issuer.data.MemberInformation;
import com.sahand.issuer.exception.IssuerException;
import com.sahand.issuer.message.IssuerSetupRequest;
import com.sahand.issuer.message.IssuerSetupResponse;
import com.sahand.issuer.model.CardType;
import com.sahand.issuer.model.CreditOrganization;
import com.sahand.issuer.model.MemberCard;
import com.sahand.issuer.model.MemberInfo;
import com.sahand.issuer.model.Members;


@Stateless
public class MemberSetupProcessorImpl {


	private static Logger logger = SahandLogger.getSahandLogger(MemberSetupProcessorImpl.class);

	@Resource
	private SessionContext context;

	private CreditOrganization organization;
	private Members members;
	private MemberInfo memberInfo;
	private MemberCard memberCard;
	private CardType cardType;
	
	@EJB
	private CreditOrganizationManagementImpl creditOrganizationManagement;
	
	@EJB
	private MemberManagementImpl memberManagement;
	
	@EJB
	private MemberInfoManagementImpl memberInfoManagement;
	
	@EJB
	private MemberCardManagementImpl memberCardManagement;
	
	@EJB
	private CardTypeManagementImpl cardTypeManagement;


	public IssuerSetupResponse memberFactory(IssuerSetupRequest request,
			OperationType type) {
		IssuerSetupResponse response = new IssuerSetupResponse();
		try {
			MemberInformation memberInformation = request.getMember();
			String key = null;
			logger.debug("Operation type : "+type);
			if(type == OperationType.UPDATE){
				key = "member.update.success";
//				members = memberManagement.find(memberInformation.getMemberId());
//				if(members == null)
//					throw new AcquirerException("member.not.find");
				memberInformation = editMember(memberInformation);
				
				
				key = "member.info.update.success";
				memberInformation = editMemberInformation(memberInformation);
			}
			else if(type == OperationType.CREATE){
				organization = creditOrganizationManagement.find_(request.getInstitute().getId());
				if(organization == null)
					throw new IssuerException("credit.institute.not.find");
				key = "member.create.success";
				memberInformation = createMember(memberInformation);
				
				key = "member.info.create.success";
				memberInformation = createMemberInformation(memberInformation);
			}
			else if(type == OperationType.DELETE){
				key = "program.delete.success";
//				members = memberManagement.find(memberInformation.getMemberId());
//				if(members == null)
//					throw new AcquirerException("program.not.find");
				deleteMember(memberInformation.getMemberId());
			}
			else{
				throw new IssuerException("operation.type.not.define");

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



	// Member-MemberInfo create - edit
	public MemberInformation createMember(MemberInformation memberInformation) throws Exception{
		members = memberManagement.create(memberInformation);
		logger.debug(members.toString());
		memberManagement.persist(members);
		memberInformation = memberManagement.convertFrom(members,memberInformation);
		return memberInformation;
	}
	public MemberInformation createMemberInformation(
			MemberInformation memberInformation) throws Exception{
		memberInfo = memberInfoManagement.create(memberInformation);
		logger.debug(memberInfo.toString());
		memberInfoManagement.persist(memberInfo);
		memberInformation = memberInfoManagement.convertFrom(memberInfo,memberInformation);
		return memberInformation;
	}
	public MemberInformation editMember(MemberInformation memberInformation) throws Exception{
		members = memberManagement.edit(memberInformation);
		logger.debug(members.toString());
		memberManagement.update(members);
		memberInformation = memberManagement.convertFrom(members,memberInformation);
		return memberInformation;
	}
	public MemberInformation editMemberInformation(
			MemberInformation memberInformation) throws Exception{
		memberInfo = memberInfoManagement.edit(memberInformation);
		logger.debug(memberInfo.toString());
		memberInfo.setMember(members);
		memberInfoManagement.update(memberInfo);
		memberInformation = memberInfoManagement.convertFrom(memberInfo,memberInformation);
		return memberInformation;
	}
	public void deleteMember(Long memberId) throws Exception{
		memberInfoManagement.delete(memberId);
		memberManagement.delete(memberId);
	}



	public IssuerSetupResponse memberCardFactory(IssuerSetupRequest request,
			OperationType type) {
		IssuerSetupResponse response = new IssuerSetupResponse();
		try {
			CardInformation cardInformation = request.getCard();
			String key = null;
			logger.debug("Operation type : "+type);
			if(type == OperationType.UPDATE){
				key = "member.card.update.success";
				cardInformation= editMemberCard(cardInformation);
			}
			else if(type == OperationType.CREATE){
				members = memberManagement.find(request.getMember().getMemberId());
				if(members == null)
					throw new IssuerException("member.not.find");
				cardType = cardTypeManagement.find(request.getCardType().getId());
				if(cardType == null)
					throw new IssuerException("card.type.not.find");
				key = "member.card.create.success";
				cardInformation = createMemberCard(cardInformation);
				
			}
			else if(type == OperationType.DELETE){
				key = "member.card.delete.success";
				deleteMemberCard(cardInformation.getPan());
			}
			else{
				throw new IssuerException("operation.type.not.define");

			}

			response = (IssuerSetupResponse)ResponseGenerator.generate(StatusCode.SUCCESSFUL, key,IssuerSetupResponse.class);
			response.setCard(cardInformation);

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



	public CardInformation createMemberCard(CardInformation cardInformation) throws Exception{
		memberCard = memberCardManagement.create(cardInformation);
		logger.debug(memberCard.toString());
		memberCard.setMember(members);
		memberCard.setCardType(cardType);
		memberCardManagement.persist(memberCard);
		cardInformation = memberCardManagement.convertFrom(memberCard,cardInformation);
		return cardInformation;
	}



	public CardInformation editMemberCard(CardInformation cardInformation) throws Exception{
		memberCard = memberCardManagement.edit(cardInformation);
		logger.debug(memberCard.toString());
//		memberCard.setMember(members);
//		memberCard.setCardType(cardType);
		memberCardManagement.update(memberCard);
		cardInformation = memberCardManagement.convertFrom(memberCard,cardInformation);
		return cardInformation;
	}
	

	private void deleteMemberCard(String pan) throws Exception{
		memberCardManagement.delete(pan);
	}


}
