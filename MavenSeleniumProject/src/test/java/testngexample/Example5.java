package testngexample;

import org.testng.annotations.Test;

public class Example5 {
	@Test(priority = 1)
	public void createNewSavinsAccount() {
		System.out.println("Signed in");
		int i=10/0;
		System.out.println(i);
	}

	@Test(dependsOnMethods="createNewSavinsAccount")
	public void createNewCurrentAccount() {
		System.out.println("Logged in");
		
	}
	@Test(priority = 3)
	public void createNewDmatAccount() {
		System.out.println("Logged out");
	}
	@Test
	public void tc4() {
		System.out.println("Tc4");
	}
}
