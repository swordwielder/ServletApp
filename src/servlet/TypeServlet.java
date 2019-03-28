package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TransactionDao;
import model.transaction;

public class TypeServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		String type = req.getParameter("Transaction_Type");
		
		
		PrintWriter out = res.getWriter();
//		out.println("This is a test\n");
//		out.println(type);
		
		
		TransactionDao td = new TransactionDao();
		transaction mytransaction = new transaction();
		try {
			mytransaction = td.gettotalbyType(type);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println("Bad Entry");
		}
		
		if (mytransaction!=null) {
			out.print("Count \t  Value\n");
			out.format("%-10s%s", mytransaction.getCount(),"$"+mytransaction.getValue());
		}else {
			out.println("Bad Entry");
		}
		
		
	}
}
