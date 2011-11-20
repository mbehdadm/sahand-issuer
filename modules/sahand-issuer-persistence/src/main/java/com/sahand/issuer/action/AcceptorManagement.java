package com.sahand.issuer.action;

import java.util.List;

import com.sahand.acquirer.data.AcceptorDto;
import com.sahand.acquirer.model.CardAcceptor;
import com.sahand.acquirer.model.Terminal;

public interface AcceptorManagement {

	public CardAcceptor edit(AcceptorDto acceptor) throws Exception;
	public CardAcceptor create(AcceptorDto acceptor) throws Exception;

	public CardAcceptor find(String acceptorId) throws Exception;
	public void persist(CardAcceptor acceptor) throws Exception;
	public void update(CardAcceptor acceptor) throws Exception;
	
	public AcceptorDto convertFrom(CardAcceptor cardAcceptor,AcceptorDto acceptorDto );
	public CardAcceptor convertFrom(AcceptorDto acceptor,CardAcceptor cardAcceptor);
	public CardAcceptor getAcceptor(String acceptorId) throws Exception;
	public List<CardAcceptor> getAcceptors() throws Exception;
	public List<Terminal> getTerminal(String acceptorId) throws Exception;

}
