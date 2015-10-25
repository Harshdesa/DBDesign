/*
Creator : Harsh Desai
Net ID : hbd140030

*/

import java.sql.*;

public class NewuserBackEnd
{

	static Connection conn = null;

	//All the strings and arrays used to populate the JTable 
	public static Object resultData[][] = new Object[1000][1000];	
	public static int Card_no_generated;
	public static void method_a()
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
			String query = "SELECT Fname,Lname,Address FROM BORROWER WHERE Fname= '" +Newuser.fname_name + "' AND Lname =  '"+Newuser.lname_name + "' AND Address = '"+ Newuser.address_name+ "';" ;
			ResultSet rs = stmt.executeQuery(query);
					
			while (rs.next()) {

				/* Keep track of the line/tuple count */
				

				/* Populate Java field variables from MySQL columnLabel */
				// Order of the following statements is not important
				resultData[i][0] = rs.getString("Fname");
				resultData[i][1] = rs.getString("Lname");
				resultData[i][2] = rs.getString("Address");
			

				i++;
			} // End while(rs.next())

	
			rs.close();
			conn.close();
			
			

			if(i>0)
			{
				Newuser.reject_flag=1;
			}
			else Newuser.reject_flag=0;
			
			

			System.out.println("Success!!");

		}

		catch(SQLException ex) 
		{
			System.out.println("Error in connection: " + ex.getMessage());
		}


		try
		{
			conn = DriverManager.getConnection(url, user, password);
			Statement stmt1 = conn.createStatement();
			stmt1.execute("use LIBRARY;");
			String query1 = "SELECT MAX(Card_no) as C FROM BORROWER;" ;
			ResultSet rs1 = stmt1.executeQuery(query1);
			
			rs1.next();	
			Card_no_generated=rs1.getInt("C");
			
	
			rs1.close();
			conn.close();
			System.out.println(Card_no_generated);
			Card_no_generated++;

		}
		catch(SQLException ex) 
		{
			System.out.println("Error in connection: " + ex.getMessage());
		}


	}

	public static void method_b()
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
			String query = "INSERT INTO BORROWER(Card_no,Fname,Lname,Address,Phone) VALUES" + "('" +Card_no_generated+"','"+ Newuser.fname_name + "','"+Newuser.lname_name+"','"+Newuser.address_name+"',"+Newuser.phone_name+");";
			stmt.executeUpdate(query);
					
			
	
			
			conn.close();
			System.out.println("Success!!");

		}
	
		catch(SQLException ex) 
		{
			System.out.println("Error in connection: " + ex.getMessage());
		}




	}

	public static void main(String[] args) {

		

	}

}
