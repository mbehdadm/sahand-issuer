package com.sahand.issuer.action;

import java.util.List;

import com.sahand.acquirer.data.TerminalDto;
import com.sahand.acquirer.model.Terminal;

public interface TerminalManagement {

	public Terminal edit(TerminalDto terminal) throws Exception;
	public Terminal create(TerminalDto terminal) throws Exception;
	
	public Terminal find(String terminalId) throws Exception;
	public void persist(Terminal terminal) throws Exception;
	public void update(Terminal terminal) throws Exception;
	
	public boolean isUniqueSerialNumber(String serialNo);
	public boolean isUniquePropertyNumber(String propertyNumber);
	
	public TerminalDto convertFrom(Terminal terminalDa,TerminalDto terminalDto);
	public Terminal editSerial(String terminalId,String serialNumber) throws Exception;
	
	public Terminal getTerminal(String terminalId) throws Exception;
	public List<Terminal> getTerminals() throws Exception;
	public boolean isTerminalSetUp(String terminalId) throws Exception;
}
