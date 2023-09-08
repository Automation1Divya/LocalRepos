package day4.handlingdropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.SeleniumUtil;

public class HandlingMultiselectDropdown extends SeleniumUtil {
	static WebDriver driver;
	public static void main(String[] args) {
		
		driver = setUp("chrome","https://omayo.blogspot.com/");	
		Select selectDropdown = new Select(driver.findElement(By.id("multiselect1")));
		System.out.println("Is dropdown multiselect ? "+selectDropdown.isMultiple());
		
		List <WebElement> allOptions = selectDropdown.getOptions();
		System.out.println("Total options: "+allOptions.size());
		for(int i=0;i<allOptions.size();i++)
		{
			System.out.println("Option "+i+":"+allOptions.get(i).getText());
		}
		
		selectDropdown.selectByIndex(0);
		selectDropdown.selectByIndex(2);
		selectDropdown.selectByIndex(3);
		selectDropdown.selectByValue("Hyundaix");
		selectDropdown.selectByVisibleText("Audi");
		System.out.println("Already Selected value "+selectDropdown.getFirstSelectedOption().getText());
		List <WebElement> selectedCars = selectDropdown.getAllSelectedOptions();
		System.out.println("Total selected cars : "+selectedCars.size());
		
		/*selectDropdown.deselectByIndex(0);
		selectDropdown.deselectByValue("Hyundaix");
		selectDropdown.deselectByVisibleText("Audi"); */
		//or
		selectDropdown.deselectAll();
		driver.close();
	}

}
