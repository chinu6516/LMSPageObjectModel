package com.lms.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lms.qa.base.TestBase;
import com.lms.qa.pages.AttendanceRegularizationPage;
import com.lms.qa.pages.HomePage;
import com.lms.qa.pages.LoginPage;
import com.lms.qa.util.TestUtil;

public class AttendanceRegularizationTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	AttendanceRegularizationPage attendanceRegularization;
	
	String sheetName="Regularization";
	
	public AttendanceRegularizationTest() {
		
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginPage=new LoginPage();
		attendanceRegularization=new AttendanceRegularizationPage();
		homePage=loginPage.loginLMS(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1,dataProvider="getRegularizationTestData")
	public void fillAttendanceRegularizationTest(String ReasonforRegularization,String shift,String Remark) {
		
		attendanceRegularization=homePage.clickOnAttendanceRegularizationLink();
		
		
		
		attendanceRegularization.fillRegularizationEntry(ReasonforRegularization, shift, Remark);
		
	}
	
	@DataProvider
	public Object[][] getRegularizationTestData() throws EncryptedDocumentException, IOException {
		
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
