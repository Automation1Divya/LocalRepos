package testngexample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class Validation extends SeleniumUtility {
	@Test
	public void testGoogleSearchResultWithAssert() {
		setUp("chrome","https://www.google.com/");
//		System.setProperty("webdriver.chrome.driver", "./executables/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		typeInput(driver.findElement(By.name("q")), "selenium");
		clickOnElement(driver.findElement(By.xpath("(//input[@value='Google Search'])[1]")));
//		driver.findElement(By.name("q")).sendKeys("selenium");
//		driver.findElement(By.xpath("(//input[@value='Google Search'])[1]")).click();
    	String expTitle = "selenium - Google Search";
		//String actTitle = driver.getTitle();
		String actTitle = getCurrentTitleOfApplication("selenium");
		Assert.assertEquals(actTitle, expTitle);
		Assert.assertEquals(actTitle, expTitle, "Either google search not happened or page title got changed");
	//	Assert.assertTrue(actTitle.contains("selenium"));
		Assert.assertTrue(actTitle.contains("selenium"), "Either google search not happened or page title got changed");
		cleanUp();
		//driver.close();
	}
}
