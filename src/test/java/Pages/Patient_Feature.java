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
                                          
public class Patient_Feature extends Baseclass_page{
AppiumDriver driver;
WebDriverWait wait;

	public Patient_Feature(AppiumDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Patient Center, Go to Patient Center']")
	public WebElement AddPatientinDashboard;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Add Patient']")  
	public WebElement AddPatient;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]")
	public WebElement PatientCode;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]")
	public WebElement PatientName;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[3]")
	public WebElement FirstName;
	
	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[4]")
	public WebElement LastName;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc='Contact Info']")
	public WebElement ContactInfoButton;
	
	@FindBy(xpath="//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup[4]/android.widget.EditText[1]")
	public WebElement ContactName;
	
	@FindBy(xpath="//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup[4]/android.widget.EditText[2]")
	public WebElement ContactPhone;
	
	@FindBy(xpath="//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup[4]/android.widget.EditText[3]")
	public WebElement ContactEmail;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc='Next']")
	public WebElement NextButton;
	
	@FindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]")
	public WebElement Street;
	
	@FindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]")
	public WebElement City;
	
	@FindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[3]")
	public WebElement PinCode;
	
	@FindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]")
	public WebElement State;
	
	@FindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[3]")
	public WebElement Country;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc='Register']")
	public WebElement RegisterButton;
	
	public void createpatient(String patientcode, String patientname,String firstname, String lastname, String contactname, String contactphone, String contactemail, String street, String city, String pincode, String state, String country) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(AddPatientinDashboard)).click();
			wait.until(ExpectedConditions.elementToBeClickable(AddPatient)).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(PatientCode)).clear();
			PatientCode.sendKeys(patientcode);
			
			wait.until(ExpectedConditions.visibilityOf(PatientName)).clear();
			PatientName.sendKeys(patientname);
			wait.until(ExpectedConditions.visibilityOf(FirstName)).clear();
			FirstName.sendKeys(firstname);
			wait.until(ExpectedConditions.visibilityOf(LastName)).clear();
			LastName.sendKeys(lastname);
			wait.until(ExpectedConditions.elementToBeClickable(ContactInfoButton)).click();
			wait.until(ExpectedConditions.visibilityOf(ContactName)).clear();
			ContactName.sendKeys(contactname);
			wait.until(ExpectedConditions.visibilityOf(ContactPhone)).clear();
			ContactPhone.sendKeys(contactphone);
			wait.until(ExpectedConditions.visibilityOf(ContactEmail)).clear();
			ContactEmail.sendKeys(contactemail);
			
			wait.until(ExpectedConditions.elementToBeClickable(NextButton)).click();
			wait.until(ExpectedConditions.visibilityOf(Street)).clear();
			Street.sendKeys(street);
			
			wait.until(ExpectedConditions.visibilityOf(City)).clear();
			City.sendKeys(city);
			
			wait.until(ExpectedConditions.visibilityOf(PinCode)).clear();
			PinCode.sendKeys(pincode);
			
			driver.findElement(AppiumBy.androidUIAutomator(
				    "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
				    ".scrollIntoView(new UiSelector().textContains(\"Country\"))"));

			Thread.sleep(2000);

			wait.until(ExpectedConditions.visibilityOf(State)).clear();
			State.sendKeys(state);
			
			wait.until(ExpectedConditions.visibilityOf(Country)).clear();
			Country.sendKeys(country);
			
			

			
			wait.until(ExpectedConditions.elementToBeClickable(RegisterButton)).click();
			
			
		}catch (Exception e) {
	        System.out.println("Ward creation failed: " + e.getMessage());
		}
		
	}
}



