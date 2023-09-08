package day02.handlingradiobtnandcheckbox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.SeleniumUtil;

public class CheckboxDemo {

	public static void main(String[] args) {
		WebDriver driver = SeleniumUtil.setUp("chrome","https://www.letskodeit.com/practice");
		 
		List<WebElement> listOfCheckbox = driver.findElements(By.cssSelector("input[type='checkbox'][ name='cars']"));
				
		System.out.println("Total mainMenuName count:"+listOfCheckbox.size());
		for(int i=0;i<listOfCheckbox.size();i++)
		{
			System.out.println((i+1) +" Checkbox name is : "+listOfCheckbox.get(i).getAttribute("value"));
			System.out.println((i+1) +" Checkbox selection status is : "+listOfCheckbox.get(i).isSelected());
			System.out.println((i+1) +" Checkbox Functional status is : "+listOfCheckbox.get(i).isEnabled());
			System.out.println((i+1) +" Checkbox Display status is : "+listOfCheckbox.get(i).isDisplayed());
			listOfCheckbox.get(i).click();
			System.out.println((i+1) +" Checkbox after selection status is : "+listOfCheckbox.get(i).isSelected());
		}
		driver.close();
	}

}
