package day7.colourfontvalidation;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.SeleniumUtil;

public class ValidateByPosition {
	static WebDriver driver;
	static WebDriverWait wait;
	
	public static void main(String[] args) {
		driver = SeleniumUtil.setUp("chrome","https://demo.actitime.com/login.do");
		driver.findElement(By.id("loginButton")).click();
		wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.attributeToBe(By.cssSelector(".errormsg"), "class", "errormsg"));
		WebElement errormsg = driver.findElement(By.cssSelector(".errormsg"));
		//get point class oject using getLocation method
		Point errorCord = errormsg.getLocation();
		int errorxCord = errorCord.getX();
		int erroryCord = errorCord.getY();
		System.out.println("Msg x-: "+errorxCord+ "Msg y - :"+erroryCord);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
		WebElement usernameIF = driver.findElement(By.id("username"));
		Point unCord = usernameIF.getLocation();
		int unxCord = unCord.getX();
		int unyCord = unCord.getY();
		System.out.println("UN x-: "+unxCord+ "UN y - :"+unyCord);
		System.out.println("is error msg getting displayed above username input field:"+(erroryCord < unyCord));
		driver.close();
		
	}

}
