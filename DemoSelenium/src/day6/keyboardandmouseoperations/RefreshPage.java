package day6.keyboardandmouseoperations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import utilities.SeleniumUtil;

public class RefreshPage extends SeleniumUtil{
	 
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = setUp("chrome","https://demo.automationtesting.in/Register.html");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.CONTROL,"r"));  
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
		//driver.close();

	}

}
