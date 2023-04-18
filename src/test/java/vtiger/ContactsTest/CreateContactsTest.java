package vtiger.ContactsTest;

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
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilityes.BaseClass;
import vtiger.GenericUtilityes.ExcelFileUtility;
import vtiger.GenericUtilityes.JavaUtility;
import vtiger.GenericUtilityes.PropertyFileUtility;
import vtiger.GenericUtilityes.WebDriverUtility;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactsPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

@Listeners(vtiger.GenericUtilityes.ListenersImplementation.class)

public class CreateContactsTest extends BaseClass {
	
	@Test(groups="SmokeSuite")
	public void createContactsTest() throws Exception
	{
		
		
	//read the data from excel file
String LASTNAME=	eutil.readDataFromExcel("CONTACTS", 1, 2)+jutil.getRandomNumber();
	
	//navigate to contacts link

	HomePage hp=new HomePage(driver);
	hp.clickOnContacts();
	
		
	Reporter.log("navaigated to contacts link",true);
	
	
	
//click on contacts look up image
	
	ContactsPage cp=new ContactsPage(driver);
	cp.createContactsApp();
	
	Reporter.log("navaigated to contacts look up image");
	
	
	//create contacts page
	
	CreateContactsPage ccp=new CreateContactsPage(driver);
	ccp.createcontactspage(LASTNAME);

	  
	Reporter.log("created contacts ");
	
	//validate the contacts
	
	ContactsInfoPage cip=new ContactsInfoPage(driver);
	String CONTACTSHEADER=cip.contactHeader();
	
	Assert.assertTrue(CONTACTSHEADER.contains(LASTNAME));
	
	
	Reporter.log("validated contacts ");
	 
	 

		}	
	
	
	@Test
	 public void demo()
	 {
		System.out.println("this id demo-excatly impacted area"); 
		
		Reporter.log("demo script");
	 }
	

}
