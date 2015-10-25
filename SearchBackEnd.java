/*
Creator : Harsh Desai

*/

import java.sql.*;

public class SearchBackEnd
{

	static Connection conn = null;

	public static int No_of_copies_checked_out;

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
			String query = "SELECT Branch_id,BOOK.Book_id,Title,Author_name,No_of_copies FROM BOOK,BOOK_AUTHORS,BOOK_COPIES WHERE Author_name LIKE" + "'%" +Search.author_name + "%'"+"AND BOOK.Book_id = BOOK_AUTHORS.Book_id AND BOOK.Book_id LIKE CONCAT('%',BOOK_COPIES.Book_id,'%');";
			ResultSet rs = stmt.executeQuery(query);
					
			while (rs.next()) {

				/* Keep track of the line/tuple count */
				

				/* Populate Java field variables from MySQL columnLabel */
				// Order of the following statements is not important
				Search.rowData[i][0] = rs.getString("Branch_id");
				Search.rowData[i][1] = rs.getString("BOOK.Book_id");
				Search.rowData[i][2] = rs.getString("Title");
				Search.rowData[i][3] = rs.getString("Author_name");
				Search.rowData[i][4] = rs.getInt("No_of_copies");

				i++;
			} // End while(rs.next())

	
			rs.close();
			conn.close();
			System.out.println("Success!!");

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
			String query = "SELECT Branch_id,BOOK.Book_id,Title,Author_name,No_of_copies FROM BOOK,BOOK_AUTHORS,BOOK_COPIES WHERE BOOK.Book_id LIKE" + "'%" +Search.book_id_name + "%'"+"AND BOOK.Book_id = BOOK_AUTHORS.Book_id AND BOOK.Book_id LIKE CONCAT('%',BOOK_COPIES.Book_id,'%');";
			ResultSet rs = stmt.executeQuery(query);
					
