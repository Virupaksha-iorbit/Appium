package Pages;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
                                 
public class Device_Feature extends  Baseclass_page{
	AppiumDriver driver;
	WebDriverWait wait;

		public Device_Feature(AppiumDriver driver) {
			this.driver=driver;
			this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
		}

		@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Device, Manage devices']")
		public WebElement AddDeviceinDashboard;

		@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Add Device']")  
		public WebElement AddDevice;

		@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.EditText[1]")
		public WebElement DeviceCode;

		@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.EditText[1]")
		public WebElement DeviceType;

		@FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.widget.EditText[3]")
		public WebElement UsageType;
		
		@FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.widget.EditText[4]")
		public WebElement VerifyWith;
		
		@FindBy(xpath="//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.widget.EditText[5]")
		public WebElement Protocol;
		
		@FindBy(xpath="//android.view.ViewGroup[@content-desc='Add Device']")
		public WebElement AddDeviceButton;
		
		public void createDeviceMethod(String devicecode, String devicetype,String usagetype, String verifywith, String protocol) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(AddDeviceinDashboard)).click();
				wait.until(ExpectedConditions.elementToBeClickable(AddDevice)).click();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOf(DeviceCode)).clear();
				DeviceCode.sendKeys(devicecode);
				
				wait.until(ExpectedConditions.visibilityOf(DeviceType)).clear();
				DeviceType.sendKeys(devicetype);
				wait.until(ExpectedConditions.visibilityOf(UsageType)).clear();
				UsageType.sendKeys(usagetype);
				wait.until(ExpectedConditions.visibilityOf(VerifyWith)).clear();
				VerifyWith.sendKeys(verifywith);
				wait.until(ExpectedConditions.visibilityOf(Protocol)).clear();
				Protocol.sendKeys(protocol);
				wait.until(ExpectedConditions.elementToBeClickable(AddDeviceButton)).click();
				
			}catch (Exception e) {
		        System.out.println("Ward creation failed: " + e.getMessage());
			}
			
		}
	}

