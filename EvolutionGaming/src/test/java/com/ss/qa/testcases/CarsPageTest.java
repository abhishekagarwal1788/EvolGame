package com.ss.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ss.qa.base.TestBase;
import com.ss.qa.pages.CarDetailPage;
import com.ss.qa.pages.CarsPage;
import com.ss.qa.pages.HomePage;
import com.ss.qa.pages.TransportPage;
import com.ss.qa.testdata.CarsPageTestData;
import com.ss.qa.util.TestUtil;

public class CarsPageTest extends TestBase{
	
	HomePage homepage;
	TransportPage transportpage;
	CarsPage carspage;
	CarDetailPage cardetailpage;
	int index;
	CarsPageTestData carspagetd;
	TestUtil util;
	
	CarsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();
		transportpage = homepage.clickTransportLink();
		carspage = transportpage.clickCarsLink();
		carspagetd = new CarsPageTestData();
		util = new TestUtil();
		index = util.generateRandomNumber();
	}
	
	@Test
	public void validateCarsPageTitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "SS.COM Transport - Cars - Ads");
	}
	
	@Test
	public void searchCarsByYear() {
		System.out.println(index);
		carspage.selectYear(index);
		cardetailpage = carspage.clickSearchBtn();
	}
	
	@Test
	public void differentModelsOfACar() {
		cardetailpage = carspage.clickCarLink(CarsPageTestData.carName);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
