package userDefineLibrary;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	//TAKE SCREENSHOT USING COMMON IO
	public static void screenShot(WebDriver ldriver) throws IOException {
		File src = ((TakesScreenshot) ldriver).getScreenshotAs(OutputType.FILE);
		try {
			//  copy the screenshot to desired location using copyFile method and image type is png
			FileUtils.copyFile(src, new File("C:\\Users\\User\\eclipse-workspace\\HandleDifferentAlerts\\ScreenShot\\"
					+ System.currentTimeMillis() + ".png"));
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}

	}

	
	// TAKE SCREENSHOT OF ALETR USING ROBOT CLASS
	public static void alertScreenShot() {
		BufferedImage image = null;
		try {
			image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		} catch (HeadlessException | AWTException e) {
			
			e.printStackTrace();
		}
		try {
			//copy the screenshot to desired location using copyFile method and image type is jpg
			ImageIO.write(image, "jpg", new File("C:\\Users\\User\\eclipse-workspace\\HandleDifferentAlerts\\ScreenShot\\"
					+ System.currentTimeMillis() + ".jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
}
