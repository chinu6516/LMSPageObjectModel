package com.lms.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.lms.qa.base.TestBase;

public class AttendanceRegularizationPage extends TestBase{

	//OR-Object Repository
	
	@FindBy(id="_ctl0_MainBody_txtInDate_TextDatepicker")
	WebElement fromDate;
	
	@FindBy(id="_ctl0_MainBody_txtRemark")
	WebElement remarks;
	
	@FindBy(id="_ctl0_MainBody_cmdSubmit")
	WebElement submitBtn;
			
	//initialization
	public AttendanceRegularizationPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void fillRegularizationEntry(String reason,String shift,String remark) {
		
		Select select=new Select(driver.findElement(By.name("_ctl0:MainBody:cboReason")));
		select.selectByVisibleText(reason);
		
		Select selectshift=new Select(driver.findElement(By.name("_ctl0:MainBody:cboShift")));
		selectshift.selectByVisibleText(shift);
		
		remarks.sendKeys(remark);
		
		//submitBtn.click();
		
	}
	
	
}
