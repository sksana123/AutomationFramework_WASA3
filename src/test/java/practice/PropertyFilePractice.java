package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws IOException {
//step1:open the file java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step2:create object of properties from java.util.package
		Properties pobj=new Properties();
		
		//step3:load the file input stream into properties
		pobj.load(fis);
		
		//step4:access the values with keys
		String URL=pobj.getProperty("url");
		
		System.out.println(URL);

	}

}
