package com.anhtester.projects.traxxia.stepdefinitions;

import com.anhtester.common.TraxxiaPageManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends TraxxiaPageManager {

    @When("user enter email {string} password {string}")
    public void userEnterEmailPassword(String email, String password) {
        getLoginPage().enterEmail(email);
        getLoginPage().enterPassword(password);
    }

    @And("click Login button")
    public void clickLoginButton() {
        getLoginPage().clickLoginButton();
    }

    @Then("user is redirected to the Dashboard page")
    public void userIsRedirectedToDashboardPage() {
        getLoginPage().verifyDashboardPage();
    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String message) {
        getLoginPage().verifyLoginFailedPopup(message);
        getLoginPage().clickTryAgain();
    }

    @When("user leave email and password fields empty")
    public void userLeaveEmailAndPasswordFieldsEmpty() {
        getLoginPage().enterEmail("");
        getLoginPage().enterPassword("");
    }

    @When("user enter email {string} and leave password field empty")
    public void userEnterEmailAndLeavePassword(String email) {
        getLoginPage().enterEmail(email);
        getLoginPage().enterPassword("");
    }

    @Then("validation message {string} should be displayed for empty password")
    public void validationMessageShouldBeDisplayedForEmptyPassword(String expectedMessage) {
        getLoginPage().verifyValidationPasswordMessage(expectedMessage);
    }

    @Then("validation message {string} should be displayed for empty email")
    public void validationMessageShouldBeDisplayedForEmptyEmail(String expectedMessage) {
        getLoginPage().verifyValidationEmailMessage(expectedMessage);
    }

    @When("user leave email field empty and enter password {string}")
    public void userLeaveEmailAndEnterPassword(String password) {
        getLoginPage().enterEmail("");
        getLoginPage().enterPassword(password);
    }

    @Then("validation message should be displayed")
    public void validationMessageShouldBeDisplayed() {
        getLoginPage().verifyValidationMessages();
    }

    @Then("user should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        getLoginPage().verifyDashboardPage();
    }
}
