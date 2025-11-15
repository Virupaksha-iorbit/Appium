package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Nurse_feature;
import Pages.Baseclass_page;
import Pages.Doctor_feature;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class CreateDoctorTest extends Baseclass_page{
	
	Doctor_feature doctor_feature;
	ExtentTest test;
	@BeforeMethod
    public void initPage() {
	doctor_feature=new Doctor_feature(Baseclass_page.driver);
	
	}
	@Test(dependsOnMethods = {"tests.Login_Test.testValidLogin", "tests.OTP_Test.enterOTPTest"})
	public void testcreatedoctor() {
		 String doctorcode ="Doctor1";
		 String firstname="pallavi";
		 String lastname="gowda";
		 String speciality="General";
		 String experince= "5";
		 String birthdate="12-12-1990";
		 String gender="Female";
		 String doctortype="SHIFT";
		 String street="karve";
		 String city="pune";
		 String pincode="585221";
		 String state="MH";
		 String country="IN";
		 String contactname="pallavi";
		 String contactphone="9879879870";
		 String contactemail="pallavigowda@mailinator.com";
		
		  try {
			 doctor_feature.createDoctoremethod(doctorcode,  firstname,  lastname, speciality,  experince,birthdate, gender, doctortype,    contactname,  contactphone,  contactemail,  street,  city,  pincode,  state,  country);
		 
		     test.log(Status.PASS, "Doctor Added Sucussfully");
	        } catch (Exception e) {
	            test.log(Status.FAIL, "Doctor Added failed: " + e.getMessage());
	            Assert.fail("Exception occurred: " + e.getMessage());
	        }
	    }
	}
