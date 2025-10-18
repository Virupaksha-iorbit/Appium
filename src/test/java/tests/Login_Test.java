package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Login_Class;
import Pages.Baseclass_page;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Login_Test extends Baseclass_page {

    Login_Class loginPage;
    ExtentTest test;

    @BeforeMethod
    public void initPage() {
        // Initialize the Login page object with the existing driver
        loginPage = new Login_Class(Baseclass_page.driver);

        // Initialize ExtentTest for reporting
        test = extent.createTest("Valid Login Test");
    }
    @Test(priority = 1, groups = {"login"})
    public void testValidLogin() {
    	
        String username = "FNHCare24_h01@iorbitteam147955.testinator.com";
        String password = "eae57229-94d9-440a-9192-42c9a7e06d84";

        try {
            loginPage.login(username, password);

            // Optional: verify login success (replace with actual element)
            // e.g., check if home screen element is visible
            // Assert.assertTrue(homeScreenElement.isDisplayed(), "Home screen not visible");

            test.log(Status.PASS, "Login successful for user: " + username);
        } catch (Exception e) {
            test.log(Status.FAIL, "Login test failed: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
}
