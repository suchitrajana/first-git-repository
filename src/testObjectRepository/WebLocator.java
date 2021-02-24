package testObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/** COLLECTING ALL THE WEBELEMENTS OF A SPECFIC PAGE 
 * 
 * Locate Show Alert Box Button
 * Locate First Try it Button 
 * Locate Second Try it Button
 * Locate the Message After Clicking OK/CANCEL Button 
 * Locate the Message After Sending Text to Prompt Box 
 * 
 */

public class WebLocator {

	public static WebElement element;
	public static WebDriver driver;

	// WEBELEMENT FOR SHOW ALERT BOX BUTTON
	public static WebElement showAlertBox(WebDriver driver) {

		element = driver.findElement(By.id("simple"));

		return element;
	}

	
	// WEBELENENT FOR FIRST TRY IT BUTTON
	public static WebElement first_try_it(WebDriver driver) {

		element = driver.findElement(By.id("confirm"));

		return element;
	}

	
	// WEBELENENT FOR SECOND TRY IT BUTTON 
	public static WebElement second_try_it(WebDriver driver) {

		element = driver.findElement(By.id("prompt"));

		return element;
	}

	
	// WEBELENENT FOR RETURN MESSAGE AFTER CLICKING OK/CANCEL BUTTON
	public static WebElement message(WebDriver driver) {

		element = driver.findElement(By.id("demo"));

		return element;
	}

	
	// WEBELENENT FOR RETURN MESSAGE AFTER CLICKING PROMPT BOX
	public static WebElement promptMessage(WebDriver driver) {

		element = driver.findElement(By.id("prompt_demo"));

		return element;
	}
}
