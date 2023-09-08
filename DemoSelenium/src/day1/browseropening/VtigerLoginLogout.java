package day1.browseropening;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VtigerLoginLogout {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = setUp("chrome");
		driver.get("https://demo.vtiger.com/vtigercrm/index.php");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement un= driver.findElement(By.id("username"));
		un.clear();
		un.sendKeys("admin");
		WebElement pwd= driver.findElement(By.name("password"));
		pwd.clear();
		pwd.sendKeys("Test@123");
		driver.findElement(By.className("buttonBlue")).click();
		driver.findElement(By.className("userName")).click();
		driver.findElement(By.linkText("Sign Out")).click();
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
