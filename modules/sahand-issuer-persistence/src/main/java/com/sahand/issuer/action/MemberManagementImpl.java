package com.sahand.issuer.action;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.sahand.acquirer.action.AcquirerRepository;
import com.sahand.common.util.SequenceGenerator;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.issuer.config.IssuerConfigLoader;
import com.sahand.issuer.data.MemberInformation;
import com.sahand.issuer.exception.IssuerException;
import com.sahand.issuer.model.Members;


@Stateless
public class MemberManagementImpl {

	private static Logger logger = SahandLogger.getSahandLogger(MemberManagementImpl.class);
	
	@Inject
	@AcquirerRepository
	EntityManager entityManager;


	public MemberInformation convertFrom(Members members,MemberInformation memberInformation) {
		if(memberInformation == null)
			memberInformation = new MemberInformation();
		memberInformation.setLatinName(members.getLatinName());
		memberInformation.setLoginPassword(members.getLoginPassword());
		memberInformation.setLoginUser(members.getLoginUser());
		memberInformation.setMemberId(members.getMemberId());
		memberInformation.setName(members.getName());
		memberInformation.setStatus(members.getStatus());
		memberInformation.setStatusDate(members.getStatusDate());
		memberInformation.setType(members.getType());
		return memberInformation;
	}
	
	public Members convertFrom(MemberInformation memberInformation,Members members) {
		if(members == null)
			members = new Members();
		members.setLatinName(memberInformation.getLatinName());
		members.setLoginPassword(memberInformation.getLoginPassword());
		members.setLoginUser(memberInformation.getLoginUser());
		members.setMemberId(memberInformation.getMemberId());
		members.setName(memberInformation.getName());
		members.setStatus(memberInformation.getStatus());
		members.setStatusDate(memberInformation.getStatusDate());
		members.setType(memberInformation.getType());
		return members;
		
	}

	
	
	public Members edit(MemberInformation memberInformation) throws Exception {

		Members members = null;
		try {

			members = find(memberInformation.getMemberId());
			if(members == null)
				throw new IssuerException("member.not.find");

			members = checkAndConvertFrom(memberInformation,members);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return members;
	}
	

	public Members create(MemberInformation memberInformation) throws Exception {

		Members member = null;
		try {

			member = checkAndConvertFrom(memberInformation,member);
			
			String memberID = "";
			if(memberInformation.isAutoGenerate()){
				Members member_  = new Members();
				while(member_ != null){
					String key = IssuerConfigLoader.getValue("member-seq");
					memberID = memberInformation.getMemberId() == null ? new String() : String.valueOf(memberInformation.getMemberId());
					memberID = SequenceGenerator.sequenceGenerator(entityManager, Members.class, memberID,key);
					member_ = find(Long.valueOf(memberID));
				}
			}
			else{
				Members member_ = find(memberInformation.getMemberId());
				if(member_ != null)
					throw new IssuerException("duplicate.member.exist");
				String key = IssuerConfigLoader.getValue("member-seq");
				memberID = memberInformation.getMemberId() == null ? new String() : String.valueOf(memberInformation.getMemberId());
				memberID = SequenceGenerator.sequenceGenerator(null, Members.class, memberID,key);
			}
			member.setMemberId(Long.valueOf(memberID));


		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return member;
	}
	

	public Members find(Long memberId) throws Exception {
		Members members = null;
		try {

			members = entityManager.find(Members.class, memberId);


		} catch (Exception e) {
			e.printStackTrace();

		}
		return members;
	}

	public void persist(Members members) throws Exception {
		try {

			entityManager.persist(members);
			entityManager.flush();

		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("member.persist.exception");

		}
		
	}
	
	public void update(Members members) throws Exception {
		try {

			entityManager.merge(members);


		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("member.update.exception");

		}
		
	}
	
	public void delete(Long memberId) throws Exception {
		Members members = null;
		try {

			members = entityManager.find(Members.class, memberId);

			entityManager.remove(members);

		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("member.delete.exception");

		}
		
	}
	
	public Members checkAndConvertFrom(MemberInformation memberInformation,Members members) throws Exception{
		
		if(members == null)
			members = new Members();
		
		members.setLatinName(memberInformation.getLatinName());
		members.setLoginPassword(memberInformation.getLoginPassword());
		members.setLoginUser(memberInformation.getLoginUser());
		members.setMemberId(memberInformation.getMemberId());
		members.setName(memberInformation.getName());
		members.setStatus(memberInformation.getStatus());
		members.setStatusDate(memberInformation.getStatusDate());
		members.setType(memberInformation.getType());
		logger.debug(members.toString());
		return members;
		
	}

	public Members getMember(Long memberId) throws Exception {
		Members members = null;

		try {

			members = find(memberId);
			if(members == null)
				throw new IssuerException("member.not.find");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return members;
	}

	




}
