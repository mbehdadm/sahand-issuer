package com.sahand.issuer.action;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.sahand.acquirer.action.AcquirerRepository;
import com.sahand.acquirer.data.InstituteInformation;
import com.sahand.acquirer.model.Institute;
import com.sahand.common.util.SequenceGenerator;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.issuer.config.IssuerConfigLoader;
import com.sahand.issuer.exception.IssuerException;
import com.sahand.issuer.model.CreditOrganization;


@Stateless
public class CreditOrganizationManagementImpl {

	private static Logger logger = SahandLogger.getSahandLogger(CreditOrganizationManagementImpl.class);
	
	@Inject
	@AcquirerRepository
	EntityManager entityManager;

	public InstituteInformation convertFrom(Institute institute,
			CreditOrganization organization,
			InstituteInformation instituteInformation) {
		if(instituteInformation == null)
			instituteInformation = new InstituteInformation();
		instituteInformation.setAddress(institute.getAddress());
		instituteInformation.setEmail(institute.getEmail());
		instituteInformation.setId(institute.getInstituteId());
		instituteInformation.setIin(institute.getIin());
//		instituteInformation.setInstituteCity(institute.getInstituteCity());
		instituteInformation.setLatinAddress(institute.getLatinAddress());
		instituteInformation.setLatinName(institute.getLatinName());
		instituteInformation.setMobile(institute.getMobile());
		instituteInformation.setName(institute.getName());
		instituteInformation.setPhone(institute.getPhone());
//		if(creditOrganization.getType() != null)
//			instituteInformation.setType(InstitutionType.fromValue(creditOrganization.getType()));
//		else{
//			String type = IssuerConfigLoader.getValue("credit-organization-type");
//			instituteInformation.setType();
//		}
		instituteInformation.setUrl(institute.getUrl());
		if(organization.getActivationAmount() != null)
			instituteInformation.setActivationAmount(String.valueOf(organization.getActivationAmount()));

		return instituteInformation;
	}

	public InstituteInformation convertFrom(Institute creditOrganization,InstituteInformation instituteInformation) {
		if(instituteInformation == null)
			instituteInformation = new InstituteInformation();
		instituteInformation.setAddress(creditOrganization.getAddress());
		instituteInformation.setEmail(creditOrganization.getEmail());
		instituteInformation.setId(creditOrganization.getInstituteId());
		instituteInformation.setIin(creditOrganization.getIin());
//		instituteInformation.setInstituteCity(creditOrganization.getInstituteCity());
		instituteInformation.setLatinAddress(creditOrganization.getLatinAddress());
		instituteInformation.setLatinName(creditOrganization.getLatinName());
		instituteInformation.setMobile(creditOrganization.getMobile());
		instituteInformation.setName(creditOrganization.getName());
		instituteInformation.setPhone(creditOrganization.getPhone());
//		if(creditOrganization.getType() != null)
//			instituteInformation.setType(InstitutionType.fromValue(creditOrganization.getType()));
//		else{
//			String type = IssuerConfigLoader.getValue("credit-organization-type");
//			instituteInformation.setType();
//		}
		instituteInformation.setUrl(creditOrganization.getUrl());
//		instituteInformation.setActivationAmount(creditOrganization.get);

		return instituteInformation;
	}
	
	public Institute convertFrom(InstituteInformation instituteInformation,Institute institute) {
		if(institute == null)
			institute = new Institute();
		institute.setAddress(instituteInformation.getAddress());
		institute.setEmail(instituteInformation.getEmail());
		institute.setInstituteId(instituteInformation.getId());
		institute.setIin(instituteInformation.getIin());
//		institute.setInstituteCity(instituteInformation.getInstituteCity());
		institute.setLatinAddress(instituteInformation.getLatinAddress());
		institute.setLatinName(instituteInformation.getLatinName());
		institute.setMobile(instituteInformation.getMobile());
		institute.setName(instituteInformation.getName());
		institute.setPhone(instituteInformation.getPhone());
		if(instituteInformation.getType() != null)
			institute.setType(instituteInformation.getType().toValue());
		else{
			String type = IssuerConfigLoader.getValue("credit-organization-type");
			institute.setType(Byte.valueOf(type));
		}
		institute.setUrl(instituteInformation.getUrl());
		return institute;
		
	}

	
	
