package Com.Guru99.PageObjects;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import Com.Guru99.Utilities.XLUtils;

public class AddNewCustomer {
	WebDriver ldriver;
	
	public AddNewCustomer(WebDriver rdriver)
	{
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//a[text()=\"New Customer\"]")
	WebElement NewCustomerMenu;
	
	@FindBy(xpath="//input[@name=\"name\"]")
	WebElement CustomerName;
	
	@FindBy(xpath="//input[@value=\"m\"]")
	WebElement GenderMale;
	
	@FindBy(xpath="//input[@value=\"f\"]")
	WebElement GenderFemale;
	
	@FindBy(xpath="//input[@id=\"dob\"]")
	WebElement CustomerDOB;
	
	@FindBy(name="addr")
	WebElement CustomerAddress;
	
	@FindBy(name="city")
	WebElement CustomerCity;
	
	@FindBy(name="state")
	WebElement Customerstate;
	
	@FindBy(name="pinno")
	WebElement CustomerPinNo;
	
	@FindBy(name="telephoneno")
	WebElement CustomerMobNo;
	
	@FindBy(name="emailid")
	WebElement CustomerEmailId;
	
	@FindBy(name="password")
	WebElement CustomerPassword;
	
	@FindBy(xpath="//input[@value=\"Submit\"]")
	WebElement SubmitButton;
	
	@FindBy(xpath="//input[@value=\"Reset\"]")
	WebElement CustomerDetailsResetButton;
	
	@FindBy(xpath="//p[contains(text(),'Customer Registered Successfully')]")
	static
	WebElement CustomerSuccessMessage;
	
	@FindBy(xpath="//table[@id='customer']//tr[3]/following::td[2]")
	static
	WebElement CustomerID;
	
	public void ClickNewCustomerMenuButton()
	{
		NewCustomerMenu.click();
	}
	
	public void SetCustomerName(String custName)
	{
		CustomerName.sendKeys(custName);
	}
	
	public void SelectGender(String selGender)
	{
		selGender=selGender.toLowerCase();
		if(selGender.equals("female") || selGender.equals("f"))
		{
			GenderFemale.click();
		}
		else
		{
			GenderMale.click();
		}
	}
	
	public void setCustomerDOB(String custDOB)
	{
		CustomerDOB.sendKeys(custDOB);
	}
	
	public void setCustomerAddress(String custAddress)
	{
		CustomerAddress.sendKeys(custAddress);
	}
	public void setCustomerCity(String custCity)
	{
		CustomerCity.sendKeys(custCity);
	}
	public void setCustomerState(String custState)
	{
		Customerstate.sendKeys(custState);
	}
	public void setCustomerPinNo(String pinNo)
	{
		CustomerPinNo.sendKeys(pinNo);
	}
	public void setCustomerMobileNumder(String mobNo)
	{
		CustomerMobNo.sendKeys(mobNo);
	}
	public void setCustomerEmailID(String custEmailID)
	{
		Random random = new Random();
		int x = random.nextInt(900) + 100;
		
		String[] var=custEmailID.split("@");
		custEmailID=var[0]+x+"@"+var[1];
		CustomerEmailId.sendKeys(custEmailID);
	}
	public void setCustomerPassword(String custPassword)
	{
		CustomerPassword.sendKeys(custPassword);
	}
	
	public void submitCustomerDetails()
	{
		SubmitButton.click();
	}
	public void ResetCustomerDetails()
	{
		CustomerDetailsResetButton.click();
	}
	public static String readSuccessMesage()
	{
		String custSuccessMsg=CustomerSuccessMessage.getText();
		return custSuccessMsg;
	}
	public static String readCustomerID()
	{
		String custID=CustomerID.getText();
		return custID;
	}
	
}
