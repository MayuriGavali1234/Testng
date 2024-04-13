package com.qc.testng.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends BaseIntegration {
	
	@BeforeMethod
	public void locateElement()
	{
		if(driver.getTitle().equals("Queue Codes | Log in"))
		{
		rePageLink = driver.findElement(By.linkText("Register a new membership"));
		 rePageLink.click();
		}
		rName = driver.findElement(By.id("name"));
		rName.clear();
	    rMobile = driver.findElement(By.id("mobile"));
	    rMobile.clear();
	    rEmail = driver.findElement(By.id("email"));
	    rEmail.clear();
	    rPass = driver.findElement(By.id("password"));
	    rPass.clear();
	    rSignin = driver.findElement(By.xpath("//button[@type='submit']"));
		
	}
	 @Test(dataProvider = "registerData")
	 public void doRegister(String testName, String uName, String uMobile, String uEmail, String uPass)
	 {
		 tName = testName;
		 rName.sendKeys(uName);
		 rMobile.sendKeys(uMobile);
		 rEmail.sendKeys(uEmail);
		 rPass.sendKeys(uPass);
		 rSignin.click();
		 
	 }
	 
	 @AfterMethod
	 public void doAssert()
	 {
		 if(tName.equals("All are valid"))
		 {
			  actResult = handleAlert();
			 exResult = "User registered successfully.";
		 }
	 
		 else
		 {
			 actResult = driver.getTitle();
			 exResult ="Queue Codes | Registration Page";
		 }
		 Assert.assertEquals(actResult, exResult);
	 }

		 public String handleAlert()
		 {
			 Alert alt = driver.switchTo().alert();
			 String altText = alt.getText();
			 alt.accept();
			 return altText;
		 }
		 
		 @AfterSuite
	      public void tearDowm()
	      {
	    	  driver.quit();
	      }
	
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	

}
