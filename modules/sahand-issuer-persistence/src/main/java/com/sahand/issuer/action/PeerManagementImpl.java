package com.sahand.issuer.action;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sahand.acquirer.action.AcquirerRepository;
import com.sahand.acquirer.action.PeerManagement;
import com.sahand.acquirer.action.SequenceGenerator;
import com.sahand.acquirer.config.AcquirerConfigLoader;
import com.sahand.acquirer.data.enumeration.PeerType;
import com.sahand.acquirer.model.Peer;
import com.sahand.issuer.exception.IssuerException;

@Stateless
public class PeerManagementImpl implements PeerManagement {

	
	@Inject
	@AcquirerRepository
	EntityManager entityManager;
	
	
	public Peer create(PeerType type) throws Exception {
		Peer peerDa = new Peer();

		try {

			String peerID = "";
			peerID = SequenceGenerator.sequenceGenerator(/*pm.getEntityManager()*/entityManager, Peer.class, peerID,"peer-seq");
			peerDa.setPeerId(peerID);
    		if(type == null){
    			String types = AcquirerConfigLoader.getValue("peer-type");
    			peerDa.setName(types);
    			peerDa.setType(PeerType.valueOf(types).toValue());
    		}
    		else{
    			peerDa.setName(type.name());
				peerDa.setType(type.toValue());
    		}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return peerDa;
	}

	public Peer find(String peerId) throws Exception {
		Peer peer = null;
		try {

			peer = /*pm.getEntityManager()*/entityManager.find(Peer.class, peerId);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return peer;
	}

	public void persist(Peer peer) throws Exception {
		try {

			/*pm.getEntityManager()*/entityManager.persist(peer);
			/*pm.getEntityManager()*/entityManager.flush();

		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("peer.persist.exception");

		}

	}

}
