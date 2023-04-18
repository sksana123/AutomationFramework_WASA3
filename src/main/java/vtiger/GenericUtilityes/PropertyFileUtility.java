package vtiger.GenericUtilityes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * this cls consistes of generic methods of read the data from properties file
 * @author PC
 *
 */

public class PropertyFileUtility {
	/**
	 * this method will read the data from properties file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		Properties pboj=new Properties();
		
		pboj.load(fis);
		
		String value=pboj.getProperty(key);
		return value;
	}

}
