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
import com.sahand.issuer.data.ProgramInformation;
import com.sahand.issuer.exception.IssuerException;
import com.sahand.issuer.message.IssuerSetupRequest;
import com.sahand.issuer.message.IssuerSetupResponse;
import com.sahand.issuer.model.Program;


@Stateless
public class ProgramSetupProcessorImpl {


	private static Logger logger = SahandLogger.getSahandLogger(ProgramSetupProcessorImpl.class);

	@Resource
	private SessionContext context;

	@EJB
	private ProgramManagementImpl programManagement;
	private Program program;

	public IssuerSetupResponse programFactory(IssuerSetupRequest request,
			OperationType type) {
		IssuerSetupResponse response = new IssuerSetupResponse();
		try {
			ProgramInformation programInformation = request.getProgram();
			String key = null;
			logger.debug("Operation type : "+type);
			if(type == OperationType.UPDATE){
				key = "program.update.success";
				program = programManagement.find(programInformation.getProgramId());
				if(program == null)
					throw new AcquirerException("program.not.find");
				programInformation = editProgram(programInformation);

			}
			else if(type == OperationType.CREATE){
				key = "program.create.success";
				programInformation = createProgram(programInformation);	
			}
			else if(type == OperationType.DELETE){
				key = "program.delete.success";
				program = programManagement.find(programInformation.getProgramId());
				if(program == null)
					throw new AcquirerException("program.not.find");
				deleteProgram(programInformation.getProgramId());	
			}

			response = (IssuerSetupResponse)ResponseGenerator.generate(StatusCode.SUCCESSFUL, key,IssuerSetupResponse.class);
			response.setProgram(programInformation);

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

	// Program create - edit
	public ProgramInformation createProgram(ProgramInformation programInformation) throws Exception{

		program = programManagement.create(programInformation);
		logger.debug(program.toString());
		programManagement.persist(program);
		programInformation = programManagement.convertFrom(program,programInformation);
		return programInformation;
	}
	public ProgramInformation editProgram(ProgramInformation programInformation) throws Exception{
		program = programManagement.edit(programInformation);
		logger.debug(program.toString());
		programManagement.update(program);
		programInformation = programManagement.convertFrom(program,programInformation);
		return programInformation;
	}
	public void deleteProgram(Long programId) throws Exception{
		programManagement.delete(programId);
	}





}
