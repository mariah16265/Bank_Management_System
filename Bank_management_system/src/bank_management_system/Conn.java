package bank_management_system;
import java.sql.*;

public class Conn {
	//JDBC:
	//register the driver
	//create connection
	//create statement
	//execute query
	//close connection
	
	Connection c;
	Statement s;
	public Conn() {
		try {
			c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Mariah@16265");
			s= c.createStatement();
			
		}
		catch(Exception e){
			System.out.println(e);
			
		}
		//mySQL is an external entity more prone to error at runtime 
	}

}
