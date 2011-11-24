package com.sahand.issuer.action;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.sahand.acquirer.action.AcquirerRepository;
import com.sahand.common.util.SequenceGenerator;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.issuer.config.IssuerConfigLoader;
import com.sahand.issuer.data.ProgramInformation;
import com.sahand.issuer.exception.IssuerException;
import com.sahand.issuer.model.Program;


@Stateless
public class ProgramManagementImpl {

	private static Logger logger = SahandLogger.getSahandLogger(ProgramManagementImpl.class);
	
	@Inject
	@AcquirerRepository
	EntityManager entityManager;


	public ProgramInformation convertFrom(Program program,ProgramInformation programInformation) {
		if(programInformation == null)
			programInformation = new ProgramInformation();
		programInformation.setDescription(program.getDescription());
		programInformation.setDisplayName(program.getDisplayName());
		programInformation.setLimitation(program.getLimitation());
		programInformation.setName(program.getName());
		programInformation.setProgramId(program.getId());
		programInformation.setRules(program.getRules());
		return programInformation;
	}
	
	public Program convertFrom(ProgramInformation programInformation,Program program) {
		if(program == null)
			program = new Program();
		program.setDescription(programInformation.getDescription());
		program.setDisplayName(programInformation.getDisplayName());
		program.setId(programInformation.getProgramId());
		program.setLimitation(programInformation.getLimitation());
		program.setName(programInformation.getName());
		program.setRules(programInformation.getRules());
		return program;
		
	}

	
	
	public Program edit(ProgramInformation programInformation) throws Exception {

		Program program = null;
		try {

			program = find(programInformation.getProgramId());
			if(program == null)
				throw new IssuerException("program.not.find");

			program = checkAndConvertFrom(programInformation,program);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return program;
	}
	

	public Program create(ProgramInformation programInformation) throws Exception {

		Program program = null;
		try {

			program = checkAndConvertFrom(programInformation,program);
			
			String programID = "";
			if(programInformation.isAutoGenerate()){
				Program program_  = new Program();
				while(program_ != null){
					String key = IssuerConfigLoader.getValue("program-seq");
					programID = SequenceGenerator.sequenceGenerator(entityManager,programID,key,null);
					program_ = find(Long.valueOf(programID));
				}
			}
			else{
				Program program_ = find(programInformation.getProgramId());
				if(program_ != null)
					throw new IssuerException("duplicate.program.exist");
				String key = IssuerConfigLoader.getValue("program-seq");
				programID = String.valueOf(programInformation.getProgramId());
				programID = SequenceGenerator.sequenceGenerator(null,  programID,key,null);
			}
			program.setId(Long.valueOf(programID));


		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return program;
	}
	

	public Program find(Long programId) throws Exception {
		Program program = null;
		try {

			program = entityManager.find(Program.class, programId);


		} catch (Exception e) {
			e.printStackTrace();

		}
		return program;
	}

	public void persist(Program program) throws Exception {
		try {

			entityManager.persist(program);
			entityManager.flush();

		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("program.persist.exception");

		}
		
	}
	
	public void update(Program program) throws Exception {
		try {

			entityManager.merge(program);


		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("program.update.exception");

		}
		
	}
	
	public void delete(Long programId) throws Exception {
		Program program = null;
		try {

			program = entityManager.find(Program.class, programId);
			if(program == null)
				throw new IssuerException("program.not.find");
			entityManager.remove(program);

		} catch (IssuerException e) {
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("program.delete.exception");

		}
		
	}
	
	public Program checkAndConvertFrom(ProgramInformation programInformation,Program program) throws Exception{
		
		if(program == null)
			program = new Program();
		
		program.setDescription(programInformation.getDescription());
		program.setDisplayName(programInformation.getDisplayName());
		program.setId(programInformation.getProgramId());
		program.setLimitation(programInformation.getLimitation());
		program.setName(programInformation.getName());
		program.setRules(programInformation.getRules());
		logger.debug(program.toString());
		return program;
		
	}

	public Program getProgram(Long programId) throws Exception {
		Program program = null;

		try {

			program = find(programId);
			if(program == null)
				throw new IssuerException("program.not.find");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return program;
	}

	




}
