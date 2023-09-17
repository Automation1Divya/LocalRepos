package extentreport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.SeleniumUtility;

public class ExtentDemo extends SeleniumUtility{
	static ExtentTest test;
	static ExtentReports report;
	@BeforeTest
	public static void startTest()
	{
		report= new ExtentReports("./ExtentReport/ExtentReportResult.html");
		report.addSystemInfo("Host Name","Divya")
			  .addSystemInfo("Environment","Dev")
			  .addSystemInfo("User Name","Divya Shinde");
	}
	@Test
	public void testCase1() throws IOException
	{
		test=report.startTest("GooglePageValidation-valid");
		WebDriver driver=setUp("chrome","https://www.google.com/");
		if(getCurrentTitleOfApplication().equals("Google"))
		{
			test.log(LogStatus.PASS, test.addScreenCapture(screenShot(driver)),"Navigated to the specified url successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShot(driver)),"Google page validation got failed");
			Assert.assertTrue(getCurrentTitleOfApplication().equals("Google"));
		}
		cleanUp();
	}
	
	@Test
	public void testCase2() throws IOException
	{
		test=report.startTest("GooglePageValidation-valid");
		WebDriver driver=setUp("chrome","https://www.google.com/");
		if(getCurrentTitleOfApplication().equals("Google1"))
		{
			test.log(LogStatus.PASS, test.addScreenCapture(screenShot(driver)),"Navigated to the specified url successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShot(driver)),"Google page validation got failed");
			Assert.assertTrue(getCurrentTitleOfApplication().equals("Google1"));
		}
		cleanUp();
	}
	
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, "Test case failed is: "+result.getName());
			test.log(LogStatus.FAIL, "Test case failed due to: "+result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(LogStatus.SKIP, "Test case Skipped is: "+result.getName());
		}
		report.endTest(test);
	}
	
	@AfterTest
	public static void endTest()
	{
		report.flush();
		report.close();
	}
	
	public static String screenShot(WebDriver driver) throws IOException
	{
		File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/../screenshots/"+System.currentTimeMillis()+".png");
		String errflpath= dest.getAbsolutePath();
		FileUtils.copyFile(srcFile, dest);
		return errflpath;
	}
}
