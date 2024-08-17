package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import pages.LogoutPage;
import static org.junit.Assert.assertTrue;

public class LogoutStep {

    private LogoutPage logoutPage = new LogoutPage();

    @Given("User is logged in")
    public void userIsLoggedIn() {
        logoutPage.userOpensApp();
    }

    @When("User clicks on logout button")
    public void userClicksOnLogoutButton() {
        logoutPage.clickLogoutButton();
    }

    @Then("User should see the login page")
    public void userShouldSeeTheLoginPage() {
        boolean loginPageVisible = logoutPage.isLoginPageVisible();
        assertTrue("Login page should be visible", loginPageVisible);
    }

    @When("User tries to access the profile page directly")
    public void userTriesToAccessTheProfilePageDirectly() {
       logoutPage.navigateToProfilePage();
    }

    @Then("User should be redirected to the login page")
    public void userShouldBeRedirectedToLoginPage() {
        boolean loginPageVisible = logoutPage.isLoginPageVisible();
        assertTrue("User should be redirected to the login page", loginPageVisible);
    }
}
