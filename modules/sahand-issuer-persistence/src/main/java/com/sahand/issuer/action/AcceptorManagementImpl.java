package com.sahand.issuer.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.sahand.acquirer.action.AcceptorManagement;
import com.sahand.acquirer.action.AcceptorManagementImpl;
import com.sahand.acquirer.action.AcquirerRepository;
import com.sahand.acquirer.action.SequenceGenerator;
import com.sahand.acquirer.config.AcquirerConfigLoader;
import com.sahand.acquirer.data.AcceptorDto;
import com.sahand.acquirer.data.enumeration.AcceptorStatus;
import com.sahand.acquirer.data.enumeration.PaymentMethod;
import com.sahand.acquirer.data.enumeration.SettlementMethod;
import com.sahand.acquirer.model.CardAcceptor;
import com.sahand.acquirer.model.Terminal;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.issuer.exception.IssuerException;


@Stateless
public class AcceptorManagementImpl implements AcceptorManagement {

	private static Logger logger = SahandLogger.getSahandLogger(AcceptorManagementImpl.class);
	
	@Inject
	@AcquirerRepository
	EntityManager entityManager;


	public AcceptorDto convertFrom(CardAcceptor cardAcceptor,AcceptorDto acceptorDto) {
		if(acceptorDto == null)
			acceptorDto = new AcceptorDto();
		acceptorDto.setBusinessCode(cardAcceptor.getBussinessCode());
		acceptorDto.setPaymentCode(PaymentMethod.fromValue(cardAcceptor.getPaymentMethod()));
		acceptorDto.setReconciliationLength(cardAcceptor.getReconciliationLength());
		acceptorDto.setSettlementMethod(SettlementMethod.fromValue(cardAcceptor.getSettlementMethod()));
		acceptorDto.setStatus(AcceptorStatus.fromValue(cardAcceptor.getStatus()));
		acceptorDto.setStatusDate(cardAcceptor.getStatusDate());
		acceptorDto.setId(cardAcceptor.getAcceptorId());
		return acceptorDto;
	}
	
	public CardAcceptor convertFrom(AcceptorDto acceptor,CardAcceptor cardAcceptor) {
		if(cardAcceptor == null)
			cardAcceptor = new CardAcceptor();
		cardAcceptor.setAcceptorId(acceptor.getId());
		cardAcceptor.setBussinessCode(acceptor.getBusinessCode());
		cardAcceptor.setPaymentMethod(acceptor.getPaymentCode().toValue());
		cardAcceptor.setReconciliationLength(acceptor.getReconciliationLength());
		cardAcceptor.setSettlementMethod(acceptor.getSettlementMethod().toValue());
		cardAcceptor.setStatus(acceptor.getStatus().toValue());
		cardAcceptor.setStatusDate(acceptor.getStatusDate());
		return cardAcceptor;
		
	}

	
	
