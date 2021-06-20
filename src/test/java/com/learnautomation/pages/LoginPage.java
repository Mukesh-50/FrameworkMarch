package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By username=By.id("txtUsername");
	By password=By.name("txtPassword");
	By loginButton=By.xpath("//input[@id='btnLogin']");
	
	
	public void typeUsername(String uname)
	{
		driver.findElement(username).sendKeys(uname);
	}
	

	public void typePassword(String pass)
	{
		driver.findElement(password).sendKeys(pass);
	}
	

	public void clickLogin()
	{
		driver.findElement(loginButton).click();
	}
	
	
	public String loginApplication(String uname,String pass)
	{
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
		
		return driver.getCurrentUrl();
	}
	
	public Logout loginApplicationNew(String uname,String pass)
	{
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
		
		Logout logOut=PageFactory.initElements(driver, Logout.class);
		
		return logOut;
	}
	
	

}
