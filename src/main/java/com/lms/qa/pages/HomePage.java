package com.lms.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lms.qa.base.TestBase;
import com.lms.qa.util.TestUtil;





public class HomePage extends TestBase{

	
	//OR-Objects Repository
	@FindBy(xpath="//font[contains(text(),'Welcome, Chinmay Velankar')]")
	WebElement userNameLabel;
	
	
	@FindBy(xpath="//span[@id='maintext-2']")
	WebElement reportsLink;
	
	@FindBy(xpath="//span[@id='maintext-1']")
	WebElement applicationLink;
	
	
	@FindBy(xpath="//span[@id='maintext-3']")
	WebElement logoutLink;
	
	//initializing the objects
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyHomePageTitle() {
		
		return driver.getTitle();
		
	}
	
	public AllSwipeDetailsReport clickOnAllSwipeDetailsLink() {
		
		Actions action=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.MINUTES);
		action.moveToElement(reportsLink).build().perform();
		
		String Script = "javascript:document.getElementById('subtext-2-9').click();";
		 ((JavascriptExecutor) driver).executeScript(Script);
		 
		 return new AllSwipeDetailsReport();
		 
	}
	
	public AttendanceRegularizationPage clickOnAttendanceRegularizationLink() {
		
		Actions action=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.MINUTES);
		action.moveToElement(applicationLink).build().perform();
		WebElement attendanceReg=driver.findElement(By.xpath("//span[contains(text(),'ATTENDANCE REGULARIZATION')]"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", attendanceReg);
		
		return new AttendanceRegularizationPage();
	}
	
	public LoginPage clickOnLogOutLink() {
		
		logoutLink.click();
		return new LoginPage();
		
	}
	
}
