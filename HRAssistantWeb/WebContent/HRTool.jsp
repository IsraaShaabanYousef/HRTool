<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HR assistant</title>

<style>
div {
  border-radius: 25px;
  border: 2px solid black;
  padding: 20px;
  width: 200px;
  height: 150px;
  margin: auto;
  width: 50%;
  text-align: center;
}
table, th, td {
  border: 1px solid black;
    margin: auto;
  width: 50%;
}
</style>
</head>
<body>
	<form action="/HRAssistantWeb/VacationRequest">
<div>
	<h3 align="left">Select Vacation Type</h3>

	Type
		<select name="vacationType">
    <option value="Annual">Annual</option>
    <option value="Sick">Sick</option>
  </select>
  </div>
  
  <div>
  	<h3 align="left">Create Request Details</h3>
   <label for="startDate">Start Date</label>
  <input type="date" id="startDate" name="startDate" >
  
  <label for="endDate">End Date</label>
  <input type="date" id="endDate" name="endDate" onblur="calcBusinessDays(startDate,endDate)"><br/>
  
  <label for="days">Days</label>
  <input id="days" readonly></input></output><br/>
  <input type="submit">
  
  </div>
  
  
  <div>
  <h3 align="left">Vacation Balance</h3>
  <table>
  <tr>
    <th>Type</th>
    <th>Balance</th>
  </tr>
  <tr>
    <td>Annual</td>
    <td><output name="annualVacations"></output></td>
  </tr>
  <tr>
    <td>Sick</td>
    <td><output name="sickVacations"></output></td>
  </tr>
</table>
  
  </div>
	</form>
	

</body>
</html>