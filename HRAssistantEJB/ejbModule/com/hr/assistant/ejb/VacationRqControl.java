package com.hr.assistant.ejb;

import java.util.Map;

import javax.ejb.Stateless;

import com.hr.assistant.datamodel.EmployeeVacationTO;
import com.hr.assistant.datamodel.VacationBalanceTO;
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
	public VacationBalanceTO approveRequest(EmployeeVacationTO employeeVacationTO) {
		EmployeeVacations employeeVacations = new EmployeeVacations();
		employeeVacations.setEmployeeId(employeeVacationTO.getEmployeeId());
		employeeVacations.setStartDate(employeeVacationTO.getStartDate());
		employeeVacations.setEndDate(employeeVacationTO.getEndDate());
		employeeVacations.setVacationType(employeeVacationTO.getVacationType());
		employeeVacations.setNumOfDays(employeeVacationTO.getNumOfDays());
		EmployeeVacationsHandler.persistEmployeeVacations(employeeVacations);

		Map<String, Integer> vacationCountByType = EmployeeVacationsHandler
				.getEmployeeVacationsByEmpId(employeeVacationTO.getEmployeeId());

		VacationBalanceTO vacationBalanceTO = null;
		if (vacationCountByType != null && !vacationCountByType.isEmpty()) {
			vacationBalanceTO = new VacationBalanceTO();
			if(vacationCountByType.get("Annual") !=null)
				vacationBalanceTO.setAnnualBalance(vacationCountByType.get("Annual"));
			
			if(vacationCountByType.get("Sick") !=null)
				vacationBalanceTO.setSickBalance(vacationCountByType.get("Sick"));
		}
		return vacationBalanceTO;
	}

}
