package testngexample;

import org.testng.annotations.Test;

public class Example2 {
	@Test(enabled = false)
	public void tc1() {
		System.out.println("Tc1");
	}

	@Test(enabled=true)
	public void tc2() {
		System.out.println("Tc2");
		
	}
	@Test(enabled=true)
	public void tc3() {
		System.out.println("Tc3");
	}
	@Test(enabled=false)
	public void tc4() {
		System.out.println("Tc4");
	}
}
