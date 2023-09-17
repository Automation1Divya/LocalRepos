package switching;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class HandlingConfirmationPopup extends SeleniumUtility {
  @BeforeTest
  public void preCondition() {
	  setUp("chrome","https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
  }
  
  @Test
  public void testAlert()
  {
	  
	  driver.switchTo().frame("iframeResult");
	  clickOnElement(driver.findElement(By.xpath("//button[text()='Try it']")));
	  String alertText = driver.switchTo().alert().getText();
	  System.out.println("Alert popup msg: "+alertText);
	 // driver.switchTo().alert().accept();
	  driver.switchTo().alert().dismiss();
  }
  
  @AfterTest
  public void postCondition() {
	  cleanUp();
  }	
  
}
