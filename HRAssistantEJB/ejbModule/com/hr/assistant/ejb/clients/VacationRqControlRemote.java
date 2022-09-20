package com.hr.assistant.ejb.clients;

import javax.ejb.Remote;

import com.hr.assistant.datamodel.EmployeeVacationTO;
import com.hr.assistant.datamodel.VacationBalanceTO;

@Remote
public interface VacationRqControlRemote {

	public VacationBalanceTO approveRequest(EmployeeVacationTO employeeVacationTO);
}
