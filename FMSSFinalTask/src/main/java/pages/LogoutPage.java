package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class LogoutPage {
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
    private By logoutButton = By.id("io.selendroid.testapp:id/logout_button");
    private By loginPageLocator = By.id("io.selendroid.testapp:id/login_page");;

    // Actions
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    public boolean isLoginPageVisible() {
        try {
            return driver.findElement(loginPageLocator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public void navigateToProfilePage() {
        driver.get("app://profile_page");
    }
}
