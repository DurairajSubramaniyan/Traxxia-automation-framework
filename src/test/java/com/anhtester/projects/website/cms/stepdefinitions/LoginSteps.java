package com.anhtester.projects.website.cms.stepdefinitions;

import com.anhtester.hooks.TestContext;
import com.anhtester.keywords.WebUI;
import com.anhtester.projects.website.cms.pages.CommonPageCMS;
import com.anhtester.projects.website.cms.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    LoginPage loginPage;
    CommonPageCMS commonPageCMS;

    public LoginSteps(TestContext testContext) {
        loginPage = testContext.getLoginPage();
        commonPageCMS = testContext.getCommonPage();
    }

    @Given("User navigate to Login Page for Admin {string}")
    public void userNavigateToLoginPageForAdmin(String url) {
        WebUI.openWebsite(url);
    }

    // Common login step
    @When("user enter email {string} password {string}")
    public void userEnterEmailPassword(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @And("click Login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    //  Success case
    @Then("user is redirected to the Dashboard page")
    public void userIsRedirectedToDashboardPage() {
        commonPageCMS.verifyDashboardPageDisplays();
    }

    //  Invalid credentials
    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String message) {
    loginPage.verifyLoginFailedPopup(message);
    loginPage.clickTryAgain(); 
}

    //  Empty email & password
    @When("user leave email and password fields empty")
    public void userLeaveEmailAndPasswordFieldsEmpty() {
        loginPage.enterEmail("");
        loginPage.enterPassword("");
    }

    //  Empty password
    @When("user enter email {string} and leave password field empty")
    public void userEnterEmailAndLeavePassword(String email) {
        loginPage.enterEmail(email);
        loginPage.enterPassword("");
    }

    //  Empty email
    @When("user leave email field empty and enter password {string}")
    public void userLeaveEmailAndEnterPassword(String password) {
        loginPage.enterEmail("");
        loginPage.enterPassword(password);
    }

    //  Validation message
    @Then("validation message {string} should be displayed")
    public void validationMessageShouldBeDisplayed(String message) {
        loginPage.verifyValidationMessage(message);
    }

    //  Case sensitivity check
    @Then("user should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        commonPageCMS.verifyDashboardPageDisplays();
    }
}