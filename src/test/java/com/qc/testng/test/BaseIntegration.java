package com.qc.testng.test;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.qc.testng.Utils.TestUtil;



public class BaseIntegration {
 
	
		//TestUtil test = new TestUtil();
	     TestUtil test = new TestUtil();
		Properties prop;
		WebDriver driver;
		WebElement email, pass, singin, logout;
		WebElement rePageLink, rName,rMobile, rEmail, rPass, rSignin;
		String tName, actResult, exResult; 
		
		@BeforeSuite
		public void doSetup() throws IOException
		{
			prop = test.readProp();
			if(prop.getProperty("browser").endsWith("chrome"))
			{
				driver = new ChromeDriver();
				
			}
			else if(prop.getProperty("browser").endsWith("edge"))
			{
				driver = new EdgeDriver();
				
			}
			else
			{
				driver = new FirefoxDriver();
			}
			 driver.manage().window().maximize();
			 driver.get(prop.getProperty("siteUrl"));
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				
		}
		
		@DataProvider
		public Object[][] loginData() throws IOException 
		{
			return test.readData("Sheet1");
		}
		@DataProvider
		public Object[][] registerData() throws IOException
		{
			return test.readData("Sheet2");
		}
	      


}


