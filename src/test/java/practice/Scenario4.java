package practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Scenario4 {
	public static void main(String[] args) {
		

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
	
WebElement element=	driver.findElement(By.xpath("//select[@name='industry']"));
element.click();
	Select s=new Select(element);
	s.selectByVisibleText("Chemicals");
	
WebElement ele=	driver.findElement(By.xpath("//select[@name='accounttype']"));
ele.click();
Select s1=new Select(ele);
s1.selectByVisibleText("Customer");

driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();


String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
if (orgHeader.contains("sanaaa")) {
	System.out.println(orgHeader + " PASS");
} 
else {
	System.out.println("FAIL");
}

	

	
	
	
	}
	

}
