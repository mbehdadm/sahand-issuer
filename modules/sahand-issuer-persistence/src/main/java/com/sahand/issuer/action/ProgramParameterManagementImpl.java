package com.sahand.issuer.action;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.sahand.acquirer.action.AcquirerRepository;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.issuer.data.ProgramParameterInformation;
import com.sahand.issuer.exception.IssuerException;
import com.sahand.issuer.model.ProgramParameter;
import com.sahand.issuer.model.ProgramParameterId;


@Stateless
public class ProgramParameterManagementImpl {

	private static Logger logger = SahandLogger.getSahandLogger(ProgramParameterManagementImpl.class);

	@Inject
	@AcquirerRepository
	EntityManager entityManager;


	public ProgramParameterInformation convertFrom(ProgramParameter programParameter,ProgramParameterInformation programParameterInformation) {
		if(programParameterInformation == null)
			programParameterInformation = new ProgramParameterInformation();
		programParameterInformation.setValue(programParameter.getValue());
//		programParameterInformation.setProgramParameterId(programParameter.getProgramParameterId().getProgramId());
		programParameterInformation.setProgramParameterTypes(programParameter.getProgramParameterId().getProgramParameterType());
		programParameterInformation.setValueDataType(programParameter.getValueDataType());
		return programParameterInformation;
	}
	
	public ProgramParameter convertFrom(ProgramParameterInformation programParameterInformation,ProgramParameter programParameter) {
		if(programParameter == null)
			programParameter = new ProgramParameter();
		programParameter.setValue(programParameterInformation.getValue());
		programParameter.setValueDataType(programParameterInformation.getValueDataType());
		ProgramParameterId id = new  ProgramParameterId();
		id.setProgramParameterType(programParameterInformation.getProgramParameterTypes());
		programParameter.setProgramParameterId(id);
		return programParameter;
		
	}
	
	public ProgramParameter edit(ProgramParameterId id,ProgramParameterInformation programParameterInformation) throws Exception {

		ProgramParameter programParameter = null;
		try {
			programParameter = find(id);
			if(programParameter == null)
				throw new IssuerException("program.parameter.not.find");

			programParameter = checkAndConvertFrom(programParameterInformation,programParameter,id);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return programParameter;
	}
	

	public ProgramParameter create(ProgramParameterId id,ProgramParameterInformation programParameterInformation) throws Exception {

		ProgramParameter programParameter = null;
		try {
			ProgramParameter programParameter_ = find(id);
			if(programParameter_ != null)
				throw new IssuerException("duplicate.program.parameter.exist");
			
			programParameter = checkAndConvertFrom(programParameterInformation,programParameter,id);
			


		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return programParameter;
	}
	

	public ProgramParameter find(ProgramParameterId id) throws Exception {
		ProgramParameter programParameter = null;
		try {

			programParameter = entityManager.find(ProgramParameter.class, id);


		} catch (Exception e) {
			e.printStackTrace();

		}
		return programParameter;
	}

	public void persist(ProgramParameter programParameter) throws Exception {
		try {

			entityManager.persist(programParameter);
			entityManager.flush();

		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("program.parameter.persist.exception");

		}
		
	}
	
	public void update(ProgramParameter programParameter) throws Exception {
		try {

			entityManager.merge(programParameter);


		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("program.parameter.update.exception");

		}
		
	}
	
	public void delete(ProgramParameterId id) throws Exception {
		ProgramParameter programParameter = null;
		try {

			programParameter = entityManager.find(ProgramParameter.class, id);

			entityManager.remove(programParameter);

		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("program.parameter.delete.exception");

		}
		
	}
	
	public ProgramParameter checkAndConvertFrom(ProgramParameterInformation programParameterInformation
			,ProgramParameter programParameter,ProgramParameterId Id) throws Exception{
		
		if(programParameter == null)
			programParameter = new ProgramParameter();
		
		programParameter.setProgramParameterId(Id);
		programParameter.setValue(programParameterInformation.getValue());
		programParameter.setValueDataType(programParameterInformation.getValueDataType());
		logger.debug(programParameter.toString());
		return programParameter;
		
	}

	public ProgramParameter getProgram(ProgramParameterId id) throws Exception {
		ProgramParameter programParameter = null;

		try {

			programParameter = find(id);
			if(programParameter == null)
				throw new IssuerException("program.parameter.not.find");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return programParameter;
	}

	


}
