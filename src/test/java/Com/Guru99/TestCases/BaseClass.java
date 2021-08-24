package Com.Guru99.TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterClass;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Listeners;

import Com.Guru99.Utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass //Intializing the drivers
	public void Setup(String browserType)
	{
		
		logger=Logger.getLogger("Guru99_Autmation");
		BasicConfigurator.configure();
		PropertyConfigurator.configure("log4j.properties");
		
		if(browserType.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver=new ChromeDriver();
		}
		if(browserType.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		if(browserType.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver=new InternetExplorerDriver();
		}
		
	}
		
		public static void takeSnapShot(String fileName) throws Exception
		{
			//Convert web driver object to TakeScreenshot
			TakesScreenshot ts=(TakesScreenshot)driver;
			
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
				try {
						FileUtils.copyFile((File) srcFile , new File("./Screenshots"+fileName+".jpg"));
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
		}
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
		System.out.println("xyz");
	}

}
