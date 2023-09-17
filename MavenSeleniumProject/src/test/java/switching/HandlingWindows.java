package switching;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class HandlingWindows extends SeleniumUtility {
	@BeforeTest
	public void preCondition() {
		setUp("chrome", "https://etrain.info/in/");
	}

	@Test
	public void testWindowHandling() {
		System.out.println("Home Page url " + getCurrentUrlOfApplication());
		System.out.println("Home Page Title " + getCurrentTitleOfApplication());
		String homeWinId = driver.getWindowHandle();
		System.out.println("Home Page Window Id: " + homeWinId);
		// click on twitter
		clickOnElement(driver.findElement(By.cssSelector(".icon-twitter")));
		setSleepTime(1000);
		Set<String> allWinIds = driver.getWindowHandles();
		System.out.println("All Window Ids: " + allWinIds);
		allWinIds.remove(homeWinId);
		System.out.println("After removing home id, All Window Ids: " + allWinIds);
		String childWinId = allWinIds.iterator().next();
		driver.switchTo().window(childWinId);
		System.out.println("Child Page Url: " + getCurrentUrlOfApplication());
		System.out.println("Child Page Title: " + getCurrentTitleOfApplication("Twitter"));
		// driver.close();
		setSleepTime(1000);
		driver.switchTo().window(homeWinId);
		System.out.println("Home Page Url: " + getCurrentUrlOfApplication());
		System.out.println("Home Page Title: " + getCurrentTitleOfApplication());
	}

	@AfterTest
	public void postCondition() {
		cleanUpAll();
	}

}
