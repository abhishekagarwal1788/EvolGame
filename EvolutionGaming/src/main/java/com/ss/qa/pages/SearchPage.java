package com.ss.qa.pages;

import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ss.qa.base.TestBase;

public class SearchPage extends TestBase{
	
	//Page Factory - OR
	
	@FindBy(id = "ptxt")
	WebElement searchField;
	
	@FindBy(id = "sbtn")
	WebElement searchBtn;
	
	@FindBy(xpath = "//select[@name='cid_0']")
	WebElement section;
	
	//public static List<WebElement> results = driver.findElements(By.xpath("//div[contains(@id,'preload_txt')]//div[contains(@id,'cmp_')]"));
	
	//Initializing Page Objects:
			public SearchPage() {
			PageFactory.initElements(driver, this);
			}

	public int countResults(String search) {
		searchField.sendKeys(search);
		int total = driver.findElements(By.xpath("//div[contains(@id,'preload_txt')]//div[contains(@id,'cmp_')]")).size();
		return total;
	}	
	public boolean verifySearchStringInResults(int total, String searchString) {
		int i = 1;
		List<WebElement> results = driver.findElements(By.xpath("//div[contains(@id,'preload_txt')]//div[contains(@id,'cmp_')]"));
		for(WebElement element:results) {
			if(element.getText().toLowerCase().contains(searchString)) {
				System.out.println("Search result @ "+i+"th iteration: "+element.getText());
			}
			else {
				System.out.println("Search result does not contain the string searched at iteration: "+i);
				return false;
			}
			i = i+1;
		}
		return true;
	}
	public JobBusinessSearch startSearch(int index) {
		driver.findElements(By.xpath("//div[contains(@id,'preload_txt')]//div[contains(@id,'cmp_')]")).get(index).click();
		Select dropdown = new Select(section);
		dropdown.selectByVisibleText("Job and business");
		searchBtn.click();
		return new JobBusinessSearch();
	}
	
	
	
}