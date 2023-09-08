package day6.keyboardandmouseoperations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.SeleniumUtil;

public class CopyPasteWithMouse extends SeleniumUtil {

	public static void main(String[] args) {
		WebDriver driver = setUp("chrome","https://demo.automationtesting.in/Register.html");
		WebElement fName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		Actions act = new Actions(driver);
		fName.sendKeys("admin");
		act.moveToElement(fName).doubleClick().keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
		
		

	}

}
