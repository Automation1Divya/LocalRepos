package day7.colourfontvalidation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.SeleniumUtil;

public class ColorFontValidation {
	static WebDriver driver;
	static WebDriverWait wait;
	
	public static void main(String[] args) {
		driver = SeleniumUtil.setUp("chrome","https://demo.actitime.com/login.do");
		driver.findElement(By.id("loginButton")).click();
		wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.attributeToBe(By.cssSelector(".errormsg"), "class", "errormsg"));
		WebElement errormsg = driver.findElement(By.cssSelector(".errormsg"));
		//selenium get the color in rgb format
		String msgColorCode = errormsg.getCssValue("color");
		String msgFontSize = errormsg.getCssValue("font-size");
		String msgFontFamily = errormsg.getCssValue("font-family");
		System.out.println("color code"+msgColorCode);
		System.out.println("color code"+msgFontFamily);
		System.out.println("color code"+msgFontSize);
		driver.close();

	}

}
