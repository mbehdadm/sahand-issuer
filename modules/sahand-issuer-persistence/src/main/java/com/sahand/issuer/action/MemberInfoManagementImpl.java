package com.sahand.issuer.action;

import java.math.BigDecimal;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.sahand.acquirer.action.AcquirerRepository;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.issuer.data.MemberInformation;
import com.sahand.issuer.exception.IssuerException;
import com.sahand.issuer.model.MemberInfo;


@Stateless
public class MemberInfoManagementImpl {

	private static Logger logger = SahandLogger.getSahandLogger(MemberInfoManagementImpl.class);
	
	@Inject
	@AcquirerRepository
	EntityManager entityManager;


	public MemberInformation convertFrom(MemberInfo memberInfo,MemberInformation memberInformation) {
		if(memberInformation == null)
			memberInformation = new MemberInformation();
		memberInformation.setBirthcity(memberInfo.getBirthcity());
		memberInformation.setBirthday(memberInfo.getBirthday());
		memberInformation.setBloodGroup(memberInfo.getBloodGroup());
		memberInformation.setCellPhone(memberInfo.getCellPhone());
		memberInformation.setEducationLevel(memberInfo.getEducationLevel());
		memberInformation.setEmail(memberInfo.getEmail());
		memberInformation.setFatherName(memberInfo.getFatherName());
		memberInformation.setFavoriteColor(memberInfo.getFavoriteColor());
		memberInformation.setGender(memberInfo.getGender());
		memberInformation.setHomeAddress(memberInfo.getHomeAddress());
		if(memberInfo.getHomeTel() != null)
			memberInformation.setHomePostalCode(memberInfo.getHomePostalCode().toPlainString());
		memberInformation.setHomeTel(memberInfo.getHomeTel());
		memberInformation.setMarriageDate(memberInfo.getMarriageDate());
		memberInformation.setMarriageStatus(memberInfo.getMarriageStatus());
		memberInformation.setMemberId(memberInfo.getMemberId());
		memberInformation.setMiprsweburl(memberInfo.getMiprsweburl());
		memberInformation.setMotherName(memberInfo.getMotherName());
		memberInformation.setNationalId(memberInfo.getNationalId());
		memberInformation.setPassportId(memberInfo.getPassportId());
		memberInformation.setPicture(memberInfo.getPicture());
		if(memberInfo.getPostAddress() != null)
			memberInformation.setPostAddress(memberInfo.getPostAddress().toPlainString());
		memberInformation.setSignature(memberInfo.getSignature());
		memberInformation.setWorkAddress(memberInfo.getWorkAddress());
		if(memberInfo.getWorkPostalCode() != null)
		memberInformation.setWorkPostalCode(memberInfo.getWorkPostalCode().toPlainString());
		memberInformation.setWorkTel(memberInfo.getWorkTel());
		return memberInformation;
	}
	
	public MemberInfo convertFrom(MemberInformation memberInformation,MemberInfo memberInfo) {
		if(memberInfo == null)
			memberInfo = new MemberInfo();
		memberInfo.setBirthcity(memberInformation.getBirthcity());
		memberInfo.setBirthday(memberInformation.getBirthday());
		memberInfo.setBloodGroup(memberInformation.getBloodGroup());
		memberInfo.setCellPhone(memberInformation.getCellPhone());
		memberInfo.setEducationLevel(memberInformation.getEducationLevel());
		memberInfo.setEmail(memberInformation.getEmail());
		memberInfo.setFatherName(memberInformation.getFatherName());
		memberInfo.setFavoriteColor(memberInformation.getFavoriteColor());
		memberInfo.setGender(memberInformation.getGender());
		memberInfo.setHomeAddress(memberInformation.getHomeAddress());
		if(memberInformation.getHomeTel() != null)
			memberInfo.setHomePostalCode(new BigDecimal(memberInformation.getHomePostalCode()));
		memberInfo.setHomeTel(memberInformation.getHomeTel());
		memberInfo.setMarriageDate(memberInformation.getMarriageDate());
		memberInfo.setMarriageStatus(memberInformation.getMarriageStatus());
		memberInfo.setMemberId(memberInformation.getMemberId());
		memberInfo.setMiprsweburl(memberInformation.getMiprsweburl());
		memberInfo.setMotherName(memberInformation.getMotherName());
		memberInfo.setNationalId(memberInformation.getNationalId());
		memberInfo.setPassportId(memberInformation.getPassportId());
		memberInfo.setPicture(memberInformation.getPicture());
		if(memberInformation.getPostAddress() != null)
			memberInfo.setPostAddress(new BigDecimal(memberInformation.getPostAddress()));
		memberInfo.setSignature(memberInformation.getSignature());
		memberInfo.setWorkAddress(memberInformation.getWorkAddress());
		if(memberInformation.getWorkPostalCode() != null)
		memberInfo.setWorkPostalCode(new BigDecimal(memberInformation.getWorkPostalCode()));
		memberInfo.setWorkTel(memberInformation.getWorkTel());
		return memberInfo;
		
	}

	
	
