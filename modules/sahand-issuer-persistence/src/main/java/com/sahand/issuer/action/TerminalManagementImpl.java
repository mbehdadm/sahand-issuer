package com.sahand.issuer.action;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.sahand.acquirer.action.AcquirerRepository;
import com.sahand.acquirer.action.ConfigChecker;
import com.sahand.acquirer.action.SequenceGenerator;
import com.sahand.acquirer.action.TerminalManagement;
import com.sahand.acquirer.action.TerminalManagementImpl;
import com.sahand.acquirer.data.TerminalDto;
import com.sahand.acquirer.model.Terminal;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.issuer.exception.IssuerException;


@Stateless
public class TerminalManagementImpl implements TerminalManagement {

	private static Logger logger = SahandLogger.getSahandLogger(TerminalManagementImpl.class);

	@Inject
	@AcquirerRepository
	EntityManager entityManager;

	public TerminalDto convertFrom(Terminal terminalDa,TerminalDto terminalDto) {
		if(terminalDto == null)
			terminalDto = new TerminalDto();
		terminalDto.setApplicationDate(terminalDa.getReleaseDate());
		terminalDto.setApplicationVersion(terminalDa.getApplicationVersion());
		terminalDto.setDnsName(terminalDa.getDnsName());
		terminalDto.setId(terminalDa.getTerminalid());
		terminalDto.setIpAddress(terminalDa.getIpAddress());
		terminalDto.setPropertyNumber(terminalDa.getDnsName());
		terminalDto.setSerialNumber(terminalDa.getDnsName());
		terminalDto.setStan(terminalDa.getSystemTrace());
		//		terminalDto.setType(terminalDa.getPeer().get);
		return terminalDto;
	}
	
	public Terminal edit(TerminalDto terminal) throws Exception {

		Terminal terminalDa = null;

		try {

			terminalDa = find(terminal.getId());
			if(terminalDa == null)
				throw new IssuerException("terminal.not.find");

			terminalDa = checkAndConvertFrom(terminal, terminalDa);
			
//			terminalDa.setTerminalid(terminal.getId());
			
//			update(terminalDa);
			
//			terminalDto = convertFrom(terminalDa);


		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return terminalDa;
	}

	public Terminal create(TerminalDto terminal) throws Exception {
		
		Terminal terminalDa = null;

		try {
			terminalDa = checkAndConvertFrom(terminal,terminalDa);
			
			String terminalID = "";
			if(terminal.isAutoGenerate()){
				Terminal terminal_  = new Terminal();
				while(terminal_ != null){
					terminalID = SequenceGenerator.sequenceGenerator(/*pm.getEntityManager()*/entityManager, Terminal.class, terminal.getId(),"terminal-seq");
					terminal_ = find(terminalID);
				}
			}
			else{
				terminalID = SequenceGenerator.sequenceGenerator(null, Terminal.class, terminal.getId(),"terminal-seq");
				Terminal terminal_ = find(terminalID);
				if(terminal_ != null)
					throw new IssuerException("duplicate.terminal.exist");
			}
			terminalDa.setTerminalid(terminalID);

//			persist(terminalDa);
//			terminalDto = convertFrom(terminalDa);


		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return terminalDa;
	}
	
	public Terminal checkAndConvertFrom(TerminalDto terminal,Terminal terminalDa) throws Exception{
		if(terminalDa == null)
			terminalDa = new Terminal();
		
		String serialNo = checkSerialNumber(terminal.getSerialNumber());
		terminalDa.setSerialNumber(serialNo);
		terminalDa.setReleaseDate(terminal.getApplicationDate());
		terminalDa.setApplicationVersion(terminal.getApplicationVersion());
		String propertyNumber = terminal.getPropertyNumber();
		if(terminal.getPropertyNumber() != null && terminal.getPropertyNumber().length() > 0 ){


			if(ConfigChecker.checkPropertyNumber() && !(isUniquePropertyNumber(propertyNumber))){
				throw new IssuerException("terminal.property.duplicate");
			}


		}
		terminalDa.setDnsName(propertyNumber);

		//			getInstance().setTednsname(terminal.getDnsName());
		terminalDa.setSystemTrace(terminal.getStan());
		terminalDa.setIpAddress(terminal.getIpAddress());
		logger.debug(terminalDa.toString());
		return terminalDa;
		
	}

	public Terminal find(String terminalId) throws Exception {
		Terminal terminal = null;
		try {

			terminal = /*pm.getEntityManager()*/entityManager.find(Terminal.class, terminalId);


		} catch (Exception e) {
			e.printStackTrace();

		}
		return terminal;
	}
	
	public void persist(Terminal terminal) throws Exception {
		try {

			/*pm.getEntityManager()*/entityManager.persist(terminal);
			/*pm.getEntityManager()*/entityManager.flush();

		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("terminal.persist.exception");

		}
		
	}

	public void update(Terminal terminal) throws Exception {
		try {

			/*pm.getEntityManager()*/entityManager.merge(terminal);


		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("terminal.update.exception");

		}
		
	}
	public boolean isUniqueSerialNumber(String serialNo) {
		try {
			if(/*pm.getEntityManager()*/entityManager.createNamedQuery("terminal.serial.isUnique").setParameter(1, serialNo).getResultList().size() == 0)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean isUniquePropertyNumber(String propertyNumber) {
		try {
			if(/*pm.getEntityManager()*/entityManager.createNamedQuery("terminal.property.isUnique").setParameter(1, propertyNumber).getResultList().size() == 0)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	public String checkSerialNumber(String serial) throws Exception{
		if(serial != null && serial.length() > 0 ){
			serial = ConfigChecker.checkSerialNumber(serial);
			if(serial == null)
				throw new IssuerException("terminal.serial.invalid");
			if(!isUniqueSerialNumber(serial)){
				throw new IssuerException("terminal.serial.duplicate");
			}
		}
		return serial;
			
	}
	
	public Terminal editSerial(String terminalId, String serialNumber)
			throws Exception {
		Terminal terminalDa = null;

		try {

			terminalDa = find(terminalId);
			if(terminalDa == null)
				throw new IssuerException("terminal.not.find");
			String serial = checkSerialNumber(serialNumber);
			
			terminalDa.setSerialNumber(serial);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return terminalDa;
	}

	public Terminal getTerminal(String terminalId) throws Exception {
		Terminal terminalDa = null;

		try {

			terminalDa = find(terminalId);
			if(terminalDa == null)
				throw new IssuerException("terminal.not.find");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return terminalDa;
	}

	@SuppressWarnings("unchecked")
	public List<Terminal> getTerminals() throws Exception {
		List<Terminal> terminals = new ArrayList<Terminal>();
		try {
			
			terminals = (List<Terminal>)/*pm.getEntityManager()*/entityManager.createNamedQuery("terminals")
									.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return terminals;
	}

	public boolean isTerminalSetUp(String terminalId) throws Exception {
		boolean check = false;
		try {
			
				check = /*pm.getEntityManager()*/entityManager.createNativeQuery("SELECT	trans.*	FROM TRNSXN trans	WHERE	trans.txtermid = ?1")/*createNamedQuery("terminal.check.initialize")*/
					.setParameter(1, terminalId)				
					.getResultList().size() > 0 ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return check;
	}
	
	

}
