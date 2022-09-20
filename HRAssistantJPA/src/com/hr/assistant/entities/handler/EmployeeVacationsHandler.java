/*
 * Licensed Material - Property of Fawry Integrated Systems � Copyright Fawry
 * Integrated Systems 2009. All Rights Reserved.
 */
package com.hr.assistant.entities.handler;

import javax.persistence.EntityManager;

import com.hr.assistant.entities.EmployeeVacations;
import com.hr.assistant.entitymanager.factory.EntityManagerRegistry;


public class EmployeeVacationsHandler {

	public static void persistEmployeeVacations(EmployeeVacations employeeVacations) {
		EntityManagerRegistry entityManagerRegistry = EntityManagerRegistry.INSTANCE;
		EntityManager entityManager = entityManagerRegistry
				.getEntityManager("HRAssistantDB");
		entityManager.persist(employeeVacations);
	}

}
