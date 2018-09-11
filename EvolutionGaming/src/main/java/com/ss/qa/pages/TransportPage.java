package com.ss.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ss.qa.base.TestBase;

public class TransportPage extends TestBase {

	//Page Factory - OR
	
		@FindBy(xpath="//a[contains(@title,'Transport')]")
		WebElement TransportLink;
		
		@FindBy(xpath="//a[contains(text(),'Cars')]")
		WebElement CarsLink;
		
		@FindBy(xpath="//a[contains(text(),'Cargo cars')]")
		WebElement CargoCarsLink;
		
		@FindBy(xpath="//input[@type='button']")
		WebElement PlaceAnnouncementBtn;
		
	//Initializing Page Objects:
		public TransportPage() {
			PageFactory.initElements(driver, this);
		}
		
	//Actions:
		
		public CargoCarsPage clickCargoCarsLink() {
			CargoCarsLink.click();
			return new CargoCarsPage();
		}
		
		public CarsPage clickCarsLink() {
			CarsLink.click();
			return new CarsPage();
		}
		
		public AnnouncementPage clickPlaceAnnouncementBtn() {
			PlaceAnnouncementBtn.click();
			return new AnnouncementPage();
		}
		
		public boolean validateTransportLink() {
			return TransportLink.isEnabled();
		}	
}
