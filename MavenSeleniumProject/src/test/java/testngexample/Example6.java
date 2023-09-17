package testngexample;

import org.testng.annotations.Test;

public class Example6 {
	@Test(priority = 1,expectedExceptions=ArithmeticException.class)
	public void testSignIn() {
		int i=10/0;
		System.out.println(i);
		System.out.println("Signed in");
	}

	@Test(priority = 3,description="this is login method")
	public void testLogin() {
		System.out.println("Logged in");
		
	}
	@Test(priority = 3,timeOut=2000)
	public void testLogout() throws InterruptedException {
		System.out.println("Logged out");
		Thread.sleep(3000);
	}
	
}
