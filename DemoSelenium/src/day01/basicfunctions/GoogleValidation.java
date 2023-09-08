package day01.basicfunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleValidation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./executables/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		System.out.println("Current Page Title: "+driver.getTitle());
		String exp_url = "https://www.google.com/";
		String act_url= driver.getCurrentUrl();
		System.out.println("Expected Url is: "+exp_url);
		System.out.println("Actual Url is: "+act_url);
		if(act_url.equals(exp_url))
		{
			System.out.println("test case passed");
		}else {
			System.out.println("test case failed");
		}
		
		System.out.println("Current Page source length: "+driver.getPageSource().length());
		driver.close();

	}

}
