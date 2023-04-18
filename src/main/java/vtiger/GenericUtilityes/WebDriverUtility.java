package vtiger.GenericUtilityes;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * for maximize window
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * for minimize 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * wait for a page to be loaded
	 * @param driver
	 */
	public void waitForPage(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * wait for element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	/**
	 * wait for element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	/**
	 * this method for drop down index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * this method for drop down value
	 * @param value
	 * @param element
	 */
	
	public void handleDropDown(String value,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	
	/**
	 * this method will handle drop down for visibility text
	 * @param element
	 * @param text
	 */
	public void handleDropDown(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
		
	}
	/**
	 * this method for actions move to element
	 * @param driver
	 * @param element
	 */
	
	public void moveToElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	/**
	 * this method for right click
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
		
	}
	/**
	 * this method for double click on web element
	 * @param driver
	 * @param element
	 */
	
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
		
	}
	/**
	 * this method for duoblr click on web page
	 * @param driver
	 */
	
	
	public void doubleClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
		
	}
	/**
	 * this method for drag and drop
	 * @param driver
	 * @param srcelemnet
	 * @param destelement
	 */
	
	
	
	
	public void dragAndDropAction(WebDriver driver,WebElement srcelemnet,WebElement destelement)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(srcelemnet, destelement).perform();
		
		
	}
	/**
	 * this method for alert accept
	 * @param driver
	 */
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * this method for alert dismmiss
	 * @param driver
	 */
	
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method for alert getText
	 * @param driver
	 */

	
	public String getAlertText(WebDriver driver)
	{
		String text=driver.switchTo().alert().getText();
		return text;
	}
	/**
	 * this method for handle frame with index
	 * @param driver
	 * @param index
	 */
	
public void handleFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}
/**
 * this method for handle frame with name or id
 * @param driver
 * @param index
 */
public void handleFrame(WebDriver driver,String nameorId)
{
	driver.switchTo().frame(nameorId);
}
/**
this method for handle frame with wenElement
* @param driver
* @param index
*/
public void handleFrame(WebDriver driver,WebElement element)
{
	driver.switchTo().frame(element);
}

/**
 * this method for parent  frame 
 * @param driver
 * @param index
 */


public void switchToParentFrame(WebDriver driver)
{
	driver.switchTo().parentFrame();
}

/**
 * this method for default frame 
 * @param driver
 * @param index
 */
	
public void switchToDefaultFrame(WebDriver driver)
{
	driver.switchTo().defaultContent();
}
/**
 * this method for switch to window based on partial window id
 * @param driver
 * @param partialid
 */

public void switchToWindow(WebDriver driver,String partialid)
{
	//step1:get all window ids
	Set<String> allids=driver.getWindowHandles();
	//step2:navigate each window
	for(String r1:allids)
	{
		//step3:switch the window and captured title
		String winid=driver.switchTo().window(r1).getTitle();
		if(winid.contains(partialid))
		{
			break;
		}
	}
	
}
/**
 * thismethod for take screen shot and save the folder
 * @param driver
 * @param screenshotname
 * @return
 * @throws IOException
 */
 
public String takesScreenShot(WebDriver driver,String screenshotname) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dest= new File(".\\ScreenShots\\"+screenshotname+".png");
	
	Files.copy(src, dest);
	
	
	return dest.getAbsolutePath();
	 
	
}
/**
 * this method for scroll 
 * @param driver
 */

public void scrollAction(WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)"," ");
}
/**
 * this method for scrool until element is identified and dom
 */

public void scroolAction(WebDriver driver,WebElement element)
{
	JavascriptExecutor je=(JavascriptExecutor)driver;
	
	int y=element.getLocation().getY();
	je.executeScript("window.scrollBy(0,"+y+")",element);
	
}
/*public void robotClass(WebDriver driver,String 1,String 2) throws AWTException
{
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_1);
	r.keyPress(KeyEvent.VK_2);
	r.keyRelease(KeyEvent.VK_1);
	r.keyRelease(KeyEvent.VK_2);
}*/











}
