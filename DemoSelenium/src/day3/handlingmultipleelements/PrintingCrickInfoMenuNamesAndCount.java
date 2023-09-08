package day3.handlingmultipleelements;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import utilities.SeleniumUtil;

public class PrintingCrickInfoMenuNamesAndCount extends SeleniumUtil {
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = setUp("chrome","https://www.espncricinfo.com/");
		 
		List<WebElement> mainMenuNames = driver.findElements(By.cssSelector(".ds-flex-1>.ds-flex-row>div>a"));
				
		System.out.println("Total mainMenuName count:"+mainMenuNames.size());
		for(int i=0;i<mainMenuNames.size();i++)
		{
			System.out.println((i+1) +" MenuNames is : "+mainMenuNames.get(i).getText());
		}
		driver.close();

	}

}
