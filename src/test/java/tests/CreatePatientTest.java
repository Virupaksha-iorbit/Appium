package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.Patient_Feature;
import Pages.Baseclass_page;

public class CreatePatientTest extends Baseclass_page{
	
	Patient_Feature patient_feature;
	
	
	@BeforeMethod
    public void initPage() {
	patient_feature=new Patient_Feature(Baseclass_page.driver);
	
	}
	@Test(dependsOnMethods = {"tests.Login_Test.testValidLogin", "tests.OTP_Test.enterOTPTest"})
	public void testcreatepatient() {
		 String patientcode ="Patient1";
		 String patientname="pallavi gowda";
		 String firstname="pallavi";
		 String lastname="gowda";
		 String contactname="pallavi gowda";
		 String contactphone= "9876543210";
		 String contactemail="pallavigowda@mailinator.com";
		 String street="karve";
		 String city="pune";
		 String pincode="585221";
		 String state="MH";
		 String country="IN";
		  try {
			 patient_feature.createpatient(patientcode,patientname,  firstname,  lastname, contactname,  contactphone,  contactemail,  street,  city,  pincode,  state,  country);
		 
		     test.log(Status.PASS, "Nurse Added Sucussfully");
	        } catch (Exception e) {
	            test.log(Status.FAIL, "Nurse Added failed: " + e.getMessage());
	            Assert.fail("Exception occurred: " + e.getMessage());
	        }
	    }
	}

	

