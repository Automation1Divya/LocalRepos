package advancetestng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class DataProviderExample extends SeleniumUtility {

	@Test(dataProvider = "getData")
	public void setData(String username, String password) {
		System.out.println("you have provided username as : " + username);
		System.out.println("you have provided password as : " + password);
	}

	@Test(dataProvider = "testData")
	public void testLoginOfVtiger(String browser, String username, String password) {
		setUp(browser, "https://demo.vtiger.com/vtigercrm/index.php");
		typeInput(driver.findElement(By.id("username")), username);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password, Keys.ENTER);
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "admin";
		data[0][1] = "admin";

		data[1][0] = "";
		data[1][1] = "";

		data[2][0] = "guestuser3";
		data[2][1] = "pass123";

		return data;
	}

	@DataProvider(name = "testData")
	public Object[][] getUserDetails() {
		Object[][] data = new Object[3][3];
		data[0][0] = "chrome";
		data[0][1] = "admin";
		data[0][2] = "Test@123";

		data[1][0] = "firefox";
		data[1][1] = "pass123";
		data[1][2] = "admin";

		data[2][0] = "chrome";
		data[2][1] = "";
		data[2][2] = "";

		return data;
	}

}
