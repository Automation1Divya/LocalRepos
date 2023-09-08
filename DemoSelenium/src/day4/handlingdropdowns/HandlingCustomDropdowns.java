package day4.handlingdropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.SeleniumUtil;

public class HandlingCustomDropdowns extends SeleniumUtil{
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = setUp("chrome","https://thompsonsj.com/bootstrap-select-dropdown/");
		driver.findElement(By.id("bsd1-button")).click();
		List<WebElement> options = driver.findElements(By.cssSelector(".dropdown-menu.dropdown-menu-right.show>div>a"));
		System.out.println("Total options :"+options.size());
		for(int i=0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
		}
		options.get(2).click();
		driver.close();
		
	}

}
