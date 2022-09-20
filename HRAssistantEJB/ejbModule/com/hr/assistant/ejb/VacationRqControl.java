package com.hr.assistant.ejb;

import javax.ejb.Stateless;

import com.hr.assistant.datamodel.EmployeeVacationTO;
import com.hr.assistant.ejb.clients.VacationRqControlLocal;
import com.hr.assistant.ejb.clients.VacationRqControlRemote;
import com.hr.assistant.entities.EmployeeVacations;
import com.hr.assistant.entities.handler.EmployeeVacationsHandler;

/**
 * Session Bean implementation class SchedulerControl
 */
@Stateless
public class VacationRqControl implements VacationRqControlLocal, VacationRqControlRemote {
	

	/**
	 * Default constructor.
	 */
	public VacationRqControl() {

	}

	@Override
	public void approveRequest(EmployeeVacationTO employeeVacationTO) {
		EmployeeVacations employeeVacations=new EmployeeVacations();	
		employeeVacations.setEmployeeId(employeeVacationTO.getEmployeeId());
		employeeVacations.setStartDate(employeeVacationTO.getStartDate());
		employeeVacations.setEndDate(employeeVacationTO.getEndDate());
		employeeVacations.setVacationType(employeeVacationTO.getVacationType());
		employeeVacations.setNumOfDays(employeeVacationTO.getNumOfDays());
		EmployeeVacationsHandler.persistEmployeeVacations(employeeVacations);
	}



}
