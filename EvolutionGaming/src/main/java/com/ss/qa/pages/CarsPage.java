package com.ss.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ss.qa.base.TestBase;

public class CarsPage extends TestBase {

	//Page Factory - OR
	
	Select dropdown;
	WebElement CarLink;
	
	@FindBy(xpath = "//select[@id='f_o_18_min']")
	WebElement YearList;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement SearchBtn;
	
	//Initializing Page Objects:
		public CarsPage() {
			PageFactory.initElements(driver, this);
			dropdown = new Select(YearList);			
		}
		
	//Actions:
		public CarDetailPage clickCarLink(String carLink) {
			CarLink = driver.findElement(By.xpath("//a[contains(text(),'"+carLink+"')]"));
			CarLink.click();
			return new CarDetailPage();
		}
		
		public void selectYear(int index) {
			dropdown.selectByIndex(index);
		}
		
		public CarDetailPage clickSearchBtn() {
			SearchBtn.click();
			return new CarDetailPage(); 
		}
}
