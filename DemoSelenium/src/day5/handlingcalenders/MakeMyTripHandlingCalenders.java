package day5.handlingcalenders;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.SeleniumUtil;

public class MakeMyTripHandlingCalenders extends SeleniumUtil{
	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {
		driver = setUp("chrome","https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[text()='Buses']")).click();
		
	    driver.findElement(By.id("fromCity")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("pune");
		driver.findElement(By.xpath("//span[contains(text(),'Pune, Maharashtra')]")).click();
		
		//WebElement toTextField = driver.findElement(By.id("toCity"));
		//toTextField.click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='To']")));		
		
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("mumbai");
		driver.findElement(By.xpath("//span[contains(text(),'Mumbai, Maharashtra')]")).click();
		
		driver.findElement(By.className("DayPicker-NavButton--next")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='9']")).click();
		driver.findElement(By.id("search_button")).click();
		//wait.until(ExpectedConditions.titleIs("MakeMyTrip Bus"));
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".dropdownWrap>li:nth-of-type(4) span")).click();
		driver.findElement(By.xpath("//span[text()='Wakad']")).click();
		driver.findElement(By.xpath("//span[text()='6 PM to 11 PM']")).click();
		driver.findElement(By.xpath("//body")).sendKeys(Keys.HOME);
		driver.findElement(By.linkText("VIEW BUSES")).click();
		
		List<WebElement> busList= driver.findElements(By.cssSelector(".bus-card .makeFlex.hrtlCenter.appendBottom8>span:first-child"));
		List<WebElement> busPrice= driver.findElements(By.cssSelector(".makeFlex.column.end>*:nth-child(2)>span"));
		
				System.out.println(busList.size());
		for(int i=0;i<busList.size();i++)
		{
			System.out.println("Bus name: "+busList.get(i).getText()+" Price is: "+busPrice.get(i).getText());
		}
		driver.close();
	}

}
