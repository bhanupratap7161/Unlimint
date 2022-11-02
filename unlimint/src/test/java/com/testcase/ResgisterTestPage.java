package com.testcase;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.ResgisterPage;

public class ResgisterTestPage extends TestBase 
{
	
	public ResgisterTestPage() throws IOException 
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		
	}
	@Test(priority=1)
	public void ValidateOrder() throws IOException 
	{
		ResgisterPage HmPg = PageFactory.initElements(driver, ResgisterPage.class);
		HmPg.ValidateOrder();
	}
	
	
//	@AfterMethod
//	public void closebrowser() 
//	{
//		driver.quit();
//	}
}
