package day1.browseropening;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class OpenChromeBrowser {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./executables/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("Current Page source : "+driver.getPageSource());
		System.out.println("Current Url is: "+driver.getCurrentUrl());
		System.out.println("Current Page Title: "+driver.getTitle());
		System.out.println("Current Page source length: "+driver.getPageSource().length());
		driver.close();
	}

}
