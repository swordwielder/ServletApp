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

public class BillServlet extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		String ssn2 = req.getParameter("billssn");
		String creditCard = req.getParameter("billcreditCard");
		String monthyear = req.getParameter("billmonth");
		PrintWriter out = res.getWriter();
		int ssn = Integer.valueOf(ssn2);
		
		String [] split = monthyear.split("-");
		TransactionDao td = new TransactionDao();
		List<transaction> monthlyTransaction = new ArrayList<transaction>();
		
		try {
			monthlyTransaction = td.getMonthlyBill(Integer.valueOf(split[0]), Integer.valueOf(split[1]),ssn,creditCard);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			out.println("Bad Entry");
		}
		
		
		out.println(ssn);
		out.println(creditCard);
		out.println(monthyear);
		out.println("skipping \n");
		
		if (!monthlyTransaction.isEmpty()) {
			String monthFormat = "%-15s%-7s%-7s%-10s%-25s%-15s%-15s%-20s%-15s\n";
			out.printf(monthFormat, "Transaction ID", "Day","Month", "Year", "Credit Card Num", "SSN", "Branch Code"
					+ "", "Transaction Type", "Value");
			monthlyTransaction.forEach(p ->
			out.printf(monthFormat, p.getTransactionId(), p.getDay(), p.getMonth(), p.getYear(),p.getCardNo(),
					p.getSsn(),p.getBranchCode(),p.getType(),"$"+p.getValue() ));
			out.println();
		}else {
			out.println("Bad Entry");
		}
		
		
		
		
		
		
		
	}
	
}
