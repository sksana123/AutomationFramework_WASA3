package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsTest {
	
	@Test
	public void createContactsTest() throws Exception
	{
		//read all necessary data from properties file
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		Properties p=new Properties();
		
		p.load(fis);
		
	String URL=	p.getProperty("url");
		
	String BROWSER= 	p.getProperty("browser");
	String USERNAME=	p.getProperty("username");
	String PASSWORD=	p.getProperty("password");
	
	//read the data from excel file
	FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	
	Workbook wb=WorkbookFactory.create(fise);
	
	String LASTNAME=wb.getSheet("CONTACTS").getRow(1).getCell(2).getStringCellValue();
	
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
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(URL);
		//step3:enter valid data to the required field
	
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
//step4:
	
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	//step5:
	
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	
	//step6
	
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
	
	//step7
	
	driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
	
	//step8
	
	String CONTACTHEADER=driver.findElement(By.xpath("//span[text()='[ CON2 ] sana  -  Contact Information']")).getText();
	
	if(CONTACTHEADER.equalsIgnoreCase(LASTNAME))
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
