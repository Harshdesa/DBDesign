/*
Creator : Harsh Desai
Net ID : hbd140030

*/

import java.sql.*;

public class CheckoutBackEnd
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
			String query = "SELECT COUNT(*) AS CHECKER FROM BOOK_LOANS WHERE Card_no =" + Checkout.Card_no + ";";

			ResultSet rs = stmt.executeQuery(query);
					
			while (rs.next()) {

				Checkout.no_of_copies = rs.getInt("CHECKER");
			}

			rs.close();
			conn.close();
			System.out.println("Success!!");

		}

		catch(SQLException ex) 
		{
			System.out.println("Error in connection: " + ex.getMessage());
		}

		if(Checkout.no_of_copies<3)
		{
			try {
				conn = DriverManager.getConnection(url, user, password);
				Statement stmt1 = conn.createStatement();
				stmt1.execute("use LIBRARY;");
				String query1 = "INSERT INTO BOOK_LOANS (Book_id,Branch_id,Card_no,Date_out,Due_date) VALUES ('" + Checkout.Book_id + "'," + Checkout.Branch_id +","+Checkout.Card_no+", SYSDATE(),ADDDATE(SYSDATE(), INTERVAL 14 DAY));";
				String query2 = "INSERT INTO FINES (fine_amt,paid) VALUES (0.00,FALSE);";

				stmt1.executeUpdate(query1);
				stmt1.executeUpdate(query2);

				conn.close();
				System.out.println("Success!!");

				}

			catch(SQLException ex) 
			{
				System.out.println("Error in connection: " + ex.getMessage());
			}
	
		

		}



	}

}
			


// INSERT INTO BOOK_LOANS (Book_id,Branch_id,Card_no,Date_out,Due_date) VALUES ('"1891620983"',2,1001,SYSDATE(),ADDDATE(SYSDATE(), INTERVAL 14 DAY));
