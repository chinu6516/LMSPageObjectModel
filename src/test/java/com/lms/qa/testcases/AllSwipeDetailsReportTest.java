package com.lms.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lms.qa.base.TestBase;
import com.lms.qa.pages.AllSwipeDetailsReport;
import com.lms.qa.pages.HomePage;
import com.lms.qa.pages.LoginPage;

public class AllSwipeDetailsReportTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	AllSwipeDetailsReport allSwipeDetailsReport;
	
	public AllSwipeDetailsReportTest() {
		
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginPage=new LoginPage();
		allSwipeDetailsReport=new AllSwipeDetailsReport();
		homePage=loginPage.loginLMS(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1,enabled=false)
	public void verifyAllSwipeDetailsReportPageTitleTest() {
		
		String allSwipeDetailsReportPageTitle=allSwipeDetailsReport.verifyAllSwipeDetailsPageTitle();
		Assert.assertEquals(allSwipeDetailsReportPageTitle, "eMpower - Webased Time Attendance & Leave Management System","Home Page title not matched");
	}
	
	
	
	@Test(priority=2)
	public void calculateInOutTimeAndDisplayOnScreen() throws Exception {
		
		allSwipeDetailsReport=homePage.clickOnAllSwipeDetailsLink();
		allSwipeDetailsReport.SelectFromTodayDate();
		allSwipeDetailsReport.clickOnDetailsLink();
		allSwipeDetailsReport.calculateEarliestInTime();
		homePage.clickOnLogOutLink();
		
		
	}

	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		allSwipeDetailsReport.printPunchTimeOnScreen();
	}
	
}
