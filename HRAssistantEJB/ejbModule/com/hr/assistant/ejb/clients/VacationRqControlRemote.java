package com.hr.assistant.ejb.clients;

import javax.ejb.Remote;

import com.hr.assistant.datamodel.EmployeeVacationTO;

@Remote
public interface VacationRqControlRemote {

	public void approveRequest(EmployeeVacationTO employeeVacationTO);
}
