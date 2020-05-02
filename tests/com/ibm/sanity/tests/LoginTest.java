package com.ibm.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ibm.generics.ScreenShot;
import com.ibm.pom.LoginPOM;
import com.ibm.utility.DriverFactory;
import com.ibm.utility.DriverNames;

public class LoginTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() {
		try{
			loginPOM.sendUserName("hvbot@nationalgrid.co.uk");
			loginPOM.sendPassword("HcBot@12345!@");
			loginPOM.clickLoginBtn(); 
			
			Assert.assertEquals(loginPOM.welcome_page(), "Welcome HC!"); // validating 
			System.out.println("***You have logged in successfully****");
			
			screenShot.captureScreenShot("First");	
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("***Your login functionality failed****");
			
		}
		
	}
}
