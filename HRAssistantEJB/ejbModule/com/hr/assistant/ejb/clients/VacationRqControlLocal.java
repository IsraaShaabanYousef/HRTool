package com.hr.assistant.ejb.clients;

import javax.ejb.Local;

import com.hr.assistant.datamodel.EmployeeVacationTO;
import com.hr.assistant.datamodel.VacationBalanceTO;

@Local
public interface VacationRqControlLocal {

	public VacationBalanceTO approveRequest(EmployeeVacationTO employeeVacationTO);

}
