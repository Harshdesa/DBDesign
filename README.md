# DBDesign

LIBRARY MANAGEMENT SYSTEM
Harsh Desai 
hbd140030

QUICK START USER GUIDE FOR LIBRARIAN SYSTEM USERS

A. Open the command terminal where the DBCREATE.sh SCRIPT is located. 

B. In the command terminal, type the following : sh DBCREATE.sh 

C. Once the Database is created, in the terminal type “javac Search.java”

D. To run the program, type in the command terminal “java Search”

E. The first page is the Search page. 


High Level Architecture, Design Decisions and Justifications


Search Page 

1. On this page, you can give a combination of Book_id , Author and or Title of the book you require to search. Even a substring will be okay.

2.  Once, you keyed in the values, hit the search button.

3. Wait for sometime and a list of books will be shown.

4. Select anyone and perform any of the following :
	a. Checkout
	b. Checkin
  	c. Pay fines
5. If a new user has to be entered, you can do so by clicking the New User? Button.



New User Page 

1. Enter the first name, last name , address and phone number of the user.

2. First name, last name and address should be unique.

3. If it's not unique, the system will throw an error.

4. On pressing the SignUp button, the system will give a unique card number to the user.




Checkout Page

1. Enter the book id, branch id and card number of the borrower and press the Search button.

2. This will checkout the book for the borrower.

3. If the book is already checked out, the system will throw an error.

4. If the borrower has more than 3 books checked out, then the system will throw an error as at a time a borrower cannot check out more than 3 books.

Checkin Page

1.  A borrower can checkin a book using his name or card no AND book id.

2. Once a search button is pressed, then the table will be populated by a list of books.

3. The admin can choose any one of the book and check them in.

4. Once the book is checked in a fine may/ may not be generated depending on the due date and the checkin date of the book.

Pay Fine Page

1.  In the text box just enter the card number of the user and press check fine. The payable fine and the non payable fine will be displayed.

2. Once, you click the refresh button, the database will be updated if the fine has been paid to display no fines( only the non payable fine)

3. The non payable fine is the fine for which the book has not been returned yet there is a fine for it since it is past due date.

4. Once you pay the fine, the fine will be zero.

The Search Page is the main page. 

You can navigate everywhere from the Search page.

You can go back to the search page from everywhere. 









Technical Dependencies (Software libraries, Software versions,etc) and build instructions

The only technical dependency is that the system must support JAVA and MYSQL. 

There are no extra libraries required !

Thank you ! 


