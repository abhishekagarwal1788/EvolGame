package com.ss.qa.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ss.qa.base.TestBase;
import com.ss.qa.pages.HomePage;
import com.ss.qa.pages.TransportPage;
  

public class HomePageTest extends TestBase{
	
	HomePage homepage;
	TransportPage transportpage;
	
	public HomePageTest() {
		super();
	}
	
/*	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();
	}
	*/
	@Test
	public void homePageTitleTest() {
		String title = homepage.validateHomePageTilte();
		Assert.assertEquals(title, "SS.COM - Announcements");			
		}
	
	@Test
	public void homePageLogoTest() {
		boolean flag = homepage.validateSSLogo();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void homePageJobBusinessLogoTest() {
		boolean flag = homepage.validateJobBusinessLogo();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void homePageTransportLogoTest() {
		boolean flag = homepage.validateTransportLogo();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void homePageTransportLinkTest() {
		transportpage = homepage.clickTransportLink();
	}
	
	@Test
	public void verifyCarImageatHomePage() {
		homepage.carImage();
		//Assert.assertEquals(result, true);
	}
	
	@Test
	public void verifyJS() {
		homepage.verifyJS();
	}
	
	@Test
	public void runFirefox() throws MalformedURLException
	{
	 
	// We have to mention browser which we want to use for test execution
	DesiredCapabilities cap=DesiredCapabilities.firefox();
	 
	// Set the platform where we want to run our test- we can use MAC and Linux and other platforms as well
	cap.setPlatform(Platform.WINDOWS);
	 
	// Here you can use hub address, hub will take the responsibility to execute the test on respective node
	URL url=new URL("http://localhost:4444/grid/console");
	 
	// Create driver with hub address and capability
	WebDriver driver=new RemoteWebDriver(url, cap);
	 
	// start application
	driver.get("http://learn-automation.com/");
	 
	// get the title and print the same
	System.out.println("Blog title is "+driver.getTitle());
	 
	driver.close();
	 
	}
	
	
	
	
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
