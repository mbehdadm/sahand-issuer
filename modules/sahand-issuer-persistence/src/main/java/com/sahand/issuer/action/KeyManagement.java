package com.sahand.issuer.action;

import java.util.List;

import com.sahand.acquirer.model.Key;

public interface KeyManagement {

	public Key create(String data, String datasec, short kyType) throws Exception;
	
	public List<Key> generatePrimaryKeys() throws Exception;
		
	public Key find(String keyId) throws Exception;
	public void persist(Key key) throws Exception;

}
