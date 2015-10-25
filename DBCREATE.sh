#!/bin/bash

# Functions
ok() { echo -e '\e[32m'$1'\e[m'; } # Green

EXPECTED_ARGS=1
E_BADARGS=65
MYSQL=`which mysql`
 
Q1="CREATE DATABASE IF NOT EXISTS $1;"
Q2="cp book_copies.csv /var/lib/mysql/$1"
Q3="cp books.csv /var/lib/mysql/$1"
Q4="cp borrowers.csv /var/lib/mysql/$1"
Q5="cp library_branch.csv /var/lib/mysql/$1"
Q6="use $1;"
Q7="CREATE TABLE BOOK(Book_id CHAR(20) NOT NULL, Title VARCHAR(200) NOT NULL);"
Q8="LOAD DATA INFILE 'books.csv' INTO TABLE BOOK FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' (@col1,@col2,@col3) set Book_id=@col1 , Title = @col3;"
Q9="ALTER IGNORE TABLE BOOK ADD UNIQUE INDEX id_index(Book_id);"
Q10="CREATE TABLE BOOK_AUTHORS(Book_id CHAR(20) NOT NULL, Author_name VARCHAR(255) NOT NULL);"
Q11="LOAD DATA INFILE 'books.csv' INTO TABLE BOOK_AUTHORS FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' (@col1,@col2,@col3,@col4) set Book_id=@col1 , Author_name = @col4;"
Q12="ALTER IGNORE TABLE BOOK_AUTHORS ADD UNIQUE INDEX id_index(Book_id,Author_name);"
Q13="ALTER TABLE BOOK_AUTHORS ADD CONSTRAINT id_fk FOREIGN KEY (Book_id) REFERENCES BOOK(Book_id);"
Q14="CREATE TABLE LIBRARY_BRANCH (Branch_id INT NOT NULL, Branch_name VARCHAR(20) NOT NULL, Address VARCHAR(50) NOT NULL, PRIMARY KEY(Branch_id));"
Q15="LOAD DATA INFILE 'library_branch.csv' INTO TABLE LIBRARY_BRANCH FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' (@col1,@col2,@col3) set Branch_id=@col1 , Branch_name = @col2, Address = @col3;"
Q16="CREATE TABLE BOOK_COPIES(Book_id CHAR(20) NOT NULL, Branch_id INT NOT NULL, No_of_copies INT NOT NULL);"
Q17="ALTER IGNORE TABLE BOOK_COPIES ADD CONSTRAINT id_fk4 FOREIGN KEY (Book_id) REFERENCES BOOK(Book_id);"
Q18="set foreign_key_checks = 0;"
Q19="LOAD DATA INFILE 'book_copies.csv' INTO TABLE BOOK_COPIES FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' (@col1,@col2,@col3) set Book_id=@col1 , Branch_id = @col2, No_of_copies = @col3;"
Q20="set foreign_key_checks = 1;"
Q21="ALTER IGNORE TABLE BOOK_COPIES ADD UNIQUE INDEX id_indexx(Book_id,Branch_id);"
Q22="ALTER TABLE BOOK_COPIES ADD CONSTRAINT id_fk2 FOREIGN KEY (Branch_id) REFERENCES LIBRARY_BRANCH(Branch_id);"
Q23="CREATE TABLE BORROWER(Card_no INT NOT NULL, Fname VARCHAR(20) NOT NULL, Lname VARCHAR(20) NOT NULL, Address VARCHAR(255) NOT NULL, Phone CHAR(20) NOT NULL,PRIMARY KEY(Card_no));"
Q24="LOAD DATA INFILE 'borrowers.csv' INTO TABLE BORROWER FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' (@col1,@col2,@col3,@col4,@col5,@col6,@col7,@col8) set Card_no=@col1 , Fname = @col2 , Lname = @col3, Address = CONCAT(@col5,@col6,@col7) , Phone = @col8;"
Q25="CREATE TABLE BOOK_LOANS(Book_id CHAR(20) NOT NULL, Branch_id INT NOT NULL, Card_no INT NOT NULL, Date_out datetime, Due_date datetime, Date_in datetime, PRIMARY KEY(Book_id,Branch_id,Card_no));"
Q26="LOAD DATA INFILE 'book_loans.csv' INTO TABLE BOOK_LOANS FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' (@col1,@col2,@col3,@col4,@col5,@col6,@col7) set Book_id=@col2 , Branch_id = @col3 , Card_no = @col4 , Date_out = @col5 , Due_date = @col6 , Date_in = @col7;"
Q27="ALTER TABLE BOOK_LOANS ADD CONSTRAINT id_fkA FOREIGN KEY (Book_id) REFERENCES BOOK(Book_id);"
Q28="ALTER TABLE BOOK_LOANS ADD CONSTRAINT id_fkB FOREIGN KEY (Branch_id) REFERENCES LIBRARY_BRANCH(Branch_id);"
Q29="ALTER TABLE BOOK_LOANS ADD CONSTRAINT id_fkC FOREIGN KEY (Card_no) REFERENCES BORROWER(Card_no);"
Q30="CREATE TABLE FINES(loan_id char(20),fine_amt DECIMAL(5,2),paid BOOLEAN);"
Q31="ALTER TABLE FINES ADD CONSTRAINT id_fkD FOREIGN KEY (loan_id) REFERENCES BOOK_LOANS(loan_id);"
Q32="UPDATE BOOK_LOANS SET Date_in = NULL WHERE Date_in = '0000-00-00 00:00:00';"
Q33="LOAD DATA INFILE 'book_loans.csv' INTO TABLE FINES FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' (@col1,@col2,@col3,@col4,@col5,@col6,@col7) set loan_id=@col2;"
Q34="ALTER IGNORE TABLE BOOK ADD UNIQUE INDEX id_index(loan_id);"
Q35="UPDATE FINES SET fine_amt=0.00 WHERE fine_amt<0.00;"

SQL="${Q1}${Q2}${Q3}${Q4}${Q5}${Q6}${Q7}${Q8}${Q9}${Q10}${Q11}${Q12}${Q13}${Q14}${Q15}${Q16}${Q17}${Q18}${Q19}${Q20}${Q21}${Q22}${Q23}${Q24}${Q25}${Q26}${Q27}${Q28}"
 
if [ $# -ne $EXPECTED_ARGS ]
then
  echo "Usage: $0 dbname dbuser dbpass"
  exit $E_BADARGS
fi
 
$MYSQL -u root -p -e "$SQL"

ok "Database $1 created"
