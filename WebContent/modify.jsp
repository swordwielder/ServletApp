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
<% Customer cu = (Customer) request.getAttribute("ModifyCustomer");%>
<% CustomerDao cd = new CustomerDao(); %>
<% cu = cd.getCustDetails(Integer.parseInt(ssn2), credit);%>

<p>
<h3>Customer Field Attributes </h3>
<font size="+2"> <pre class="tab">
<tr>
SSN:    <%= ssn2%><br>
Credit Card No: <%= credit%>
<%if (cu!=null){ %>
<td>First Name:        <%= cu.getFirstName()%></td>
<td>Middle Name:       <%= cu.getMiddleName()%></td>
<td>Last Name:         <%= cu.getLastName()%></td>
<td>Apartment No:      <%= cu.getAptNo()%></td>
<td>Street Name:       <%= cu.getStreetName()%></td>
<td>Customer City:     <%= cu.getCustCity()%></td>
<td>Customer State:    <%= cu.getCustState()%></td>
<td>Customer Country:  <%= cu.getCustCountry()%></td>
<td>Customer ZipCode:  <%= cu.getCustZip()%></td>
<td>Phone Number:      <%= cu.getCustPhone()%></td>
<td>Customer Email:    <%= cu.getCustEmail()%></td>
<%} %>
<pre>
</font>
</p>
</tr>












</p>



</body>
</html>
