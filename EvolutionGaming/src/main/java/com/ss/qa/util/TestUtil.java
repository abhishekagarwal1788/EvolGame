package com.ss.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;


public class TestUtil {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;	
	Random objGenerator;
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\ABHISHEK.agarwal\\eclipse-workspace\\"
			+ "EvolutionGaming\\src\\main\\java\\com\\ss\\qa\\testdata\\userTestData.xls";
	static Workbook book = null;
	static Sheet sheet = null;
	static WebDriver webDriver = null;
	static WebElement element;
	static String path = "";
	
	
	public int generateRandomNumber() {
		objGenerator = new Random();
		return objGenerator.nextInt(15);
	}
	
	public static Object[][] getTestData(String sheetName){
		FileInputStream file = null;	
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		}catch(FileNotFoundException e) {
		e.printStackTrace();
	}
		try {
			book = WorkbookFactory.create(file);
		} catch(IOException e) {
			 e.printStackTrace();			
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; 
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		WebDriver driver = new ChromeDriver();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File (currentDir+"/screenshots/"+System.currentTimeMillis()+".png"));
	}
	
	public static boolean findLogoInHomePage(Screen screen, Pattern imageObj) {
		screen.capture().save("D:\\Images", "fullPage");
		Finder f = new Finder(screen.capture().getImage());
		f.find(imageObj);
		if(f.hasNext()) {
			Match m=f.next();
	        System.out.println("Match found with "+(m.getScore())+"100"+"%");
	        f.destroy();
	        return true;
		}
		else{
	        System.out.println("No Match Found");
	        return false;
	    }
	}

}
