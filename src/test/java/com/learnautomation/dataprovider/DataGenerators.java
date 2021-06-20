package com.learnautomation.dataprovider;

import org.testng.annotations.DataProvider;

public class DataGenerators 
{

	@DataProvider(name="login")
	public static Object[][] getLogins()
	{
		return ExcelReader.getDataFromExcel("Admin");
	}
	
	
	@DataProvider(name="user")
	public static Object[][] getUser()
	{
		return ExcelReader.getDataFromExcel("User");
	}
	
}
