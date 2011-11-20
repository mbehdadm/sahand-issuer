package com.sahand.issuer.action;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sahand.acquirer.action.IPersistenceManager;


@Stateless
public class PersistenceManager implements IPersistenceManager {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
