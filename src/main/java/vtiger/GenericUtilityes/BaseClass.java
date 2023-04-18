package vtiger.GenericUtilityes;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class BaseClass {
	
public 	PropertyFileUtility putil=new PropertyFileUtility();
public	WebDriverUtility wutil=new WebDriverUtility();
public 	ExcelFileUtility eutil=new ExcelFileUtility();
public	JavaUtility jutil=new JavaUtility();
	
	
public	WebDriver driver=null;

public static WebDriver sdriver;//for Listeners
	
   
 @BeforeSuite(alwaysRun=true)
	public void bsConfig()
	
	{
		System.out.println("-----database connection sucessfully----");
		
	}
	
	
	//@Parameters("browser") // chrome or firefox
	//@BeforeTest
	@BeforeClass(groups={"SmokeSuite","RegressionSuite"})
	public void bcConfig(/*String BROWSER*/) throws Exception
	{
	String URL=	putil.readDataFromPropertyFile("url");
   String BROWSER=putil.readDataFromPropertyFile("browser");
	
	     if(BROWSER.equalsIgnoreCase("chrome"))
	     {
	    	 
	    	 //WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","D:\\AUTOMATION\\AutomationFramework.WASA3\\chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("-----chrome launched successfully------");
		
	    }
	    else if(BROWSER.equalsIgnoreCase("firefox"))
	    {
		//WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver","D:\\AUTOMATION\\AutomationFramework.WASA3\\geckodriver.exe");
		driver=new FirefoxDriver();
		System.out.println("-----firefox launched successfully-------");
	     }
	     
	     
	    wutil.maximizeWindow(driver);
	 	wutil.waitForPage(driver);
	     driver.get(URL);
	     
	     sdriver=driver;//for Listeners
	     
	}
	
	

	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException
	{
		
		String USERNAME=putil.readDataFromPropertyFile("username");
		String PASSWORD=putil.readDataFromPropertyFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToapplication(USERNAME, PASSWORD);
		System.out.println("---login sucessfully----");
	}
	
	

	@AfterMethod(alwaysRun=true)
	public void amConfig() throws InterruptedException 
	{
		Thread.sleep(10);
		
	            HomePage hp=new HomePage(driver);
	             hp.logOutApp(driver);
	         System.out.println("-----logout successful------------");
		
	}
	
	//@AfterTest
	@AfterClass(groups={"SmokeSuite","RegressionSuite"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("----close the driver suceessfully------");
		
	}
	
	
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		System.out.println("-----database closed suceesfully-----");
		
	}

}
