package com.qc.testng.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginMVn extends BaseIntegration {
	
	@BeforeSuite
	public void setup() throws IOException
	{
		doSetup();
	}
	
	@BeforeMethod
	public void locateElement()
	{
		email = driver.findElement(By.id("email"));
		email.clear();
		pass = driver.findElement(By.id("password"));
		pass.clear();
		singin = driver.findElement(By.id("submit"));
	}
         
	
	@Test(dataProvider = "loginData")
	public void doLogin(String testName, String uName, String uPass)
	{
		tName = testName;
		email.sendKeys(uName);
		pass.sendKeys(uPass);
		singin.click();
	}
	
	@AfterMethod
	public void doAssert() throws InterruptedException
	{    
		Thread.sleep(2000);
		String actResult = driver.getTitle();
		String exResult;
		if(tName.equals("Both are valid"))
		{
			 exResult = "Queue Codes | Dashboard";
			 doLogout();
		}
		else
		{
			exResult = "Queue Codes | Log in";
		}
		 
		Assert.assertEquals(actResult, exResult);
		
	}
	
	public void doLogout()
	{
		logout = driver.findElement(By.id("hlogout"));
		logout.click();
	}
	
	@AfterSuite
    public void tearDowm()
    {
  	  driver.quit();
    }

	
	
	
	
	

}
