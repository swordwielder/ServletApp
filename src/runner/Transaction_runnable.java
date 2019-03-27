package runner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

import Exception.IncorrectQueryInputException;
import Exception.InvalidCustomerException;
import dao.CustomerDao;
import dao.TransactionDao;
import model.Customer;
import model.transaction;
import resources.MyQueries;

public class Transaction_runnable {
	Scanner sc = new Scanner(System.in);
	public void startCreditCardSystem() throws Exception {	

		String type,state,creditNum = null;
		int a,zip,month,year,day,ssn;
		a=0;
		do {
			try {
				try {
					TransactionDao td = new TransactionDao();
					CustomerDao cd = new CustomerDao();
					mainMenu();
					a = sc.nextInt();
					switch (a){
					case 1:
						System.out.println("Enter a Zip Code");
						zip = sc.nextInt();
						System.out.println("Enter a month");
						month = sc.nextInt();
						System.out.println("Enter a year");
						year = sc.nextInt();
						List<transaction> lt = new ArrayList<transaction>();
						lt = td.getAllByZip(zip,month,year);
						if (lt.isEmpty()) {
							throw new IncorrectQueryInputException("One of the Input was Invalid!");
						}
						String strFormat = "%-15s%-7s%-7s%-10s%-25s%-15s%-15s%-20s%-15s\n";
						System.out.printf(strFormat, "Transaction ID", "Day","Month", "Year", "Credit Card Num", "SSN", "Branch Code"
								+ "", "Transaction Type", "Value");
						lt.forEach(p ->
						System.out.printf(strFormat, p.getTransactionId(), p.getDay(), p.getMonth(), p.getYear(),p.getCardNo(),p.getSsn(),
								p.getBranchCode(),p.getType(),"$"+p.getValue() ));
						System.out.println();
						break;
					case 2:
						System.out.println("Which Type would you like to check?");
						System.out.println("Enter:\n Education \n Entertainment \n Grocery \n Gas \n Bills \n Test \n Healthcare");
						type = sc.next();
						System.out.println();
						transaction mytransaction = td.gettotalbyType(type);
						if (mytransaction == null) {
							throw new IncorrectQueryInputException("Invalid! Type Does not Exist in Database!");
						}
						File log = new File("type.csv");
						FileWriter fileWriter=null;
						//PrintWriter writer = new PrintWriter("type.csv","UTF-8");
						if (!log.exists()) {
							log.createNewFile();
						}
						String towrite = "Count \t  Value\n";
						System.out.print("Count \t  Value\n");
						System.out.format("%-10s%s", mytransaction.getCount(),"$"+mytransaction.getValue());
						towrite = towrite.concat( mytransaction.getCount()+"\t"+"$"+mytransaction.getValue()+"\n");
						System.out.println();
						
						//writer.println(towrite);
						fileWriter = new FileWriter(log,true);
						fileWriter.write(towrite);
						BufferedWriter bw = new BufferedWriter(fileWriter);
						
						bw.close();
						//writer.close();
						fileWriter.close();
						System.out.println();
						break;
					case 3:	
						System.out.println("Enter a State: \nExample: \n\tNY, NJ, CT\n\tAL, OH, FL\n");
						state = sc.next();
						System.out.println();
						String stateFormat = "%-15s%-15s%-10s\n";
						transaction myState = td.getTotalByState(state);
						if (myState == null) {
							throw new IncorrectQueryInputException("Invalid! State does not Exist!");
						}
						System.out.format(stateFormat, "Total Number", "Total Value", "Brach State");
						System.out.format(stateFormat, myState.getCount(),"$"+myState.getValue(), state.toUpperCase()+"\n");

						break;
					case 4:
						System.out.println("Enter the SSN");
						ssn = sc.nextInt();
						System.out.println("Enter the Credit Card Number");
						creditNum = sc.next();
						Customer c = cd.getByCreditSSN(ssn, creditNum);
						if (c == null) {
							throw new InvalidCustomerException("Invalid SSN or Credit Card Number!");
						}
						String customerFormat = "%-15s%-9s%-15s%-10s%-20s%-10s%-20s%-10s%-8s%-15s%-10s%-10s%-10s\n";
						System.out.format(customerFormat,"First Name","Middle","Last Name","SSN", "Credit Card Num"
								, "Apt No", "Street Name","City", "State", "Country", "Zip", "Phone #", "Email");
						System.out.format(customerFormat,c.getFirstName(),c.getMiddleName(),c.getLastName(),c.getSsn(),
								c.getCreditCardNo(),c.getAptNo(),c.getStreetName(),c.getCustCity(),
								c.getCustState(),c.getCustCountry(),c.getCustZip(),c.getCustPhone(),c.getCustEmail()+"\n");

						break;
					case 5:
						updateField();
						break;
					case 6:
						System.out.println("Enter the SSN");
						int ssn6 = sc.nextInt();
						System.out.println("Enter the Credit Card Number");
						String credit = sc.next();
						System.out.println("Enter the Year");
						year = sc.nextInt();
						System.out.println("Enter the Month");
						month = sc.nextInt();
						List<transaction> monthlyTransaction = td.getMonthlyBill(year, month,ssn6,credit);
						if (monthlyTransaction.isEmpty()) {
							throw new IncorrectQueryInputException("One of the Input was Invalid!");
						}
						String monthFormat = "%-15s%-7s%-7s%-10s%-25s%-15s%-15s%-20s%-15s\n";
						System.out.printf(monthFormat, "Transaction ID", "Day","Month", "Year", "Credit Card Num", "SSN", "Branch Code"
								+ "", "Transaction Type", "Value");
						monthlyTransaction.forEach(p ->
						System.out.printf(monthFormat, p.getTransactionId(), p.getDay(), p.getMonth(), p.getYear(),p.getCardNo(),
								p.getSsn(),p.getBranchCode(),p.getType(),"$"+p.getValue() ));
						System.out.println();

						break;
					case 7:
						int y2,m2,d2;
						System.out.println("Enter the SSN");
						int ssn7 = sc.nextInt();
						System.out.println("Enter the Credit Card Number");
						String credit7 = sc.next();
						System.out.println("Enter the From(1st) Year");
						year = sc.nextInt();
						System.out.println("Enter the From(1st) Month");
						month = sc.nextInt();
						System.out.println("Enter the From(1st) Date");
						day = sc.nextInt();
						System.out.println("Enter the To(2nd) Year");
						y2 = sc.nextInt();
						System.out.println("Enter the To(2nd) Month");
						m2 = sc.nextInt();
						System.out.println("Enter the To(2nd) Date");
						d2 = sc.nextInt();
						String firstDate = year+"-"+month+"-"+day;
						String secondDate = y2+"-"+m2+"-"+d2;
						List<transaction> transactionDates = td.getTransactionByDates(ssn7, credit7, firstDate, secondDate);
						if (transactionDates.isEmpty()) {
							throw new IncorrectQueryInputException("One of the Input was Invalid!");
						}
						String strFormat7 = "%-20s%-23s%-14s%-10s%-17s%-15s\n";
						System.out.printf(strFormat7, "Last 4 Social", "Credit Card #","Branch Code", "Value", "Type", "Date");
						transactionDates.forEach(p -> System.out.printf(strFormat7, p.getSsn(), p.getCardNo(),p.getBranchCode(),
								"$"+p.getValue(),p.getType(),p.getDateFormat() ));
						System.out.println();

						break;
					case 8:
						System.out.println("Byeee!!!");
						sc.close();
						break;
					default:
						sc.reset();
						System.out.println("\nEnter a number between 1-8!\n");
						sc.nextLine();
						break;
					}

				}catch(IncorrectQueryInputException er) {
					System.out.println("\n"+er.getMessage());
					System.out.println("Error! Query was unsuccessful! Exception caught! Enter a valid Input! \n");
				}
			}catch (InputMismatchException e) {
				sc.reset();
				System.out.println("\nInput Mismatch! Please enter a number between 1-8!! \n");
				sc.nextLine();
			}

		}while(a!=8);

	}

