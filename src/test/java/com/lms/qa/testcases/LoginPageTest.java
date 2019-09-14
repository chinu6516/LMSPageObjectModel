package com.lms.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lms.qa.base.TestBase;
import com.lms.qa.pages.HomePage;
import com.lms.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest()
	{
		
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginPage=new LoginPage();
		
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "eMpower - Webased Time Attendance & Leave Management System");
	}
	
	@Test(priority=2)
	public void lmsLogoImageTest() {
		
		boolean flag=loginPage.lmsLogo();
		Assert.assertTrue(flag);
		
	}
	
	
	
	@Test(priority=3)
	public void loginTest() {
		
		homePage=loginPage.loginLMS(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
}
