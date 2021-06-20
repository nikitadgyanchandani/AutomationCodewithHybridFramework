package Com.Guru99.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement Username;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(name="btnLogin")
	WebElement LoginButton;
	
	@FindBy(name="btnReset")
	WebElement ResetButton;
	
	public void SetUsername(String uname)
	{
		Username.sendKeys(uname);
	}
	public void SetPassword(String pwd )
	{
		Password.sendKeys(pwd);
	}
	
	public void ClickSubmit()
	{
		LoginButton.click();
	}
	
	public void ResetPassowrd()
	{
		ResetButton.click();
	}
	
 
}
