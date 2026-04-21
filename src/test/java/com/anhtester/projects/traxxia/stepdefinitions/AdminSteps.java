package com.anhtester.projects.traxxia.stepdefinitions;

import com.anhtester.common.TraxxiaPageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminSteps extends TraxxiaPageManager {


    @Given("user navigates to the Admin section")
    public void userNavigatesToTheAdminSection() {
        getAdminPage().navigateToAdminSection();
    }

    @When("user opens the {string} tab")
    public void userOpensTheTab(String tabName) {
        getAdminPage().openAdminTab(tabName);
    }

    @Then("the {string} heading should be displayed")
    public void theHeadingShouldBeDisplayed(String headingText) {
        getAdminPage().verifyAdminHeading(headingText);
    }
}