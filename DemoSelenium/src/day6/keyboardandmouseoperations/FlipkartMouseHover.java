package day6.keyboardandmouseoperations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.SeleniumUtil;

public class FlipkartMouseHover extends SeleniumUtil{

	public static void main(String[] args) {
		WebDriver driver = setUp("chrome","https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
		List<WebElement> menuList = driver.findElements(By.cssSelector("._3sdu8W>*>div>div>span>*:nth-child(1)"));
		                              
		System.out.println("Total mainMenuName count:"+menuList.size());
		Actions act = new Actions(driver);
		for(int i=0;i<menuList.size();i++)
		{
			
			System.out.println("Link Name : "+menuList.get(i).getText());
			act.moveToElement(menuList.get(i)).perform();
		}
	}

}
