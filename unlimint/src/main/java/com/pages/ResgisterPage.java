package com.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.TestBase;
import com.util.TestUtil;

public class ResgisterPage  extends TestBase 
{

public ResgisterPage() throws IOException 
	{
		super();
	}
	generateusers gn = new generateusers();

	@FindBy (xpath="//a[contains(text(),'Create an Account')]")
	static WebElement create_an_Account;
	
	@FindBy (xpath="//input[@id='firstname']")
	static WebElement inputfirstname;
	
	@FindBy (xpath="//input[@id='lastname']")
	static WebElement inputlastname;
	
	@FindBy (xpath="//input[@id='email_address']")
	static WebElement inputemail_address;
	
	@FindBy (xpath="//input[@id='password-confirmation']")
	static WebElement inputpassword_confirmation;
	
	@FindBy (xpath="//input[@id='password']")
	static WebElement inputpassword;
	
	@FindBy (xpath="//button[@title='Create an Account']")
	static WebElement inputCreate_an_Account_btn;
	
	@FindBy (xpath="//a[@id='ui-id-5']")
	static WebElement inputmendrp;
	
	@FindBy (xpath="//span[@class='product-image-container']")
	static WebElement product;
	
	@FindBy (xpath="//div[@class='swatch-attribute size']/div/div[1]")
	static WebElement productsize;
	
	@FindBy (xpath="//div[@class='swatch-attribute color']/div[1]")
	static WebElement productcolor;
	
	@FindBy (xpath="//button[@title='Add to Cart']")
	static WebElement addtocart;
	
	@FindBy (xpath="//a[@class='action showcart']")
	static WebElement showcart;
	
	@FindBy (xpath="//button[@title='Proceed to Checkout']")
	static WebElement proceedtocart;
	
	
	public void ValidateOrder() throws IOException 
	{
		Actions a = new Actions(driver);
		TestUtil.geturl("url");
		create_an_Account.click();
		User user=gn.GetBooksDetails();
		Results result = user.getResults().get(0);
		inputfirstname.sendKeys(result.getName().getFirst());
		inputlastname.sendKeys(result.getName().getLast());
		inputemail_address.sendKeys(result.getEmail());
		char[] password = TestUtil.generatePassword(10);
		String pass = new String(password);
		inputpassword.sendKeys(pass);
		inputpassword_confirmation.sendKeys(pass);
		inputCreate_an_Account_btn.click();
		//Instantiate Action Class        
        Actions actions = new Actions(driver);
    	//Mouse hover menuOption 'Music'
    	actions.moveToElement(inputmendrp).perform();
    	inputmendrp.click();
    	product.click();
    	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    	productsize.click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	productcolor.click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	addtocart.click();
    	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    	showcart.click();
    	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    	proceedtocart.click();
    	
	}
}
