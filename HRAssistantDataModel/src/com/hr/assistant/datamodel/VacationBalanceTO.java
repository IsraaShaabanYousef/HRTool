/**
 * 
 */
package com.hr.assistant.datamodel;

import java.io.Serializable;

/**
 * @author Israa.Shaaban
 *
 */
public class VacationBalanceTO implements Serializable{
	private int annualBalance;
	private int sickBalance;
	
	public int getAnnualBalance() {
		return annualBalance;
	}
	public void setAnnualBalance(int annualBalance) {
		this.annualBalance = annualBalance;
	}
	public int getSickBalance() {
		return sickBalance;
	}
	public void setSickBalance(int sickBalance) {
		this.sickBalance = sickBalance;
	}

	
}
