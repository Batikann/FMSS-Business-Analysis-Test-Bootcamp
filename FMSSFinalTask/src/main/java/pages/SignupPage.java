package pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;


public class SignupPage {
    private AppiumDriver driver;

    // Locator Definitions
    private By nameField = By.id("#name");
    private By surnameField = By.id("#surname");
    private By emailField = By.id("#email");
    private By identityNumberField = By.id("#identityNumber");
    private By passportNumberField = By.id("#passportNumber");
    private By phoneNumberField = By.id("#phoneNumber");
    private By passwordField = By.id("#password");
    private By registerButton = By.id("#registerButton");
    private By errorMessage = By.id("#errorMessage");

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

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterIdentityNumber(String identityNumber) {
        driver.findElement(identityNumberField).sendKeys(identityNumber);
    }

    public void enterPassportNumber(String passportNumber) {
        driver.findElement(passportNumberField).sendKeys(passportNumber);
    }

    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public boolean isLoginPageDisplayed() {
        try {
            WebElement loginPage = driver.findElement(By.id("login_page_id"));
            return loginPage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isOnRegisterPage() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains("/register");
    }

    public void navigateToRegisterPage() {
        WebElement registerLink = driver.findElement(By.id("register_link_id")); // Update with actual ID
        registerLink.click();
    }
}
