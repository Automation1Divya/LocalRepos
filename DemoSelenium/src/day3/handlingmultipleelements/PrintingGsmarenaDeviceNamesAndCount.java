package day3.handlingmultipleelements;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import utilities.SeleniumUtil;

public class PrintingGsmarenaDeviceNamesAndCount extends SeleniumUtil {
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = setUp("chrome","https://www.gsmarena.com/");
		 
		List<WebElement> deviceNames = driver.findElements(By.cssSelector(".brandmenu-v2>ul>li>a"));
				
		System.out.println("Total Device count:"+deviceNames.size());
		for(int i=0;i<deviceNames.size();i++)
		{
			System.out.println((i+1) +" DeviceName is : "+deviceNames.get(i).getText());
		}
		driver.close();

	}

}
