package tests;

import Pages.Baseclass_page;
import Pages.OTP_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class OTP_Test extends Baseclass_page {

    @Test(dependsOnMethods = {"tests.Login_Test.testValidLogin"})
    public void enterOTPTest() throws Exception {
       
        String otp = OTP_Class.fetchLatestOTP();

        Assert.assertNotNull(otp, "OTP should not be null.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement otpField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//android.widget.EditText[contains(@text,'OTP')]")
                )
        );
        otpField.sendKeys(otp);

        WebElement verifyBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//android.widget.Button[contains(@content-desc,'VERIFY')]")
                )
        );
        verifyBtn.click();
    }
        
}
