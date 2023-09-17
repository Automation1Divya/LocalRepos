package testngexample;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAfterMethod {
  @BeforeMethod
  public void beforeTestEg() {
	  System.out.println("logged in");
  }
  @Test
  public void testPIMCreation() {
	  System.out.println("created");
  }
  @Test
  public void testPIMDeletion() {
	  System.out.println("deleted");
  }
  @AfterMethod
  public void afterTestEg() {
	  System.out.println("logged out");
  }
}
