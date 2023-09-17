package takingscreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class GetScreenshot {

	public static void main(String[] args) {
//		SeleniumUtility s = new SeleniumUtility();
//		WebDriver driver = s.setUp("chrome", "https://demo.actitime.com/login.do");
		System.setProperty("webdriver.chrome.driver", "./executables/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		
		String fileLocation = ".\\screenshots\\actitime_"+ System.currentTimeMillis()+".jpg";
		getScreenshot(driver,fileLocation);
	}

	public static void getScreenshot(WebDriver driver, String filePath) 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(filePath));
		} 
		catch (IOException e) {
			e.printStackTrace();
	    }

    }

}