package pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;

import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginPage {
    private AppiumDriver driver;

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void userOpensApp() {
        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("appium:deviceName", "Pixel 6")
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:udid", "Android Emulator")
                .amend("appium:avd", "Pixel_6_Pro_API_32")
                .amend("appium:fastReset", true)
                .amend("appium:newCommandTimeout", 5)
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:connectHardwareKeyboard", true)
                .amend("appium:app", "");


        driver = new AndroidDriver(this.getUrl(), options);

    }

    // Locators
    private By emailField = By.id("io.selendroid.testapp:id/my_text_field");
    private By passwordField = By.id("io.selendroid.testapp:id/my_password_field");
    private By loginButton = By.id("io.selendroid.testapp:id/login_button");
    private By profilePageLocator = By.id("io.selendroid.testapp:id/profile_page");
    private By errorMessageLocator = By.id("io.selendroid.testapp:id/error_message");

    // Actions
    public void enterEmail(String username) {
        driver.findElement(emailField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }


    public boolean isProfilePageVisible() {
        try {
            return driver.findElement(profilePageLocator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage() {
        try {
            return driver.findElement(errorMessageLocator).getText();
        } catch (Exception e) {
            return "";
        }
    }
}
