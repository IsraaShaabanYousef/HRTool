/*
 * Licensed Material - Property of Fawry Integrated Systems � Copyright Fawry
 * Integrated Systems 2009. All Rights Reserved.
 */
package com.hr.assistant.entities.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.hr.assistant.entities.EmployeeVacations;
import com.hr.assistant.entitymanager.factory.EntityManagerRegistry;


public class EmployeeVacationsHandler {
	 protected static EntityManagerRegistry entityManagerRegistry = EntityManagerRegistry.INSTANCE;

	public static void persistEmployeeVacations(EmployeeVacations employeeVacations) {
		EntityManager entityManager = entityManagerRegistry
				.getEntityManager("HRAssistantDB");
		entityManager.persist(employeeVacations);
	}

	public static Map<String, Integer> getEmployeeVacationsByEmpId(String empId) {
		EntityManager entityManager = entityManagerRegistry.getEntityManager("HRAssistantDB");
		Query getVactionBalanceQuery = entityManager.createNamedQuery("getVactionBalance");
		getVactionBalanceQuery.setParameter("employeeId", empId);
		List<Object[]> results = getVactionBalanceQuery.getResultList();
		Map<String, Integer> vacationCountByType = null;
		if (results != null && !results.isEmpty()) {
			vacationCountByType = new HashMap<>();
			for (Object[] objects : results) {
				vacationCountByType.put((String) objects[0], ((Long) objects[1]).intValue());
			}
		}
		return vacationCountByType;
	}
}
