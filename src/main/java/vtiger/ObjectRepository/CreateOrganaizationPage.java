package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilityes.WebDriverUtility;

public class CreateOrganaizationPage extends WebDriverUtility {
	
	@FindBy(xpath="//input[@name='accountname']") private WebElement OrgName;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")  private WebElement SaveBtn;
	@FindBy(xpath="//select[@name='industry']") private WebElement IndustryDropDown;

	public CreateOrganaizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getcreateOrganaization()
	{
		return  OrgName;
	}
	public WebElement getSaveBtn()
	{
		return SaveBtn;
	}
	public WebElement  getIndustryDropDown()
	{
		return IndustryDropDown;
	}
	
	
	///
	
		public void createOrg(String Orgname)
		{
			
			OrgName.sendKeys(Orgname);
			SaveBtn.click();
			
	}
		public void createOrg(String Orgname,String IndustryType)
	
		{
			OrgName.sendKeys(Orgname);
			handleDropDown(IndustryDropDown,IndustryType);
			SaveBtn.click();
			
			
		}
	
	
	

}
