package testngexample;

import org.testng.annotations.Test;

public class Example3 {
	@Test(priority = 1)
	public void tc1() {
		System.out.println("Tc1");
	}

	@Test(priority = 2)
	public void tc2() {
		System.out.println("Tc2");
		
	}
	@Test(priority = 3)
	public void tc3() {
		System.out.println("Tc3");
	}
	@Test
	public void tc4() {
		System.out.println("Tc4");
	}
}
