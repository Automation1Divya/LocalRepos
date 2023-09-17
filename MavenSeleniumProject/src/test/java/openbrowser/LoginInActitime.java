package openbrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.SeleniumUtility;

public class LoginInActitime {

	public static void main(String[] args) {
		SeleniumUtility s = new SeleniumUtility();
		WebDriver driver = s.setUp("chrome", "https://demo.actitime.com/login.do");
		s.typeInput(driver.findElement(By.id("username")), "admin");
		s.typeInput(driver.findElement(By.name("pwd")), "manager");
		s.clickOnElement(driver.findElement(By.id("loginButton")));
		s.cleanUp();
	}

}
