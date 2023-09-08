package day01.basicfunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActitimeValidation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./executables/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		System.out.println("Current Page Title: "+driver.getTitle());
		String exp_url = "https://demo.actitime.com/";
		String act_url= driver.getCurrentUrl();
		System.out.println("Current Url is: "+act_url);
		if(act_url.contains(exp_url))
		{
			System.out.println("test case passed");
		}else {
			System.out.println("test case failed");
		}
		
		System.out.println("Current Page source length: "+driver.getPageSource().length());
		driver.close();

	}

}
