package day6.keyboardandmouseoperations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.SeleniumUtil;

public class CopyPasteWithKeys extends SeleniumUtil {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = setUp("chrome","https://demo.automationtesting.in/Register.html");
		WebElement fName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		fName.sendKeys("admin",Keys.chord(Keys.CONTROL,"a"));
		fName.sendKeys(Keys.chord(Keys.CONTROL,"c"));
		
		WebElement lName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		lName.sendKeys(Keys.chord(Keys.CONTROL,"v"));
		driver.close();
	}

}
