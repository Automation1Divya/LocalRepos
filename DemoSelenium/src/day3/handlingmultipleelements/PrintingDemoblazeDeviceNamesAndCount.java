package day3.handlingmultipleelements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintingDemoblazeDeviceNamesAndCount {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./executables/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		
		List<WebElement> deviceNames = driver.findElements(By.cssSelector("#tbodyid>div>div>div>h4>a"));
		List<WebElement> devicePrice = driver.findElements(By.cssSelector("#tbodyid>div>div>div>h5"));
		
		System.out.println("Total Device count:"+deviceNames.size());
		for(int i=0;i<deviceNames.size();i++)
		{
			System.out.println((i+1) +" DeviceName is : "+deviceNames.get(i).getText()+"  Price is : "+ devicePrice.get(i).getText());
		}
		driver.close();

	}

}
