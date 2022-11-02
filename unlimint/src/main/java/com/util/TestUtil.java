package com.util;

import static org.testng.Assert.assertSame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.base.TestBase;

public class TestUtil extends TestBase
{

	public TestUtil() throws IOException {
	}
	
	public static long PAGE_LOAD_TIMEOUT =20;
	public static long IMPLICIT_WAIT = 10;
	public static String url = "";
	public static HttpURLConnection huc = null;
	public static  int respCode = 200;
	
	
	public static void takeScreenshot() throws IOException
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis()  + ".png"));
	
	}
	public static void compareString(String wikistring, String imdbstring)
	{
		Assert.assertEquals(wikistring, imdbstring);
	}
	
	public static void geturl(String url) throws IOException
	{
		prop =new Properties(); 
		String path =System.getProperty("user.dir");
		FileInputStream ip= new FileInputStream(path+"\\src\\main\\java\\com\\config\\config.properties");
		prop.load(ip); 
		driver.get(prop.getProperty(url));
	}
	
	public static void checkbrokenlink(String urls)
	{
       
		try
        {
            huc = (HttpURLConnection)(new URL(url).openConnection());
            huc.setRequestMethod("HEAD");
            huc.connect();
            respCode = huc.getResponseCode();
            if(respCode >= 400){
                System.out.println(url+" is a broken link");
            }
            else{
                System.out.println(url+" is a valid link");
            }   
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
		/*
		 * public static void scrollpage(int xaxis, int yaxis) { JavascriptExecutor js =
		 * (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(xaxis,yaxis)"); // TODO Auto-generated
		 * method stub
		 * 
		 * }
		 */
	
		   public static char[] generatePassword(int length) {
		      String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
		      String specialCharacters = "!@#$";
		      String numbers = "1234567890";
		      String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
		      Random random = new Random();
		      char[] password = new char[length];

		      password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
		      password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
		      password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
		      password[3] = numbers.charAt(random.nextInt(numbers.length()));
		   
		      for(int i = 4; i< length ; i++) {
		         password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
		         
		      }
		      return password;
		   
	
		   }
	}