package helpers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshooter {

	public static void takeScreen(String screenName,WebDriver driver) {
		File myScreenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(myScreenshotFile, new File(screenName + "_" + System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
