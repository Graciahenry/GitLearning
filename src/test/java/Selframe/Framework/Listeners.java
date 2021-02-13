package Selframe.Framework;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends base implements ITestListener{

	public WebDriver driver;
	ExtentTest Test;
	//ExtentReports extentRep= base.Reports();
	ExtentReports extentRep =Reports();
	//fileName = base.getScreenShotPath();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		  String testName= result.getMethod().getMethodName(); 
		   Test= extentRep.createTest(testName);
		   extentTest.set(Test);
		  
		 
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test passed");
		
		 ITestListener.super.onTestSuccess(result);
		 
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String testMethodName= result.getMethod().getMethodName();
		try {
			driver= (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver),result.getMethod().getMethodName());
			getScreenShotPath(testMethodName,driver);
		} catch(Exception e)
		{
			
		}
		extentTest.get().fail(result.getThrowable());
		//ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//System.out.println("Context Name = " + context.getName());
	
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		ITestListener.super.onFinish(context);
		//System.out.println("Context Name = " + context.getPassedTests());
		extentRep.flush();
	}

}
