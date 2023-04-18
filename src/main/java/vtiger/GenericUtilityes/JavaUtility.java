package vtiger.GenericUtilityes;

import java.util.Date;
import java.util.Random;

public class JavaUtility {

		/**
		 * this method for sys date
		 * @return
		 */
		public String getSystemDate()
		{
			Date d =new Date();
		String	systemdate=d.toString();
		return systemdate;
			
		}
/**
 * this method for Sys date in user formate
 */
		
		public String getSystemDateInFormat()
		{
			Date d=new Date();
			String sysdate=d.toString();
			String date[]=sysdate.split(" ");
			
			String month=date[1];
			
			String date1=date[2];
			String year=date[5];
			String time=date[3].replace(":","-");
			
			 String finaldate=date1+" "+month+" "+year+" "+time;
		
		return finaldate;
		
		
		
	}
		
		/**
		 * this method for random num
		 * @return 
		 */
		
		public int getRandomNumber()
		{
			Random r=new Random();
		return	r.nextInt(1000);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
