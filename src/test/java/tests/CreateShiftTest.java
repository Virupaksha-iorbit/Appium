package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Baseclass_page;
import Pages.Shift_Feature;

import com.aventstack.extentreports.ExtentTest;

public class CreateShiftTest extends Baseclass_page{
	Shift_Feature shift_feature;
	ExtentTest test;
	
	@BeforeMethod
	public void initshiftpage() {
		shift_feature=new Shift_Feature(Baseclass_page.driver);
	}
	@Test(dependsOnMethods = {"tests.Login_Test.testValidLogin", "tests.OTP_Test.enterOTPTest"})
 public void testcreateshift() {
		
		String shiftname= "Morning Shift";
		String shiftcode= "testshift2";
		String starttime= "2025-10-24T10:45:00";
		String endtime= "2025-10-26T10:45:00";

		try {
			shift_feature.createshift(shiftname, shiftcode, starttime, endtime);
		}catch (Exception e) {
			System.out.println("Shift Creation Failed "+ e.getMessage());
			Assert.fail("Exception occurred: " + e.getMessage());
		}
		}
}

