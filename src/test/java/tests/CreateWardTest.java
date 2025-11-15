	package tests;
	import org.testng.Assert;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	
	import Pages.Ward_Feature;
	import Pages.Baseclass_page;
	import com.aventstack.extentreports.ExtentTest;
	
	public class CreateWardTest extends Baseclass_page{
		Ward_Feature ward_feature;
		ExtentTest test;
		@BeforeMethod
		public void initwardpage() {
			ward_feature=new Ward_Feature(Baseclass_page.driver);	
		}
	
		@Test(dependsOnMethods = {"tests.Login_Test.testValidLogin", "tests.OTP_Test.enterOTPTest"})
	
		public void testcreateward() {
	
			String wardcode= "automatedward1";
			String wardname= "testward1";
			String wardtype= "testgeneral";
	
			try {
				ward_feature.createward(wardcode, wardname, wardtype);
			}catch (Exception e) {
				System.out.println("Ward Creation Failed "+ e.getMessage());
				Assert.fail("Exception occurred: " + e.getMessage());
			}
	
		}
	}
