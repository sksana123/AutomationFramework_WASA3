package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {
	
	@Test(retryAnalyzer=vtiger.GenericUtilityes.RetryAnalyserImplementation.class)
	public void sample()
	{
		Assert.fail();
		System.out.println("hi");
	}

}
