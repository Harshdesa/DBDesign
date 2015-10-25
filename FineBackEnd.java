/*
Creator : Harsh Desai
Net ID : hbd140030

*/

import java.sql.*;

public class FineBackEnd
{

	static Connection conn = null;

	//All the strings and arrays used to populate the JTable 
	
	static public void method_a()
	{
		String url = "jdbc:mysql://localhost:3306/";
		String user = "root";
		String password = "db123";

		String ssn;
		String firstName;
		String lastName;
		int salary;
		int dno;

		int i = 0;


		try {
			conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			stmt.execute("use LIBRARY;");
			String query = "SELECT SUM(fine_amt) FROM FINES,BOOK_LOANS WHERE FINES.loan_id=BOOK_LOANS.loan_id AND Card_no=" + Fine.card_no_name  +  " AND paid=FALSE AND Date_in IS NOT NULL GROUP BY Card_no;";

			ResultSet rs = stmt.executeQuery(query);
					
			while (rs.next()) {

				Fine.fine_amt = rs.getDouble("SUM(fine_amt)");
			}

			rs.close();
			conn.close();
			System.out.println("Success!!");

		}

		catch(SQLException ex) 
		{
			System.out.println("Error in connection: " + ex.getMessage());
		}
	}

	static public void method_b()
	{
		String url = "jdbc:mysql://localhost:3306/";
		String user = "root";
		String password = "db123";

		String ssn;
		String firstName;
		String lastName;
		int salary;
		int dno;

		int i = 0;


		try {
			conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			stmt.execute("use LIBRARY;");
			String query = "SELECT SUM(fine_amt) FROM FINES,BOOK_LOANS WHERE FINES.loan_id=BOOK_LOANS.loan_id AND Card_no=" + Fine.card_no_name + " AND paid=FALSE AND Date_in IS NULL GROUP BY Card_no;";

			ResultSet rs = stmt.executeQuery(query);
					
			while (rs.next()) {

				Fine.est_fine_amt = rs.getDouble("SUM(fine_amt)");
			}

			rs.close();
			conn.close();
			System.out.println("Success!!");

		}

		catch(SQLException ex) 
		{
			System.out.println("Error in connection: " + ex.getMessage());
		}
	}

	static public void method_c()
	{
		String url = "jdbc:mysql://localhost:3306/";
		String user = "root";
		String password = "db123";

		String ssn;
		String firstName;
		String lastName;
		int salary;
		int dno;

		int i = 0;



		try {
			conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			stmt.execute("use LIBRARY;");
			String query = "UPDATE FINES,BOOK_LOANS SET fine_amt=0.00,paid=TRUE WHERE paid=FALSE AND Card_no=" + Fine.card_no_name + " AND BOOK_LOANS.loan_id=FINES.loan_id AND Date_in IS NOT NULL;";

			 stmt.executeUpdate(query);
			
			conn.close();
			System.out.println("Success!!");

		}

		catch(SQLException ex) 
		{
			System.out.println("Error in connection: " + ex.getMessage());
		}
	}

	static public void method_d()
	{
		String url = "jdbc:mysql://localhost:3306/";
		String user = "root";
		String password = "db123";

		String ssn;
		String firstName;
		String lastName;
		int salary;
		int dno;

		int i = 0;



		try {
			conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			stmt.execute("use LIBRARY;");
			String query = "UPDATE FINES,BOOK_LOANS SET FINES.fine_amt=Datediff(SYSDATE(),BOOK_LOANS.Due_date)*0.25 WHERE BOOK_LOANS.loan_id=FINES.loan_id AND FINES.paid=0 AND Date_in IS NULL;";
			String query2 = "UPDATE FINES,BOOK_LOANS SET FINES.fine_amt=Datediff(BOOK_LOANS.Date_in,BOOK_LOANS.Due_date)*0.25 WHERE BOOK_LOANS.loan_id=FINES.loan_id AND FINES.paid=0 AND Date_in IS NOT NULL;";
			String query3="UPDATE FINES SET fine_amt=0.00 WHERE fine_amt<0.00;";


			 stmt.executeUpdate(query);
			stmt.executeUpdate(query2);
			stmt.executeUpdate(query3);
			conn.close();
			System.out.println("Success!!");

		}

		catch(SQLException ex) 
		{
			System.out.println("Error in connection: " + ex.getMessage());
		}
	}
}
