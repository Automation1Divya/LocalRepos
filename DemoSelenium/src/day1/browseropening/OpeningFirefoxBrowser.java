package day1.browseropening;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpeningFirefoxBrowser {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "./executables/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		System.out.println("Current Page source : "+driver.getPageSource());
		System.out.println("Current Url is: "+driver.getCurrentUrl());
		System.out.println("Current Page Title: "+driver.getTitle());
		System.out.println("Current Page source length: "+driver.getPageSource().length());
		driver.close();
	}

}
