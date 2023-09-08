package day2.browseroperations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonBrowserOperations {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./executables/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Electronics")).click();
		String ExpPageTitle = "Electronics Store: Buy Electronics products Online at Best Prices in India at Amazon.in";
		String PageTitle = driver.getTitle();
		System.out.println("Navigated to Electronics section successfully? :"+PageTitle.equals(ExpPageTitle));
		driver.navigate().back();
		driver.findElement(By.linkText("Mobiles")).click();
		ExpPageTitle ="Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		 PageTitle = driver.getTitle();
		 System.out.println("Navigated to Mobile section successfully? :"+PageTitle.equals(ExpPageTitle));
		 driver.navigate().back();
		driver.navigate().forward();
		System.out.println("navigated forward successfully"+driver.getTitle());
		driver.close();

	}

}
