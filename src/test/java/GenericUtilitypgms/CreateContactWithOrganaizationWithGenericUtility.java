package GenericUtilitypgms;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilityes.ExcelFileUtility;
import vtiger.GenericUtilityes.JavaUtility;
import vtiger.GenericUtilityes.PropertyFileUtility;
import vtiger.GenericUtilityes.WebDriverUtility;

public class CreateContactWithOrganaizationWithGenericUtility {

	public static void main(String[] args) throws Exception {
		WebDriverUtility wutil=new WebDriverUtility();
	PropertyFileUtility putil=new PropertyFileUtility();
	JavaUtility jutil=new JavaUtility();
	ExcelFileUtility eutil=new ExcelFileUtility();

	
	String URL=putil.readDataFromPropertyFile("url");
	String BROWSER= putil.readDataFromPropertyFile("browser");
	String USERNAME=putil.readDataFromPropertyFile("username");
	String PASSWORD=putil.readDataFromPropertyFile("password");
	
	

	String ORGNAME=eutil.readDataFromExcel("CONTACTS", 4, 2);
	String LASTNAME=eutil.readDataFromExcel("CONTACTS", 4, 3);
	WebDriver driver=null;
	 
	 
	 if(BROWSER.equalsIgnoreCase("chrome"))
	 {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	 }
	 else if(BROWSER.equalsIgnoreCase("firefox")) {
		 WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
		 
	 }
	 else
	 {
		 System.out.println("default browser");
	 }
	 driver.get(URL);
wutil.maximizeWindow(driver);
wutil.waitForPage(driver);
int num=jutil.getRandomNumber();
	 //login
	 driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
	 
	 driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
	 
	 driver.findElement(By.xpath("//input[@type='submit']")).click();
	  //contacts
	 //1.org
	 driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	 
	 driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	 
	 driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(ORGNAME+num);
	 
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 //2.con
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	 
	 
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
	driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
	
	
	wutil.switchToWindow(driver, "Accounts");
	
	driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys(ORGNAME);
	driver.findElement(By.xpath("//input[@type='button']")).click();
	
	driver.findElement(By.xpath("//a[text()='" +ORGNAME+"']")).click();
	wutil.switchToWindow(driver, "Contacts");
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	Thread.sleep(3000);
	String header=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

	 if(header.contains("ORGNAME"))
	 {
		 System.out.println("created");
	 }
	 else
	 {
		 System.out.println(" not created");

	 }
	 
	 
	 
	 
	 
	 
	 

	}

}
