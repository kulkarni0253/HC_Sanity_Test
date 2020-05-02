package com.ibm.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ibm.generics.GenericMethods;

public class HC_SAP_Rainbow_POM {
	private WebDriver driver; 
	private GenericMethods genericMethods = new GenericMethods(driver);
	
	public HC_SAP_Rainbow_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="_58_login")
	private WebElement username;
	
	@FindBy(name="_58_password")
	private WebElement password;
	
	@FindBy(className="login100-form-btn")
	private WebElement loginBtn; 
	
	@FindBy(xpath="/html/body/div[3]/nav/div/div[1]/ul/li[3]/a/span[2]")
	private WebElement resedential;
	
	@FindBy(xpath="/html/body/div[3]/nav/div/div[1]/ul/li[3]/ul/li[3]/a")
	private WebElement workrequest;
	
	@FindBy(xpath="/html/body/div[3]/nav/div/div[1]/ul/li[3]/ul/li[3]/ul/li[1]/a")
	private WebElement createnew;

	
	@FindBy(xpath="/html/body/div[3]/nav/div/div[1]/ul/li[3]/ul/li[3]/ul/li[3]/a")
	private WebElement viewall;
	
	@FindBy(xpath="//*[@id='_createworkrequest_WAR_CreateWorkRequest100_supplierShortCodeSearch']")
	private WebElement suppliercode;  
	
	@FindBy(xpath="//*[@id='yui_patched_v3_11_0_1_1588191618847_460']")
	private WebElement installselect;
	
	@FindBy(id="go")
	private WebElement go;
	
	@FindBy(xpath="//*[@id='exportBtn']")
	private WebElement mprn;
	
	@FindBy(xpath="/html/body/div[10]/div[3]/div/button[1]")
	private WebElement alert;
	
	@FindBy(xpath="//*[@id='_createworkrequest_WAR_CreateWorkRequest100_mprnSearch']")
	private WebElement entermprn;
	
	@FindBy(xpath="//*[@id='_createworkrequest_WAR_CreateWorkRequest100_mprnSearchSubmit']")
	private WebElement search;

	@FindBy(css=".customInputText.clsTextbox.success-field")  
	private WebElement mfgserialno;
	
	
	
	public void sendUserName(String userName) {
		this.username.clear();
		this.username.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickresedential() throws InterruptedException {
		Thread.sleep(2000);
		this.resedential.click(); 
	}
	
	public void clickworkrequest() throws InterruptedException {
		Thread.sleep(2000);
		this.workrequest.click(); 
	}
	
	public void clickcreatenew() throws InterruptedException {
		Thread.sleep(2000);
		this.createnew.click(); 
	}
	
	public void clickalert() throws InterruptedException{
		Thread.sleep(3000);
		this.alert.click();
	}
	
	public void selectBGT() {
		genericMethods.selectdropdownbyvisibletext(suppliercode, "BGT");
	}
	
	
	public void clicksearch() throws InterruptedException{
		this.search.click(); 
		Thread.sleep(4000);
	}
	
	public void entermprn(String mprn) {
		this.entermprn.sendKeys(mprn);
	}
	
	public String mfgserialnocheck(){
		WebDriverWait wait = new WebDriverWait(driver, 100);
		mfgserialno= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".customInputText.clsTextbox")));
		return mfgserialno.getAttribute("value");
		
	}
	
	
	
	
	
	
	

}
