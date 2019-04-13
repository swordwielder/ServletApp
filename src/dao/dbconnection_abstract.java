package dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.sql.*;

public abstract class dbconnection_abstract {

	public Connection con = null;
	public ResultSet rs;
	public PreparedStatement ps;
	public Statement st;

	protected void myconnection() throws Exception {
		// step 1
		//FileReader f = new FileReader("db.properties");
		// will hold properties of f
		//Properties p = new Properties();
		// p loads properties
		//p.load(f);
		
		Class.forName("com.mysql.jdbc.Driver");
		//con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CDW_SAPP?useSSL=false", "sqlsql", "password");
		
	}
}
