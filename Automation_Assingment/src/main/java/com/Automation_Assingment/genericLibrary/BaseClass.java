package com.Automation_Assingment.genericLibrary;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
/**
 * 
 * @author Prakriti Priya
 *
 */

public class BaseClass {
	/*Global Objects*/
	public static WebDriver driver = null;
	
	public FileLib fLib = new FileLib();
	
	/**
	 * Initializing reports
	 * @throws Throwable 
	 */
	@BeforeSuite
	public void configBeforeSuite() throws Throwable {
//		String dir = System.getProperty("user.dir");
//		System.setProperty("webdriver.chrome.driver", dir+"/src/main/resources/chromedriver.exe");
	}
	@BeforeClass
	public void configBC() throws Throwable {

		System.out.println("launch the Browser");

		/*read browser name from properties File*/
		String browserName = fLib.getPropertyKeyValue("browser");

		if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else {
			driver = new FirefoxDriver();
		}
	}

	
	
	/**
	 * This TestNg configuration method used to close the Browser
	 */
	@AfterClass
	public void configAC(){
		
		driver.quit();
	}
	
	/**
	 * 
	 * Appends the report HTML file with all the test results and 
	 * closes the underlying stream
	 * Kills driver executable instances
	 * @throws Throwable 
	 */
	
	@AfterSuite
	public void configAfterSuite() throws Throwable {
		Runtime.getRuntime().exec("taskkill -im chromedriver.exe /f");
		Runtime.getRuntime().exec("taskkill -im geckodriver.exe /f");
	}

}
