package com.ibm.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ibm.generics.GenericMethods;
import com.ibm.generics.ScreenShot;
import com.ibm.pom.HC_SAP_Rainbow_POM;
import com.ibm.pom.HC_VIew_All_POM;
import com.ibm.pom.LoginPOM;
import com.ibm.utility.DriverFactory;
import com.ibm.utility.DriverNames;

public class HC_SAP_Rainbow_Test {

	private WebDriver driver;
	private String baseUrl;
	private HC_SAP_Rainbow_POM hC_SAP_Rainbow_POM;
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
		hC_SAP_Rainbow_POM = new HC_SAP_Rainbow_POM(driver);
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
			hC_SAP_Rainbow_POM.sendUserName("hvbot@nationalgrid.co.uk");
			hC_SAP_Rainbow_POM.sendPassword("HcBot@12345!@");
			hC_SAP_Rainbow_POM.clickLoginBtn(); 
			hC_SAP_Rainbow_POM.clickresedential();
			hC_SAP_Rainbow_POM.clickworkrequest();
			hC_SAP_Rainbow_POM.clickcreatenew();
			hC_SAP_Rainbow_POM.clickalert();
			hC_SAP_Rainbow_POM.selectBGT();
			hC_SAP_Rainbow_POM.entermprn("2489767807");
			hC_SAP_Rainbow_POM.clicksearch();
			//System.out.println("checking serial presence..");
			//System.out.println(">>>>"+hC_SAP_Rainbow_POM.mfgserialnocheck());
			
			Assert.assertEquals(hC_SAP_Rainbow_POM.mfgserialnocheck(), "2489767807");
			
			
			System.out.println("*******SUCCESS - SAP Ranbow works*******");	
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("***SAP Rainbow is NOT responding as expected****");
			
		}
		
	}
}
