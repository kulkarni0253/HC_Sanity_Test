package com.ibm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ibm.generics.GenericMethods;
import com.ibm.waits.WaitTypes;

public class Application_url_check_POM {
	
	private WebDriver driver;
    private WaitTypes waitTypes;
    private GenericMethods genericMethods = new GenericMethods(driver); 
    
	public Application_url_check_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="_58_login")
	private WebElement username;
	
	public String username_field() throws InterruptedException {
		Thread.sleep(10000L);
		return this.username.getText();
	}
//
//	public void mouseOverNewLaunchBtn(WebDriver driver) throws InterruptedException {
//		genericMethods.hoverWebelement(newLaunch, driver);
//	}

//	@FindBy(xpath="//div[@id='wpmm-megamenu']/div/div[3]/div[2]/a")
//	private WebElement prestigeimg;
//	public void clickPrestigeImg() {
//		this.prestigeimg.click(); 
//	}
//
//	@FindBy(name="_58_password")
//	private WebElement password;
//
//	public void enter_password(String name) {
//		this.password.clear(); 
//		this.password.sendKeys(name); 
//	}
//
//	@FindBy(name="your-email")
//	private WebElement yourEmailEdt;
//
//	public void sendyourEmail(String email) {
//		this.yourEmailEdt.clear(); 
//		this.yourEmailEdt.sendKeys(email); 
//	}
//
//	@FindBy(name="your-subject")
//	private WebElement yourSubjectEdt;
//
//	public void sendyourSubject(String subject) {
//		this.yourSubjectEdt.clear(); 
//		this.yourSubjectEdt.sendKeys(subject);
//	}
//
//	@FindBy(name="your-message")
//	private WebElement yourMsgEdt;
//
//	public void sendyourMessage(String message) {
//		this.yourMsgEdt.clear(); 
//		this.yourMsgEdt.sendKeys(message); 
//	}
//	@FindBy(xpath="//div[@class='wpcf7']//input[@class='wpcf7-form-control wpcf7-submit']")
//	private WebElement submit;
//
//	public void clickSubmit() throws InterruptedException {
//		Thread.sleep(2000);
//		this.submit.click();
//	}
//
//	@FindBy(xpath="//form[@class='wpcf7-form failed']//div[@role='alert']")
//	private WebElement messagePostSubmit;
//
//	public String getmessagePostSubmit() throws InterruptedException
//	{
//		Thread.sleep(5000L);
//		String msg=messagePostSubmit.getText();
//		return msg;
//	}
//	@FindBy(xpath="//a[@class='sign-in']")
//	private WebElement loginRegisterlink;
//
//	public void ClickloginRegisterlink() {
//		this.loginRegisterlink.click(); 
//	}

}
