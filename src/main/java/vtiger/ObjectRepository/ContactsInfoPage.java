package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	@FindBy(xpath="//span[@class='dvHeaderText']") private WebElement ContactHeader;
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getContactsInfo()
	{
		return ContactHeader;
	}
	//
	public String contactHeader()
	{
	return	ContactHeader.getText();
         
	}
	

}
