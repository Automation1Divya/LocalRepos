package day6.keyboardandmouseoperations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.SeleniumUtil;

public class DragAndDropOperation extends SeleniumUtil {

	public static void main(String[] args) {
		WebDriver driver = setUp("chrome","https://www.globalsqa.com/demo-site/draganddrop/");
		WebElement frame = driver.findElement(By.cssSelector(".demo-frame.lazyloaded"));
		driver.switchTo().frame(frame);
		Actions act = new Actions(driver);
		List<WebElement> source = driver.findElements(By.cssSelector("ul#gallery>li"));
		WebElement target = driver.findElement(By.id("trash"));
		for(int i=0;i<source.size();i++)
		{
		act.dragAndDrop(source.get(i), target).build().perform();
		}
		driver.close();

	}

}
