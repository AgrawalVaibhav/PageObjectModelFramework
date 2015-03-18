package com.base;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.pages.HeaderPage;
import com.pages.LoginPage;
import com.util.Utils;



public class TestBase extends Wrapper{
	public String browser = "FF";
	public static Utils util = new Utils();
	protected LoginPage loginPage;
	protected HeaderPage headerPage;
	
	public String baseUrl = "Url";

	

	@BeforeTest(alwaysRun = true)
	public void setUp() throws MalformedURLException {
		if (browser.equalsIgnoreCase("Chrome")) {
			chrome();

		} else if (browser.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();

		} else if (browser.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		} else {
			driver = new FirefoxDriver();
		}

		loginPage = PageFactory.initElements(driver, LoginPage.class);
		headerPage = PageFactory.initElements(driver, HeaderPage.class);
		
		
		

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		openUrl(baseUrl);
		loginPage.loginWithFacebook();

	}

	@AfterTest
	public void tesrDown() {
		driver.quit();
	}

	// Chrome Browser Configuration.
	public void chrome() {
		if (util.isWindows()) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//lib//chromedriver.exe");

		} else if (util.isMac()) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//lib//chromedriver");
		}
		driver = new ChromeDriver();
	}

}
