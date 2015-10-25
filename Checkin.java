/*
Created by : Harsh Desai
Net ID : hbd140030
Description : DB Design Project 
*/


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Checkin extends JFrame
{

	public JLabel book_label;
	public JLabel borrower_label;
	public JLabel card_label;

	public JTextField book_txt;
	public JTextField borrower_txt;
	public JTextField card_txt;

	public static String book_id_name;
	public static String borrower_name;
	public static String card_no_name;

	public static String branch_name_search;
	public static String book_name_search;

	public Checkbox book_id_check;
	public Checkbox borrower_check;
	public Checkbox card_no_check;

	static public Object rowData[][] = new Object[5000][5000];
	Object columnNames[] = { "branch_id", "book_id", "Card_no","Fname","Date_out","Due_date","Date_in" };
	Object selected_data[];

	public static JButton checkin_button;
	public static JButton search_button;
	public static JButton back_to_search_button;

	public JLabel error_label;

	public Checkin(String header)
	{
		super(header);
		setSize(1200,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
		setLayout(null);	//TO AVOID THE DEFAULT BORDER LAYOUT MANAGER

		final JTable table = new JTable(rowData, columnNames);

		JScrollPane scrollPane = new JScrollPane(table);

	
		book_label = new JLabel("Book ID : ");
		borrower_label = new JLabel("Borrower : ");
		card_label = new JLabel("Card No. : ");
		error_label = new JLabel("");

		book_txt = new JTextField("");
		borrower_txt = new JTextField("");		
		card_txt = new JTextField("");

		book_id_check = new Checkbox("",true);
		borrower_check = new Checkbox();
		card_no_check = new Checkbox();

		checkin_button = new JButton("Checkin!");
		back_to_search_button = new JButton("Back to Search!");
		search_button = new JButton("Search");

		book_label.setSize(100,100);
		borrower_label.setSize(100,100);
		card_label.setSize(100,100);
		error_label.setSize(600,100);

		book_txt.setSize(200,20);
		borrower_txt.setSize(200,20);
		card_txt.setSize(200,20);
		book_id_check.setSize(15,15);
		borrower_check.setSize(15,15);
		card_no_check.setSize(15,15);

		checkin_button.setSize(200,20);
		search_button.setSize(200,20);
		back_to_search_button.setSize(200,20);
	
		scrollPane.setSize(700,200);	

		book_label.setLocation(20,20);
		borrower_label.setLocation(20,50);
		card_label.setLocation(20,80);
				


		book_txt.setLocation(120,60);
		borrower_txt.setLocation(120,90);
		card_txt.setLocation(120,120);
		error_label.setLocation(20,400);
		book_id_check.setLocation(5,65);
		borrower_check.setLocation(5,95);
		card_no_check.setLocation(5,125);
	
		checkin_button.setLocation(20,170);
		search_button.setLocation(350,100);
		back_to_search_button.setLocation(350,140);
		scrollPane.setLocation(20,200);	
	
		if(Search.populate_checkin_flag==1)
		{		
			book_txt.setText(book_name_search);
			System.out.println("blah blah");
			

		}

		add(book_label);
		add(borrower_label);
		add(card_label);
		add(error_label);

		add(book_txt);
		add(borrower_txt);
		add(card_txt);

		add(book_id_check);
		add(borrower_check);
		add(card_no_check);

		add(checkin_button);
		add(search_button);
		add(back_to_search_button);
		add(scrollPane);
		


		checkin_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("TestLa");
				AbstractButton button = (AbstractButton)e.getSource();
				int row=0;
				int col=0;
        			if(e.getActionCommand().equals(button.getActionCommand()))
				{	
					 row = table.getSelectedRow();
            				 col = table.getSelectedColumn();
				}	

				CheckinBackEnd.book_id=(String)table.getValueAt(row,1);
				CheckinBackEnd.branch_id=Integer.parseInt((String)table.getValueAt(row,0));
				CheckinBackEnd.Card_no=Integer.parseInt((String)table.getValueAt(row,2));

				
	
				CheckinBackEnd.method_d();

				System.out.println(table.getValueAt(row,0));
				System.out.println(table.getValueAt(row,1));
				System.out.println(table.getValueAt(row,2));
				System.out.println(table.getValueAt(row,3));
				System.out.println(table.getValueAt(row,4));
				
				repaint();
				//ALSO, SET THE paid of FINES TO 0. WHY ? NOT NECESSARY !

			}

		});

		search_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(borrower_check.getState())
				{
					for(int i=0;i<10;i++)
					{
					Checkin.rowData[i][0] = "";
					Checkin.rowData[i][1] = "";
					Checkin.rowData[i][2] = "";
					Checkin.rowData[i][3] = "";
					Checkin.rowData[i][4] = "";
					Checkin.rowData[i][5] = "";
					}

					error_label.setText("");
					borrower_name=borrower_txt.getText();
					System.out.println("borrower");
					CheckinBackEnd.method_b();
				}
				else if(book_id_check.getState())
				{
					for(int i=0;i<10;i++)
					{
					Checkin.rowData[i][0] = "";
					Checkin.rowData[i][1] = "";
					Checkin.rowData[i][2] = "";
					Checkin.rowData[i][3] = "";
					Checkin.rowData[i][4] = "";
					Checkin.rowData[i][5] = "";
					}

					error_label.setText("");
					book_id_name = book_txt.getText();
					System.out.println("book id");
					CheckinBackEnd.method_a();
				
				}
				else if(card_no_check.getState())
				{

					for(int i=0;i<10;i++)
					{
					Checkin.rowData[i][0] = "";
					Checkin.rowData[i][1] = "";
					Checkin.rowData[i][2] = "";
					Checkin.rowData[i][3] = "";
					Checkin.rowData[i][4] = "";
					Checkin.rowData[i][5] = "";
					}
					error_label.setText("");
					card_no_name = card_txt.getText();
					CheckinBackEnd.method_c();
					System.out.println("card_no");
		
					}
				else 
				{
					error_label.setText("Please enter either BOOK ID,TITLE OR AUTHOR NAME OR BOTH !");
				}
				
				repaint();


			}

		});




		back_to_search_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				error_label.setText("");
				setVisible(false);
				Search.frame.setVisible(true);
		


			}
		});



	}



}
