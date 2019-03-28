package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.TransactionDao;
import model.transaction;

public class ZipServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		String zip = req.getParameter("zipcode");
		String month = req.getParameter("zipmonth");
		String [] spl = month.split("-");
		
		int year = Integer.valueOf(spl[0]);
		int mon = Integer.valueOf(spl[1]);
		int zipcode = Integer.valueOf(zip);
		
		PrintWriter out = res.getWriter();
		TransactionDao td = new TransactionDao();
		List<transaction> lt = new ArrayList<transaction>();
		try {
			lt = td.getAllByZip(zipcode,mon,year);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println("Bad Entry");
		}
		
		
		if (!lt.isEmpty()) {
			
			String strFormat = "%-15s%-7s%-7s%-10s%-25s%-15s%-15s%-20s%-15s\n";
			out.printf(strFormat, "Transaction ID", "Day","Month", "Year", "Credit Card Num", "SSN", "Branch Code"
					+ "", "Transaction Type", "Value");
			lt.forEach(p ->
			out.printf(strFormat, p.getTransactionId(), p.getDay(), p.getMonth(), p.getYear(),p.getCardNo(),p.getSsn(),
					p.getBranchCode(),p.getType(),"$"+p.getValue() ));
			out.println();
			
		}else {
			out.println("Bad Entry");
		}
		
		
		
		
		
	}
}
