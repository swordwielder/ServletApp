package servlet;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import model.Customer;


public class AddServlet extends HttpServlet
{	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
	
		String ssn2 = req.getParameter("ssn");
		String creditCard = req.getParameter("creditCard");
		PrintWriter out = res.getWriter();
		int ssn = Integer.valueOf(ssn2);
		
//		out.println(ssn2);
//		out.println("skipping line");
//		out.println();
//		out.println("The ssn is " + ssn);
//		out.println("The credit card is " + creditCard);
//		out.println(cu.getFirstName());		
		
		
		CustomerDao cd = new CustomerDao();
		Customer cu = new Customer();
		
		
		try {
			cu = cd.getCustDetails(ssn, creditCard);
			
			
		} catch (Exception e) {
			out.println("Bad Entry");
		}
		
		
		//TODO
		req.setAttribute("hkjh",cu);
		RequestDispatcher reqDis = req.getRequestDispatcher("");
		reqDis.forward(req, res);
		//TODO
		
		
		
		
		if (cu!=null) {
			String customerFormat = "%-15s%-9s%-15s%-10s%-20s%-10s%-20s%-10s%-8s%-15s%-10s%-10s%-10s\n";
			out.format(customerFormat, "First Name","Middle","Last Name","SSN", "Credit Card Num"
					, "Apt No", "Street Name","City", "State", "Country", "Zip", "Phone #", "Email");

			out.format(customerFormat, cu.getFirstName(),cu.getMiddleName(),cu.getLastName(),cu.getSsn(),
					cu.getCreditCardNo(),cu.getAptNo(),cu.getStreetName(),cu.getCustCity(),
					cu.getCustState(),cu.getCustCountry(),cu.getCustZip(),cu.getCustPhone(),cu.getCustEmail()+"\n");
		}else {
			out.println("Bad Entry");
		}
		
		
	}
	
}
