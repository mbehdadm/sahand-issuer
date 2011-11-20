package com.sahand.issuer.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.sahand.acquirer.action.AcquirerRepository;
import com.sahand.acquirer.action.GeographicalManagement;
import com.sahand.acquirer.action.InstituteManagement;
import com.sahand.acquirer.action.InstituteManagementImpl;
import com.sahand.acquirer.action.SequenceGenerator;
import com.sahand.acquirer.config.AcquirerConfigLoader;
import com.sahand.acquirer.data.InstituteDto;
import com.sahand.acquirer.data.enumeration.InstitutionType;
import com.sahand.acquirer.model.CardAcceptor;
import com.sahand.acquirer.model.ExternalAccount;
import com.sahand.acquirer.model.Geographical;
import com.sahand.acquirer.model.Institute;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.issuer.exception.IssuerException;

@Stateless
public class InstituteManagementImpl implements InstituteManagement {

	private static Logger logger = SahandLogger.getSahandLogger(InstituteManagementImpl.class);

	
	@Inject
	@AcquirerRepository
	EntityManager entityManager;
	
	@EJB
	private GeographicalManagement geographicalManagement;
	
	
	public InstituteDto convertFrom(Institute instituteDa,InstituteDto instituteDto) {
		if(instituteDto == null)
			instituteDto = new InstituteDto();
		instituteDto.setAddress(instituteDa.getAddress());
		instituteDto.setEmail(instituteDa.getEmail());
		instituteDto.setId(instituteDa.getInstituteId());
		instituteDto.setLatinAddress(instituteDa.getLatinAddress());
		instituteDto.setLatinName(instituteDa.getLatinName());
		instituteDto.setMobile(instituteDa.getMobile());
		instituteDto.setName(instituteDa.getName());
		instituteDto.setPhone(instituteDa.getPhone());
		instituteDto.setType(InstitutionType.fromValue(instituteDa.getType()));
		instituteDto.setUrl(instituteDa.getUrl());
		instituteDto.setInstituteCity(geographicalManagement.convertFrom(instituteDa.getInstituteCity()));
		return instituteDto;
	}
	
	public Institute convertFrom(InstituteDto institute,Institute instituteDa) {
		if(instituteDa == null)
			instituteDa = new Institute();
		instituteDa.setAddress(institute.getAddress());
		instituteDa.setEmail(institute.getEmail());
		instituteDa.setIin(institute.getIin());
//		instituteDa.setInstituteCity(instituteCity)
		instituteDa.setInstituteId(institute.getId());
		instituteDa.setLatinAddress(institute.getLatinAddress());
		instituteDa.setLatinName(institute.getLatinName());
		instituteDa.setMobile(institute.getMobile());
		instituteDa.setName(institute.getName());
		instituteDa.setPhone(institute.getPhone());
		instituteDa.setType(institute.getType().toValue());
		instituteDa.setUrl(institute.getUrl());
		return instituteDa;
	}
	
	public Institute edit(InstituteDto institute) throws Exception {
		Institute instituteDa = null;

		try {

			instituteDa = find(institute.getId());
			if(instituteDa == null)
				throw new IssuerException("institute.not.find");

			instituteDa = checkAndConvertFrom(institute, instituteDa);
			
			instituteDa.setInstituteId(institute.getId());
			

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return instituteDa;
	}

	public Institute create(InstituteDto institute) throws Exception {
		Institute instituteDa = null;

		try {
			instituteDa = checkAndConvertFrom(institute, instituteDa);
			
			String instituteID = "";
			Institute institute_  = new Institute();
			while(institute_ != null){
				instituteID = SequenceGenerator.sequenceGenerator(/*pm.getEntityManager()*/entityManager, Institute.class, institute.getId(),"institute-seq");
				institute_ = find(instituteID);
			}
			instituteDa.setInstituteId(instituteID);


		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return instituteDa;
	}

	public Institute checkAndConvertFrom(InstituteDto institute,Institute instituteDa) throws Exception{
		if(instituteDa == null)
			instituteDa = new Institute();
		
		instituteDa.setEmail(institute.getEmail());
		if(institute.getIin() == null || institute.getIin().length() > 0){
			String iin = AcquirerConfigLoader.getValue("institute-iin");
			if(iin != null)
				instituteDa.setIin(iin);
		}
		else 
			instituteDa.setIin(institute.getIin());
		instituteDa.setLatinAddress(institute.getLatinAddress());
		instituteDa.setLatinName(institute.getLatinName());
		instituteDa.setAddress(institute.getAddress());
		instituteDa.setMobile(institute.getMobile());
		
		instituteDa.setName(institute.getName());
		instituteDa.setPhone(institute.getPhone());
		if(institute.getType() == null ){
			String istype = AcquirerConfigLoader.getValue("institute-type");
			if(istype != null)
				instituteDa.setType(Byte.valueOf(istype));
		}
		else
			instituteDa.setType(institute.getType().toValue());
		instituteDa.setUrl(institute.getUrl());
		if(institute.getInstituteCity() != null && institute.getInstituteCity().getCode() != null){
//			
//			Geographical geo = autoComplete.getZone(institute.getCityName(),2);
//			logger.info("Geographical : "+geo);
//			if(geo == null){
//				getStatusMessages().clearGlobalMessages();
//				StatusMessages.instance().addFromResourceBundle(Severity.ERROR,"city.create.failed");
//				return "fail";
//			}
			Geographical geographical = geographicalManagement.find(institute.getInstituteCity().getCode());
			instituteDa.setInstituteCity(geographical);
		}
		logger.debug(instituteDa.toString());

		return instituteDa;
		
	}
	public Institute find(String institutelId) throws Exception {
		Institute institute = null;
		try {

			institute = /*pm.getEntityManager()*/entityManager.find(Institute.class, institutelId);


		} catch (Exception e) {
			e.printStackTrace();

		}
		return institute;
	}

	public void persist(Institute institute) throws Exception {
		try {

			/*pm.getEntityManager()*/entityManager.persist(institute);


		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("institute.persist.exception");

		}
		
		
	}

	public void update(Institute institute) throws Exception {
		try {

			/*pm.getEntityManager()*/entityManager.merge(institute);
			/*pm.getEntityManager()*/entityManager.flush();

		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("institute.update.exception");

		}
		
		
	}

	public ExternalAccount getAccount(String instituteId) throws Exception {
		ExternalAccount account = null;

		try {

			Institute institute = find(instituteId);
			if(institute == null)
				throw new IssuerException("institute.not.find");

			account = institute.getExternalAccount();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return account;
	}

	public List<CardAcceptor> getAcceptor(String instituteId) throws Exception {
		List<CardAcceptor> acceptors = new ArrayList<CardAcceptor>();

		try {

			Institute institute = find(instituteId);
			if(institute == null)
				throw new IssuerException("institute.not.find");

			Set<CardAcceptor> setAcceptor = institute.getCardAcceptors();
			
			acceptors = new ArrayList<CardAcceptor>(setAcceptor);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return acceptors;
	}

	

	

	

}
