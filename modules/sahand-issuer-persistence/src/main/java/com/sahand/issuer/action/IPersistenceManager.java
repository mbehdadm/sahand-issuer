package com.sahand.issuer.action;

import javax.ejb.Local;
import javax.persistence.EntityManager;

@Local
public interface IPersistenceManager {

	public abstract EntityManager getEntityManager();

}