package com.lms.qa.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lms.qa.base.TestBase;



public class AllSwipeDetailsReport extends TestBase {

	String to_print;
	int rowCount;
	//OR-Objects Repository
	
	@FindBy(xpath="//input[@name='_ctl0:MainBody:lblFromDate:TextDatepicker']")
	WebElement FromDatePicker;
	
	@FindBy(xpath="//div[@id='_ctl0_MainBody_lblFromDate_TextDatepicker_CalendarExtender_today']")
	WebElement FromTodayDate;
	
	@FindBy(xpath="//input[@name='_ctl0:MainBody:cmdDetails']")
	WebElement btnDetails;
	
	@FindBy(name="cmdCancel")
	WebElement btnCancel;
	
	
	
	//initialization of Objects
	public AllSwipeDetailsReport() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyAllSwipeDetailsPageTitle() {
		
		return driver.getTitle();
		
	}
	
	public void SelectFromTodayDate()
	{
		
		FromDatePicker.click();
		FromTodayDate.click();
		
	}
	
	public void clickOnDetailsLink() {
		
		btnDetails.click();
		
	}
	
	public void calculateEarliestInTime() throws Exception {
		
		rowCount=driver.findElements(By.xpath("//table[@id='_ctl0_MainBody_dgrdDetails']/tbody/tr")).size();
	 	
	 	int colCount=driver.findElements(By.xpath("//table[@id='_ctl0_MainBody_dgrdDetails']/tbody/tr[1]/*")).size();
	 	System.out.println("Number of rows :" +rowCount);
	 	if(rowCount==1)
	 	{
	 		System.out.println("You have not punched your card yet.");
	 		//driver.quit();
	 	}
	 	
	 	else {
	 	System.out.println("Number of columns :" +colCount);
	 
	 	//fetch column data of datetime
	 	
	 	List<String> value = new ArrayList<String>();
	 	for(int i=1;i<=rowCount;i++)
	 	{
	 		for(int j=4;j<colCount;j++)
	 		{
	 			
	 			//System.out.print(driver.findElement(By.xpath("//table[@id='_ctl0_MainBody_dgrdDetails']/tbody/tr[" + i + "]/*[" + j + "]")).getText() + " ");
	 			value.add(driver.findElement(By.xpath("//table[@id='_ctl0_MainBody_dgrdDetails']/tbody/tr[" + i + "]/*[" + j + "]")).getText());
	 			
	 		}
	 		
	 	}
	 
	 	//Convert into date time and sort
	 	//Collections.sort(value);
	 
	 	//new SimpleDateFormat("yyyy-MM-ddTHH:mm:ss.SSS").
	 	
	 	String str[] = new String[value.size()]; 
	 	  
        // ArrayList to Array Conversion 
        for (int j = 0; j < value.size(); j++) { 
  
            // Assign each value to String array 
            str[j] = value.get(j); 
          
        } 
       
        
         
	 List<String> dates=new ArrayList<String>();
	 int s=1;
	 for(s=1;s<str.length;s++)
	 {
	 dates.add(str[s]);
	 
	 }	
	
	  Collections.sort(dates, new Comparator<String>() {
		  SimpleDateFormat f = new SimpleDateFormat("MMM dd yyyy hh:mma");
	        public int compare(String o1, String o2) {
	            try {
	                return f.parse(o1).compareTo(f.parse(o2));
	            } catch (ParseException e) {
	                throw new IllegalArgumentException(e);
	            }
	        }
	    });
  
	 String s1=dates.get(0);
	
	 System.out.println("Your in time is:"+dates.get(0));
		
	SimpleDateFormat formatterone=new SimpleDateFormat("MMM dd yyyy hh:mma");
   	 java.util.Date dateout = null;
   	dateout=formatterone.parse(dates.get(0).toString());
   	//System.out.println(out);
   	Calendar cl = Calendar. getInstance();
   	cl.setTime(dateout);
   	cl. add(Calendar.HOUR, 8);
   	cl. add(Calendar.MINUTE, 30);
   	
   	String s2=cl.getTime().toString();
   	
   	to_print="Your in time is: " +s1+ "\n" +"Your out time is: " +s2;
 
   	System.out.println("Your out time is:"+cl.getTime().toString());
   	
	 	}
	 	
		
	}
	
	
	public void printPunchTimeOnScreen() {
		
		if(rowCount>1)
		JOptionPane.showMessageDialog(null,to_print);
		
	}
	
	
	
}
