package com.learnautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataprovider.DataGenerators;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.pages.Logout;


public class LoginTest2 extends BaseClass
{
	
	@Test(priority=1,description="Validating admin login fun",dataProviderClass=DataGenerators.class,dataProvider="login")
	public void adminLoginTest(String username, String password)
	{
		LoginPage login= PageFactory.initElements(driver, LoginPage.class);
		
		String url=login.loginApplication(username,password);
		
		Assert.assertTrue(url.contains("dashboard"));
		
		Logout logOut=PageFactory.initElements(driver, Logout.class);
		
		Assert.assertTrue(logOut.logoutFromApplication().contains("login"));
	}
	
}
