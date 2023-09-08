package day6.keyboardandmouseoperations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.SeleniumUtil;

public class ContextClickOperation extends SeleniumUtil{

	public static void main(String[] args) {
		WebDriver driver = setUp("chrome","https://demo.automationtesting.in/Register.html");
		List<WebElement> menuList = driver.findElements(By.cssSelector(".navbar-nav>li>a"));
		Actions act = new Actions(driver);
		WebElement link = menuList.get(3);
		act.contextClick(link).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();  //not working
		
	}

}
