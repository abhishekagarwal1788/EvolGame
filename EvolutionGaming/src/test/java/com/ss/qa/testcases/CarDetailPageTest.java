package com.ss.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ss.qa.base.TestBase;
import com.ss.qa.log.Log;
import com.ss.qa.pages.CarDetailPage;
import com.ss.qa.pages.CarsPage;
import com.ss.qa.pages.HomePage;

import com.ss.qa.pages.TransportPage;

import com.ss.qa.util.TestUtil;

public class CarDetailPageTest extends TestBase {
	
	HomePage homepage;
	TransportPage transportpage;
	CarsPage carspage;
	CarDetailPage cardetailpage;
	String sheetName = "";
	String temp;
	
	CarDetailPageTest(){
		super(); 		
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		homepage = new HomePage();
		transportpage = homepage.clickTransportLink();
		carspage = transportpage.clickCarsLink();
		cardetailpage = carspage.clickCarLink("BMW");
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object [][] BMWData = TestUtil.getTestData("BMW");
		return BMWData;
	}
	
	@Test(priority=1, dataProvider="getTestData")
	public void validateRegisterNewUser(String Announcement, String Model, String Year, String Vol,
			String Run, String Price) {
		int rowCount = cardetailpage.tableRowCount();
		int colCount = cardetailpage.tableColumnCount();
		boolean flag = cardetailpage.verifyTableData(Announcement, Model, Year, Vol, Run, Price, rowCount, colCount);
		Log.info("Table data verification"+flag);
		System.out.println("Data found in system: "+flag);
	}
	
	public void validateSlideShowImages() {
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		}

}
