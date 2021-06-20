package com.learnautomation.listeners;

import java.io.IOException;
import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.learnautomation.helper.Utility;

public class ExtentTestNGITestListener implements ITestListener {

	
	ExtentReports report=ExtentManager.getInstance();
	
	ExtentTest child;
	
	ThreadLocal<ExtentTest> parentTest=new ThreadLocal<ExtentTest>();
	

	public synchronized void onStart(ITestContext context) 
	{
	

	}

	public synchronized void onFinish(ITestContext context) 
	{
		
		report.flush();
		
		System.out.println("LOG:INFO- Test Suite Completed");

	}

	public synchronized void onTestStart(ITestResult result) 
	{
		System.out.println("LOG:INFO- Test Started "+result.getMethod().getMethodName());
		
		ExtentTest logger=report.createTest(result.getMethod().getMethodName());
		
		parentTest.set(logger);

	}

	public synchronized void onTestSuccess(ITestResult result) 
	{
		System.out.println("LOG:INFO- Test Passed "+result.getMethod().getMethodName());
		parentTest.get().pass("Test Passed");
		
	}

	public synchronized void onTestFailure(ITestResult result) 
	{
		WebDriver driver=null;
		
	
		
		try 
		{
			
			//WebDriver driver1=driver= (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			
			Field f=result.getTestClass().getRealClass().getDeclaredField("driver");
			
			Object obj=f.get(result.getInstance());
			
			driver=(WebDriver)obj;
			
			System.out.println("Driver value using reflection "+driver);
			
		}  catch (Exception e1) 
		{
			System.out.println("Failed to capture dynamic values");
		}
		
		System.out.println("LOG:INFO- Test Failed "+result.getMethod().getMethodName());
		
		System.out.println("LOG:INFO- Failure Reason "+result.getThrowable().getMessage());
		
		System.out.println("Driver value is "+driver);
		
		try 
		{
			parentTest.get().fail("Test failed "+result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.captureScreenshotBase64(driver)).build());
			System.out.println("LOG:INFO- Screenshot added in report");
			
		} catch (IOException e) 
		{
			System.out.println("Failed to capture/attach screenshot "+e.getMessage());
		}
	}

	public synchronized void onTestSkipped(ITestResult result) {
		
		System.out.println("LOG:INFO- Test Skipped "+result.getMethod().getMethodName());
		parentTest.get().skip("Test skipped");
	}

	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

}
