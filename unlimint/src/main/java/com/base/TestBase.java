/**
 * 
 */
package com.base;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.util.TestUtil;
import com.util.WebEventlistener;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author 850668
 *
 */
public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
		 
	 public TestBase() throws IOException 
	 { 
		 prop =new Properties(); 
		 String path =System.getProperty("user.dir");
		 FileInputStream ip= new FileInputStream(path+"\\src\\main\\java\\com\\config\\config.properties");
		 prop.load(ip); 
	}

	public static void initialization() throws IOException
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
		}
		if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
}

