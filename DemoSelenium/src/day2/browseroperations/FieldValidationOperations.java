package day2.browseroperations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FieldValidationOperations {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./executables/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		//identify FN field and perform validations
		WebElement firtNameTextField = driver.findElement(By.className("form-control"));

		System.out.println("firtNameTextField is displayed or not: "+firtNameTextField.isDisplayed());
		System.out.println("firtNameTextField is enabled or not: "+firtNameTextField.isEnabled());
		String firtNameTextFieldValue = firtNameTextField.getAttribute("placeholder");
		System.out.println("default value validation: "+firtNameTextFieldValue.equals("First Name"));

		//identify male radiobutton field and perform validations
		WebElement maleRadioButton = driver.findElement(By.name("radiooptions"));

		System.out.println("maleRadioButton is displayed or not: "+maleRadioButton.isDisplayed());
		System.out.println("maleRadioButton is enabled or not: "+maleRadioButton.isEnabled());
		System.out.println("maleRadioButton is selected or not: "+maleRadioButton.isSelected());
		maleRadioButton.click();
		System.out.println("maleRadioButton is selected or not: "+maleRadioButton.isSelected());
		
		//identify submit button and perform validations
				WebElement submitButton = driver.findElement(By.id("submitbtn"));

				System.out.println("submitButton is displayed or not: "+submitButton.isDisplayed());
				System.out.println("submitButton is enabled or not: "+submitButton.isEnabled());
				String actualButtonName = submitButton.getText().trim();
				System.out.println("submitButton name validation status: "+actualButtonName.equals("Submit"));
				driver.close();

		

	}

}
