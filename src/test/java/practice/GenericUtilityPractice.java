package practice;

import java.io.IOException;

import vtiger.GenericUtilityes.ExcelFileUtility;
import vtiger.GenericUtilityes.JavaUtility;
import vtiger.GenericUtilityes.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Exception {
		
		
	
		PropertyFileUtility putil=new PropertyFileUtility();
		
		String URL=putil.readDataFromPropertyFile("url");
		
		
		System.out.println(URL);
		
		
		
		ExcelFileUtility eutil=new ExcelFileUtility();
		
		String value=eutil.readDataFromExcel("CONTACTS", 1, 2);
		
		System.out.println(value);
		eutil.writeDataIntoExcel("CONTACTS",1,3,"Sana");
		
		System.out.println("data added");
		
		
		JavaUtility jutil=new JavaUtility();
	System.out.println(	jutil.getSystemDate());
	
	String userformate=jutil.getSystemDateInFormat();
	System.out.println(userformate);
	//System.out.println(jutil.getRandomNumber());
		

	}

}
