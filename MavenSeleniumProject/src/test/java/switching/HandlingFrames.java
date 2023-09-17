package switching;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class HandlingFrames extends SeleniumUtility {
  @BeforeTest
  public void preCondition() {
	  setUp("chrome","https://jqueryui.com/");
  }
  
  @Test(priority=1)
  public void switchingToFrame()
  {
	  clickOnElement(driver.findElement(By.xpath("//a[text()='Draggable']")));
	  switchToFrameWithWebElement(driver.findElement(By.cssSelector(".demo-frame")));
	  //switchToFrameWithIndex(0);
	  WebElement src= driver.findElement(By.id("draggable"));
	  action.dragAndDropBy(src, 100, 0).build().perform();
	  switchFromFrameToMainPage();
	  clickOnElement(driver.findElement(By.cssSelector(".logo")));
  }
  
  @AfterTest
  public void postCondition() {
	  cleanUp();
  }	
  
}
