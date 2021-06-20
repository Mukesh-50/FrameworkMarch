package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learnautomation.helper.Utility;

public class Logout {
	
	WebDriver driver;
	
	public Logout(WebDriver driver)
	{
		this.driver=driver;
	}

	By welcome=By.xpath("//a[contains(text(),'Welcome')]");
	
	By logoutLink=By.xpath("//a[contains(text(),'Logout')]");
	
	public String logoutFromApplication()
	{
		Utility.waitForWebElement(driver, welcome).click();
		
		Utility.waitForWebElement(driver, logoutLink, 60).click();
		
		return driver.getCurrentUrl();
	}
	
}
