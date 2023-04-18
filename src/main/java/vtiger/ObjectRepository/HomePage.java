package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilityes.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	@FindBy(xpath="//a[text()='Contacts']") private WebElement ContactsLin;
	
	@FindBy(xpath="(//a[text()='Organizations'])[1]") private WebElement OrganaizationLin;
	 @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']") private WebElement AdministatroImg;
@FindBy(xpath="//a[text()='Sign Out']") private WebElement SignOut;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getContactsLin()
	{
		return ContactsLin;
	}
	public WebElement getOrganaizationLin()
	{
		return  OrganaizationLin;
	}
	public WebElement getAdministatroImg()
	{
		return AdministatroImg;
	}
	public WebElement getSignOut()
	{
		return SignOut;
	}
	
	//
	public void clickOnContacts()
	{
		ContactsLin.click();
	}
	public void clickOnOrganaization()
	{
		OrganaizationLin.click();
	}
	
	public void logOutApp(WebDriver driver)
	{
	moveToElement(driver,AdministatroImg);
	SignOut.click();
		
	}
	
	

}
