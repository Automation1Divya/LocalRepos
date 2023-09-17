package testngexample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BeforeAfterClass {
  @BeforeClass
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
  @AfterClass
  public void afterTestEg() {
	  System.out.println("logged out");
  }
}
