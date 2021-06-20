package com.learnautomation.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	static Properties pro;
	
	public static String getProperty(String key)
	{
		createInstance();
		return pro.getProperty(key);
	}
	
	
	public static String getBrowser()
	{
		createInstance();
		return pro.getProperty("Browser");
	}
	
	
	public static String getURL()
	{
		createInstance();
		return pro.getProperty("url");
	}
	
	public static Properties createInstance()
	{
		if(pro==null)
		{
			System.out.println("LOG:INFO- No property object found - Creating fresh instance");
			
			pro=new Properties();
			
			try 
			{
				pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/Config/Config.properties")));
			} 
			catch (FileNotFoundException e) 
			{
				System.out.println("Could not find the file "+e.getMessage());
			} 
			catch (IOException e) {
				
				System.out.println("Could not load the file "+e.getMessage());
			}
			
			return pro;
		}
		else
		{
			System.out.println("LOG:INFO- Existing object found - Reusing the existing ");
			return pro;
		}
		
	}

}
