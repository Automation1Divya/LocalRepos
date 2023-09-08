package day02.handlingradiobtnandcheckbox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.SeleniumUtil;

public class RadiobtnDemo {

	public static void main(String[] args) {
		WebDriver driver = SeleniumUtil.setUp("chrome","https://www.letskodeit.com/practice");
		 
		List<WebElement> radioBtns = driver.findElements(By.cssSelector("input[type='radio']"));
				
		System.out.println("Total mainMenuName count:"+radioBtns.size());
		for(int i=0;i<radioBtns.size();i++)
		{
			System.out.println((i+1) +" radioBtn name is : "+radioBtns.get(i).getAttribute("value"));
			System.out.println((i+1) +" radioBtn selection status is : "+radioBtns.get(i).isSelected());
			System.out.println((i+1) +" radioBtn Functional status is : "+radioBtns.get(i).isEnabled());
			System.out.println((i+1) +" radioBtn Display status is : "+radioBtns.get(i).isDisplayed());
			radioBtns.get(i).click();
			System.out.println((i+1) +" radioBtn after selection status is : "+radioBtns.get(i).isSelected());
		}
		driver.close();
	}

}
