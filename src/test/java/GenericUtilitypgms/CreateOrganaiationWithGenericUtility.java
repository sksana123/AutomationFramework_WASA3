package GenericUtilitypgms;

import java.io.IOException;

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

public class CreateOrganaiationWithGenericUtility {

	public static void main(String[] args) throws Exception {
		
		//Step 1: Create Object of Generic Utilities
				ExcelFileUtility eUtil = new ExcelFileUtility();
				PropertyFileUtility pUtil = new PropertyFileUtility();
				JavaUtility jUtil = new JavaUtility();
				WebDriverUtility wUtil = new WebDriverUtility();
				
				//Step 2: Read all the required Data
				String URL = pUtil.readDataFromPropertyFile("url");
				String BROWSER = pUtil.readDataFromPropertyFile("browser");
				String USERNAME = pUtil.readDataFromPropertyFile("username");
				String PASSWORD = pUtil.readDataFromPropertyFile("password");
				
				String ORGNAME = eUtil.readDataFromExcel("ORGANAIZATIONS", 1, 2)+jUtil.getRandomNumber();
				
				WebDriver driver = null;
				
				//Step 3: Launch the Browser - RUNTIME POLYMORPHISM
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				}
				else
				{
					System.out.println("invalid browser name");
				}
				
				wUtil.maximizeWindow(driver);
				wUtil.waitForPage(driver);
				driver.get(URL);
				
				//Step 4: Login to App
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//Step 5: Navigate to Organizations link
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step 6: Click on Create Organization Look up Image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//Step 7: Create organization with mandatory Fields
				driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				
				//Step 8: Save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Step 9: Validate for Organization
				String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(OrgHeader.contains(ORGNAME))
				{
					System.out.println(OrgHeader+" ---- PASS ----");
				}
				else
				{
					System.out.println(" ---- Failed ----");
				}
				
				//Step 10: Logout of app
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wUtil.moveToElement(driver, ele);
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("Sign out successful");
				
				//Step 11: close the browser
				driver.quit();
				
				
				
			}


	}


