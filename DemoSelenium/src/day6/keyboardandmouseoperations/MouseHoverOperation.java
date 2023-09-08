package day6.keyboardandmouseoperations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.SeleniumUtil;

public class MouseHoverOperation extends SeleniumUtil {

	public static void main(String[] args) {
		WebDriver driver = setUp("chrome","https://demo.automationtesting.in/Register.html");
		List<WebElement> menuList = driver.findElements(By.cssSelector(".navbar-nav>li>a"));
		Actions act = new Actions(driver);
		for(int i=0;i<menuList.size();i++)
		{
			act.moveToElement(menuList.get(i)).perform();
			
		}
		WebElement webtableLink = menuList.get(2);
		act.moveToElement(webtableLink, 100, 0).perform();
		

	}

}
