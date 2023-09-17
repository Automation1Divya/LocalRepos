package testngexample;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Example7 {
	@BeforeSuite
	public void startUp() {
		System.out.println("*************Before suit*****************");
	}

	@Test
	public void testFB() {
		System.out.println("Logged in");
		
	}
	@AfterSuite
	public void endUp(){
		System.out.println("*************After suit*****************");
		
	}
	
}

