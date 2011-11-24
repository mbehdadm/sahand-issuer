package com.sahand.issuer.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import org.slf4j.Logger;

import com.sahand.common.util.enumeration.OperationType;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.common.util.message.ResponseGenerator;
import com.sahand.common.util.message.StatusCode;
import com.sahand.issuer.data.ProgramInformation;
import com.sahand.issuer.data.ProgramParameterInformation;
import com.sahand.issuer.exception.IssuerException;
import com.sahand.issuer.message.IssuerSetupRequest;
import com.sahand.issuer.message.IssuerSetupResponse;
import com.sahand.issuer.model.Program;
import com.sahand.issuer.model.ProgramParameter;
import com.sahand.issuer.model.ProgramParameterId;


@Stateless
public class ProgramSetupProcessorImpl {


	private static Logger logger = SahandLogger.getSahandLogger(ProgramSetupProcessorImpl.class);

	@Resource
	private SessionContext context;

	@EJB
	private ProgramManagementImpl programManagement;
	private Program program;
	
	@EJB
	private ProgramParameterManagementImpl programParameterManagement;
	private ProgramParameter programParameter;


	public IssuerSetupResponse programFactory(IssuerSetupRequest request,
			OperationType type) {
		IssuerSetupResponse response = new IssuerSetupResponse();
		try {
			ProgramInformation programInformation = request.getProgram();
			List<ProgramParameterInformation> parameterInformations = new ArrayList<ProgramParameterInformation>();
			String key = null;
			logger.debug("Operation type : "+type);
			if(type == OperationType.UPDATE){
				key = "program.update.success";
//				program = programManagement.find(programInformation.getProgramId());
//				if(program == null)
//					throw new AcquirerException("program.not.find");
				

				programInformation = editProgram(programInformation);

				for (ProgramParameterInformation dto : programInformation.getParameterInformations()) {
					key = "program.parameter.update.success";
					ProgramParameterId id = new ProgramParameterId();
					id.setProgramId(programInformation.getProgramId());
					id.setProgramParameterType(dto.getProgramParameterTypes());
//					programParameter = programParameterManagement.find(id);
//					if(programParameter == null)
//						throw new AcquirerException("program.parameter.not.find");
					dto = editProgramParameter(id,dto);
					parameterInformations.add(dto);
				}
				
			}
			else if(type == OperationType.CREATE){
				key = "program.create.success";
				programInformation = createProgram(programInformation);	
				
				for (ProgramParameterInformation dto : programInformation.getParameterInformations()) {
					key = "program.parameter.create.success";
					ProgramParameterId id = new ProgramParameterId();
					id.setProgramId(programInformation.getProgramId());
					id.setProgramParameterType(dto.getProgramParameterTypes());
					dto = createProgramParameter(id,dto);
					parameterInformations.add(dto);
				}
			}
			else if(type == OperationType.DELETE){
				key = "program.delete.success";
//				program = programManagement.find(programInformation.getProgramId());
//				if(program == null)
//					throw new AcquirerException("program.not.find");
				deleteProgram(programInformation.getProgramId());	
			}
			else{
				throw new IssuerException("operation.type.not.define");

			}

			response = (IssuerSetupResponse)ResponseGenerator.generate(StatusCode.SUCCESSFUL, key,IssuerSetupResponse.class);
			programInformation.setParameterInformations(parameterInformations);
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
	
	public ProgramParameterInformation createProgramParameter(
			ProgramParameterId id, ProgramParameterInformation parameterInformation) throws Exception{
		programParameter = programParameterManagement.create(id,parameterInformation);
		logger.debug(programParameter.toString());
		programParameter.setProgram(program);
		programParameterManagement.persist(programParameter);
		parameterInformation = programParameterManagement.convertFrom(programParameter,parameterInformation);
		return parameterInformation;
	}


	
	public ProgramInformation editProgram(ProgramInformation programInformation) throws Exception{
		program = programManagement.edit(programInformation);
		logger.debug(program.toString());
		programManagement.update(program);
		programInformation = programManagement.convertFrom(program,programInformation);
		return programInformation;
	}
	
	public  ProgramParameterInformation editProgramParameter(
			ProgramParameterId id, ProgramParameterInformation parameterInformation) throws Exception{
		programParameter = programParameterManagement.edit(id,parameterInformation);
		logger.debug(programParameter.toString());
		programParameterManagement.update(programParameter);
		parameterInformation = programParameterManagement.convertFrom(programParameter,parameterInformation);
		return parameterInformation;
	}
	public void deleteProgram(Long programId) throws Exception{
		programManagement.delete(programId);
	}





}
