package practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateOrganaizationTest {

	public void createOrganaizationTest()
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






	}


