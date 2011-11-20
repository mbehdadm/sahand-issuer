package com.sahand.issuer.action;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sahand.acquirer.action.AcquirerRepository;
import com.sahand.acquirer.action.KeyManagement;
import com.sahand.acquirer.action.SequenceGenerator;
import com.sahand.acquirer.config.AcquirerConfigLoader;
import com.sahand.acquirer.data.enumeration.KeyType;
import com.sahand.acquirer.model.Key;
import com.sahand.common.util.Encryption;
import com.sahand.issuer.exception.IssuerException;


@Stateless
public class KeyManagementImpl implements KeyManagement {

	
	@Inject
	@AcquirerRepository
	EntityManager entityManager;
	
	public Key create(String data, String datasec, short kyType) throws Exception {
	
		Key keyBean = new Key();
		try {
			String keyId = null;
	        while(keyBean != null){
	        	keyId = SequenceGenerator.sequenceGenerator(/*pm.getEntityManager()*/entityManager, Key.class,  new String(),"key-seq");
	        	keyBean = find(keyId);
	        }
//			if(keyBean != null)
//				throw new AcquirerException("duplicate.key.exist");
			
	        keyBean = new Key();
			keyBean.setKeyId(keyId);
			keyBean.setType(kyType);
			keyBean.setData(data);
			keyBean.setDataNew(datasec);

		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return keyBean;
	}
	
//	public Key create(String data,  short kyType) throws Exception {
//		
//		Key keyBean = null;
//		try {
//	        String kyid = SequenceGenerator.sequenceGenerator(pm.getEntityManager(), Key.class,  new String(),"key-seq");
//	        
//	        keyBean = find(kyid);
//			if(keyBean != null)
//				throw new AcquirerException("duplicate.key.exist");
//			
//	        keyBean = new Key();
//			keyBean.setKeyId(kyid);
//			keyBean.setType(kyType);
//			keyBean.setData(data);
//
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}
//		return keyBean;
//	}

	public Key find(String keyId) throws Exception {
		Key key = null;
		try {

			key = /*pm.getEntityManager()*/entityManager.find(Key.class, keyId);


		} catch (Exception e) {
			e.printStackTrace();

		}
		return key;
	}

	public void persist(Key key) throws Exception {
		try {

			/*pm.getEntityManager()*/entityManager.persist(key);
			/*pm.getEntityManager()*/entityManager.flush();

		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("key.persist.exception");

		}

	}
	
	public List<Key> generatePrimaryKeys() throws Exception{
		try{
			Encryption encription = new Encryption(AcquirerConfigLoader.getValue("defaultkey"));
			
			Encryption encriptionTemp = new Encryption(AcquirerConfigLoader.getValue("secondarykey"));
			
			
			String ktm = encription.keyGen();			
			Key keyBean = create(encriptionTemp.encryptKey(ktm), encription.encryptKey(ktm),  KeyType.KTM.toValue());
			
			
			List<Key> keys = new ArrayList<Key>();
			
			keys.add(keyBean);
			
			String mac = encription.keyGen();
			encription.Init(ktm);
			keyBean = create( encription.encryptKey(mac), null,KeyType.MPK.toValue());
			keys.add(keyBean);
			
			String ppk = encription.keyGen();
			encription.Init(ktm);
			keyBean = create(encription.encryptKey(ppk), null,KeyType.PPK.toValue());
			keys.add(keyBean);
			
			
			return keys;
		
		}catch (IssuerException e) {
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("generate.primary.key.failed");
		}
		
	}

}
