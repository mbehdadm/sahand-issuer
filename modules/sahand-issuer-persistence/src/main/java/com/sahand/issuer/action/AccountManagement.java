package com.sahand.issuer.action;

import java.util.List;

import com.sahand.acquirer.data.AccountDto;
import com.sahand.acquirer.model.ExternalAccount;

public interface AccountManagement {

	public ExternalAccount edit(AccountDto account) throws Exception;
	public ExternalAccount create(AccountDto account) throws Exception;
	
	public ExternalAccount find(String accountId) throws Exception;
	public void persist(ExternalAccount account) throws Exception;
	public void update(ExternalAccount account) throws Exception;
	
	public boolean checkDigitPanNumber(String pan) throws Exception;
	public boolean isUniquePanNumber(String pan) throws Exception;
	
	public AccountDto convertFrom(ExternalAccount account,AccountDto accountDto);
	public ExternalAccount getAccount(String accountId) throws Exception;
	public List<ExternalAccount> getAccounts() throws Exception;
	

}
