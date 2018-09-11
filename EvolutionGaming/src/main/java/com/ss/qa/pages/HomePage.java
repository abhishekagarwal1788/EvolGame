package com.ss.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.basics.Settings;
import com.ss.qa.base.TestBase;
import com.ss.qa.util.TestUtil;

public class HomePage extends TestBase {
	
	//Page Factory - OR
	
	@FindBy(xpath="//a[@title='Announcements Job and business']")
	WebElement JobBusinessTitle;
	
	@FindBy(xpath="//a[contains(@title,'Announcements Transport')]")
	WebElement TransportTitle;
	
	@FindBy(xpath="//img[contains(@class,'page_header_logo')]")
	WebElement PageLogo;
	
	@FindBy(xpath="//img[contains(@alt,'Announcements Job and business')]")
	WebElement JobBusinessLogo;
	
	@FindBy(xpath="//img[contains(@alt,'Announcements Transport')]")
	WebElement TransportLogo;
	
	@FindBy(xpath="//a[@title='My messages']")
	WebElement MyMessages;
	
	@FindBy(xpath = "//a[contains(@href,'/en/search')]")
	WebElement SearchLink;
	
	//Initializing Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateHomePageTilte() {
		return driver.getTitle();
	}
	
	public boolean validateSSLogo() {
		return PageLogo.isDisplayed();
	}
	
	public boolean validateJobBusinessLogo() {
		return JobBusinessLogo.isDisplayed();
	}
	
	public boolean validateTransportLogo() {
		return TransportLogo.isDisplayed();
	}
	
	public TransportPage clickTransportLink() {
		TransportTitle.click();
		return new TransportPage();
	}
	
	public LoginPage clickMyMessagesLink() {
		MyMessages.click();
		return new LoginPage();
	}
	
	public SearchPage clickSearchLink() {
	
		System.out.println(SearchLink.isDisplayed());
		SearchLink.click();
		return new SearchPage();
	}
	
	public void carImage() {
		System.out.println("reached");
		Pattern imageCar = new Pattern("D:\\Images\\Car.PNG");
		TestUtil.findLogoInHomePage(screen, imageCar);
		}
	
	public void FactoryImage() {
		//imageFactory = new Pattern(prop.getProperty("imagePath")+"Factory.PNG");
		
	}
	}
	
	
	
