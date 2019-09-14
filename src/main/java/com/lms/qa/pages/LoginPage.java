package com.lms.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lms.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	//Page Factory - OR:
	
	@FindBy(name="txtUsername")
	//@CacheLookup
	WebElement username;
	
	@FindBy(name="txtPassword")
	//@CacheLookup
	WebElement password;
	
	@FindBy(id="btnLogin")
	//@CacheLookup
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@src='Images/logo.jpg']")
	WebElement lmsLogo;
	
	//Initializing the Objects:
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	//Actions:
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
		
	}
	
	public boolean lmsLogo() {
		
		return lmsLogo.isDisplayed();
		
	}
	
	public HomePage loginLMS(String un, String pwd) {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	
	
}
