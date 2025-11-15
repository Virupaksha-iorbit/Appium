package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Nurse_feature;
import Pages.Baseclass_page;
import Pages.CreateBed_Feature;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class CreateBedTest extends Baseclass_page{
	CreateBed_Feature createbed_feature;
	@BeforeMethod
    public void initPage() {
	createbed_feature=new CreateBed_Feature(Baseclass_page.driver);
	
	}
	@Test(dependsOnMethods = {"tests.Login_Test.testValidLogin", "tests.OTP_Test.enterOTPTest"})
	public void testcreatenurse() {
		 String bedcode ="Bed1";
		 String patientcode="Patient1";
		 String gatewaycode="ReviveH1G1";
		 String devicecode="Comen1";
		 
		  try {
			 createbed_feature.createBedMethod(bedcode,  patientcode,  gatewaycode, devicecode);
		 
		     test.log(Status.PASS, "Bed Added Sucussfully");
	        } catch (Exception e) {
	            test.log(Status.FAIL, "Bed Added failed: " + e.getMessage());
	            Assert.fail("Exception occurred: " + e.getMessage());
	        }
	    }
	}

	


