package com.learnautomation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;

public class GoogleHome extends BaseClass{
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		driver=getDriver();
	}
	
	@Test
	public void googleSearch()
	{
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium 4 Beta 3");
	}

}
