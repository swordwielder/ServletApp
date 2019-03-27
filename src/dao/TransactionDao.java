package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.transaction;
import resources.MyQueries;

public class TransactionDao extends dbconnection_abstract {
	
	public transaction gettotalbyType(String type) throws Exception {
		myconnection();
		ps = con.prepareStatement(MyQueries.totalByType2);
		ps.setString(1, type);
		
		rs = ps.executeQuery();
		transaction t = new transaction();
		if(rs.next()) {
			
			t.setCount(rs.getInt(1));
			t.setValue(rs.getDouble(2));
			return t;
		}		
		return null;
	}
	
	
	public transaction getTotalByState(String state) throws Exception {
		myconnection();
		transaction t = new transaction();
		ps = con.prepareStatement(MyQueries.stateTransaction);
		ps.setString(1, state);
		rs = ps.executeQuery();
		if (rs.next()) {
			t.setCount(rs.getInt(1));
			t.setValue(rs.getDouble(2));
			return t;
		}
		return null;
	}
	
	public List<transaction> getMonthlyBill(int year, int month, int ssn, String credit) throws Exception {
		myconnection();
		List<transaction> lt = new ArrayList<transaction>();
		ps = con.prepareStatement(MyQueries.monthlyBill);
		ps.setInt(1,year);
		ps.setInt(2, month);
		ps.setInt(3, ssn);
		ps.setString(4, credit);
		rs = ps.executeQuery();
		while (rs.next()) {
			transaction t = new transaction();
			t.setTransactionId(rs.getInt(1));
			t.setDay(rs.getInt(2));
			t.setMonth(rs.getInt(3));
			t.setYear(rs.getInt(4));
			t.setCardNo(rs.getString(5));
			t.setSsn(rs.getInt(6));
			t.setBranchCode(rs.getInt(7));
			t.setType(rs.getString(8));
			t.setValue(rs.getDouble(9));
			lt.add(t);
			
		}
		return lt;
	}
	
	public List<transaction> getTransactionByDates(int ssn, String credit, String date1, String date2) throws Exception{
		myconnection();
		List<transaction> lt = new ArrayList<transaction>();
		ps = con.prepareStatement(MyQueries.twoDatesTransaction);
		ps.setInt(1, ssn);
		ps.setString(2, credit);
		ps.setString(3, date1);
		ps.setString(4, date2);
		rs = ps.executeQuery();
		while (rs.next()) {
			transaction t = new transaction();
			t.setSsn(rs.getInt(1));
			t.setCardNo(rs.getString(2));
			t.setBranchCode(rs.getInt(3));
			t.setValue(rs.getDouble(4));
			t.setType(rs.getString(5));
			t.setDateFormat(rs.getString(6));
			lt.add(t);
		}
		return lt;
	}
	
	public List<transaction> getAllByZip(int custZip, int month, int year) throws Exception {
		myconnection();
		List<transaction> lt = new ArrayList<transaction>();
		ps = con.prepareStatement(MyQueries.zipTransaction);
		ps.setInt(1,custZip);
		ps.setInt(2,month);
		ps.setInt(3,year);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			transaction t = new transaction();
			t.setTransactionId(rs.getInt(1));
			t.setDay(rs.getInt(2));
			t.setMonth(rs.getInt(3));
			t.setYear(rs.getInt(4));
			t.setCardNo(rs.getString(5));
			t.setSsn(rs.getInt(6));
			t.setBranchCode(rs.getInt(7));
			t.setType(rs.getString(8));
			t.setValue(rs.getDouble(9));
			lt.add(t);
		}
		
		return lt;
	}
	
}