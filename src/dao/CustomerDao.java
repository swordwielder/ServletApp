package dao;

import model.Customer;
import model.transaction;
import resources.MyQueries;

public class CustomerDao extends dbconnection_abstract{
	public Customer getByCreditSSN(int ssn, String credit) throws Exception {
		myconnection();
		ps = con.prepareStatement(MyQueries.customerAccountDetails);
		ps.setInt(1, ssn);
		ps.setString(2, credit);
		Customer c = new Customer();
		rs = ps.executeQuery();
		
		if (rs.next()) {
			c.setFirstName(rs.getString(1));
			c.setMiddleName(rs.getString(2));
			c.setLastName(rs.getString(3));
			c.setSsn(rs.getInt(4));
			c.setCreditCardNo(rs.getString(5));
			c.setAptNo(rs.getInt(6));
			c.setStreetName(rs.getString(7));
			c.setCustCity(rs.getString(8));
			c.setCustState(rs.getString(9));
			c.setCustCountry(rs.getString(10));
			c.setCustZip(rs.getInt(11));
			c.setCustPhone(rs.getString(12));
			c.setCustEmail(rs.getString(13));
			c.setLastUpdated(rs.getString(14));
			return c;
		}
		
		return null;
	}
	
	public Customer getCustDetails(int ssn, String credit) throws Exception {
		myconnection();
		ps = con.prepareStatement(MyQueries.customerDetails);
		ps.setInt(1, ssn);
		ps.setString(2, credit);
		Customer c = new Customer();
		rs = ps.executeQuery();
		
		if (rs.next()) {
			c.setFirstName(rs.getString(1));
			c.setMiddleName(rs.getString(2));
			c.setLastName(rs.getString(3));
			c.setSsn(rs.getInt(4));
			c.setCreditCardNo(rs.getString(5));
			c.setAptNo(rs.getInt(6));
			c.setStreetName(rs.getString(7));
			c.setCustCity(rs.getString(8));
			c.setCustState(rs.getString(9));
			c.setCustCountry(rs.getString(10));
			c.setCustZip(rs.getInt(11));
			c.setCustPhone(rs.getString(12));
			c.setCustEmail(rs.getString(13));
			c.setLastUpdated(rs.getString(14));
			return c;
		}
		return null;
	}
	
	
	public void modifyCustomer(String query,String name, int ssn, String credit) throws Exception {
		myconnection();
		ps = con.prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2, ssn);
		ps.setString(3, credit);
		ps.executeUpdate();
		
	}
	
	public void modifyIntCustomer(String query, int number, int ssn, String credit) throws Exception {
		myconnection();
		ps = con.prepareStatement(query);
		ps.setInt(1, number);
		ps.setInt(2, ssn);
		ps.setString(3, credit);
		ps.executeUpdate();
		
	}
	
	
}