			while (rs.next()) {

				/* Keep track of the line/tuple count */
				

				/* Populate Java field variables from MySQL columnLabel */
				// Order of the following statements is not important
				Search.rowData[i][0] = rs.getString("Branch_id");
				Search.rowData[i][1] = rs.getString("BOOK.Book_id");
				Search.rowData[i][2] = rs.getString("Title");
				Search.rowData[i][3] = rs.getString("Author_name");
				Search.rowData[i][4] = rs.getInt("No_of_copies");

				i++;
			} // End while(rs.next())

	
			rs.close();
			conn.close();
			System.out.println("Success!!");

		}
	
		catch(SQLException ex) 
		{
			System.out.println("Error in connection: " + ex.getMessage());
		}




	}

	public static void method_c()
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
			String query = "SELECT Branch_id,BOOK.Book_id,Title,Author_name,No_of_copies FROM BOOK,BOOK_AUTHORS,BOOK_COPIES WHERE BOOK.Title LIKE" + "'%" +Search.title_name + "%'"+"AND BOOK.Book_id = BOOK_AUTHORS.Book_id AND BOOK.Book_id LIKE CONCAT('%',BOOK_COPIES.Book_id,'%');";
			ResultSet rs = stmt.executeQuery(query);
					
			while (rs.next()) {

				/* Keep track of the line/tuple count */
				

				/* Populate Java field variables from MySQL columnLabel */
				// Order of the following statements is not important
				Search.rowData[i][0] = rs.getString("Branch_id");
				Search.rowData[i][1] = rs.getString("BOOK.Book_id");
				Search.rowData[i][2] = rs.getString("Title");
				Search.rowData[i][3] = rs.getString("Author_name");
				Search.rowData[i][4] = rs.getInt("No_of_copies");

				i++;
			} // End while(rs.next())

	
			rs.close();
			conn.close();
			System.out.println("Success!!");

		}
	
		catch(SQLException ex) 
		{
			System.out.println("Error in connection: " + ex.getMessage());
		}




	}

	public static void method_d()
	{
		String url = "jdbc:mysql://localhost:3306/";
		String user = "root";
		String password = "db123";
			
		try {
			conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			stmt.execute("use LIBRARY;");
		
			String query = "SELECT COUNT(*) AS CHECKER FROM BOOK_LOANS WHERE Branch_id =" + Search.Branch_id + " AND Book_id LIKE CONCAT('%',"+Search.Book_id+",'%') AND Date_in IS NULL;";

			ResultSet rs = stmt.executeQuery(query);
					
			while (rs.next()) {
			
				No_of_copies_checked_out=rs.getInt("CHECKER");

			} // End while(rs.next())

	
			rs.close();
			conn.close();
			System.out.println("Success!!");

		}
	
		catch(SQLException ex) 
		{
			System.out.println("Error in connection: " + ex.getMessage());
		}

	}

	static public void method_e()
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
			String query = "SELECT Branch_id,BOOK.Book_id,Title,Author_name,No_of_copies FROM BOOK,BOOK_AUTHORS,BOOK_COPIES WHERE Author_name LIKE" + "'%" +Search.author_name + "%' AND BOOK.Book_id LIKE" + "'%" +Search.book_id_name + "%'"+"AND BOOK.Book_id = BOOK_AUTHORS.Book_id AND BOOK.Book_id LIKE CONCAT('%',BOOK_COPIES.Book_id,'%');";
			ResultSet rs = stmt.executeQuery(query);
					
			while (rs.next()) {

				/* Keep track of the line/tuple count */
				

				/* Populate Java field variables from MySQL columnLabel */
				// Order of the following statements is not important
				Search.rowData[i][0] = rs.getString("Branch_id");
				Search.rowData[i][1] = rs.getString("BOOK.Book_id");
				Search.rowData[i][2] = rs.getString("Title");
				Search.rowData[i][3] = rs.getString("Author_name");
				Search.rowData[i][4] = rs.getInt("No_of_copies");

				i++;
			} // End while(rs.next())

	
			rs.close();
			conn.close();
			System.out.println("Success!!");

		}

		catch(SQLException ex) 
		{
			System.out.println("Error in connection: " + ex.getMessage());
		}


	}

	static public void method_f()
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
			String query = "SELECT Branch_id,BOOK.Book_id,Title,Author_name,No_of_copies FROM BOOK,BOOK_AUTHORS,BOOK_COPIES WHERE Author_name LIKE" + "'%" +Search.author_name + "%' AND BOOK.Title LIKE" + "'%" +Search.title_name + "%'"+"AND BOOK.Book_id = BOOK_AUTHORS.Book_id AND BOOK.Book_id LIKE CONCAT('%',BOOK_COPIES.Book_id,'%');";
			ResultSet rs = stmt.executeQuery(query);
					
			while (rs.next()) {

				/* Keep track of the line/tuple count */
				

				/* Populate Java field variables from MySQL columnLabel */
				// Order of the following statements is not important
				Search.rowData[i][0] = rs.getString("Branch_id");
				Search.rowData[i][1] = rs.getString("BOOK.Book_id");
				Search.rowData[i][2] = rs.getString("Title");
				Search.rowData[i][3] = rs.getString("Author_name");
				Search.rowData[i][4] = rs.getInt("No_of_copies");

				i++;
			} // End while(rs.next())

	
			rs.close();
			conn.close();
			System.out.println("Success!!");

		}

		catch(SQLException ex) 
		{
			System.out.println("Error in connection: " + ex.getMessage());
		}


	}
	
	static public void method_g()
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
			String query = "SELECT Branch_id,BOOK.Book_id,Title,Author_name,No_of_copies FROM BOOK,BOOK_AUTHORS,BOOK_COPIES WHERE BOOK.Book_id LIKE " + "'%" +Search.book_id_name + "%'"+" AND BOOK.Title LIKE " + "'%" +Search.title_name + "%'"+" AND BOOK.Book_id = BOOK_AUTHORS.Book_id AND BOOK.Book_id LIKE CONCAT('%',BOOK_COPIES.Book_id,'%');";
			ResultSet rs = stmt.executeQuery(query);
					
			while (rs.next()) {

				/* Keep track of the line/tuple count */
				

				/* Populate Java field variables from MySQL columnLabel */
				// Order of the following statements is not important
				Search.rowData[i][0] = rs.getString("Branch_id");
				Search.rowData[i][1] = rs.getString("BOOK.Book_id");
				Search.rowData[i][2] = rs.getString("Title");
				Search.rowData[i][3] = rs.getString("Author_name");
				Search.rowData[i][4] = rs.getInt("No_of_copies");

				i++;
			} // End while(rs.next())

	
			rs.close();
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
