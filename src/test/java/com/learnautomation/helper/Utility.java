package com.learnautomation.helper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility 
{

	public static void sleep(int second)
	{
	System.out.println("LOG:INFO- Waiting for "+second +" Seconds");	
		
		try 
		{
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
		
			
		}
	}
	

	public static String captureScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String path=System.getProperty("user.dir")+"/Screenshots/Automation"+ System.currentTimeMillis()+".png";
		
		File dest=new File(path);
		
		try 
		{
			FileHandler.copy(src, dest);
			
		} catch (IOException e) 
		{
			System.out.println("Failed to capture screenshots "+e.getMessage());
		}
		
		return path;
	}
	
	public static String captureScreenshotBase64(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		String base64=ts.getScreenshotAs(OutputType.BASE64);
	
		System.out.println("LOG:INFO- Screenshot captured in Base64 format");
		
		return base64;
	}

	
	
	public static WebElement waitForWebElement(WebDriver driver,By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static WebElement waitForWebElement(WebDriver driver,By locator,int seconds)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

}
