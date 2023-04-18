package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_01_Practices {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\AUTOMATION FOLDER\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
		Thread.sleep(3000);
		
		 
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("ram");
		
		
		

	}

}
