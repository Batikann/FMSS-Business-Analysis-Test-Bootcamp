package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignupPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SignupStep {

    private SignupPage signupPage = new SignupPage();

    @Given("User opens app")
    public void userOpensApp() {
        signupPage.userOpensApp();
    }

    @And("User navigates to register page")
    public void userNavigatesToRegisterPage() {
        signupPage.navigateToRegisterPage();
    }

    @And("User fills registration details with:")
    public void userFillsRegistrationDetailsWith(io.cucumber.datatable.DataTable dataTable) {
        var data = dataTable.asMaps(String.class, String.class).get(0);

        if (data.containsKey("Name")) {
            signupPage.enterName(data.get("Name"));
        }
        if (data.containsKey("Surname")) {
            signupPage.enterSurname(data.get("Surname"));
        }
        if (data.containsKey("Email")) {
            signupPage.enterEmail(data.get("Email"));
        }
        if (data.containsKey("Identity Number")) {
            signupPage.enterIdentityNumber(data.get("Identity Number"));
        }
        if (data.containsKey("Passport Number")) {
            signupPage.enterPassportNumber(data.get("Passport Number"));
        }
        if (data.containsKey("Phone Number")) {
            signupPage.enterPhoneNumber(data.get("Phone Number"));
        }
        if (data.containsKey("Password")) {
            signupPage.enterPassword(data.get("Password"));
        }
    }

    @When("User clicks on register button")
    public void userClicksOnRegisterButton() {
        signupPage.clickRegisterButton();
    }

    @Then("User should be redirected to the login page")
    public void userShouldBeRedirectedToTheLoginPage() {
        assertTrue(signupPage.isLoginPageDisplayed());
    }

    @Then("User should see an error message {string}")
    public void userShouldSeeAnErrorMessage(String expectedErrorMessage) {
        assertEquals(expectedErrorMessage, signupPage.getErrorMessage());
    }

    @And("User should stay on the register page")
    public void userShouldStayOnTheRegisterPage() {
        assertTrue(signupPage.isOnRegisterPage());
    }
}
