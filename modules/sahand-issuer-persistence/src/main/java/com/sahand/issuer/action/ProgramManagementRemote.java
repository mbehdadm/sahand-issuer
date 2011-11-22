package com.sahand.issuer.action;

import com.sahand.issuer.data.ProgramInformation;
import com.sahand.issuer.model.Program;

public interface ProgramManagementRemote {

	public Program edit(ProgramInformation programInformation) throws Exception ;
	public Program create(ProgramInformation programInformation) throws Exception;

	public Program find(Long programId) throws Exception;
	public void persist(Program program) throws Exception;
	public void update(Program program) throws Exception;
	public void delete(Long programId) throws Exception;

	public ProgramInformation convertFrom(Program program,ProgramInformation programInformation);
	public Program convertFrom(ProgramInformation programInformation,Program program);
	public Program getProgram(Long programId) throws Exception;

}
