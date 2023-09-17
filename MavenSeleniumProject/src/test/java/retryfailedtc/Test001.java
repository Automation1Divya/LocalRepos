package retryfailedtc;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test001 {
  static int num=6;
	@Test(retryAnalyzer=retryfailedtc.MyRetryAnalyzer.class)
  public void Test1() {
		Assert.assertEquals(false, true);
  }
	@Test
	public void Test2() {
		Assert.assertEquals(false, true);
  }
	@Test(retryAnalyzer=retryfailedtc.MyRetryAnalyzer.class)
	public void Test3() {
		num--;
		Assert.assertTrue(num<4);
  }
}
