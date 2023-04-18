package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario1 {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		 Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("sana");
		
		
		
		String NAME=driver.findElement(By.xpath("//input[@name='lastname']")).getText();
		
		
		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
		
		String CONTACTHEADER=driver.findElement(By.xpath("//span[text()='[ CON2 ] sana  -  Contact Information']")).getText();
		
		if(CONTACTHEADER.contains(NAME))
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("filed");
		}
		
	}

}
