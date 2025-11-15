package Pages;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Baseclass_page {
    public static AndroidDriver driver;
    public static ExtentReports extent; 
    public static ExtentTest test; 

    @BeforeTest
    public void setup() throws MalformedURLException {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        options.setCapability("noReset", true); 
        options.setCapability("newCommandTimeout", 900);

        // APK path
        File app = new File(System.getProperty("user.dir") + "/src/test/resources/apps/tech_admin.apk");
        if (app.exists()) {
            options.setApp(app.getAbsolutePath());
        } else {
            options.setAppPackage("com.techadminapp");
            options.setAppActivity("com.techadminapp.MainActivity");
        }

        URL url = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(url, options);
    }

   // @BeforeMethod
   // public void resetAppBeforeEachTest() {
       // if (driver != null) {
          //  driver.terminateApp("com.techadminapp");  
          //  driver.activateApp("com.techadminapp");  
       // }
    }

//    @AfterTest
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//        if (extent != null) {
//            extent.flush(); // ✅ generate report at the end
//        }
//    }

