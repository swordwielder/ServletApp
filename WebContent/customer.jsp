<%@ page import="resources.MyQueries"%>
<%@ page import="runner.*"%>
<%@ page import="dao.*"%>
<%@ page import="model.*"%>

<%
	MyQueries obj = new MyQueries();
	String dataTodisplay = obj.getMonthlybill();
%>



<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./customer.css" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Righteous"
	rel="stylesheet">
<title>Case Study</title>
</head>
<body>
	<div class="header" id="top">
		<h2>Case Study Credit Card System using JSP/Servlets</h2>
	</div>


	<br>
	<br>
	
	<div class="alignleft">

		<h4>1) display the transactions made by customers living in a
			given zip code for a given month and year.</h4>
		Zip Code <br>
		<form action="zipcodeTransaction">
			<input type="text" name="zipcode" placeholder="39120"> <input
				type="month" id="zip" name="zipmonth" min="2018-01" value="2018-05" max="2018-12">
			<br> <input type="submit" value="Submit">
		</form>
		<br> <br>

		<h4>2) Display the total number and total values of transactions
			for a given type</h4>
		<form action="transactionType">
			<select name="Transaction_Type">
				<option value="Education">Education</option>
				<option value="Entertainment">Entertainment</option>
				<option value="Grocery">Grocery</option>
				<option value="Gas">Gas</option>
				<option value="Bills">Bills</option>
				<option value="Test">Test</option>
				<option value="Healthcare">Health Care</option>
			</select> 
			<input type="submit" value="Submit">
		</form>

		<br> <br>
		<h4>3) Display the total number and total values of transactions
			for branches in a given state</h4>
		State<br>
		<form action="stateTransaction">
			<input type="text" name="state" placeholder="NY, NJ"> <br>
			<input type="submit" value="Submit">
		</form>

		<br> <br>

		<h4>4) Display the existing account details of a customer</h4>
		<form action="add">
			SSN<br> <input type="text" name="ssn" placeholder="123456100"><br>
			Credit Card<br> <input type="text" name="creditCard"
				placeholder="4210653310061055"> <br> <input
				type="submit" value="Submit">
		</form>
	
	
		<br> <br>
	</div>

	<div class="alignright">
		<h4>5) Modify the existing account details of a customer.</h4>
		<form action="modify">
			SSN<br> <input type="text" name="modifyssn" placeholder="123456100"><br>
			Credit Card<br> <input type="text" name="modifycreditCard"
				placeholder="4210653310061055"> <br> <input
				type="submit" value="Submit">
		</form>

		<br> <br>
		<!-- <label for="start">Start month:</label> -->
		<h4>6) Display the Monthly bill for a customer for a given month
			and year</h4>

		<form action="monthlyBill">
			SSN<br> <input type="text" name="billssn" placeholder="123456100"><br>
			Credit Card<br> <input type="text" name="billcreditCard"
				placeholder="4210653310061055"> <br> Month and Year <br>
			<input type="month" id="start" name="billmonth" min="2018-01"
				value="2018-05" max="2018-12"> <br> 
				<input type="submit"
				value="Submit">
		</form>



		<br> <br>

		<h4>7) Display the transactions made by a customer between two
			dates</h4>
		<form action="twoDatesTransaction">
			SSN<br> <input type="text" name="twoDatessn" placeholder="123456100"><br>
			Credit Card<br> <input type="text" name="twoDatescreditCard"
				placeholder="4210653310061055"> <br> Date 1:<br> <input
				type="date" name="date1" min="2018-01-01" max="2018-12-31" value="2018-05-01"> <br> Date 2:<br> <input
				type="date" name="date2" min="2018-01-01" max="2018-12-31" value="2018-05-29"> <br> <input type="submit"
				value="Submit">
		</form>
	</div>

</body>
</html>
