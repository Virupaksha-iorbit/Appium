package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Nurse_feature;
import Pages.Baseclass_page;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class CreateNurseTest extends Baseclass_page{
	
	Nurse_feature nurse_feature;
	ExtentTest test;
	@BeforeMethod
    public void initPage() {
	nurse_feature=new Nurse_feature(Baseclass_page.driver);
	
	}
	@Test(dependsOnMethods = {"tests.Login_Test.testValidLogin", "tests.OTP_Test.enterOTPTest"})
	public void testcreatenurse() {
		 String nursecode ="Nurse1";
		 String firstname="pallavi";
		 String lastname="gowda";
		 String speciality="Cardiac Care Nurse,Surgical ICU Nurse";
		 String experince= "5";
		 String nursetype="ICU_SPECIALIST";
		 String dob="1990-03-03";
		 String gender="Female";
		 String sharedphonenumber="9879879870";
		 String contactname="pallavi";
		 String contactphone="9879879870";
		 String contactemail="pallavigowda@mailinator.com";
		 String street="karve";
		 String city="pune";
		 String pincode="585221";
		 String state="MH";
		 String country="IN";
		  try {
			 nurse_feature.createnursemethod(nursecode,  firstname,  lastname, speciality,  experince,  nursetype,  dob,  gender,  sharedphonenumber,  contactname,  contactphone,  contactemail,  street,  city,  pincode,  state,  country);
		 
		     test.log(Status.PASS, "Nurse Added Sucussfully");
	        } catch (Exception e) {
	            test.log(Status.FAIL, "Nurse Added failed: " + e.getMessage());
	            Assert.fail("Exception occurred: " + e.getMessage());
	        }
	    }
	}
