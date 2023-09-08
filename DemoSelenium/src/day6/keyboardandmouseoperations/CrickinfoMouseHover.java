package day6.keyboardandmouseoperations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.SeleniumUtil;

public class CrickinfoMouseHover extends SeleniumUtil {

	public static void main(String[] args) {
		WebDriver driver = setUp("chrome","https://www.espncricinfo.com/");
		 
		List<WebElement> mainMenuNames = driver.findElements(By.cssSelector(".ds-flex-1>.ds-flex-row>div>a"));
				
		System.out.println("Total mainMenuName count:"+mainMenuNames.size());
		Actions act = new Actions(driver);
		for(int i=0;i<mainMenuNames.size();i++)
		{
			System.out.println((i+1) +" MenuNames is : "+mainMenuNames.get(i).getText());
			act.moveToElement(mainMenuNames.get(i)).perform();
		}
		driver.close();


	}

}
