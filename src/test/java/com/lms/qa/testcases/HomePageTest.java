package com.lms.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lms.qa.base.TestBase;
import com.lms.qa.pages.AllSwipeDetailsReport;
import com.lms.qa.pages.HomePage;
import com.lms.qa.pages.LoginPage;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	
	public HomePageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.loginLMS(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "eMpower - Webased Time Attendance & Leave Management System","Home Page title not matched");
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
}
