package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TransactionDao;
import model.transaction;

public class TwoDatesServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		
		String ssn2 = req.getParameter("twoDatessn");
		String credit = req.getParameter("twoDatescreditCard");
		String date1 = req.getParameter("date1");
		String date2 = req.getParameter("date2");
		PrintWriter out = res.getWriter();
		
		
		out.println(ssn2);
		out.println(credit);
		out.println(date1);
		out.println(date2);
		
//		String [] firstDate = date1.split("-");
//		String [] secondDate = date2.split("-");
		
		TransactionDao td = new TransactionDao();
		List<transaction> transactionDates = new ArrayList<transaction>();
		try {
			transactionDates = td.getTransactionByDates(Integer.parseInt(ssn2), 
					credit, date1, date2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String strFormat7 = "%-20s%-23s%-14s%-10s%-17s%-15s\n";
		out.printf(strFormat7, "Last 4 Social", "Credit Card #","Branch Code", "Value", "Type", "Date");
		transactionDates.forEach(p -> out.printf(strFormat7, p.getSsn(), p.getCardNo(),p.getBranchCode(),
				"$"+p.getValue(),p.getType(),p.getDateFormat() ));
		out.println();
		
		
		
		
		
		
		
	}
}
