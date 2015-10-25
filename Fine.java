/*
Creator : Harsh Desai 
Net ID : hbd140030

*/


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Fine extends JFrame
{

	public static JLabel card_no_label;

	
	public static JTextField card_no_txt;


	public static int card_no_name;
	public static double fine_amt;
	public static double est_fine_amt;



	public static JButton check_fine_button;
	public static JButton pay_fine_button;
	public static JButton refresh_button;
	public static JButton back_to_search_button;
	
	
	public JLabel error_label;
	public JLabel error_label2;

	public Fine(String header)
	{
		super(header);
		setSize(1200,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
		setLayout(null);	//TO AVOID THE DEFAULT BORDER LAYOUT MANAGER
	
		card_no_label = new JLabel("Card No. : ");

		error_label = new JLabel("");
		error_label2 = new JLabel("");

		card_no_txt = new JTextField("");





		check_fine_button = new JButton("Check Fine!");
		pay_fine_button = new JButton("Pay Fine !");
		refresh_button = new JButton("REFRESH !");		
		back_to_search_button =new JButton("Back To Search !");	

		card_no_label.setSize(100,100);

		error_label.setSize(600,100);
		error_label2.setSize(600,100);

		card_no_txt.setSize(200,20);


		check_fine_button.setSize(200,20);
		pay_fine_button.setSize(200,20);
		refresh_button.setSize(200,20);
		back_to_search_button.setSize(200,20);


		card_no_label.setLocation(20,20);
		
				
		

		card_no_txt.setLocation(120,60);
		

		error_label.setLocation(20,400);
		error_label2.setLocation(20,430);

		

		check_fine_button.setLocation(20,200);
		pay_fine_button.setLocation(20,230);
		refresh_button.setLocation(20,270);
		back_to_search_button.setLocation(20,300);

		add(card_no_label);
		
		add(error_label);
		add(error_label2);

		

		add(card_no_txt);
		

		add(check_fine_button);
		add(pay_fine_button);
		add(refresh_button);
		add(back_to_search_button);

		check_fine_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
					
					error_label.setText("");
					card_no_name=Integer.parseInt(card_no_txt.getText());

					FineBackEnd.method_a();

					error_label.setText("Your TO PAY fine is : " + fine_amt);
					FineBackEnd.method_b();
					error_label2.setText("Your estimated fine is : "+ est_fine_amt);
				
				System.out.println("Check fine");

			}
		});

		pay_fine_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FineBackEnd.method_c();
				error_label.setText("Your fine has been paid. Please check your estimated fine. ");
				error_label2.setText("");
				System.out.println("Pay fine");
				
			}
		});

		refresh_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				fine_amt=0.0;
				est_fine_amt=0.0;
				FineBackEnd.method_d();
				System.out.println("Refresh");
				error_label.setText("");
				error_label2.setText("");
				//calculate all the fines, add entries of new fines in the FINE table, update the new fines ! 
			}
		});

		back_to_search_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				Search.frame.setVisible(true);

			}
		});


	}





}



//INSERT INTO FINES(loan_id,fine_amt,paid) VALUES('"0195798589"',0,0);

//UPDATE FINES,BOOK_LOANS SET FINES.fine_amt=Datediff(SYSDATE(),BOOK_LOANS.Due_date)*0.25 WHERE BOOK_LOANS.Book_id=FINES.loan_id AND FINES.paid=0;
