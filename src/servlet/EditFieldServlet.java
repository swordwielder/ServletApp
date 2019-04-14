package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import model.Customer;

public class EditFieldServlet extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		PrintWriter out = res.getWriter();
		CustomerDao cd = new CustomerDao();
		String type = req.getParameter("ModifyType");
		String newValue = req.getParameter("newValue");
		
		Customer cust = new Customer();
		req.setAttribute("variable name","value of its");
		//session.setAttribute("variable name","value");
		
	}
	

}
