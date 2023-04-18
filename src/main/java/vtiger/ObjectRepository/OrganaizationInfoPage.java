package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganaizationInfoPage {
	@FindBy(xpath="//span[@class='dvHeaderText']") private WebElement  OrgHeader;
	
	public OrganaizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrgHeader()
	{
		return OrgHeader;
	}
	
	
	//
	public String OrgNameHeader()
	{
	 return OrgHeader.getText();

}
}
