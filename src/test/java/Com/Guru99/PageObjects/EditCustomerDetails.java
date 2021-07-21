package Com.Guru99.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerDetails {
	
WebDriver ldriver;
	
	public EditCustomerDetails(WebDriver rdriver)
	{
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//input[@name='cusid']")
	WebElement customerID_editCustomerPage;
	
	@FindBy(xpath="//input[@name=\"AccSubmit\"]")
	WebElement SubmitButton;
	
	@FindBy(xpath="//input[@name=\"res\"]")
	WebElement ResetButton;
	
	public void setCustomerID()
	{
		customerID_editCustomerPage.sendKeys("");
	}
	
	public void submitCustomerID()
	{
		SubmitButton.click();
	}

}
