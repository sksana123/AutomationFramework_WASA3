package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganaizationPage {
	
	@FindBy(xpath="//img[@title='Create Organization...']") private WebElement Organaization;
			
	public OrganaizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrganaization()
	{
		return Organaization; 
	}
	
	//
	public void organaizationPage()
	{
		Organaization.click();
	}
			

}
