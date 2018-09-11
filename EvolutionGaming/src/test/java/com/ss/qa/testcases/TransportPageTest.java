package com.ss.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ss.qa.base.TestBase;
import com.ss.qa.pages.AnnouncementPage;
import com.ss.qa.pages.CarsPage;
import com.ss.qa.pages.HomePage;
import com.ss.qa.pages.TransportPage;
import com.ss.qa.util.TestUtil;

public class TransportPageTest extends TestBase{
	
	TransportPage transportpage;
	AnnouncementPage announcepage;
	CarsPage carspage;
	HomePage homepage;
	
	TransportPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();
		transportpage = homepage.clickTransportLink();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT , TimeUnit.SECONDS);
	}
	
	@Test
		public void transportPageTitleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "SS.COM Transport - Ads");
	}
	
	@Test
		public void transportPageAnnouncementButtonTest() {
		announcepage = transportpage.clickPlaceAnnouncementBtn();
	}
	
	@Test
		public void transportPageCarsLinkTest() {
		carspage = transportpage.clickCarsLink();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT , TimeUnit.SECONDS);
	}
	
	
	@AfterMethod
	public void teadDown() {
		driver.quit();
	}
	
	
	

}
