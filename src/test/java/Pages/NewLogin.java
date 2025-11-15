package Pages;





import java.time.Duration;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class NewLogin  extends Baseclass_page{
    AppiumDriver driver;
    WebDriverWait wait;

    public NewLogin(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @FindBy(xpath = "//android.widget.EditText[@text='User ID']")
    public WebElement username;

    @FindBy(xpath = "//android.widget.EditText[@text='Password']")  
    public WebElement password;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Log in']")
    public WebElement loginButton;

    // Method to perform login
    public void login(String user, String pass) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(username)).click();
            username.clear();

            username.sendKeys(user);

            wait.until(ExpectedConditions.elementToBeClickable(password)).click();
            password.clear();
            password.sendKeys(pass);
            Thread.sleep(5000);
            if (driver instanceof AndroidDriver) {
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
                Thread.sleep(1000);
            }

            


          //  wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
           // Thread.sleep(2000);

            wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
        }
    }
}
