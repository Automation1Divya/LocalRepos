package testngexample;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAfterTest {
  @BeforeTest
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
  @AfterTest
  public void afterTestEg() {
	  System.out.println("logged out");
  }
}
