package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import pages.LoginPage;
import static org.junit.Assert.assertTrue;

public class LoginStep {

    private LoginPage loginPage = new LoginPage();

    @Given("User opens app")
    public void userOpensApp() {
        loginPage.userOpensApp();
    }

    @And("User fills email as {string}")
    public void userFillsEmailAs(String email) {
        loginPage.enterEmail(email);
    }

    @And("User fills password as {string}")
    public void userFillsPasswordAs(String password) {
        loginPage.enterPassword(password);
    }

    @When("User clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("User should see the profile page")
    public void userShouldSeeTheProfilePage() {
        boolean profilePageVisible = loginPage.isProfilePageVisible();
        assertTrue("Profile page should be visible", profilePageVisible);
    }

    @Then("User should see an error message {string}")
    public void userShouldSeeAnErrorMessage(String errorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        assertTrue("Error message should be " + errorMessage, errorMessage.equals(actualErrorMessage));
    }

    @Then("User should see an error message for invalid email format")
    public void userShouldSeeAnErrorMessageForInvalidEmailFormat() {
        String actualErrorMessage = loginPage.getErrorMessage();
        assertTrue("Error message should be 'Invalid email format'", "Invalid email format".equals(actualErrorMessage));
    }

}
