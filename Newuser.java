/*
Creator : Harsh Desai
Net ID : hbd140030

*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Newuser extends JFrame
{
	
	public static int reject_flag=0;

	public JLabel fname_label;
	public JLabel lname_label;
	public JLabel address_label;
	public JLabel phone_label;

	public JTextField fname_txt;
	public JTextField lname_txt;
	public JTextField address_txt;
	public JTextField phone_txt;

	public static String fname_name;
	public static String lname_name;
	public static String address_name;
	public static String phone_name;
		
	public static JButton signup_button;
	public static JButton search_button;

	public JLabel error_label;

	public Newuser(String header)
	{
		super(header);
		setSize(1200,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
		setLayout(null);	//TO AVOID THE DEFAULT BORDER LAYOUT MANAGER

		fname_label = new JLabel("First Name : ");
		lname_label = new JLabel("Last Name : ");
		address_label = new JLabel("Address : ");		
		phone_label = new JLabel("Phone : ");
		error_label = new JLabel("");

		fname_txt = new JTextField("");
		lname_txt = new JTextField("");		
		address_txt = new JTextField("");
		phone_txt = new JTextField("");		

		signup_button = new JButton("Signup!");
		search_button = new JButton("Back to Search!");

		fname_label.setSize(100,100);
		lname_label.setSize(100,100);
		address_label.setSize(100,100);
		phone_label.setSize(100,100);
		error_label.setSize(600,100);
		
		fname_txt.setSize(200,20);
		lname_txt.setSize(200,20);
		address_txt.setSize(200,20);
		phone_txt.setSize(200,20);

		signup_button.setSize(200,20);
		search_button.setSize(200,20);


		fname_label.setLocation(20,20);
		lname_label.setLocation(20,50);
		address_label.setLocation(20,80);
		phone_label.setLocation(20,110);		


		fname_txt.setLocation(120,60);
		lname_txt.setLocation(120,90);
		address_txt.setLocation(120,120);
		phone_txt.setLocation(120,150);
		error_label.setLocation(20,400);

		signup_button.setLocation(20,200);
		search_button.setLocation(350,100);
	
		add(fname_label);
		add(lname_label);
		add(address_label);
		add(phone_label);
		add(error_label);

		add(fname_txt);
		add(lname_txt);
		add(address_txt);
		add(phone_txt);

		add(signup_button);
		add(search_button);
	
		signup_button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) 
			{
				fname_name = fname_txt.getText();
				lname_name = lname_txt.getText();
				address_name = address_txt.getText();
				phone_name = phone_txt.getText();

				
			
				NewuserBackEnd.method_a();
				if(!phone_name.matches("[0-9]+"))
				{
					error_label.setText("Phone number contains a character !");
				}
				else if(reject_flag==1)
				{
					System.out.println("Reject Message !");
					error_label.setText("This user is already registered!");
				}
				else
				{ 
					error_label.setText("Creating a card number, HOLD ON!");
					NewuserBackEnd.method_b();
					error_label.setText("Your new Card Number is : " + NewuserBackEnd.Card_no_generated);
				}
				repaint();		
			
			}

		});
	
		search_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				Search.frame.setVisible(true);
		


			}



		});
	}






	




}
