package testngexample;

import org.testng.annotations.Test;

public class Example4 {
	@Test(invocationCount=3)
	public void testSignIn() {
		System.out.println("signed in");
	}

	}
