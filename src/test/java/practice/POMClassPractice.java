package practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganaizationPage;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactsPage;
import vtiger.ObjectRepository.CreateOrganaizationPage;
import vtiger.ObjectRepository.LoginPage;

public class POMClassPractice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToapplication("admin","admin");
		
		HomePage hp=new HomePage(driver);
		hp.clickOnContacts();
		
		
		ContactsPage cp=new ContactsPage(driver);
		cp.createContactsApp();
		
		

        CreateContactsPage ccp=new CreateContactsPage(driver);
		ccp.createcontactspage("sanjana");
		
		ContactsInfoPage cip=new ContactsInfoPage(driver);
	String header=     cip.contactHeader();
		if(header.contains("sanjana"))
		{
		System.out.println("passed");
		}
		else
		{
			System.out.println("fail");

		}
	/*	OrganaizationPage op=new OrganaizationPage(driver);
		op.organaizationPage();
		
		CreateOrganaizationPage cop=new CreateOrganaizationPage(driver);
		cop.createOrg();*/
	
		
	}

}
