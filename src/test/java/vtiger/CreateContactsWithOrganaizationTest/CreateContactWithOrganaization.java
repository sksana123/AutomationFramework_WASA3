package vtiger.CreateContactsWithOrganaizationTest;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilityes.BaseClass;
import vtiger.GenericUtilityes.ExcelFileUtility;
import vtiger.GenericUtilityes.JavaUtility;
import vtiger.GenericUtilityes.PropertyFileUtility;
import vtiger.GenericUtilityes.WebDriverUtility;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactsPage;
import vtiger.ObjectRepository.CreateOrganaizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganaizationInfoPage;
import vtiger.ObjectRepository.OrganaizationPage;



@Listeners(vtiger.GenericUtilityes.ListenersImplementation.class)

public class CreateContactWithOrganaization extends BaseClass {

    @Test
    public void CreateContactWithOrganaization() throws Exception
    
	{
    	
    //navigating to Organaization link
	 
  HomePage hp=new HomePage(driver);
   hp.clickOnOrganaization();
   
   Reporter.log("navigated to organaization link");

    //click on organaization look up image
  OrganaizationPage op=new OrganaizationPage(driver);
    op.organaizationPage();

    Reporter.log("navigated  organaization look up image");
    

         int NUM=jutil.getRandomNumber();

   String  ORGNAME= eutil.readDataFromExcel("ORGANAIZATIONS", 4, 2)+NUM;


   //create organaization 

	CreateOrganaizationPage cop=new CreateOrganaizationPage(driver);
	 
	 cop.createOrg(ORGNAME);
	 
	 Reporter.log("created organaization ");
	 
	// validate the organaization and check organaization created
	 
	 OrganaizationInfoPage oip=new OrganaizationInfoPage(driver);
	 String OrgHeader=oip.OrgNameHeader();
	 
	 Assert.assertTrue(OrgHeader.contains(ORGNAME));
	 
	 
	 Reporter.log("validated organaization ");
	
	 //navigate to contacts
	 
	 hp.clickOnContacts();
	 
	 
	 Reporter.log("navigated to contacts  link");
	 
	 //click on contacts look up image
	 ContactsPage cp=new ContactsPage(driver);
	 cp.createContactsApp();
	 
	 
	 Reporter.log("navigated to contacts  look up image");
	 
	 
	 String LASTNAME=	 eutil.readDataFromExcel("CONTACTS", 4, 3)+NUM;
	 
   //create contacts with lastname and orgname
	 
	 CreateContactsPage ccp=new CreateContactsPage(driver);
	  ccp.createcontactspage(driver, LASTNAME, ORGNAME);
	  
	  Reporter.log("created  contacts  with orgname");
	  

	 //validate
	  
	 ContactsInfoPage cip=new ContactsInfoPage(driver);
	 
	String CONTACTHEADER= cip.contactHeader();
	
	Assert.assertTrue(CONTACTHEADER.contains(LASTNAME));
	 
	
	 Reporter.log("validated contacts  ");
		 
}

}
