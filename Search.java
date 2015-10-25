/*
Creator : Harsh Desai
Net ID : hbd140030

*/


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.*;

//cd Desktop/DBDesign/Project/java


//----------------------------------Class extending JFrame--------------------
public class Search extends JFrame
{

public int numClicks=0;
public JLabel book_id;
public JLabel title;
public JLabel author;

public JTextField book_id_txt;
public JTextField title_txt;
public JTextField author_txt;

public Checkbox book_id_check;
public Checkbox title_check;
public Checkbox author_check;

public JLabel error_label;

static public Object rowData[][] = new Object[5000][5000];
Object columnNames[] = { "branch_id", "book_id", "Title","Author(s)","No_Of_Copies"};
Object selected_data[];
public JButton search_button;
public JButton newuser_button;
public JButton checkout_button;
public JButton checkin_button;
public JButton fine_button;

public static String author_name;
public static String book_id_name;
public static String title_name;
public static Newuser n;
public static Search frame;
public static Checkout c;
public static Checkin cin;
public static Fine cfine;
public static int populate_checkout_flag=0;
public static int populate_checkin_flag=0;

public static int Branch_id;
public static String Book_id;
public static int No_of_copies;


//--------------------Constructor-----------------------------
	public Search(String header)
	{
		super(header);
		setSize(1200,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
		setLayout(null);	//TO AVOID THE DEFAULT BORDER LAYOUT MANAGER 
	
		
		
		final JTable table = new JTable(rowData, columnNames);

		JScrollPane scrollPane = new JScrollPane(table);

		
		book_id = new JLabel("Book ID : ");
		title = new JLabel("Title : ");
		author = new JLabel("Author : ");
		
		book_id_txt = new JTextField("");
		title_txt = new JTextField("");		
		author_txt = new JTextField("");
		
		book_id_check = new Checkbox("",true);
		title_check = new Checkbox();
		author_check = new Checkbox();

		search_button = new JButton("Search");
		newuser_button = new JButton("New User ?");
		checkout_button = new JButton("Check out!");
		checkin_button = new JButton("Check in!");
		fine_button = new JButton("Check fine!");
		
		error_label = new JLabel("");

		//WITH LABEL setSize does not matter but need it with combination of setLocation
		book_id.setSize(100,100);
		title.setSize(100,100);
		author.setSize(100,100);
		error_label.setSize(600,100);		
				
		
		book_id_txt.setSize(200,20);
		title_txt.setSize(200,20);
		author_txt.setSize(200,20);
		book_id_check.setSize(15,15);
		title_check.setSize(15,15);
		author_check.setSize(15,15);

		search_button.setSize(200,20);
		newuser_button.setSize(200,20);
		checkout_button.setSize(200,20);	
		checkin_button.setSize(200,20);	
		fine_button.setSize(200,20);
		
		scrollPane.setSize(700,200);

		book_id.setLocation(20,20);
		title.setLocation(20,50);
		author.setLocation(20,80);
		error_label.setLocation(20,400);		


		book_id_txt.setLocation(100,60);
		title_txt.setLocation(100,90);
		author_txt.setLocation(100,120);
		
		book_id_check.setLocation(5,65);
		title_check.setLocation(5,95);
		author_check.setLocation(5,125);

		search_button.setLocation(20,150);
		newuser_button.setLocation(350,60);
		checkout_button.setLocation(350,90);
		checkin_button.setLocation(350,120);
		fine_button.setLocation(350,150);
		scrollPane.setLocation(20,200);		
		

		add(book_id);
		add(title);
		add(author);
		add(error_label);
	
		add(book_id_txt);
		add(title_txt);
		add(author_txt);
		
		add(book_id_check);
		add(title_check);
		add(author_check);

		add(search_button);
		add(newuser_button);
		add(checkout_button);
		add(checkin_button);
		add(fine_button);
		add(scrollPane);
		search_button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) 
			{
				
				if(author_check.getState() && book_id_check.getState())
				{
					error_label.setText("");
					author_name=author_txt.getText();
					book_id_name = book_id_txt.getText();
					SearchBackEnd.method_e();

				}
				else if(author_check.getState() && title_check.getState())
				{
					error_label.setText("");
					author_name=author_txt.getText();
					title_name = title_txt.getText();
					SearchBackEnd.method_f();		


				}
				else if(book_id_check.getState() && title_check.getState())
				{
					error_label.setText("");
					book_id_name = book_id_txt.getText();
					title_name = title_txt.getText();
					SearchBackEnd.method_g();


				}
				else if(author_check.getState())
				{
					error_label.setText("");
					author_name=author_txt.getText();
					SearchBackEnd.method_a();
				}
				else if(book_id_check.getState())
				{
					error_label.setText("");
					book_id_name = book_id_txt.getText();
					SearchBackEnd.method_b();
				
				}
				else if(title_check.getState())
				{
					error_label.setText("");
					title_name = title_txt.getText();
					SearchBackEnd.method_c();
		
					}
				else 
				{
					error_label.setText("Please enter either BOOK ID,TITLE OR AUTHOR NAME OR BOTH !");
				}
				
				repaint();
			}
		});

		newuser_button.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent ae) 
			{
				System.out.println("Test");
				
				setVisible(false);
				n.setVisible(true);				
		




			}
		});

		checkout_button.addActionListener(new ActionListener(){
		
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

				Checkout.branch_name=(String)table.getValueAt(row,0);
				Checkout.book_name=(String)table.getValueAt(row,1);

				Branch_id = Integer.parseInt((String)table.getValueAt(row,0));
				Book_id = (String)table.getValueAt(row,1);
				No_of_copies = (Integer)table.getValueAt(row,4);
	
				SearchBackEnd.method_d();

				System.out.println(table.getValueAt(row,0));
				System.out.println(table.getValueAt(row,1));
				System.out.println(table.getValueAt(row,2));
				System.out.println(table.getValueAt(row,3));
				System.out.println(table.getValueAt(row,4));
				
				if(No_of_copies<=SearchBackEnd.No_of_copies_checked_out)
				{

					error_label.setText("There are no books available for this branch.");
				}
			
				else
				{

					populate_checkout_flag=1;
					error_label.setText("");
					dispose();
					//setVisible(false);
					c = new Checkout("CHECKOUT !");				
					c.setVisible(true);
				}

	
			}
		});

		checkin_button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){


				System.out.println("TestLa");
				AbstractButton button = (AbstractButton)e.getSource();
				int row=0;
				int col=0;
        			if(e.getActionCommand().equals(button.getActionCommand()))
				{	
					 row = table.getSelectedRow();
            				 col = table.getSelectedColumn();
				}	

				Checkin.branch_name_search=(String)table.getValueAt(row,0);
				Checkin.book_name_search=(String)table.getValueAt(row,1);
				

				System.out.println(table.getValueAt(row,0));
				System.out.println(table.getValueAt(row,1));
				System.out.println(table.getValueAt(row,2));
				System.out.println(table.getValueAt(row,3));
				System.out.println(table.getValueAt(row,4));
				
				

				populate_checkin_flag=1;
				error_label.setText("");
				dispose();
				cin = new Checkin("CHECKIN !");
				cin.setVisible(true);


			}


		});

		fine_button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){
				dispose();
				cfine = new Fine("FINE !");
				cfine.setVisible(true);

			}
		});



	}
//-------------------If author name is selected then populate table. --------------------
	




//----------------------------Main Class ---------------------------
	public static void main(String[] args)
	{
			frame = new Search("SEARCH BOOK!");
			frame.setVisible(true);
	
			n = new Newuser("NEW USER!");

			







	}







}
