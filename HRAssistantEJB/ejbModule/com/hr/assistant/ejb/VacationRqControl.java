package com.hr.assistant.ejb;

import javax.ejb.Stateless;

import com.hr.assistant.datamodel.EmployeeVacationTO;
import com.hr.assistant.ejb.clients.VacationRqControlLocal;
import com.hr.assistant.ejb.clients.VacationRqControlRemote;

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
		// TODO Auto-generated method stub
		
	}



}
