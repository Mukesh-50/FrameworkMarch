package com.learnautomation.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentReports extent;
	
	
	public static ExtentReports getInstance()
	{
		if(extent==null)
		{
			extent=createInstance(System.getProperty("user.dir")+"/Reports/AutomationReport_"+System.currentTimeMillis()+".html");
		}	
		return extent;
	}
	
	
	public static ExtentReports createInstance(String fileName)
	{
		ExtentSparkReporter reporter=new ExtentSparkReporter(fileName);
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Sprint 1 Report");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		
		return extent;
	}

}
