package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCUpdatequery {

	public static void main(String[] args) throws SQLException {
		
		Driver driverref=new Driver();
		
		Connection con=null;
		
		try
		{
		
		
		
	//step :1 register the data base / driver
		
		DriverManager.registerDriver(driverref);
		
	//step: 2 get connection to the database
		
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db", "root", "root");
		
	//step :3 issuse create statement
		      
		  Statement state=con.createStatement();
		
	//step :4 execute a querey
		  
			String query= "insert into candidateinfo values('subha',,'banglore');";
		  
		  int result=state.executeUpdate(query);
		  
		  if(result>=1)
		  {
			  System.out.println("data added");
		  }
		  ResultSet result1=state.executeQuery("select * from candidateinfo;");
		  
		  while(result1.next()) 
		  {
			  
		  System.out.println(result1.getString(1)+" "+result1.getInt(2)+" "+result1.getString(3));
		  }
		}
		  
		finally
		{
		//step :5 close database
		  con.close();
		  System.out.println("db closed");
		}
	}

}
