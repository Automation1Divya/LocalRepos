package day3.handlingmultipleelements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintingSuggestionsAndCount {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./executables/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("selenium");
		List<WebElement> suggestionList = driver.findElements(By.cssSelector(".G43f7e>li>div>*:nth-child(2)>div>*:first-child>span"));
		System.out.println("Total suggestion count:"+suggestionList.size());
		for(int i=0;i<suggestionList.size();i++)
		{
			System.out.println((i+1) +" suggestion is : "+suggestionList.get(i).getText());
		}
		driver.close();

	}

}
