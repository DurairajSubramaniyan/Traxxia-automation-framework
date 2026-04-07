package com.anhtester.projects.website.crm.stepdefinitions;

import com.anhtester.common.CommonPageCRM;
import com.anhtester.projects.website.crm.pages.RegisterPageCRM;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RegisterNowSteps extends CommonPageCRM {

    private RegisterPageCRM registerPage;

    @Given("User navigates to the Register page")
    public void userNavigatesToTheRegisterPage() {
        getRegisterPage().openRegisterPage();
    }

    @When("user enters full name {string} email {string} password {string} confirm password {string}")
    public void userEntersRegistrationDetails(String fullName, String email, String password, String confirmPassword) {
        getRegisterPage().enterFullName(fullName);
        getRegisterPage().enterEmail(email);
        getRegisterPage().enterPassword(password);
        getRegisterPage().enterConfirmPassword(confirmPassword);
    }

    @When("user leaves full name, email, password and confirm password empty")
    public void userLeavesAllRegistrationFieldsEmpty() {
        getRegisterPage().clearAllFields();
    }

    @And("user clicks Register button")
    public void userClicksRegisterButton() {
        getRegisterPage().clickRegisterButton();
    }

    @Then("user should be redirected to the company setup or success page")
    public void userShouldBeRedirectedToSuccessPage() {
        getRegisterPage().verifySuccessPage();
    }

    @Then("validation messages should be displayed for required fields")
    public void validationMessagesShouldBeDisplayedForRequiredFields() {
        getRegisterPage().verifyRequiredFieldValidation();
    }

    @Then("validation message {string} should be displayed")
    public void validationMessageShouldBeDisplayed(String expectedMessage) {
        getRegisterPage().verifyValidationMessage(expectedMessage);
    }

    @Then("registration should succeed and whitespace should be trimmed")
    public void registrationShouldSucceedAndWhitespaceShouldBeTrimmed() {
        String actualFullNameValue = getRegisterPage().getActualFullNameValue();
        String actualEmailValue = getRegisterPage().getActualEmailValue();
        Assert.assertNotNull(actualFullNameValue, "Full name value was not captured during form entry.");
        Assert.assertNotNull(actualEmailValue, "Email value was not captured during form entry.");
        Assert.assertEquals(actualFullNameValue, actualFullNameValue.trim(), "Full name value was not trimmed before submission.");
        Assert.assertEquals(actualEmailValue, actualEmailValue.trim(), "Email value was not trimmed before submission.");
        getRegisterPage().verifySuccessPage();
    }
}
