package com.learnautomation.unittest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;

public class TestDriver extends BaseClass
{
	@Test
	public void adminLogin()
	{
		Assert.assertNotNull(driver);
	}

}
