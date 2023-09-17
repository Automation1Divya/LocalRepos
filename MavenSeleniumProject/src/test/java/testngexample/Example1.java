package testngexample;

import org.testng.annotations.Test;

public class Example1 {
	@Test
	public void tc1() {
		System.out.println("Tc1");
	}

	@Test
	public void tc2() {
		System.out.println("Tc2");
		tc3();
	}

	public void tc3() {
		System.out.println("Tc3");
	}
}
