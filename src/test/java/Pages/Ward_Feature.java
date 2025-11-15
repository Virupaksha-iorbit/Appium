package Pages;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
public class Ward_Feature {
	AppiumDriver driver;
	WebDriverWait wait;

	public Ward_Feature(AppiumDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Add Ward, Add new hospital ward']")
	public WebElement AddWardinDashboard;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Add Ward']")  
	public WebElement AddWard;

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup[2]/android.widget.EditText[1]")
	public WebElement WardCode;

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup[2]/android.widget.EditText[2]")
	public WebElement WardName;

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup[2]/android.widget.EditText[3]")
	public WebElement WardType;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Add Ward']")
	public WebElement AddWardButton;
	
	public void createward(String wardcode, String wardname, String wardtype) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(AddWardinDashboard)).click();
			wait.until(ExpectedConditions.elementToBeClickable(AddWard)).click();
			wait.until(ExpectedConditions.visibilityOf(WardCode)).clear();
			WardCode.sendKeys(wardcode);
			wait.until(ExpectedConditions.visibilityOf(WardName)).clear();
			WardName.sendKeys(wardname);
			wait.until(ExpectedConditions.visibilityOf(WardType)).clear();
			WardType.sendKeys(wardtype);
			wait.until(ExpectedConditions.elementToBeClickable(AddWardButton)).click();
			
		}catch (Exception e) {
	        System.out.println("Ward creation failed: " + e.getMessage());
		}
		
	}
}
