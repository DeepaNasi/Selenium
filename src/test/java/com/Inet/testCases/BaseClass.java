package com.Inet.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.TakesScreenshot;

import com.Inet.utilities.ReadConfig;

public class BaseClass {
	//to read the variables from config.property files then we have to create the obj for read.config file 
	
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	// since we need to use this looger on all page so made it as public
	
	@Parameters("browser")
	@BeforeClass 
	public void setup(String br ) //since create the parameter setUp method will take one variable br
	{
		
		if(br.equals("chrome"))
		{		
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
				//System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver=new ChromeDriver();
		//create the logger class for the logs to genarate
		}
		
		else if (br.equals("firefox"))
		
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			
	driver=new FirefoxDriver();
			
		}
		else if	(br.equals("ie"))
			
			{
				System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
				
		driver=new InternetExplorerDriver();
				
			}
			
		
		
		logger = Logger.getLogger("ebanking");		
	   PropertyConfigurator.configure("log4j.properties");
		
				
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		
	}
	public void captureScreenshot(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Taken screenshot");
	}
	
	
	
}
