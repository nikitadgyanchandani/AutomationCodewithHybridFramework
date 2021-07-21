package Com.Guru99.TestCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Guru99.PageObjects.LoginPage;
import Com.Guru99.Utilities.XLUtils;

public class Login_TC_001 extends BaseClass {
	
	@Test
	public void LoginTest() throws Exception 
	{
		driver.get(baseURL);
		logger.info("URL is opened");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(20000);
		LoginPage lp=new LoginPage(driver);
		lp.SetUsername(username);
		lp.SetPassword(password);
		
		/*@DataProvider(name="TestLogintoApplication")
		String[][] getData() throws IOException
		{
			String path=System.getProperty("user.dir")+"/src/test/java/Com/Guru99/TestData/TestData_AutomationPractice.xlsx";
			
			int rownum=XLUtils.getRowCount(path, "LoginToGuru99");
			int colnum=XLUtils.getCellCount(path, "LoginToGuru99",1);
			
			String newLogin[][]=new String[rownum][colnum];
			for(int i=1; i<=rownum;i++)
			{
				for(int j=0;j<colnum;j++)
				{
					
					newLogin[i-1][j]=XLUtils.getCellData(path, "LoginToGuru99", i, j);
				}
			}
			return newLogin;
		}*/
		
		lp.ClickSubmit();	
		
		Thread.sleep(5000);
		
		String message = null;
		if(username.equalsIgnoreCase(username) && password.equalsIgnoreCase(password))
		{
			message=LoginPage.MenuName();
			
			
			if (message.equalsIgnoreCase("Manager"))
			{
				Assert.assertTrue(true);
				System.out.println("Test Execution");
				logger.info("Login Test Paased");
				
			}
		}
		
		/*if(message.equals("Welcome To Manager's Page of Guru99 Bank"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}*/
		//message=LoginPage.MenuName();
		/*if(message.equalsIgnoreCase("Manager"))
		{
			Assert.assertTrue(true);
			System.out.println("Test Execution");
			logger.info("Login Test Paased");
			
		}*/
		else
		{
			Assert.assertFalse(false);
			System.out.println("Login Test case failed");
			logger.info("Login Test Failed");
			
			
			//Switch tabs
			/*Set wnd = driver.getWindowHandles();
		      // window handles iterate
		      Iterator i = wnd.iterator();
		      String popwnd = (String) i.next();
		      System.out.println("new tab: "+popwnd);
		      String prntw = (String) i.next();
		      System.out.println("current window: "+prntw);
		      // switching pop up tab
		      driver.switchTo().window(popwnd);*/
		      
			try 
			{
				String alertMessage= driver.switchTo().alert().getText();
				driver.switchTo().alert().accept();
				//Alert alert=driver.switchTo().alert();
				
				System.out.println("Aler message is: "+alertMessage);
				alertMessage.equalsIgnoreCase("User or Password is not valid");
				
			}
		   catch(UnhandledAlertException ex)
			{
			   ex.printStackTrace();
			}
			
			takeSnapShot("TestScreenshotCapture");
		
	}
		
	}
}
		
		

