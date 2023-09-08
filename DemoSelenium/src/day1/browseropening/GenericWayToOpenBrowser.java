package day1.browseropening;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GenericWayToOpenBrowser {

	public static void main(String[] args) {
		WebDriver driver = setUp("firefox");
		driver.get("https://www.google.com");
		System.out.println("Current Page source : "+driver.getPageSource());
		System.out.println("Current Url is: "+driver.getCurrentUrl());
		System.out.println("Current Page Title: "+driver.getTitle());
		System.out.println("Current Page source length: "+driver.getPageSource().length());
		driver.close();
	}
		
		public static WebDriver setUp(String browserName)
		{
			if(browserName.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./executables/chromedriver.exe");
				return new ChromeDriver();
			}
			
			else if(browserName.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "./executables/geckodriver.exe");
				return new FirefoxDriver();
			}
			return null;
		}

}
