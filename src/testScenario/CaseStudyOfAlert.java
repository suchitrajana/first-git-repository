package testScenario;


import java.awt.HeadlessException;
import java.io.File;
//import java.io.FileNotFoundException;
//import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testObjectRepository.WebLocator;
import userDefineLibrary.DriverSetup;
import userDefineLibrary.ExcelReadAndWrite;
import userDefineLibrary.ScreenShot;

public class CaseStudyOfAlert extends DriverSetup {

	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	public static XSSFRow row;
	public static String promptInput;
	public static String browser;
	public static File src;
	public static int t;
	public static String okAlertText, okCancleAlertText, text,message;
	public static String expected1, expected2;
	public static WebDriver driver;
	public static WebElement element;

	/**
	 * Project:Work with different type of alerts 
	 * Name:Suchitra Jana 
	 * ID:885635
	 * 
	 * Project description:
	 *                   1. Click a button and work with an Alert having only OK button. 
                         2. Click a button and work with an Alert having both OK and Cancel buttons. 
                         3. Click a button and work with an Alert having prompt box. 
                         4. Get the message associated with each Alert box. 
	 */

	
	
	// OPENING THE BROWSER
	@Parameters("browser")
	@BeforeClass
	public void driverConfig(String browser) {
		driver = DriverSetup.createdriver(browser);
	}
	

	// READING THE DATA FROM AN EXCEL FILE
	@Test(priority = 1)
	public void testcaseExcel() {
		try {
			ExcelReadAndWrite.readexcel();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	

	// CLICKING THE SHOW ALERT BOX BUTTON AND HANDLE THE ALERT
	@Test(priority = 2)
	public void testOkAlert() {
		
	try {
		WebLocator.showAlertBox(driver).click();

		WebDriverWait wait = new WebDriverWait(driver, 15); //WAIT UNTIL ALERT IS PRESENT
		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();

		okAlertText = driver.switchTo().alert().getText();
		System.out.println(okAlertText); //PRINT THE TEXT TO CONSOLE

		expected1 = ExcelReadAndWrite.expected1;
		// expected1 = "Hello! I am an alert box!";
        
		//VERIFY THE TEXT PRESENT IN ALERT BOX
		Assert.assertEquals(okAlertText, expected1);

		 alert.accept();
		
		}catch(Exception e) {
			
			e.printStackTrace();
		}

	}


	// CLICKING THE FIRST TRY IT BUTTON AND HANDLE THE ALERT
	@Test(priority = 3)
	public void testOkCancleAlert() {
	
	try {	
		WebLocator.first_try_it(driver).click();

		WebDriverWait wait = new WebDriverWait(driver, 15);  //WAIT UNTIL ALERT IS PRESENT
		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();

		okCancleAlertText = driver.switchTo().alert().getText();
		System.out.println(okCancleAlertText); //PRINT THE TEXT TO CONSOLE

		expected2 = ExcelReadAndWrite.expected2;
		// expected2 = "Press a button!";
        
		//VERIFY THE TEXT PRESENT IN ALERT BOX
		Assert.assertEquals(okCancleAlertText, expected2);

		alert.dismiss();
		
	  }catch(Exception e) {
		  
		  e.printStackTrace();
	  }
	}


	// AFTER CLICKING FIRST TRY IT BUTTON GET THE MESSAGE AND PRINT IT TO CONSOLE
	@Test(priority = 4)
	public void getAlertMessage() {
		
		element = WebLocator.message(driver);
		message = element.getText();
		System.out.println(message);
		
		// WRITEING DATA TO AN EXCELFILE
		
		try {
			cell = ExcelReadAndWrite.sheet.getRow(1).getCell(2);
			if (cell == null)
				cell = ExcelReadAndWrite.sheet.getRow(1).createCell(2);
			cell.setCellValue(message);
			ExcelReadAndWrite.writeexcel();
		} catch (Exception e3) {
			
			e3.printStackTrace();
		}

	}

	// CLICKING THE SECOND TRY IT BUTTON AND HANDLE THE ALERT
	@Test(priority = 5)
	public void testPromptAlert() {

		
	try {	
		WebLocator.second_try_it(driver).click();

		WebDriverWait wait = new WebDriverWait(driver, 15); //WAIT UNTIL ALERT IS PRESENT
		wait.until(ExpectedConditions.alertIsPresent());

		Alert promptAlert = driver.switchTo().alert();

		// PASSING DATA TO THE PROMPT BOX THROUGH AN EXCELFILE
		promptAlert.sendKeys(ExcelReadAndWrite.promptInput);
		
		// TAKE SCREENSHOT OF PROMPT ALERT
		try {
        ScreenShot.alertScreenShot();
		}catch(HeadlessException e1) {
			e1.printStackTrace();
		}
		promptAlert.accept();
		
	  }catch(Exception e) {
		  
		  e.printStackTrace();
	  }
	
	}

	// AFTER CLICKING SECOND TRY IT BUTTON WRITE THE OUTPUT MESSAGE TO AN EXCEL FILE AND TO THE CONSOLE
	@Test(priority = 6)
	public void getPromptMessage() {

		element = WebLocator.promptMessage(driver);
		text = element.getText();
		System.out.println(text);

		// WRITEING DATA TO AN EXCELFILE
		try {
			cell = ExcelReadAndWrite.sheet.getRow(1).getCell(4);
			if (cell == null)
				cell = ExcelReadAndWrite.sheet.getRow(1).createCell(4);
			cell.setCellValue(text);
			ExcelReadAndWrite.writeexcel();

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
	
	//TAKE SCREENSHOT AFTER HANDLING ALL ALERTS
	@Test(priority = 7)
	public static void screenshot()
	  {
		  try {
			ScreenShot.screenShot(driver);
		} catch (IOException e) {
			
			e.printStackTrace();
		}	  
	  }


	// CLOSING THE BROWSER AND IT'S SESSION
	@AfterClass
	public void driverexit() {
		DriverSetup.closeDriver();
	}
}
