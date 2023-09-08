package day5.handlingcalenders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.SeleniumUtil;

public class RedBusHandlingCalenders2 extends SeleniumUtil{
	static WebDriver driver;

	public static void main(String[] args) {
		driver = setUp("chrome","https://www.redbus.in/");
		
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//text[@class='placeHolderMainText'])[1]")));
		WebElement fromTextField = driver.findElement(By.xpath("(//text[@class='placeHolderMainText'])[1]"));
		fromTextField.clear();
		fromTextField.sendKeys("pune");
		driver.findElement(By.xpath("//ul/li[2]/div/text[1]")).click();
		
		WebElement toTextField = driver.findElement(By.xpath("(//text[@class='placeHolderMainText'])[2]"));
		toTextField.clear();
		toTextField.sendKeys("goa");
		driver.findElement(By.xpath("//ul/li[3]/div/text[1]")).click();
		
		driver.findElement(By.cssSelector(".labelCalendarContainer>i")).click();
		
		driver.findElement(By.id("search_button")).click();
		
		


	}

}
