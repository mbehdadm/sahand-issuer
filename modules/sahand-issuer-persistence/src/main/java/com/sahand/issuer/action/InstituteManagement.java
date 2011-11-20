package com.sahand.issuer.action;

import java.util.List;

import com.sahand.acquirer.data.InstituteDto;
import com.sahand.acquirer.model.CardAcceptor;
import com.sahand.acquirer.model.ExternalAccount;
import com.sahand.acquirer.model.Institute;

public interface InstituteManagement {

	public Institute edit(InstituteDto institute) throws Exception;
	public Institute create(InstituteDto institute) throws Exception;
	
	public Institute find(String institutelId) throws Exception;
	public void persist(Institute institute) throws Exception;
	public void update(Institute institute) throws Exception;
	
	public InstituteDto convertFrom(Institute instituteDa,InstituteDto instituteDto);
	public Institute convertFrom(InstituteDto institute,Institute instituteDa);
	public ExternalAccount getAccount(String instituteId) throws Exception;
	public List<CardAcceptor> getAcceptor(String instituteId) throws Exception;

}
