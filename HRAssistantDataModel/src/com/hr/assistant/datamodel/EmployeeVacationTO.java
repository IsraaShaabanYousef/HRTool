/**
 * 
 */
package com.hr.assistant.datamodel;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Israa.Shaaban
 *
 */
public class EmployeeVacationTO implements Serializable{
	private long id;
	private String employeeId;
	private String vacationType;
	private Date startDate;
	private Date endDate;
	private int numOfDays;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getNumOfDays() {
		return numOfDays;
	}
	public void setNumOfDays(int numOfDays) {
		this.numOfDays = numOfDays;
	}
	public String getVacationType() {
		return vacationType;
	}
	public void setVacationType(String vacationType) {
		this.vacationType = vacationType;
	}
	
}
