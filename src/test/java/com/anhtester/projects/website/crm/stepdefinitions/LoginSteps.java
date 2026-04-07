package com.anhtester.projects.website.crm.stepdefinitions;

import com.anhtester.common.CommonPageCRM;
import com.anhtester.keywords.WebUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.anhtester.keywords.WebUI.getCurrentUrl;
import static com.anhtester.keywords.WebUI.verifyContains;

public class LoginSteps extends CommonPageCRM {

    private final By welcomeMessage = By.xpath("//*[contains(normalize-space(),'Welcome') or contains(normalize-space(),'Sign In') or contains(normalize-space(),'Login')]");

    @Given("User navigate to Login Page for Admin {string}")
    public void userNavigateToLoginPageForAdmin(String url) {
        WebUI.openWebsite(url);
        WebUI.waitForPageLoaded();
    }

    @Then("welcome message should be displayed")
    public void welcomeMessageShouldBeDisplayed() {
        WebUI.verifyElementPresent(welcomeMessage, 10, "Welcome message is not displayed on the login page");
    }

    @Given("User navigate to url {string}")
    public void userNavigateToUrl(String url) {
        WebUI.openWebsite(url);
        WebUI.waitForPageLoaded();
    }

    @When("User login with username {string} and password {string} valid")
    public void userLoginWithUsernameAndPasswordValid(String email, String password) {
        getSignInPage().signIn(email, password);
        getSignInPage().verifySignInSuccess();
    }

    @When("User login with username {string} and password {string} invalid")
    public void userLoginWithUsernameAndPasswordInvalid(String email, String password) {
        getSignInPage().signIn(email, password);
        getSignInPage().verifySignInFail();
    }

    @Then("The user redirect to Dashboard page")
    public void theUserRedirectToDashboardPage() {
        WebUI.waitForPageLoaded();
        verifyContains(getCurrentUrl(), getDashboardPage().pageUrl, "Can not redirect to the dashboard page.");

    }

    @Then("The user can not redirect to Dashboard page")
    public void theUserCanNotRedirectToDashboardPage() {
        WebUI.verifyElementNotPresent(getSignInPage().labelEmailError, "FAIL. User sign in successfully");
    }

    @And("The error message is displays")
    public void theErrorMessageIsDisplays() {
        WebUI.verifyElementPresent(getSignInPage().alertErrorMessage, "The error message does not display");
    }
}
