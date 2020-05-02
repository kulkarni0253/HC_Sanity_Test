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

import com.ibm.generics.GenericMethods;
import com.ibm.generics.ScreenShot;
import com.ibm.pom.HC_VIew_All_POM;
import com.ibm.pom.LoginPOM;
import com.ibm.utility.DriverFactory;
import com.ibm.utility.DriverNames;

public class HC_VIew_All_Test {

	private WebDriver driver;
	private String baseUrl;
	private HC_VIew_All_POM hC_VIew_All_POM;
	private GenericMethods genericmethods;
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
		hC_VIew_All_POM = new HC_VIew_All_POM(driver); 
		genericmethods = new GenericMethods(driver);
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
			hC_VIew_All_POM.sendUserName("hvbot@nationalgrid.co.uk");
			hC_VIew_All_POM.sendPassword("HcBot@12345!@");
			hC_VIew_All_POM.clickLoginBtn(); 
			hC_VIew_All_POM.clickresedential();
			hC_VIew_All_POM.clickworkrequest();
			hC_VIew_All_POM.clickviewall();
			hC_VIew_All_POM.selectjobtypeInstall();
			hC_VIew_All_POM.clickgo();
			//hC_VIew_All_POM.viewallcheck();
			//System.out.println("text is"+hC_VIew_All_POM.viewallmprntext());
			
			Assert.assertEquals(hC_VIew_All_POM.viewallmprntext(), "Export");
			
			System.out.println("******View All Functionaliy is working as expected*******");
			
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("***View All Functionality is NOT working as expected****");
			
		}
		
	}
}
