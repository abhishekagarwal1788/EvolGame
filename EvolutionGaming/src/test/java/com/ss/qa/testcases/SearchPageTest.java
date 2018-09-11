package com.ss.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.*;
import com.ss.qa.base.TestBase;
import com.ss.qa.pages.HomePage;
import com.ss.qa.pages.JobBusinessSearch;
import com.ss.qa.pages.SearchPage;
import com.ss.qa.util.TestUtil;

public class SearchPageTest extends TestBase{
	
	HomePage homepage;
	SearchPage searchpage;
	int count = 0;
	TestUtil testutil;
	JobBusinessSearch jobbusinesssearch;
	
	SearchPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		homepage = new HomePage();
		searchpage = homepage.clickSearchLink();
		testutil = new TestUtil();
	}
	
	@Test
	public void verifySearchStringInResults() {
		count = searchpage.countResults("a");
		Assert.assertEquals(count, 15);
		boolean flag = searchpage.verifySearchStringInResults(count, "a");		
		Assert.assertEquals(flag, true);
		int index = testutil.generateRandomNumber();
		jobbusinesssearch = searchpage.startSearch(index);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		}
}
