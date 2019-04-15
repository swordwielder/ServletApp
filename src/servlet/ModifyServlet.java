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

public class ModifyServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		
		PrintWriter out = res.getWriter();
		CustomerDao cd = new CustomerDao();
		String ssn2 = req.getParameter("modifyssn");
		String credit = req.getParameter("modifycreditCard");
		
		int ssn=0;
		try {
			ssn =Integer.parseInt(ssn2);
		}catch (Exception uiwe) {
			
		}
		
		Customer cu = new Customer();
		try {
			cu = cd.getCustDetails(ssn, credit);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO
		req.setAttribute("ModifyCustomer", cu);
		RequestDispatcher reqDis = req.getRequestDispatcher("modify.jsp");
		//RequestDispatcher reqDisp = req.getRequestDispatcher("editField.jsp");
		//reqDisp.forward(req, res);
		
		reqDis.forward(req, res);
		
		// TODO
		
	}
}
