package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //rule1:create a pom cls for every web page
	//rule2:identify web element @FindBy @FindBys @FindAll
	@FindBy(name="user_name") private WebElement UsernameEdt;
	
	@FindBy(name="user_password") private WebElement PasswordEdt;
	
	@FindBy(id="submitButton") private WebElement SubmitBtn;
	//create constractor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//getter
	public  WebElement getusernameEdt()
	{
		return  UsernameEdt;
	}
	public  WebElement getPasswordEdt()
	{
		return  PasswordEdt;
	}
	public  WebElement SubmitBtn()
	{
		return  SubmitBtn;
	}
	
	
	//business libraries
	public  void loginToapplication(String username,String password) 
	{
		UsernameEdt.sendKeys(username);
		PasswordEdt.sendKeys(password);
		SubmitBtn.click();
		
	}
	
	

}
