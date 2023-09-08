package day3.handlingmultipleelements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintingMenusAutomationtesting {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./executables/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		List<WebElement> MenuNames = driver.findElements(By.cssSelector(".navbar-nav>li>a"));
				
		System.out.println("Total Device count:"+MenuNames.size());
		for(int i=0;i<MenuNames.size();i++)
		{
			System.out.println((i+1) +" DeviceName is : "+MenuNames.get(i).getText());
		}
		
		driver.close();


	}

}
