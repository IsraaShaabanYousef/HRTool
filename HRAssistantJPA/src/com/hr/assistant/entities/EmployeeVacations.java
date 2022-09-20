package com.hr.assistant.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "EMPLOYEE_VACATIONS")
@SequenceGenerator(sequenceName="EMPLOYEE_VACATIONS_SEQ",name="EMPLOYEE_VACATIONS_SEQ_GEN")
public class EmployeeVacations implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String employeeId;
	private String vacationType;
	private Date startDate;
	private Date endDate;
	private int numOfDays;
	
	public EmployeeVacations() {
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	@GeneratedValue(generator="EMPLOYEE_VACATIONS_SEQ_GEN",strategy=GenerationType.SEQUENCE)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "EMPLOYEE_ID")
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name = "VACATION_TYPE")
	public String getVacationType() {
		return vacationType;
	}

	public void setVacationType(String vacationType) {
		this.vacationType = vacationType;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DATE")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "NUM_OF_DAYS")
	public int getNumOfDays() {
		return numOfDays;
	}

	public void setNumOfDays(int numOfDays) {
		this.numOfDays = numOfDays;
	}

}
