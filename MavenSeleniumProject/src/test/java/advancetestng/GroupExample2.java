package advancetestng;

import org.testng.annotations.Test;

public class GroupExample2 {
  @Test(groups="Regression")
  public void testLogin() {
	  System.out.println("Iam Login - and in Regression group");
  }
  
  @Test(groups="Smoke Test")
  public void testSignIn() {
	  System.out.println("Iam SignIn - and in Smoke Test group");
  }
  
  @Test(groups="Sanity Test")
  public void testPIM() {
	  System.out.println("Iam PIM - and in Sanity Test group");
  }
  
  @Test(groups="Regression")
  public void testLeads() {
	  System.out.println("Iam Leads - and in Regression group");
  }
  
  @Test(groups="Smoke Test")
  public void testTask() {
	  System.out.println("Iam Task - and in Smoke Test group");
  }
}
