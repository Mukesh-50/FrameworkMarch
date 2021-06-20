package com.learnautomation.unittest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.dataprovider.ExcelReader;

public class DataProviderTest 
{

	@Test
	public void loadExcel()
	{
		
		ExcelReader excel=new ExcelReader();
		
		Assert.assertNotNull(excel.getData("Admin", 0,0));
		
	}
	
	
}
