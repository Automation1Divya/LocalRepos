package day01.basicfunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookValidation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./executables/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		String exp_title = "Facebook – log in or sign up";
		String act_title= driver.getTitle();
		System.out.println("Expected Page Title is: "+exp_title);
		System.out.println("Actual Page Title is: "+act_title);
		if(act_title.equals(exp_title))
		{
			System.out.println("test case passed");
		}else {
			System.out.println("test case failed");
		}
		
		System.out.println("Current Page source length: "+driver.getPageSource().length());
		driver.close();

	}

}