	public MemberInfo edit(MemberInformation memberInformation) throws Exception {

		MemberInfo memberInfo = null;
		try {

			memberInfo = find(memberInformation.getMemberId());
			if(memberInfo == null)
				throw new IssuerException("member.info.not.find");

			memberInfo = checkAndConvertFrom(memberInformation,memberInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return memberInfo;
	}
	

	public MemberInfo create(MemberInformation memberInformation) throws Exception {

		MemberInfo memberInfo = null;
		try {
			MemberInfo memberInfo_ = find(memberInformation.getMemberId());
			if(memberInfo_ != null)
				throw new IssuerException("duplicate.member.info.exist");
		
			memberInfo = checkAndConvertFrom(memberInformation,memberInfo);
				


		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return memberInfo;
	}
	

	public MemberInfo find(Long memberId) throws Exception {
		MemberInfo memberInfo = null;
		try {

			memberInfo = entityManager.find(MemberInfo.class, memberId);


		} catch (Exception e) {
			e.printStackTrace();

		}
		return memberInfo;
	}

	public void persist(MemberInfo memberInfo) throws Exception {
		try {

			entityManager.persist(memberInfo);
			entityManager.flush();

		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("member.info.persist.exception");

		}
		
	}
	
	public void update(MemberInfo memberInfo) throws Exception {
		try {

			entityManager.merge(memberInfo);


		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("member.info.update.exception");

		}
		
	}
	
	public void delete(Long memberId) throws Exception {
		MemberInfo memberInfo = null;
		try {

			memberInfo = entityManager.find(MemberInfo.class, memberId);

			entityManager.remove(memberInfo);

		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("member.info.delete.exception");

		}
		
	}
	
	public MemberInfo checkAndConvertFrom(MemberInformation memberInformation,MemberInfo memberInfo) throws Exception{
		
		if(memberInfo == null)
			memberInfo = new MemberInfo();
		memberInfo.setBirthcity(memberInformation.getBirthcity());
		memberInfo.setBirthday(memberInformation.getBirthday());
		memberInfo.setBloodGroup(memberInformation.getBloodGroup());
		memberInfo.setCellPhone(memberInformation.getCellPhone());
		memberInfo.setEducationLevel(memberInformation.getEducationLevel());
		memberInfo.setEmail(memberInformation.getEmail());
		memberInfo.setFatherName(memberInformation.getFatherName());
		memberInfo.setFavoriteColor(memberInformation.getFavoriteColor());
		memberInfo.setGender(memberInformation.getGender());
		memberInfo.setHomeAddress(memberInformation.getHomeAddress());
		if(memberInformation.getHomeTel() != null)
			memberInfo.setHomePostalCode(new BigDecimal(memberInformation.getHomePostalCode()));
		memberInfo.setHomeTel(memberInformation.getHomeTel());
		memberInfo.setMarriageDate(memberInformation.getMarriageDate());
		memberInfo.setMarriageStatus(memberInformation.getMarriageStatus());
		memberInfo.setMemberId(memberInformation.getMemberId());
		memberInfo.setMiprsweburl(memberInformation.getMiprsweburl());
		memberInfo.setMotherName(memberInformation.getMotherName());
		memberInfo.setNationalId(memberInformation.getNationalId());
		memberInfo.setPassportId(memberInformation.getPassportId());
		memberInfo.setPicture(memberInformation.getPicture());
		if(memberInformation.getPostAddress() != null)
			memberInfo.setPostAddress(new BigDecimal(memberInformation.getPostAddress()));
		memberInfo.setSignature(memberInformation.getSignature());
		memberInfo.setWorkAddress(memberInformation.getWorkAddress());
		if(memberInformation.getWorkPostalCode() != null)
		memberInfo.setWorkPostalCode(new BigDecimal(memberInformation.getWorkPostalCode()));
		memberInfo.setWorkTel(memberInformation.getWorkTel());
		logger.debug(memberInfo.toString());
		return memberInfo;
		
	}

	public MemberInfo getMemberInfo(Long memberId) throws Exception {
		MemberInfo memberInfo = null;

		try {

			memberInfo = find(memberId);
			if(memberInfo == null)
				throw new IssuerException("member.info.not.find");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return memberInfo;
	}

	




}
