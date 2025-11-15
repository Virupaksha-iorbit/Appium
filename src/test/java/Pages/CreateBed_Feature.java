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
                                 
public class CreateBed_Feature extends  Baseclass_page{
	AppiumDriver driver;
	WebDriverWait wait;

		public CreateBed_Feature(AppiumDriver driver) {
			this.driver=driver;
			this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
		}

		@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Bed, Create Bed']")
		public WebElement AddBedinDashboard;

		@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]")  
		public WebElement AddBed;

		@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]")
		public WebElement BedCode;

		@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[3]")
		public WebElement GatewayCode;

		@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[4]")
		public WebElement PatientCode;
		
		@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[5]")
		public WebElement DeviceCode;
		
		@FindBy(xpath="//android.widget.Button[@content-desc='CREATE BED']")
		public WebElement CreateButton;
		
		
		
		public void createBedMethod(String bedcode, String gatewaycode,String patientcode, String devicecode) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(AddBedinDashboard)).click();
				wait.until(ExpectedConditions.elementToBeClickable(AddBed)).click();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOf(PatientCode)).clear();
				PatientCode.sendKeys(patientcode);
				
				wait.until(ExpectedConditions.visibilityOf(BedCode)).clear();
				BedCode.sendKeys(bedcode);
				wait.until(ExpectedConditions.visibilityOf(GatewayCode)).clear();
				GatewayCode.sendKeys(gatewaycode);
				wait.until(ExpectedConditions.visibilityOf(PatientCode)).clear();
				PatientCode.sendKeys(patientcode);
				wait.until(ExpectedConditions.visibilityOf(DeviceCode)).clear();
				DeviceCode.sendKeys(devicecode);
				
				
				
				wait.until(ExpectedConditions.elementToBeClickable(CreateButton)).click();
				
			}catch (Exception e) {
		        System.out.println("Ward creation failed: " + e.getMessage());
			}
			
		}
	}

