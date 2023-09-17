package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumUtility {

	public static WebDriver driver;
	public static WebDriverWait wait;
	protected Properties properties;
	protected Actions action;
	protected FileInputStream fis;
	protected static String filePath;
	
	static
	{
		filePath= System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\testAppData.properties";
	}
	
	public WebDriver setUp(String browserName, String appUrl)
	{
		properties=new Properties();
		try
		{
			fis= new FileInputStream(filePath);
			properties.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,20);
		driver.get(appUrl);
		action = new Actions(driver);	
		return driver;
	}
	
	public String getValueFromPropertyFile(String key)
	{
		return properties.getProperty(key);
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public void typeInput(WebElement element, String input)
	{
		waitForElementDisplayed(element);
		element.clear();
		element.sendKeys(input);
	}
	
	public void clickOnElement(WebElement element)
	{
		waitForElementToBeClickable(element);
		element.click();
	}
	
	public void performMouseHoverOperation(WebElement element)
	{
		action.moveToElement(element).perform();
	}
	
	public void performRightClickOperation(WebElement element)
	{
		action.moveToElement(element).contextClick().build().perform();
	}
	
	public void takeScreenshotOfThePage(String location)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(file, new File(location));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public String getRequiredAttributeValue(WebElement element,String attribute)
	{
		waitForElementDisplayed(element);
		setSleepTime(2000);
		return element.getAttribute(attribute);
	}
	
	
	public String getCurrentTitleOfApplication(String title)
	{
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
	public String getCurrentTitleOfApplication()
	{
		return driver.getTitle();
	}
	
	public String getCurrentUrlOfApplication()
	{
		return driver.getCurrentUrl();
	}
	
	public boolean isElementExist(WebElement element)
	{
		waitForElementDisplayed(element);
		return element.isDisplayed();
	}
	
	public boolean isCheckBoxSelected(WebElement element)
	{
		waitForElementDisplayed(element);
		return element.isSelected();
	}
	
	public void handleHtmlDropdownListWithVisibleText(WebElement element, String visibleText)
	{
		waitForElementDisplayed(element);
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	public void handleHtmlDropdownListWithIndex(WebElement element, int index)
	{
		waitForElementDisplayed(element);
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	protected List<WebElement> getHtmlDropdownListSize(WebElement element)
	{
		waitForElementDisplayed(element);
		Select select = new Select(element);
		return select.getOptions();
	}
	
	protected WebElement getFistSelectedOptionFromHtmlDropdown(WebElement element)
	{
		waitForElementDisplayed(element);
		Select select = new Select(element);
		return select.getFirstSelectedOption();
	}
	
	protected List<WebElement> getAllSelectedOptionsFromMultielectDropdownList(WebElement element)
	{
		waitForElementDisplayed(element);
		Select select = new Select(element);
		return select.getAllSelectedOptions();
	}
	
	protected void switchToFrameWithWebElement(WebElement element)
	{
		waitForElementDisplayed(element);
		driver.switchTo().frame(element);
	}
	
	protected void switchToFrameWithIndex(int index)
	{
		driver.switchTo().frame(index);
	}
	
	protected void switchFromFrameToMainPage()
	{
		driver.switchTo().defaultContent();
	}
	
	protected void setSleepTime(long millis)
	{
		try
		{
			Thread.sleep(millis);
		}
		catch(InterruptedException e)
		{
			
		}
	}
	
	protected void refreshPage()
	{
		driver.navigate().refresh();
	}
	
	public void waitForElementDisplayed(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeClickable(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement getActiveElementFromUI()
	{
		return driver.switchTo().activeElement();
	}
	
	public void cleanUp()
	{
		driver.close();
	}
	
	public void cleanUpAll()
	{
		driver.quit();
	}
}
