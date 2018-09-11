package com.ss.qa.pages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ss.qa.base.TestBase;
import com.ss.qa.util.TestUtil;

public class RegistrationPage extends TestBase {
	
	//Page Factory - OR
	
	@FindBy(xpath="//input[contains(@name,'name')]")
	WebElement userName;
	
	@FindBy(xpath="//input[contains(@name,'sname')]")
	WebElement userSurname;
	
	@FindBy(xpath="//input[contains(@name,'email')]")
	WebElement userEmail;
	
	@FindBy(xpath="//input[contains(@name,'phone')]")
	WebElement userPhone;
	
	@FindBy(xpath="//input[contains(@name,'pass1')]")
	WebElement userPassword;
	
	@FindBy(xpath="//input[contains(@name,'pass2')]")
	WebElement userConfirmPassword;
	
	@FindBy(xpath="//center/input[3]")
	WebElement Submit;
	
	String alertText;
	String alertTitle = "Attention";
	String parentWindowHandler;
	String subWindowHandler = null;
	public static WebElement temp;
	
	RegistrationConfirmationPage regisconfirmpage;
	

	//Initializing Page Objects:
		public RegistrationPage() {
			PageFactory.initElements(driver, this);
			regisconfirmpage = new RegistrationConfirmationPage();
		}
		
	//Actions:
		
		public String createNewContact(String name, String surname, String email, String password,
			String confirmPassword, String phoneNumber, String country) throws InterruptedException {
			Select select = new Select(driver.findElement(By.name("country_id")));
			
			select.selectByVisibleText(country);
			userName.sendKeys(name);
			userSurname.sendKeys(surname);
			userEmail.sendKeys(email);
			phoneNumber = userPhone.getText()+phoneNumber;
			userPhone.sendKeys(phoneNumber);
			userPassword.sendKeys(password);
			userConfirmPassword.sendKeys(confirmPassword);
			driver.findElement(By.id("rules")).click();
			Submit.click();
			if(userName.isDisplayed()) {
				parentWindowHandler = driver.getWindowHandle(); // Store your parent window
			    Set<String> handles = driver.getWindowHandles(); // get all window handles
			    Iterator<String> iterator = handles.iterator();
			    while (iterator.hasNext()){
			        subWindowHandler = iterator.next();
			    }
			    driver.switchTo().window(subWindowHandler); // switch to popup window
			    temp = driver.findElement(By.id("alert_msg"));
			    WebElement popupTitle = driver.findElement(By.className("alert_head_left"));
			    
			    switch(temp.getText().substring(13)) {
			    	case "name.":
			    		System.out.println(popupTitle.getText()+": Error message when Name is not filled:"+temp.getText());
			    		driver.findElement(By.id("alert_ok")).click();
			    		return "name is not filled";
			    	case "surname.":
			    		System.out.println(popupTitle.getText()+": Error message when Surname is not filled:"+temp.getText());
			    		driver.findElement(By.id("alert_ok")).click();
			    		return "surname is not filled";
			    	case "e-mail.":
			    		System.out.println(popupTitle.getText()+": Error message when Email is not filled:"+temp.getText());
			    		driver.findElement(By.id("alert_ok")).click();
			    		return "email is not filled";
			    	case "":
			    		System.out.println(popupTitle.getText()+": Error message when Password is not filled:"+temp.getText());
			    		driver.findElement(By.id("alert_ok")).click();
			    		return "password is not filled";
			    		default:
			    		System.out.println(popupTitle.getText()+": Error message when Password is not filled:"+temp.getText());
			    		driver.findElement(By.id("alert_ok")).click();
			    		return "confirm password is not correctly filled";
			    }			    	
			    }
			else {
				driver.switchTo().window(parentWindowHandler);
				return regisconfirmpage.verifyRegistrationConfirmationPage();
			}
						
		}
		
}