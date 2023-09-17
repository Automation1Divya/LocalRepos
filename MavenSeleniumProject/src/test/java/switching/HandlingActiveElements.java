package switching;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class HandlingActiveElements extends SeleniumUtility {
  @BeforeTest
  public void preCondition() {
	  setUp("chrome","https://demo.actitime.com/login.do");
  }
  
  @Test(priority=1)
  public void testMouseFocus()
  {
	  WebElement element =driver.switchTo().activeElement();
	  String value = element.getAttribute("placeholder");
	  String expValue="Username";
	  Assert.assertEquals(value,expValue);
  }
  @Test(priority=2)
  public void testLoginWithoutIdentifyingElement()
  {
	  driver.switchTo().activeElement().sendKeys("admin",Keys.TAB);
	  driver.switchTo().activeElement().sendKeys("manager",Keys.ENTER);
	  String expTitle = "actiTIME - Enter Time-Track";
	  String actTitle =getCurrentTitleOfApplication(expTitle);
	  Assert.assertEquals(actTitle,expTitle);
  }
  @AfterTest
  public void postCondition() {
	  cleanUp();
  }	
  
}
