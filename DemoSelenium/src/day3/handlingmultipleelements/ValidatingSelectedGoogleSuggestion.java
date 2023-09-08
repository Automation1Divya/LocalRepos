package day3.handlingmultipleelements;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidatingSelectedGoogleSuggestion {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./executables/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Testing interview questions");
		List<WebElement> suggestionList = driver.findElements(By.cssSelector(".G43f7e>li>div>*:nth-child(2)>div>*:first-child>span"));
		System.out.println("Total suggestion count:"+suggestionList.size());
		for(int i=0;i<suggestionList.size();i++)
		{
			suggestionList = driver.findElements(By.cssSelector(".G43f7e>li>div>*:nth-child(2)>div>*:first-child>span"));
			
			WebElement suggestion = suggestionList.get(i);
			if(suggestion.getText().equals("testing interview questions for freshers"))
			{
				suggestion.click();
				break;
			}
		}
		
		String expTitle= "testing interview questions for freshers - Google Search";
		String actualTitle= driver.getTitle();
		System.out.println("validation of search page: "+actualTitle.contains(expTitle));
		/*if(actualTitle.equals(expTitle))
		{
			System.out.println("Test case passed");
		}
		else
		{
			System.out.println("Test case failed");
		}*/
		driver.close();

	}

}
