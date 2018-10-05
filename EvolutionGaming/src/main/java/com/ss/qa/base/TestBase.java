package com.ss.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.sikuli.*;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.ss.qa.util.TestUtil;
import com.ss.qa.util.WebEventListener;


public class TestBase {
	
	 public static WebDriver driver;
	 public static Properties prop;
	 public static EventFiringWebDriver e_driver;
	 public static WebEventListener eventListener;
	 public static Screen screen;
	 
	 public TestBase(){		 
		 try {
			 prop = new Properties();
			 FileInputStream ip = new FileInputStream("C:\\Users\\ABHISHEK.agarwal\\eclipse-workspace\\"
			 		+ "EvolutionGaming\\src\\main\\java\\com\\ss\\qa\\config\\config.properties");
			 prop.load(ip);
		 
		 } catch (FileNotFoundException e) {
			 e.printStackTrace();			 
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	 }

	 public static void initialization() {
		 //	DOMConfigurator.configure("log4j.xml");
			String browserName = prop.getProperty("browser");
			 if (browserName.equalsIgnoreCase("chrome")) {
				  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABHISHEK.agarwal\\Downloads\\"
				  		+ "chromedriver_win32\\chromedriver.exe");
				  
				  driver = new ChromeDriver();	
				  System.out.println("driver=" + driver); 
			 }		 
			 else if (browserName.equalsIgnoreCase("FF")) {
				  System.setProperty("webdriver.gecko.driver", "C:\\Users\\ABHISHEK.agarwal\\Downloads\\"
				  		+ "geckodriver-v0.21.0-win64\\geckodriver.exe");
				  driver = new FirefoxDriver();			  
			 }
			 e_driver = new EventFiringWebDriver(driver);
			 eventListener = new WebEventListener();
			 e_driver.register(eventListener);
			 driver = e_driver;
			 driver.manage().window().maximize();
			 driver.manage().deleteAllCookies();
			 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT , TimeUnit.SECONDS);
			 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT , TimeUnit.SECONDS);
			 System.out.println("reached");
			 driver.get(prop.getProperty("url"));
		}
}
