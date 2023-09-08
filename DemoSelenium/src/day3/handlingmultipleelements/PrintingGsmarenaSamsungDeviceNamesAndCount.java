package day3.handlingmultipleelements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PrintingGsmarenaSamsungDeviceNamesAndCount {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "./executables/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.gsmarena.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector(".brandmenu-v2>ul>li:nth-of-type(1)>a")).click();
		List<WebElement> deviceNames = driver.findElements(By.cssSelector(".makers>ul>li>a>*:nth-child(2)>span"));
				
		System.out.println("Total Device count:"+deviceNames.size());
		for(int i=0;i<deviceNames.size();i++)
		{
			System.out.println((i+1) +" DeviceName is : "+deviceNames.get(i).getText());
		}
		driver.close();

	}

}
