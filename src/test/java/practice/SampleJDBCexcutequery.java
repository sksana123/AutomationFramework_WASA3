package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCexcutequery {

	public static void main(String[] args) throws SQLException {
		
		//driver for mysql database
		Driver driverref=new Driver();
		
		
		
		//step:1 register the driver
		DriverManager.registerDriver(driverref);
		
		//step:2 get the connection database -(give db name)
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db","root", "root");
		
		//step3: issue create statement
	 Statement state=con.createStatement();
	 
	 
	 //step:4 excute a querey-(give table name)
	 ResultSet result=state.executeQuery("select * from candidateinfo");
	 
	 while(result.next())
	 {
		 System.out.println(result.getString(1)+" "+result.getInt(2)+" "+result.getString(3));
	 }
	 
	 //step:5 close the db
	 
	 con.close();
	 
	 System.out.println("closed");
	 
		
		
		
		
		
		
		
		
		
		
		

	}

}
