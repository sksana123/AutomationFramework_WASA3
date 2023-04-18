package vtiger.GenericUtilityes;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener
{
	
	ExtentReports report;
	ExtentTest test;

	
	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
	String  methodname=	result.getMethod().getMethodName();
	test=report.createTest(methodname);
	test.log(Status.INFO, "--- test script execution started---");
	
	}

	
	public void onTestSuccess(ITestResult result)
	{
		// TODO Auto-generated method stub
		String  methodname=	result.getMethod().getMethodName();
		test.log(Status.PASS,methodname+ "--PASS--");
	
	}
	

	public void onTestFailure(ITestResult result)
	{
		// TODO Auto-generated method stub
		String  methodname=	result.getMethod().getMethodName();
		
		test.log(Status.FAIL, methodname+"--FAIL--");
		test.log(Status.INFO, result.getThrowable());
	
	
	WebDriverUtility wutil=new WebDriverUtility();
	
/*	String ScreenShotName=methodname+"-"+new JavaUtility().getSystemDateInFormat();

	try
	{
		
		 String path=wutil.takesScreenShot(BaseClass.sdriver, ScreenShotName);
		 test.addScreenCaptureFromPath(path);//go to screen shot location and it will attached to report
		 
	} 
	catch (IOException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
		
	}
	
	

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String  methodname=	result.getMethod().getMethodName();
		test.log(Status.SKIP, methodname+"---SKIP---");
		
	     test.log(Status.INFO, result.getThrowable());//print exception
		 
		 
	}

		
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onStart(ITestContext context)
	{
		// TODO Auto-generated method stub
		
		System.out.println("---excution started----");
		//Extent report configuration Report-05 Apr 2023-10-23-45.html
		ExtentSparkReporter htmlreporter=new ExtentSparkReporter(".\\ExtentReport\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlreporter.config().setDocumentTitle("Vtiger Execution Report ");
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setReportName("Automation excution Report");
		
		
		report=new ExtentReports();
		report.attachReporter(htmlreporter);
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base Browser", "FireFox");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Reporter-name", "sana");
		
		
		
	}

	
	

	public void onFinish(ITestContext context)
	{
		// TODO Auto-generated method stub
	
		System.out.println("---excution finished----");
		
		report.flush();//generate the report
	

		
	}
	
	
	

}
