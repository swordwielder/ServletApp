<%@ page import="resources.MyQueries"%>
<%@ page import="runner.*"%>
<%@ page import="dao.*"%>
<%@ page import="model.*"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.PrintWriter" %>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./style.css" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Righteous"
	rel="stylesheet">
<title>ModifyCustomer</title>
</head>
<body background="galaxy.jpg">
<p>
Test


<% String ssn2 = request.getParameter("modifyssn");%>

<%  String credit = request.getParameter("modifycreditCard");%>
<%Customer cu = new Customer(); %>
<%CustomerDao cd = new CustomerDao(); %>
<% cu = cd.getCustDetails(Integer.parseInt(ssn2), credit);%>
<%= ssn2%>
<%= credit%>










</p>



</body>
</html>
