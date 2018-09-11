package com.ss.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ss.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - OR
	
	@FindBy(id="login_txt")
	WebElement UserName;
	
	@FindBy(id="pass_txt")
	WebElement Password;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement SubmitBtn;
	
	LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public RegistrationPage clickRegistrationLink() {
		driver.findElement(By.linkText("Register")).click();
		return new RegistrationPage();
	}

}
