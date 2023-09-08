package day5.handlingcalenders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.SeleniumUtil;

public class RedBusHandlingCalenders extends SeleniumUtil{
	static WebDriver driver;

	public static void main(String[] args) {
		driver = setUp("chrome","https://www.redbus.in/");
		WebElement fromTextField = driver.findElement(By.id("src"));
		fromTextField.clear();
		fromTextField.sendKeys("pun");
		driver.findElement(By.xpath("//li[2]/div/text[1]")).click();
		
		WebElement toTextField = driver.findElement(By.id("dest"));
		toTextField.clear();
		toTextField.sendKeys("goa");
		driver.findElement(By.xpath("//ul/li[3]/div/text[1]")).click();
		
		driver.findElement(By.cssSelector(".icon-datev2")).click();
		
		driver.findElement(By.id("search_button")).click();
		
		


	}

}
