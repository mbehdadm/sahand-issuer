package com.sahand.issuer.action;

import com.sahand.acquirer.data.enumeration.PeerType;
import com.sahand.acquirer.model.Peer;

public interface PeerManagement {

	public Peer create(PeerType type) throws Exception;
	public Peer find(String peerId) throws Exception;
	public void persist(Peer peer) throws Exception;

}
