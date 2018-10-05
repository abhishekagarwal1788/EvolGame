package com.ss.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.ss.qa.base.TestBase;
import com.ss.qa.log.Log;


public class RegistrationConfirmationPage extends TestBase{
	
	// Page Factory - OR
	
	//Initializing Page Objects:
	public RegistrationConfirmationPage() {
		PageFactory.initElements(driver, this);
		Log.startTestCase("RegistrationConfirmationPage");
	}
	
	//Actions:
	public String verifyRegistrationConfirmationPage() {
		String title = driver.findElement(By.className("head_title")).getText();
		Log.info("Registration Confirmation Title found"+title);
		return title;
	}
	

}
