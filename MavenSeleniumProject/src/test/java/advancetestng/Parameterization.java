package advancetestng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class Parameterization extends SeleniumUtility{
	@Parameters({"browser"})
  @Test
  public void testCaseOne(String browser) {
	  System.out.println("Browser passed as :"+browser);
  }
  @Parameters({"username","password"})
  @Test
  public void testCaseTwo(String username,String password) {
	  System.out.println("Parameter for username: "+username);
	  System.out.println("Parameter for password: "+password);
  }
  @Parameters({"browser","username","password"})
  @Test
  public void testCaseThree(String browser,String username,String password) {
	  System.out.println("Broser passed as :"+browser);
	  System.out.println("Parameter for username: "+username);
	  System.out.println("Parameter for password: "+password);
  }
  @Parameters({"browser","username","password"})
  @Test
  public void testLoginOfVtiger(String browser,String username,String password) {
	  setUp(browser,"https://demo.vtiger.com/vtigercrm/index.php");
	  typeInput(driver.findElement(By.id("username")),username);
	  driver.findElement(By.id("password")).clear();
	  driver.findElement(By.id("password")).sendKeys(password,Keys.ENTER);	  
  }
  
 }
