package Com.Guru99.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Guru99.PageObjects.LoginPage;

public class Login_TC_001 extends BaseClass {
	
	@Test
	public void LoginTest() throws InterruptedException
	{
		driver.get(baseURL);
		logger.info("URL is opened");
		driver.manage().window().maximize();
		Thread.sleep(20000);
		LoginPage lp=new LoginPage(driver);
		lp.SetUsername(username);
		lp.SetPassword(pasword);
		
		lp.ClickSubmit();	
		
		if(driver.getTitle().trim().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else
		{
			Assert.assertFalse(false);
			logger.info("Login Test Failed");
		}

	}

}
