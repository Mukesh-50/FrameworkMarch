package com.learnautomation.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory 
{
	
	
	public static WebDriver startBrowser(String browserName,String url)
	{
		WebDriver driver = null;
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox") || browserName.equalsIgnoreCase("FF"))
		{
			try 
			{
				WebDriverManager.firefoxdriver().setup();
			} catch (Error e) 
			{
				System.out.println("Failed to download driver automatically "+e.getMessage());
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Driver/geckodriver.exe");
			}
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Sorry -Only Chrome,FF, Edge is supported for execution");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		System.out.println("**** Session Started ****");
		
		return driver;
	}
	
	public WebDriver startBrowserHeadless(String browserName,String url)
	{
		WebDriver driver = null;
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox") || browserName.equalsIgnoreCase("FF"))
		{
			try 
			{
				WebDriverManager.firefoxdriver().setup();
			} catch (Error e) 
			{
				System.out.println("Failed to download driver automatically "+e.getMessage());
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Driver/geckodriver.exe");
			}
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Sorry -Only Chrome,FF, Edge is supported for execution");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		System.out.println("**** Session Started ****");
		
		return driver;
	}

}
