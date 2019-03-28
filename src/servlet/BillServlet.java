package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BillServlet extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		String ssn2 = req.getParameter("billssn");
		String creditCard = req.getParameter("billcreditCard");
		PrintWriter out = res.getWriter();
		int ssn = Integer.valueOf(ssn2);
		
		
		out.println(ssn);
		out.println(creditCard);
		
		
	}
	
}
