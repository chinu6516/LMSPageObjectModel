package TestNGRunner;

import org.testng.TestNG;

import com.lms.qa.testcases.AllSwipeDetailsReportTest;
import com.lms.qa.testcases.HomePageTest;
import com.lms.qa.testcases.LoginPageTest;



public class MyRunner {

	static TestNG testNg;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		testNg=new TestNG();
		testNg.setTestClasses(new Class[] {(AllSwipeDetailsReportTest.class)});
		testNg.run();
		
	}

}
