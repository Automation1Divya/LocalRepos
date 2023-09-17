package advancetestng;

import org.testng.annotations.Test;

public class GroupExamples {
  @Test(groups="Regression")
  public void testCaseOne() {
	  System.out.println("Iam tc1 - and in Regression group");
  }
  
  @Test(groups="Smoke Test")
  public void testCaseTwo() {
	  System.out.println("Iam tc2 - and in Smoke Test group");
  }
  
  @Test(groups="Sanity Test")
  public void testCaseThree() {
	  System.out.println("Iam tc3 - and in Sanity Test group");
  }
  
  @Test(groups="Regression")
  public void testCaseFour() {
	  System.out.println("Iam tc4 - and in Regression group");
  }
  
  @Test(groups="Smoke Test")
  public void testCaseFive() {
	  System.out.println("Iam tc5 - and in Smoke Test group");
  }
}
