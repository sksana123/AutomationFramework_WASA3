package vtiger.OrganaizationTest;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
import vtiger.ObjectRepository.CreateOrganaizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganaizationInfoPage;
import vtiger.ObjectRepository.OrganaizationPage;



@Listeners(vtiger.GenericUtilityes.ListenersImplementation.class)


public class CreateOrganaizationTest extends BaseClass {
	
	@Test(groups="RegressionSuite")
	public void CreateOrganaizationTest() throws Exception
	 {
		
	String ORGNAME=eutil.readDataFromExcel("ORGANAIZATIONS", 1, 2)+jutil.getRandomNumber();
	

  //navigate to organaization link
	
      HomePage hp=new HomePage(driver);
      hp.clickOnOrganaization();
      Reporter.log("navigated organaization link");
      
// click on create organaization look up
      
      OrganaizationPage op=new OrganaizationPage(driver);
      op.organaizationPage();
      
      Reporter.log("navigated organaization look up image");
      
    //create organaization  
      
      CreateOrganaizationPage cop=new CreateOrganaizationPage(driver);
      cop.createOrg(ORGNAME);
      
      Reporter.log("created  organaization ");
      
      //validate
      
      OrganaizationInfoPage oip=new OrganaizationInfoPage(driver);
      String ORGHEADER=oip.OrgNameHeader();
      
      Assert.assertTrue(ORGHEADER.contains(ORGNAME));
      
      
      Reporter.log("validated organaization ");
      
    }
	
	@Test
	public void demo()
	{
		System.out.println("demo");
	}

}































/*public void createOrganaizationTest()
	{
WebDriver driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
Random r =new Random();
int num=r.nextInt();
driver.get("http://localhost:8888");
driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");

driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");

driver.findElement(By.xpath("//input[@type='submit']")).click();

driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();


driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("sanaaa"+num);

driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

String title=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

if(title.contains("sanaaa"))
{
	System.out.println("passed");
}

System.out.println("failed");
}
*/





	