	public CreditOrganization edit_(InstituteInformation instituteInformation) throws Exception {

		CreditOrganization institute = null;
		try {

			institute = find_(instituteInformation.getId());
			if(institute == null)
				throw new IssuerException("credit.institute.not.find");
			
			if(instituteInformation.getActivationAmount() != null 
					&& instituteInformation.getActivationAmount().length() > 0)
				institute.setActivationAmount(Integer.valueOf(instituteInformation.getActivationAmount()));
			institute.setInstitutionId(institute.getInstitutionId());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return institute;
	}
	
	public Institute edit(InstituteInformation instituteInformation) throws Exception {

		Institute institute = null;
		try {

			institute = find(instituteInformation.getId());
			if(institute == null)
				throw new IssuerException("institute.not.find");

			institute = checkAndConvertFrom(instituteInformation,institute);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return institute;
	}


	public Institute create(InstituteInformation instituteInformationn) throws Exception {

		Institute institute = null;
		try {

			institute = checkAndConvertFrom(instituteInformationn,institute);
			
			String instituteID = "";
			if(instituteInformationn.isAutoGenerate()){
				Institute institute_  = new Institute();
				while(institute_ != null){
					String key = IssuerConfigLoader.getValue("institute-seq");
					instituteID = SequenceGenerator.sequenceGenerator(entityManager, instituteID,key,null);
					institute_ = find(instituteID);
				}
			}
			else{
				Institute institute_ = find(instituteInformationn.getId());
				if(institute_ != null)
					throw new IssuerException("duplicate.institute.exist");
				String key = IssuerConfigLoader.getValue("institute-seq");
				instituteID = SequenceGenerator.sequenceGenerator(null,instituteID,key,null);
			}
			institute.setInstituteId(instituteID);


		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return institute;
	}
	
	public CreditOrganization create_(InstituteInformation instituteInformationn) throws Exception {

		CreditOrganization institute = null;
		try {
			institute = find_(instituteInformationn.getId());
			if(institute != null)
				throw new IssuerException("duplicate.credit.institute.exist");
			institute = new CreditOrganization();
			institute.setInstitutionId(instituteInformationn.getId());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return institute;
	}
	

	public Institute find(String instituteId) throws Exception {
		Institute institute = null;
		try {

			institute = entityManager.find(Institute.class, instituteId);


		} catch (Exception e) {
			e.printStackTrace();

		}
		return institute;
	}
	
	public CreditOrganization find_(String instituteId) throws Exception {
		CreditOrganization institute = null;
		try {

			institute = entityManager.find(CreditOrganization.class, instituteId);


		} catch (Exception e) {
			e.printStackTrace();

		}
		return institute;
	}


	public void persist(Institute institute) throws Exception {
		try {

			entityManager.persist(institute);
			entityManager.flush();

		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("institute.persist.exception");

		}
		
	}
	public void persist_(CreditOrganization institute) throws Exception {
		try {

			entityManager.persist(institute);
			entityManager.flush();

		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("credit.institute.persist.exception");

		}
		
	}
	
	public void update(Institute institute) throws Exception {
		try {

			entityManager.merge(institute);


		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("institute.update.exception");

		}
		
	}
	public void update_(CreditOrganization institute) throws Exception {
		try {

			entityManager.merge(institute);


		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("institute.update.exception");

		}
		
	}
	
	
	public void delete(String instituteId) throws Exception {
		Institute institute = null;
		try {

			institute = entityManager.find(Institute.class, instituteId);
			if(institute == null)
				throw new IssuerException("institute.not.find");
			entityManager.remove(institute);

		} catch (IssuerException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("institute.delete.exception");

		}
		
	}
	
	public void delete_(String instituteId) throws Exception {
		CreditOrganization institute = null;
		try {

			institute = find_(instituteId);
			if(institute == null)
				throw new IssuerException("credit.institute.not.find");
			entityManager.remove(institute);

		} catch (IssuerException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("credit.institute.delete.exception");

		}
		
	}
	
	public Institute checkAndConvertFrom(InstituteInformation instituteInformation,Institute institute) throws Exception{
		
		if(institute == null)
			institute = new Institute();
		
		institute.setAddress(instituteInformation.getAddress());
		institute.setEmail(instituteInformation.getEmail());
		institute.setInstituteId(instituteInformation.getId());
		institute.setIin(instituteInformation.getIin());
//		institute.setInstituteCity(instituteInformation.getInstituteCity());
		institute.setLatinAddress(instituteInformation.getLatinAddress());
		institute.setLatinName(instituteInformation.getLatinName());
		institute.setMobile(instituteInformation.getMobile());
		institute.setName(instituteInformation.getName());
		institute.setPhone(instituteInformation.getPhone());
		if(instituteInformation.getType() != null)
			institute.setType(instituteInformation.getType().toValue());
		institute.setUrl(instituteInformation.getUrl());
		
		logger.debug(institute.toString());
		return institute;
		
	}

	public Institute getInstitute(String instituteId) throws Exception {
		Institute institute = null;

		try {

			institute = find(instituteId);
			if(institute == null)
				throw new IssuerException("institute.not.find");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return institute;
	}



	




}
