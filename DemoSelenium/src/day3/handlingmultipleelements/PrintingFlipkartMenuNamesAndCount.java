package day3.handlingmultipleelements;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import utilities.SeleniumUtil;

public class PrintingFlipkartMenuNamesAndCount extends SeleniumUtil {
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = setUp("chrome","https://www.flipkart.com/");
		driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
		//List<WebElement> mainMenuNames = driver.findElements(By.cssSelector("._37M3Pb>div>a>*:nth-child(2)"));
		List<WebElement> mainMenuNames = driver.findElements(By.cssSelector("._3sdu8W>*>div>div>span>*:nth-child(1)"));		
		
		System.out.println("Total mainMenuName count:"+mainMenuNames.size());
		for(int i=0;i<mainMenuNames.size();i++)
		{
			System.out.println((i+1) +" MenuNames is : "+mainMenuNames.get(i).getText());
		}
		driver.close();

	}

}
