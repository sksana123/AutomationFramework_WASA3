package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilityes.WebDriverUtility;

public class CreateContactsPage extends WebDriverUtility {
	
	@FindBy(name="lastname") private WebElement LastnameEdt;
	@FindBy(xpath="(//img[@alt='Select'])[1]")private WebElement OrgLookUp;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")  private WebElement SaveBtn;
	@FindBy(xpath="(//input[@type='text'])[1]") private WebElement SearchBox;
	@FindBy(xpath="//input[@type='button']") private WebElement SearchBtn;
	public CreateContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getLastnameEdt()
	{
		return LastnameEdt;
	}
	public WebElement getOrgLookUp ()
	{
		return OrgLookUp;
	}
	public WebElement getSaveBtn()
	{
		return SaveBtn;
	}
	
	public WebElement getSearchBox()
	{
		return SearchBox;
	}
	public WebElement getSearchBtn()
	{
		return SearchBtn;
	}
	
	
	//
	public void createcontactspage(String lastname)
	{
		LastnameEdt.sendKeys(lastname);
		SaveBtn.click();
	}
	public void createcontactspage(WebDriver driver,String lastname,String orgname)
	{
		LastnameEdt.sendKeys(lastname);
		OrgLookUp.click();
		switchToWindow(driver,"Accounts");
		SearchBox.sendKeys(orgname);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		switchToWindow(driver,"Contacts");
		SaveBtn.click();
		
		
	}
	

}
