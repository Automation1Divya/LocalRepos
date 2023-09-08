package day1.browseropening;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ActitimeLoginLogout {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = setUp("chrome");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		
		String expTitle="actiTIME - Enter Time-Track";
		
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.titleIs(expTitle));
		 
//		FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
//		wait.until(ExpectedConditions.titleIs(expTitle));
		
		String actualTitle = driver.getTitle();
		System.out.println("Expected Home Page Title"+expTitle);
		System.out.println("Actual Home Page Title"+expTitle);
		if(actualTitle.equals(expTitle))
		{
			System.out.println("test case passed allowed to logout");
			driver.findElement(By.id("logoutLink")).click();
			driver.close();

		}
		else {
			System.out.println("test case failed not allowed to logout");
		}

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
