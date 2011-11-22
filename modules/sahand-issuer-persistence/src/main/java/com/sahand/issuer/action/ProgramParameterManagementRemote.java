package com.sahand.issuer.action;

import java.util.List;

import com.sahand.acquirer.data.TerminalInformation;
import com.sahand.acquirer.model.Terminal;

public interface ProgramParameterManagementRemote {

	public Terminal edit(TerminalInformation terminal) throws Exception;
	public Terminal create(TerminalInformation terminal) throws Exception;
	
	public Terminal find(String terminalId) throws Exception;
	public void persist(Terminal terminal) throws Exception;
	public void update(Terminal terminal) throws Exception;
	
	public boolean isUniqueSerialNumber(String serialNo);
	public boolean isUniquePropertyNumber(String propertyNumber);
	
	public TerminalInformation convertFrom(Terminal terminalDa,TerminalInformation terminalDto);
	public Terminal editSerial(String terminalId,String serialNumber) throws Exception;
	
	public Terminal getTerminal(String terminalId) throws Exception;
	public List<Terminal> getTerminals() throws Exception;
	public boolean isTerminalSetUp(String terminalId) throws Exception;
}
