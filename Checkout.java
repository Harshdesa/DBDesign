/*
Creator : Harsh Desai
Net ID : hbd140030
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Checkout extends JFrame
{

	public JLabel book_label;
	public JLabel branch_label;
	public JLabel card_label;

	public JTextField book_txt;
	public JTextField branch_txt;
	public JTextField card_txt;

	public static String book_name;
	public static String branch_name;
	public static String card_name;

	public static JButton checkout_button;
	public static JButton search_button;

	public JLabel error_label;

	public static String Book_id;
	public static int Branch_id;
	public static int Card_no;
	public static int no_of_copies;
	public static Date date = new Date();
	

	public Checkout(String header)
	{
		super(header);
		setSize(1200,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
		setLayout(null);	//TO AVOID THE DEFAULT BORDER LAYOUT MANAGER
	
		book_label = new JLabel("Book ID : ");
		branch_label = new JLabel("Branch ID : ");
		card_label = new JLabel("Card No. : ");
		error_label = new JLabel("");


		book_txt = new JTextField("");
		branch_txt = new JTextField("");		
		card_txt = new JTextField("");

		checkout_button = new JButton("Checkout!");
		search_button = new JButton("Back to Search!");

		book_label.setSize(100,100);
		branch_label.setSize(100,100);
		card_label.setSize(100,100);
		error_label.setSize(1000,100);

		book_txt.setSize(200,20);
		branch_txt.setSize(200,20);
		card_txt.setSize(200,20);

		checkout_button.setSize(200,20);
		search_button.setSize(200,20);


		book_label.setLocation(20,20);
		branch_label.setLocation(20,50);
		card_label.setLocation(20,80);
				


		book_txt.setLocation(120,60);
		branch_txt.setLocation(120,90);
		card_txt.setLocation(120,120);
		error_label.setLocation(20,400);

		if(Search.populate_checkout_flag==1)
		{		
			book_txt.setText(book_name);
			branch_txt.setText(branch_name);
			System.out.println("blah blah");
			

		}
	
		checkout_button.setLocation(20,200);
		search_button.setLocation(350,100);
	
		add(book_label);
		add(branch_label);
		add(card_label);
		add(error_label);

		add(book_txt);
		add(branch_txt);
		add(card_txt);

		add(checkout_button);
		add(search_button);

		

		checkout_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Calendar c = Calendar.getInstance();
				c.setTime(new Date()); // Now use today date.
				c.add(Calendar.DATE, 14); // Adding 14 days
				String output = sdf.format(c.getTime());
				System.out.println(output);

				Card_no = Integer.parseInt(card_txt.getText());
				Branch_id = Integer.parseInt(branch_txt.getText());
				Book_id = book_txt.getText();
				CheckoutBackEnd.method_a();
				if(no_of_copies==3)
				error_label.setText("Sorry, you have checked out more than 3 Books!");
				else
				error_label.setText("Thank you. You have successfully checked out the book. Today's date is "+ date.toString()+ " and return date is "+output);

				repaint();

				//ALSO INSERT INTO FINES VALUES(loan_id,0.00,FALSE).


			}
		});


		search_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				error_label.setText("");
				setVisible(false);
				Search.frame.setVisible(true);
		


			}



		});	

			


	}














}
