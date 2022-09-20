package com.hr.assistant.entitymanager.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum EntityManagerRegistry {

	INSTANCE;

	private EntityManager entityManager;
	private EntityManagerFactory emf;

	public EntityManager getEntityManager(String persistenceUnitName) {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		if (entityManager == null)
			entityManager = emf.createEntityManager();
		return entityManager;
	}

}
