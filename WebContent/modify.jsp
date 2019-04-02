<%@ page import="resources.MyQueries"%>
<%@ page import="runner.*"%>
<%@ page import="dao.*"%>
<%@ page import="model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.PrintWriter"%>

<html><script language="JavaScript">
function myFunction() {
        document.getElementById('display').innerHTML = 
                    document.getElementById("user_input").value;
    } </script>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./modify.css" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Righteous"
	rel="stylesheet">
<title>ModifyCustomer</title>
</head>
<body background="galaxy.jpg">
	<p>
		<%
		String ssn2 = request.getParameter("modifyssn");%>
		<%String credit = request.getParameter("modifycreditCard");%>
		<%Customer cu = (Customer) request.getAttribute("ModifyCustomer");%>
		<!--  
		<%int ssn =0; %>
		<%try{ ssn = Integer.parseInt(ssn2);%>
		<% }catch(Exception wejir){}%>
		-->
		
		<%CustomerDao cd = new CustomerDao();%>
		<%
			cu = cd.getCustDetails(ssn, credit);
		%>
	<form action="ModifyCustomerDetail">
		<select name="ModifyType">
			<option value="First_Name">First Name</option>
			<option value="Middle_Name">Middle Name</option>
			<option value="Last_Name">Last Name</option>
			<option value="ApartmentNo">Apartment Number</option>
			<option value="Street">Street Name</option>
			<option value="City">Customer City</option>
			<option value="State">Customer State</option>
			<option value="Country">Customer Country</option>
			<option value="Zipcode">Customer Zip Code</option>
			<option value="Number">Phone Number</option>
			<option value="Email">Customer Email</option>
		</select> <button onclick="myFunction()">Edit this Field</button>
	</form>
	<p>
	<h3>Customer Field Attributes</h3>
	<font size="+2"> <pre class="tab">
			<tr>
SSN:    <%=ssn2%>
Credit Card No: <%=credit%>
<%if (cu != null) {%>
<td>First Name:        <%=cu.getFirstName()%></td>
<td>Middle Name:       <%=cu.getMiddleName()%></td>
<td>Last Name:         <%=cu.getLastName()%></td>
<td>Apartment No:      <%=cu.getAptNo()%></td>
<td>Street Name:       <%=cu.getStreetName()%></td>
<td>Customer City:     <%=cu.getCustCity()%></td>
<td>Customer State:    <%=cu.getCustState()%></td>
<td>Customer Country:  <%=cu.getCustCountry()%></td>
<td>Customer ZipCode:  <%=cu.getCustZip()%></td>
<td>Phone Number:      <%=cu.getCustPhone()%></td>
<td>Customer Email:    <%=cu.getCustEmail()%></td>
<%}%>
<pre>	</p>
			</tr>
</font>
	







</body>
</html>
