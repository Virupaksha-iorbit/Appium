package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Nurse_feature;
import Pages.Baseclass_page;
import Pages.CreateBed_Feature;
import Pages.Device_Feature;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class CreateDeviceTest extends Baseclass_page{
	Device_Feature device_feature;
	@BeforeMethod
    public void initPage() {
	device_feature=new Device_Feature(Baseclass_page.driver);
	
	}
	@Test(dependsOnMethods = {"tests.Login_Test.testValidLogin", "tests.OTP_Test.enterOTPTest"})
	public void testcreatedevice() {
		 String verifywith ="SERIALNO";
		 String usagetype="Fixed";
		 String devicetype="Comen";
		 String devicecode="Comen1";
		 String protocol ="HL7";
		 
		  try {
			 device_feature.createDeviceMethod(devicecode,  devicetype,  usagetype, verifywith, protocol);
		 
		     test.log(Status.PASS, "Device Added Sucussfully");
	        } catch (Exception e) {
	            test.log(Status.FAIL, "Device Added failed: " + e.getMessage());
	            Assert.fail("Exception occurred: " + e.getMessage());
	        }
	    }
	}

	


