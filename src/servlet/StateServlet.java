package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TransactionDao;
import model.transaction;

public class StateServlet extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		
		String state = req.getParameter("state");
		
		PrintWriter out = res.getWriter();
		
		
//		out.println("This is a test\n");
//		out.println(state);
//		
		
		TransactionDao td = new TransactionDao();
		String stateFormat = "%-15s%-15s%-10s\n";
		transaction myState = new transaction();
		try {
			myState = td.getTotalByState(state);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println("Bad Entry");
		}
		
		if (myState!=null) {
			out.format(stateFormat, "Total Number", "Total Value", "Brach State\n");
			out.format(stateFormat, myState.getCount(),"$"+myState.getValue(), state.toUpperCase()+"\n");
		}else {
			out.println("Bad Entry");
		}
		
		
	}
}
