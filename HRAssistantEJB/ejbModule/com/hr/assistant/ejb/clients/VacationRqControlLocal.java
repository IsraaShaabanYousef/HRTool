package com.hr.assistant.ejb.clients;

import javax.ejb.Local;

import com.hr.assistant.datamodel.EmployeeVacationTO;

@Local
public interface VacationRqControlLocal {

	public void approveRequest(EmployeeVacationTO employeeVacationTO);

}
