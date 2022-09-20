package com.hr.assistant.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.assistant.datamodel.EmployeeVacationTO;
import com.hr.assistant.ejb.clients.VacationRqControlRemote;

public class VacationRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private VacationRqControlRemote vacationRqControlRemote;
	public static final String EJB_JNDI_NAME = "ejb/VacationRqControl";
	public static final int TOTAL_ANNUAL_VACATIONS = 21;
	public static final int TOTAL_SICK_VACATIONS = 12;


	public VacationRequest() {
		super();
		initialize();
	}

	public void initialize() {
		try {

			Context ctx = new InitialContext();
			vacationRqControlRemote = (VacationRqControlRemote) ctx.lookup(EJB_JNDI_NAME);

		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalStateException("Error in lookup of " + EJB_JNDI_NAME);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empId = request.getParameter("empId");
		String vacationType = request.getParameter("vacationType");
		EmployeeVacationTO employeeVacationTO = new EmployeeVacationTO();
		employeeVacationTO.setVacationType(vacationType);
		employeeVacationTO.setEmployeeId(empId);
		String startDateStr = request.getParameter("startDate");
		String endDateStr = request.getParameter("endDate");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		int workDays = 0;
		try {
			Date startDate = formatter.parse(startDateStr);
			Date endDate = formatter.parse(endDateStr);
			employeeVacationTO.setStartDate(startDate);
			employeeVacationTO.setEndDate(endDate);
			workDays = calculateDuration(startDate, endDate);
			employeeVacationTO.setNumOfDays(workDays);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vacationRqControlRemote.approveRequest(employeeVacationTO);
		response.setContentType("text/html");
		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.print("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">"
				+ "<title>HR assistant</title><style>" + "div {\r\n" + "  border-radius: 25px;\r\n"
				+ "  border: 2px solid black;\r\n" + "  padding: 20px;\r\n" + "  width: 200px;\r\n"
				+ "  height: 150px;\r\n" + "  margin: auto;\r\n" + "  width: 50%;\r\n" + "  text-align: center;\r\n"
				+ "}\r\n" + "table, th, td {\r\n" + "  border: 1px solid black;\r\n" + "    margin: auto;\r\n"
				+ "  width: 50%;\r\n" + "}\r\n"
				+ "</style></head><body><form action=\"/HRAssistantWeb/VacationRequest\" method=\"POST\">\r\n"
				+ "<div><label>Employee Card ID</label><input id=\"empId\" name=\"empId\" value=\"" + empId + "\"/>"
				+ "	<h3 align=\"left\">Select Vacation Type</h3>\r\n" + "	Type<select name=\"vacationType\">\r\n"
				+ "    <option value=\"Annual\">Annual</option>\r\n" + "    <option value=\"Sick\">Sick</option>\r\n"
				+ "  </select>\r\n" + "  </div>\r\n" + "  \r\n" + "  <div>\r\n"
				+ "  <h3 align=\"left\">Create Request Details</h3>\r\n"
				+ "   <label for=\"startDate\">Start Date</label>\r\n"
				+ "  <input type=\"date\" id=\"startDate\" name=\"startDate\" value=\""+startDateStr+"\">"
				+ "  <label for=\"endDate\">End Date</label>\r\n"
				+ "  <input type=\"date\" id=\"endDate\" name=\"endDate\" value=\""+endDateStr+"\"><br/>"
				+ "  <label for=\"days\">Days</label>" + "  <input name=\"days\" value=\"" + workDays
				+ "\" readonly></input><br/>\r\n" + "  <input type=\"submit\">\r\n" + "  \r\n" + "  </div><div>"
				+ "  <h3 align=\"left\">Vacation Balance</h3>" + "  <table>\r\n" + "  <tr>\r\n"
				+ "    <th>Type</th>\r\n" + "    <th>Balance</th>\r\n" + "  </tr>\r\n" + "  <tr>\r\n"
				+ "    <td>Annual</td>\r\n" + "    <td><output name=\"annualVacations\"></output></td>\r\n"
				+ "  </tr>\r\n" + "  <tr>\r\n" + "    <td>Sick</td>\r\n"
				+ "    <td><output name=\"sickVacations\"></output></td>\r\n" + "  </tr>\r\n"
				+ "</table></div></form></body></html>");

	}

	public static int calculateDuration(Date startDate, Date endDate) {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		int workDays = 0;

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}

		do {
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.FRIDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
				workDays++;
			}
		} while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());

		return workDays;
	}



}
