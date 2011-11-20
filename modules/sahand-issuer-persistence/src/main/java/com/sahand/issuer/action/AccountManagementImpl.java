package com.sahand.issuer.action;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.sahand.acquirer.action.AccountManagement;
import com.sahand.acquirer.action.AccountManagementImpl;
import com.sahand.acquirer.action.AcquirerRepository;
import com.sahand.acquirer.action.ConfigChecker;
import com.sahand.acquirer.action.SequenceGenerator;
import com.sahand.acquirer.config.AcquirerConfigLoader;
import com.sahand.acquirer.data.AccountDto;
import com.sahand.acquirer.data.enumeration.AccountType;
import com.sahand.acquirer.model.ExternalAccount;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.issuer.exception.IssuerException;


@Stateless
public class AccountManagementImpl implements AccountManagement {

	private static Logger logger = SahandLogger.getSahandLogger(AccountManagementImpl.class);

	@Inject
	@AcquirerRepository
	EntityManager entityManager;

	public AccountDto convertFrom(ExternalAccount account,AccountDto accountDto) {
		if(accountDto == null)
			accountDto = new AccountDto();
		if(account.getBankId() != null)
			accountDto.setBankid(String.valueOf(account.getBankId()));
		if(account.getBranchId() != null)
			accountDto.setBranchid(String.valueOf(account.getBranchId()));
		accountDto.setCardNumber(account.getAccountNumber());
		accountDto.setId(account.getAccountId());
		accountDto.setTitle(account.getTitle());
		accountDto.setType(AccountType.fromValue(account.getType()));
		return accountDto;
	}

	public ExternalAccount edit(AccountDto account) throws Exception {
		ExternalAccount accountDa = null;

		try {

			accountDa = find(account.getId());
			if(accountDa == null)
				throw new IssuerException("account.not.find");

			accountDa = checkAndConvertFrom(account,accountDa);

			accountDa.setAccountId(account.getId());


		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return accountDa;
	}

	public ExternalAccount create(AccountDto account) throws Exception {
		ExternalAccount accountDa = null;

		try {

			accountDa = checkAndConvertFrom(account,accountDa);

			String accountID = "";
			ExternalAccount accountDa_  = new ExternalAccount();
			while(accountDa_ != null){
				accountID = SequenceGenerator.sequenceGenerator(/*pm.getEntityManager()*/entityManager, ExternalAccount.class, account.getId(),"account-seq");
				accountDa_ = find(accountID);
			}
//				if(accountDa != null)
//				throw new AcquirerException("duplicate.account.exist");

			accountDa.setAccountId(accountID);


		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return accountDa;
	}

	public ExternalAccount checkAndConvertFrom(AccountDto account,ExternalAccount accountDa) throws Exception{
		if(accountDa == null)
			accountDa = new ExternalAccount();

		if(account.getType() == null ){
			String accountType = AcquirerConfigLoader.getValue("account-type");
			if(accountType != null)
				accountDa.setType(Byte.valueOf(accountType));
		}
		else
			accountDa.setType(account.getType().toValue());
		accountDa.setTitle(account.getTitle());

		String pan = account.getCardNumber();
		boolean panCheck = false;
		if(account.getType() == AccountType.PAN){
			panCheck = checkDigitPanNumber(pan);
			if(!panCheck){
				throw new IssuerException("pan.number.invalid");
			}
		}
		panCheck = isUniquePanNumber(pan);
		if(!panCheck){
			throw new IssuerException("duplicate.pan.number");
		}
		accountDa.setAccountNumber(pan);

		if(account.getBankid() != null && account.getBankid().length() > 0)
			accountDa.setBankId(Short.valueOf(account.getBankid()));
		if(account.getBranchid() != null && account.getBranchid().length() > 0)
			accountDa.setBranchId(Integer.valueOf(account.getBranchid()));
		logger.debug(accountDa.toString());
		return accountDa;

	}

	public ExternalAccount find(String accountId) throws Exception {
		ExternalAccount account = null;
		try {

			account = /*pm.getEntityManager()*/entityManager.find(ExternalAccount.class, accountId);


		} catch (Exception e) {
			e.printStackTrace();

		}
		return account;
	}

	public void persist(ExternalAccount account) throws Exception {
		try {

			/*pm.getEntityManager()*/entityManager.persist(account);
			/*pm.getEntityManager()*/entityManager.flush();

		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("account.persist.exception");

		}

	}

	public void update(ExternalAccount account) throws Exception {
		try {

			/*pm.getEntityManager()*/entityManager.merge(account);


		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("account.update.exception");

		}

	}


	public boolean checkDigitPanNumber(String pan) throws Exception{

		boolean panCheck = true;

		String panChecker = AcquirerConfigLoader.getValue("account-pan-check");
		if(panChecker.equals("1")){
			panCheck = ConfigChecker.CardNumberChecking(pan);
		}
		return panCheck;

	}

	public boolean isUniquePanNumber(String pan) throws Exception{

		boolean panCheck = true;
		try{
			String panChecker = AcquirerConfigLoader.getValue("account-pan-unique");
			if(panChecker.equals("1")){
				panCheck = /*pm.getEntityManager()*/entityManager.createNamedQuery("account.pan.isUnique")
						.setParameter(1, pan).getResultList().size() == 0 ? true : false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			panCheck = false;
		}
		return panCheck;
	}

	public ExternalAccount getAccount(String accountId) throws Exception {
		ExternalAccount account = null;

		try {

			account = find(accountId);
			if(account == null)
				throw new IssuerException("account.not.find");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return account;
	}

	@SuppressWarnings("unchecked")
	public List<ExternalAccount> getAccounts() throws Exception {
		List<ExternalAccount> accounts = new ArrayList<ExternalAccount>();
		try {
			
			accounts = (List<ExternalAccount>)/*pm.getEntityManager()*/entityManager.createNamedQuery("accounts")
									.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return accounts;
	}





}
