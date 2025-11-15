package Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Shift_Feature {

    AppiumDriver driver;
    WebDriverWait wait;

    public Shift_Feature(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // <-- initialize wait
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Add Shift, Create duty shift']")
    public WebElement AddShiftinDashboard;

    @FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[1]")
    public WebElement ShiftName;

    @FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[2]")
    public WebElement ShiftCode;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Next']")
    public WebElement NextButton;

    @FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText[1]")
    public WebElement StartTime;

    @FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText[2]")
    public WebElement EndTime;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Next']")
    public WebElement NextButton1;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Create Shift']")
    public WebElement CreateShift;

    public void createshift(String shiftname, String shiftcode, String starttime, String endtime) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AddShiftinDashboard)).click();

            wait.until(ExpectedConditions.visibilityOf(ShiftName)).clear();
            ShiftName.sendKeys(shiftname);

            wait.until(ExpectedConditions.visibilityOf(ShiftCode)).clear();
            ShiftCode.sendKeys(shiftcode);
            
            wait.until(ExpectedConditions.elementToBeClickable(NextButton)).click();

            wait.until(ExpectedConditions.visibilityOf(StartTime)).clear();
            StartTime.sendKeys(starttime);

            wait.until(ExpectedConditions.visibilityOf(EndTime)).clear();
            EndTime.sendKeys(endtime);

            wait.until(ExpectedConditions.elementToBeClickable(NextButton1)).click();
            wait.until(ExpectedConditions.elementToBeClickable(CreateShift)).click();

            System.out.println("Shift created successfully.");

        } catch (Exception e) {
            System.out.println("Shift creation failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
