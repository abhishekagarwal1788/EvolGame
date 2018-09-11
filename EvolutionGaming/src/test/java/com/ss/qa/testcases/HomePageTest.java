package com.ss.qa.testcases;

import org.sikuli.script.Screen;
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
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();
	}
	
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
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}