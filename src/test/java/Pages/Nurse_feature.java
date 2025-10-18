package Pages;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
public class Nurse_feature extends Baseclass_page{

	AppiumDriver driver;
	WebDriverWait wait;

	public Nurse_feature(AppiumDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Add Nurse, Add new nurse']")
	public WebElement AddNurseinDashboard;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Add Nurse']")  
	public WebElement AddNurse;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[1]")
	public WebElement NurseCode;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[2]")
	public WebElement FirstName;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[3]")
	public WebElement LastName;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[4]")
	public WebElement Speciality;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[5]")
	public WebElement Experince;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[6]")
	public WebElement NurseType;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[7]")
	public WebElement DOB;


	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[8]")
	public WebElement Gender;

	
	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText[6]")
	public WebElement SharedPhoneNumber;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Next']")
	public WebElement NextButton;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText[1]")
	public WebElement ContactName;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText[2]")
	public WebElement ContactPhone;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText[3]")
	public WebElement ContactEmail;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Next']")
	public WebElement ContactInfoNextButton;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText[1]")
	public WebElement Street;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText[2]")
	public WebElement City;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText[3]")
	public WebElement PinCode;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText[4]")
	public WebElement State;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText[5]")
	public WebElement Country;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Create Nurse']")
	public WebElement CreateNurseButton;

	public void createnursemethod(String nursecode, String firstname, String lastname, String speciality, String experince, String nursetype, String dob, String gender, String sharedphonenumber, String contactname, String contactphone, String contactemail, String street, String city, String pincode, String state, String country) {
	    try {
	        wait.until(ExpectedConditions.elementToBeClickable(AddNurseinDashboard)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(AddNurse)).click();

	        wait.until(ExpectedConditions.visibilityOf(NurseCode)).clear();
	        NurseCode.sendKeys(nursecode);

	        wait.until(ExpectedConditions.visibilityOf(FirstName)).clear();
	        FirstName.sendKeys(firstname);

	        wait.until(ExpectedConditions.visibilityOf(LastName)).clear();
	        LastName.sendKeys(lastname);

	        wait.until(ExpectedConditions.visibilityOf(Speciality)).clear();
	        Speciality.sendKeys(speciality);

	        wait.until(ExpectedConditions.visibilityOf(Experince)).clear();
	        Experince.sendKeys(experince);

	        wait.until(ExpectedConditions.visibilityOf(NurseType)).clear();
	        NurseType.sendKeys(nursetype);

	        wait.until(ExpectedConditions.visibilityOf(DOB)).clear();
	        DOB.sendKeys(dob);

	        wait.until(ExpectedConditions.visibilityOf(Gender)).clear();
	        Gender.sendKeys(gender);
	        
	        String desc = "Shared Phone Number"; 

//	        driver.findElement(AppiumBy.androidUIAutomator(
//	            "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
//	            ".scrollIntoView(new UiSelector().description(\"" + desc + "\"))"));
	        driver.findElement(AppiumBy.androidUIAutomator(
	        	    "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
	        	    ".scrollIntoView(new UiSelector().textContains(\"Shared Phone Number\"))"));

	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement phoneField = wait.until(ExpectedConditions.elementToBeClickable(SharedPhoneNumber));

	        phoneField.click();

	        phoneField.clear();

	        phoneField.sendKeys(sharedphonenumber);

	       
	        try {
	        	((AndroidDriver) driver).hideKeyboard();
	        } catch (Exception e) {
	            System.out.println("Keyboard not open or already hidden.");
	        }
	            WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(NextButton));
	            nextBtn.click();

	        Thread.sleep(5000);
	        wait.until(ExpectedConditions.visibilityOf(ContactName)).clear();
	        ContactName.sendKeys(contactname);
	        Thread.sleep(1500);
	        wait.until(ExpectedConditions.visibilityOf(ContactPhone)).clear();
	        ContactPhone.sendKeys(contactphone);
	        Thread.sleep(1500);
	        wait.until(ExpectedConditions.visibilityOf(ContactEmail)).clear();
	        ContactEmail.sendKeys(contactemail);
	        try {
	        	((AndroidDriver) driver).hideKeyboard();
	        } catch (Exception e) {
	            System.out.println("Keyboard not open or already hidden.");
	        }
	        Thread.sleep(1500);
	        
	      wait.until(ExpectedConditions.elementToBeClickable(ContactInfoNextButton)).click();

	        wait.until(ExpectedConditions.visibilityOf(Street)).clear();
	        Street.sendKeys(street);

	        wait.until(ExpectedConditions.visibilityOf(City)).clear();
	        City.sendKeys(city);

	        wait.until(ExpectedConditions.visibilityOf(PinCode)).clear();
	        PinCode.sendKeys(pincode);

	        wait.until(ExpectedConditions.visibilityOf(State)).clear();
	        State.sendKeys(state);

	        wait.until(ExpectedConditions.visibilityOf(Country)).clear();
	        Country.sendKeys(country);

	        wait.until(ExpectedConditions.elementToBeClickable(CreateNurseButton)).click();

	        System.out.println(" Nurse created successfully");

	    } catch (Exception e) {
	        System.out.println("Nurse creation failed: " + e.getMessage());
	    
	}}}
