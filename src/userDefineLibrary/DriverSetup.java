package userDefineLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {

	public static WebDriver driver;
	public static String exePath;
	public static String url = "http://cookbook.seleniumacademy.com/Alerts.html";
	public static String browsertype;

	/**
	 * INSTANTIATION OF CHROME BROWSER AND MOZILA FIREFOX BROWSERS 
	 * WITH THE HELP OF CORRESPONDING DRIVERS
	 * 
	 * First it invoke the browser
	 * Then Navigate to given URL & maximize the window
	 * Perform required task
	 * And close the browser 
	 */
	
	//INVOKING THE BROWSER, AS PER BROWSER TYPE
	public static WebDriver createdriver(String browser) {
		browsertype = browser;
		if (browsertype.equalsIgnoreCase("chrome")) {

			exePath = "C:\\Users\\User\\eclipse-workspace\\HandleDifferentAlerts\\Driver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			exePath = "C:\\Users\\User\\eclipse-workspace\\HandleDifferentAlerts\\Driver\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", exePath);
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// SET TIMEUNIT FOR LOADING THE PAGE
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.get(url);//NAVIGATE TO URL 
		driver.manage().deleteAllCookies();

		return driver;
	}

	// CLOSING THE DRIVERS AND IT'S SESSION
	public static void closeDriver() {

		DriverSetup.driver.quit();
	}

}
