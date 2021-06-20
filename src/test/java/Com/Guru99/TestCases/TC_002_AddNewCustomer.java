package Com.Guru99.TestCases;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Guru99.PageObjects.AddNewCustomer;
import Com.Guru99.Utilities.XLUtils;

public class TC_002_AddNewCustomer extends BaseClass {
	
	@Test(priority=1)
	public void loginToGuru99() throws InterruptedException
	{
		Login_TC_001 login=new Login_TC_001();
		login.LoginTest();
	}
	@Test(dataProvider="AddNewCustomerData",priority=2)
	public void AddCustomer(String Name, String Gender, String DOB, String Address, String City, String State, String PinNo, String MobNo, String Email, String Password) throws InterruptedException
	{
		Thread.sleep(2000);
		AddNewCustomer newcust=new AddNewCustomer(driver);
		newcust.ClickNewCustomerMenuButton();
		newcust.SetCustomerName(Name);
		newcust.SelectGender(Gender);
		newcust.setCustomerDOB(DOB);
		newcust.setCustomerAddress(Address);
		newcust.setCustomerCity(City);
		newcust.setCustomerState(State);
		newcust.setCustomerPinNo(PinNo);
		newcust.setCustomerMobileNumder(MobNo);
		newcust.setCustomerEmailID(Email);
		newcust.setCustomerPassword(Password);
		
		newcust.submitCustomerDetails();
	}
	
	@DataProvider(name="AddNewCustomerData")
	String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/Com/Guru99/TestData/TestData_AutomationPractice.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "AddNewCustomer");
		int colnum=XLUtils.getCellCount(path, "AddNewCustomer",1);
		
		String newCustomerdata[][]=new String[rownum][colnum];
		for(int i=1; i<=rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				
				newCustomerdata[i-1][j]=XLUtils.getCellData(path, "AddNewCustomer", i, j);
			}
		}
		return newCustomerdata;
	}

}
