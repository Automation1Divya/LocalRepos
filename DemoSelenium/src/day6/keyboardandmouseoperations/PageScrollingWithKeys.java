package day6.keyboardandmouseoperations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


import utilities.SeleniumUtil;

public class PageScrollingWithKeys extends SeleniumUtil {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = setUp("chrome","https://www.flipkart.com/");
		driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
		/*for(int i=0;i<6;i++)
		{
			driver.findElement(By.xpath("//body")).sendKeys(Keys.PAGE_DOWN);	
		}
		
		for(int i=0;i<6;i++)
		{
			driver.findElement(By.xpath("//body")).sendKeys(Keys.PAGE_UP);	
		}*/
		driver.findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.CONTROL),Keys.END);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.CONTROL),Keys.HOME);
		
		
		//driver.close();
	}

}
