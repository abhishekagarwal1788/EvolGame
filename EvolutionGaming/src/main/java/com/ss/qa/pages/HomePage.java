package com.ss.qa.pages;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		Screen screen = new Screen();
		Pattern imageCar = new Pattern("D:\\Images\\Car.PNG");
		TestUtil.findLogoInHomePage(screen, imageCar);		
		}
	
	public static void verifyJS() {
		 WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Sadarbība')]"));
		 JavascriptExecutor je = (JavascriptExecutor) driver;
		 je.executeScript("arguments[0].scrollIntoView(true);", element);
		 je.executeScript("document.getElementById('mtd_73').click();");
		 
		 je.executeScript("window.location.href = 'https://www.flipkart.com'");
		 driver.findElement(By.xpath("//button[contains(@class,'29YdH8')]")).click();		 
		WebElement element1 = driver.findElement(By.xpath("//span[text()='Electronics']"));

		String mouseOverScript = "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent('mouseover', true, false);"
				+ "arguments[0].dispatchEvent(evObj);";		
        je.executeScript(mouseOverScript, element1);

        WebElement element2 = driver.findElement(By.xpath("//a[contains(text(),'Honor')]"));        
        je.executeScript("arguments[0].click();", element2);
		 
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void FactoryImage() {
		//imageFactory = new Pattern(prop.getProperty("imagePath")+"Factory.PNG");
		
	}
	}
	
	
	

