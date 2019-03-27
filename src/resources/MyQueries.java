package resources;

public class MyQueries {
	//1
	public final static String zipTransaction = "SELECT CDW_SAPP_CREDITCARD.* FROM CDW_SAPP_CREDITCARD "
			+ "LEFT JOIN CDW_SAPP_CUSTOMER USING (CREDIT_CARD_NO) WHERE CUST_ZIP = ? AND MONTH = ? AND YEAR = ? ORDER BY DAY DESC";
	
	//original implementation.
	public final static String totalByType = "select sum(transaction_value), count(*)" +
											"from CDW_SAPP_CREDITCARD " +
											"where TRANSACTION_TYPE = ? " +
											"GROUP by TRANSACTION_TYPE";
	//2 - my implementation
	public final static String totalByType2 = "SELECT COUNT(TRANSACTION_VALUE), SUM(TRANSACTION_VALUE) FROM CDW_SAPP_CREDITCARD "
			+ "GROUP BY TRANSACTION_TYPE HAVING TRANSACTION_TYPE = ?;";
	
	//public final static String selectEverything = "SELECT * FROM CDW_SAPP_CREDITCARD";
	
	//3
	public final static String stateTransaction = "SELECT COUNT(TRANSACTION_VALUE), "
			+ "SUM(TRANSACTION_VALUE) AS 'TotalValue' FROM CDW_SAPP_CREDITCARD JOIN "
			+ "CDW_SAPP_BRANCH USING (BRANCH_CODE) GROUP BY BRANCH_STATE HAVING BRANCH_STATE =?;";
	
	//4
	public final static String customerAccountDetails = "SELECT * FROM CDW_SAPP_CUSTOMER WHERE SSN LIKE ? "
			+ "AND CREDIT_CARD_NO = ? ";
	
	//5
	public static String modifyDetails = "UPDATE CDW_SAPP_CUSTOMER SET %s = ? WHERE SSN = ? AND CREDIT_CARD_NO = ? ";
	//get one customer details;
	public static String customerDetails = "SELECT * FROM CDW_SAPP_CUSTOMER WHERE SSN = ? AND CREDIT_CARD_NO = ? ";
	
	//6
	public final static String monthlyBill = "SELECT * FROM CDW_SAPP_CREDITCARD WHERE YEAR = ? "
			+ "AND MONTH = ? AND CUST_SSN = ? AND CREDIT_CARD_NO = ? ORDER BY DAY ASC";
	
	//7
	public final static String twoDatesTransaction = "SELECT RIGHT(CUST_SSN, 4) AS Last4Social, CREDIT_CARD_NO, "
			+ "BRANCH_CODE, TRANSACTION_VALUE, TRANSACTION_TYPE, STR_TO_DATE(CONCAT(YEAR, '/', MONTH, '/', DAY), "
			+ "'%Y/%m/%d') AS 'DateFormat' FROM CDW_SAPP_CREDITCARD WHERE CUST_SSN = ? AND CREDIT_CARD_NO = ? "
			+ "AND STR_TO_DATE(CONCAT(YEAR, '/', MONTH, '/', DAY), '%Y/%m/%d') BETWEEN ? AND ? ORDER BY DateFormat DESC";

	public static String getZiptransaction() {
		return zipTransaction;
	}

	public static String getTotalbytype() {
		return totalByType;
	}

	public static String getTotalbytype2() {
		return totalByType2;
	}

	public static String getStatetransaction() {
		return stateTransaction;
	}

	public static String getCustomeraccountdetails() {
		return customerAccountDetails;
	}

	public static String getModifyDetails() {
		return modifyDetails;
	}

	public static String getCustomerDetails() {
		return customerDetails;
	}

	public static String getMonthlybill() {
		return monthlyBill;
	}

	public static String getTwodatestransaction() {
		return twoDatesTransaction;
	}
	
	
	
	
}
