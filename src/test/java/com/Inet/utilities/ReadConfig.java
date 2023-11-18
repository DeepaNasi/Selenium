package com.Inet.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro; // we have to create an obj (pro) to class Properties
	
	
	//We have to create the constructor as same in page object class driver objebt
	public ReadConfig()
	{
		
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();//initiating pro obj
			pro.load(fis); // load is a method which will load the complete read file 
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
		
	}
	//now we have to create the different method to read the variable from config property just like page object calss
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
	String username=pro.getProperty("username");
	return username;
	}
	
	public String getPassword()
	{
	String password=pro.getProperty("password");
	return password;
	}
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}

	

}
