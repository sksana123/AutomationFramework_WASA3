package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtilityes.BaseClass;
import vtiger.GenericUtilityes.ExcelFileUtility;
import vtiger.GenericUtilityes.IConstantUtility;
import vtiger.GenericUtilityes.JavaUtility;
import vtiger.GenericUtilityes.PropertyFileUtility;
import vtiger.GenericUtilityes.WebDriverUtility;
import vtiger.ObjectRepository.CreateOrganaizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganaizationInfoPage;
import vtiger.ObjectRepository.OrganaizationPage;



public class CreateOrgMultipleTest extends BaseClass{
	
	
	
	
	@Test(dataProvider="OrgWithIndustry")
	public void createOrgMultipleTest(String ORG,String INDUSTRY) throws IOException//dataProviderOrg orgname and industry
	{
		
	String ORGNAME=ORG+jutil.getRandomNumber();
	
//navigate to organaization link
	
      HomePage hp=new HomePage(driver);
      hp.clickOnOrganaization();
      
// click on create organaization look up
      
      OrganaizationPage op=new OrganaizationPage(driver);
      op.organaizationPage();
      
    //create organaization 
      
      CreateOrganaizationPage cop=new CreateOrganaizationPage(driver);
      cop.createOrg(ORGNAME, INDUSTRY);
      
      //validate
      
      OrganaizationInfoPage oip=new OrganaizationInfoPage(driver);
      String ORGHEADER=oip.OrgNameHeader();
      
      Assert.assertTrue(ORGHEADER.contains(ORGNAME));
           
      
}	
		
	

	@DataProvider(name="OrgWithIndustry")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		Object[][] data = eutil.readTheDataFromExcelToDataProvider("DataProviderOrg");
		return data;
	}
	
	
}
