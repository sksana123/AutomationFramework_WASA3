package practice;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilityes.ExcelFileUtility;
import vtiger.GenericUtilityes.PropertyFileUtility;
import vtiger.GenericUtilityes.WebDriverUtility;

public class CreateContactsWithGenericUtility {

	public static void main(String[] args) throws Exception 
	{
		PropertyFileUtility putil=new PropertyFileUtility();
	
		
		//read all necessary data from properties file
		
			
		String URL=putil.readDataFromPropertyFile("url");
		
		System.out.println(URL);
		
String BROWSER=putil.readDataFromPropertyFile("browser");
		
		System.out.println(BROWSER);
		
		
			
	//read the data from excel file
			ExcelFileUtility eutil=new ExcelFileUtility();
			
	String data=eutil.readDataFromExcel("CONTACTS",1,2);
	System.out.println(data);
	
			WebDriver driver=null;
			//step1:launch the browser
			if(BROWSER.equalsIgnoreCase("chrome"))
					{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
					}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				
			}
			else
			{
				System.out.println("invalid browser");
			}
			
			//step2:get url
			WebDriverUtility wd=new WebDriverUtility();
			wd.maximizeWindow( driver);
			wd.waitForPage( driver);
			
			driver.get(URL);
				//step3:enter valid data to the required field
			
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		//step4:
			
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			//step5:
			
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			
			//step6
			
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(data);
			
			//step7
			
			driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
			
			//step8
			
			String CONTACTHEADER=driver.findElement(By.xpath("//span[text()='[ CON2 ] sana  -  Contact Information']")).getText();
			
			if(CONTACTHEADER.equalsIgnoreCase(data))
			{
				System.out.println("passes=d");
			}
			else
			{
				System.out.println("filed");

			}
				//step9
			
			WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act=new Actions(driver);
				
				act.moveToElement(element).click().perform();
				
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				

	}

}
