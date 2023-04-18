package GenericUtilitypgms;
import java.lang.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilityes.ExcelFileUtility;
import vtiger.GenericUtilityes.JavaUtility;
import vtiger.GenericUtilityes.PropertyFileUtility;
import vtiger.GenericUtilityes.WebDriverUtility;

public class CreateContactsWithGenericUtility {

	public static void main(String[] args) throws Exception 
	{
		PropertyFileUtility putil=new PropertyFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
          JavaUtility jutil=new JavaUtility();
		
		//read all necessary data from properties file
		
			
		String URL=putil.readDataFromPropertyFile("url");
		
        String BROWSER=putil.readDataFromPropertyFile("browser");
		
		String USERNAME=putil.readDataFromPropertyFile("username");
		
		String PASSWORD=putil.readDataFromPropertyFile("password");
		
		WebDriver driver=null;
		
		//read the data from excel file
		
		
		String LASTNAME=eutil.readDataFromExcel("CONTACTS",1,2)+jutil.getRandomNumber();
		  
		/*wutil.waitForPage(driver);
		
		if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
		
			driver=new EdgeDriver();
			
		}*/

				//step1:launch the browser
			if(BROWSER.equalsIgnoreCase("chrome"))
					{
				//WebDriverManager.chromedriver().setup();
				System.setProperty("webdriver.chrome.driver", "D:\\AUTOMATION\\AutomationFramework.WASA3\\chromedriver.exe");
				driver=new ChromeDriver();
					}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				//WebDriverManager.firefoxdriver().setup();
				System.setProperty("webdriver.gecko.driver","D:\\AUTOMATION\\AutomationFramework.WASA3\\geckodriver.exe");
				driver=new FirefoxDriver();
				
			}
			else if(BROWSER.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			else
			{
				System.out.println("invalid browser");
			}
			
			
		
		//step2:get url
			
			wutil.maximizeWindow( driver);
			wutil.waitForPage( driver);
			driver.get(URL);
			
				//step3:enter valid data to the required field
			
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
		//step4:
			
			driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
			//step5:
			
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			
			//step6
			
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
			
			//step7
			
			
			driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
			
			//step8
			
			String CONTACTHEADER=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			
			if(CONTACTHEADER.contains(LASTNAME))
			{
				System.out.println("---passed------");
			}
			else
			{
				System.out.println("----failed-------");

			}
				//step9
			
			WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wutil.moveToElement(driver, element);
				
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				

	}

}
