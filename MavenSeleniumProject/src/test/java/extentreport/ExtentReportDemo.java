package extentreport;

import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportDemo {
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
		test=report.startTest("TestCase1");
		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Test case 1 is passed");
	}
	
	@Test
	public void testCase2() throws IOException
	{
		test=report.startTest("TestCase2");
		Assert.assertTrue(false);
		test.log(LogStatus.FAIL, "Test case 2 is failed");
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
	
}

