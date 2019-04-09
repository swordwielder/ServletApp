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
<link rel="stylesheet" href="./transaction.css" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Righteous"
	rel="stylesheet">
<title>Transaction</title>
</head>
<body>
<div class="header" id="top">
		<h2>Transaction Side</h2>
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

		<form action="stateTransaction">s
			<input type="text" name="state" placeholder="NY, NJ"> <br>
			<input type="submit" value="Submit">
		</form>
		
		


</body>
</html>

