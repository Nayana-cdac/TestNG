package testScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constants;
import utilities.ScreenShotUtility;

public class Base {

	public WebDriver driver; // interface
	public Properties properties;
	public FileInputStream fis;
	public  ScreenShotUtility scrshot;

	@BeforeMethod(alwaysRun = true) // initialize browser should execute before all test cases execution
	@Parameters("browser") // parameter parameterization - same as the parameter inside initializeBrowser
							// method
	public void initializeBrowser(String browser) throws Exception {
		// driver = new ChromeDriver(); // interface obj = new class
		// driver=new EdgeDriver();
		// driver=new FirefoxDriver();
		try {
			properties = new Properties();
			fis = new FileInputStream(Constants.CONFIGFILE);// Constant class in src/main/java
			properties.load(fis);

		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("invalid browser");
		}
		//driver.get("https://selenium.qabible.in/index.php");
		driver.get(properties.getProperty("url"));// get the property from 
		driver.manage().window().maximize(); // maximize the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// implicit wait
	}

	@AfterMethod // close and quit should execute after all test case execution
	 public void browserQuit(ITestResult iTestResult) throws IOException { 
			if (iTestResult.getStatus() == ITestResult.FAILURE) { 
				scrshot = new ScreenShotUtility(); 
				scrshot.getScreenShot(driver, iTestResult.getName()); 
			} 

			driver.quit(); 
		}

}