	public CardAcceptor edit(AcceptorDto acceptor) throws Exception {

		CardAcceptor cardAcceptor = null;
		try {

			cardAcceptor = find(acceptor.getId());
			if(cardAcceptor == null)
				throw new IssuerException("acceptor.not.find");

			cardAcceptor = checkAndConvertFrom(acceptor,cardAcceptor);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return cardAcceptor;
	}
	

	public CardAcceptor create(AcceptorDto acceptor) throws Exception {

		CardAcceptor cardAcceptor = null;
		try {

			cardAcceptor = checkAndConvertFrom(acceptor,cardAcceptor);
			
			String acceptorID = "";
			if(acceptor.isAutoGenerate()){
				CardAcceptor cardAcceptor_  = new CardAcceptor();
				while(cardAcceptor_ != null){
					acceptorID = SequenceGenerator.sequenceGenerator(/*pm.getEntityManager()*/entityManager, CardAcceptor.class, acceptor.getId(),"acceptor-seq");
					cardAcceptor_ = find(acceptorID);
				}
			}
			else{
				CardAcceptor cardAcceptor_ = find(acceptor.getId());
				if(cardAcceptor_ != null)
					throw new IssuerException("duplicate.acceptor.exist");
				acceptorID = SequenceGenerator.sequenceGenerator(null, CardAcceptor.class, acceptor.getId(),"acceptor-seq");
			}
			cardAcceptor.setAcceptorId(acceptorID);

			


		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return cardAcceptor;
	}
	

	public CardAcceptor find(String acceptorId) throws Exception {
		CardAcceptor cardAcceptor = null;
		try {

			cardAcceptor = /*pm.getEntityManager()*/entityManager.find(CardAcceptor.class, acceptorId);


		} catch (Exception e) {
			e.printStackTrace();

		}
		return cardAcceptor;
	}

	public void persist(CardAcceptor acceptor) throws Exception {
		try {

			/*pm.getEntityManager()*/entityManager.persist(acceptor);
			/*pm.getEntityManager()*/entityManager.flush();

		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("acceptor.persist.exception");

		}
		
	}
	
	public void update(CardAcceptor acceptor) throws Exception {
		try {

			/*pm.getEntityManager()*/entityManager.merge(acceptor);


		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("acceptor.update.exception");

		}
		
	}
	
	public CardAcceptor checkAndConvertFrom(AcceptorDto acceptor,CardAcceptor cardAcceptor) throws Exception{
		
		if(cardAcceptor == null)
			cardAcceptor = new CardAcceptor();
		
		if(acceptor.getBusinessCode() == null ){
			String busCode = AcquirerConfigLoader.getValue("bussiness-code");
			if(busCode != null)
				cardAcceptor.setBussinessCode(Short.valueOf(busCode));
		}
		else
			cardAcceptor.setBussinessCode(acceptor.getBusinessCode());

		if(acceptor.getPaymentCode() == null ){
			String payCode = AcquirerConfigLoader.getValue("payment-code");
			if(payCode != null)
				cardAcceptor.setPaymentMethod(Byte.valueOf(payCode));
		}
		else
			cardAcceptor.setPaymentMethod(acceptor.getPaymentCode().toValue());

		
		if(acceptor.getReconciliationLength() == null)
			cardAcceptor.setReconciliationLength(Byte.valueOf(AcquirerConfigLoader.getValue("reconciliation-length")));
		else
			cardAcceptor.setReconciliationLength(acceptor.getReconciliationLength());
		
		if(acceptor.getSettlementMethod() == null ){
			String settlement = AcquirerConfigLoader.getValue("settlement-method");
			cardAcceptor.setSettlementMethod(Byte.valueOf(settlement));
		}
		else
			cardAcceptor.setSettlementMethod(acceptor.getSettlementMethod().toValue());
		
		if(acceptor.getStatus() == null ){
			String status = AcquirerConfigLoader.getValue("acceptor-status");
			cardAcceptor.setStatus(Byte.valueOf(status));
		}
		else
			cardAcceptor.setStatus(acceptor.getStatus().toValue());
		cardAcceptor.setStatusDate(new Date());
		logger.debug(cardAcceptor.toString());
		return cardAcceptor;
		
	}

	public CardAcceptor getAcceptor(String acceptorId) throws Exception {
		CardAcceptor cardAcceptor = null;

		try {

			cardAcceptor = find(acceptorId);
			if(cardAcceptor == null)
				throw new IssuerException("acceptor.not.find");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return cardAcceptor;
	}

	@SuppressWarnings("unchecked")
	public List<CardAcceptor> getAcceptors() throws Exception {
		List<CardAcceptor> cardAcceptors = new ArrayList<CardAcceptor>();
		try {
			
			cardAcceptors = (List<CardAcceptor>)/*pm.getEntityManager()*/entityManager.createNamedQuery("acceptors")
									.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return cardAcceptors;
	}

	public List<Terminal> getTerminal(String acceptorId) throws Exception {
		List<Terminal> terminals = null;

		try {

			CardAcceptor cardAcceptor = find(acceptorId);
			if(cardAcceptor == null)
				throw new IssuerException("acceptor.not.find");
			
			Set<Terminal> setTerminals = cardAcceptor.getTerminals();
			terminals = new ArrayList<Terminal>(setTerminals);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return terminals;
	}



}