	public void updateField() throws Exception {
		CustomerDao cd = new CustomerDao();

		System.out.println("Enter the SSN");
		int ssn7 = sc.nextInt();
		System.out.println("Enter the Credit Card Number");
		String credit7 = sc.next();
		int updateChoice = -1;
		Customer cu = cd.getCustDetails(ssn7, credit7);
		if (cu == null) {
			throw new IncorrectQueryInputException("Invalid SSN or Credit Card Number!");
		}
		Customer c = new Customer();

		System.out.println("\nEnter a number to choose which field to modify");
		System.out.println("SSN: "+ ssn7 + " ,  Credit Card#: "+credit7 );
		System.out.println("0) First Name       : " + cu.getFirstName());
		System.out.println("1) Middle Name      : " + cu.getMiddleName());
		System.out.println("2) Last Name        : " + cu.getLastName());
		System.out.println("3) Apartment #      : " + cu.getAptNo());
		System.out.println("4) Street Name      : " + cu.getStreetName());
		System.out.println("5) Customer City    : " + cu.getCustCity());
		System.out.println("6) Customer State   : " + cu.getCustState());
		System.out.println("7) Customer Country : " + cu.getCustCountry());
		System.out.println("8) Customer Zip Code: " + cu.getCustZip());
		System.out.println("9) Customer Phone # : " + cu.getCustPhone());
		System.out.println("10) Customer Email  : " + cu.getCustEmail());
		updateChoice = sc.nextInt();

		switch(updateChoice) {
		case 0:
			System.out.println("Enter the Updated First Name ");
			String firstName = sc.next();
			//String.format(MyQueries.modifyDetails, "First_Name");
			//MyQueries.modifyDetails.replaceFirst("%s", "First_Name");
			cd.modifyCustomer(MyQueries.modifyDetails.replaceFirst("%s", "First_Name"),firstName,ssn7,credit7);
			
			break;
		case 1:
			System.out.println("Enter the Updated Middle Name ");
			String middleName = sc.next();
			MyQueries.modifyDetails.replaceFirst("%s", "Middle_Name");
			cd.modifyCustomer(MyQueries.modifyDetails.replaceFirst("%s", "Middle_Name"),middleName,ssn7,credit7);

			break;
		case 2:
			System.out.println("Enter the Updated Last Name ");
			String lastName = sc.next();
			cd.modifyCustomer(MyQueries.modifyDetails.replaceFirst("%s", "Last_Name"),lastName,ssn7,credit7);

			break;
		case 3:
			System.out.println("Enter the Updated Apartment Number ");
			int updatedSSN = sc.nextInt();
			cd.modifyIntCustomer(MyQueries.modifyDetails.replaceFirst("%s", "APT_NO"),updatedSSN,ssn7,credit7);

			break;
		case 4:
			System.out.println("Enter the Updated Street Name");
			String street = sc.next();
			cd.modifyCustomer(MyQueries.modifyDetails.replaceFirst("%s", "STREET_NAME"),street,ssn7,credit7);
			System.out.println("\nResult: ");

			break;
		case 5:
			System.out.println("Enter the Updated City Name");
			String city = sc.next();
			cd.modifyCustomer(MyQueries.modifyDetails.replaceFirst("%s", "CUST_CITY"),city,ssn7,credit7);

			break;
		case 6:
			System.out.println("Enter the Updated State Name");
			String state = sc.next();
			cd.modifyCustomer(MyQueries.modifyDetails.replaceFirst("%s", "CUST_STATE"),state,ssn7,credit7);

			break;
		case 7:
			System.out.println("Enter the Updated Country Name");
			String country = sc.next();
			cd.modifyCustomer(MyQueries.modifyDetails.replaceFirst("%s", "CUST_COUNTRY"),country,ssn7,credit7);

			break;
		case 8:
			System.out.println("Enter the Updated Zip Code ");
			int zip = sc.nextInt();
			cd.modifyIntCustomer(MyQueries.modifyDetails.replaceFirst("%s", "CUST_ZIP"),zip,ssn7,credit7);

			break;
		case 9:
			System.out.println("Enter the Updated Phone number");
			String phone = sc.next();
			cd.modifyCustomer(MyQueries.modifyDetails.replaceFirst("%s", "CUST_PHONE"),phone,ssn7,credit7);

			break;
		case 10:
			System.out.println("Enter the Updated E-mail");
			String email = sc.next();
			cd.modifyCustomer(MyQueries.modifyDetails.replaceFirst("%s", "CUST_EMAIL"),email,ssn7,credit7);
			break;
		default:
			System.out.println("Not an option!");
			break;
		}
		System.out.println("\nResult: ");
		c = cd.getCustDetails(ssn7, credit7);
		String customerFormat = "%-15s%-9s%-15s%-10s%-20s%-10s%-20s%-10s%-8s%-15s%-10s%-10s%-10s\n";
		System.out.format(customerFormat,"First Name","Middle","Last Name","SSN", "Credit Card Num"
				, "Apt No", "Street Name","City", "State", "Country", "Zip", "Phone #", "Email");
		System.out.format(customerFormat,c.getFirstName(),c.getMiddleName(),c.getLastName(),c.getSsn(),
				c.getCreditCardNo(),c.getAptNo(),c.getStreetName(),c.getCustCity(),
				c.getCustState(),c.getCustCountry(),c.getCustZip(),c.getCustPhone(),c.getCustEmail()+"\n");

	}

	public void mainMenu() {
		System.out.println("Please enter transaction Type:");
		System.out.println("Transaction Details: ");
		System.out.println("1) Display the transactions made by computers living in a given zip code for a given month and year.");
		System.out.println("2) Display the total number and total values of transactions for a given type");
		System.out.println("3) Display the total number and total values of transactions for branches in a given state");
		System.out.println("Customer Details: ");
		System.out.println("4) Dispay the existing account details of a customer");
		System.out.println("5) Modify the existing account details of a customer");
		System.out.println("6) Display the Monthly bill for a customer for a given month and year");
		System.out.println("7) Display the transactions made by a customer between two dates ");
		System.out.println("8) Exit");

	}
}




