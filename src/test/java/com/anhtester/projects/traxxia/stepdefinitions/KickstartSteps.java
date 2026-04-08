package com.anhtester.projects.traxxia.stepdefinitions;

import com.anhtester.common.TraxxiaPageManager;
import com.anhtester.keywords.WebUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class KickstartSteps extends TraxxiaPageManager {

    @Given("User signs in to Application with email {string} and password {string}")
    public void userSignsInToApplicationWithEmailAndPassword(String email, String password) {
        getLoginPage().enterEmail(email);
        getLoginPage().enterPassword(password);
        getLoginPage().clickLoginButton();
        WebUI.waitForPageLoaded();
    }

    @And("User creates a new business with name {string} and purpose {string}")
    public void userCreatesANewBusinessWithNameAndPurpose(String businessName, String businessPurpose) {
        getKickstartPage().createNewBusiness(businessName, businessPurpose);
    }

    @And("Click Businesses menu")
    public void clickBusinessesMenu() {
        getKickstartPage().clickBusinessesMenu();
    }

    @And("User selects the existing business {string}")
    public void userSelectsTheExistingBusiness(String businessName) {
        getKickstartPage().selectExistingBusiness(businessName);
    }

    @And("verify that I Land on Executive summary Page")
    public void verifyThatILandOnExecutiveSummaryPage() {
        getKickstartPage().verifyExecutiveSummaryPageDisplayed();
    }

    @And("User clicks Execution and select the priority")
    public void userClicksExecutionAndSelectThePriority() {
        getKickstartPage().clickExecutionMenu();
    }

    @And("User completes the 9-step PMF onboarding flow")
    public void userCompletesThe9StepPMFOnboardingFlow() {
        getKickstartPage().completeOnboardingFlow();
    }

    @And("User navigates to the Priorities section")
    public void userNavigatesToThePrioritiesSection() {
        getKickstartPage().navigateToPrioritiesSection();
    }

    @When("User selects the first available priority")
    public void userSelectsTheFirstAvailablePriority() {
        getKickstartPage().selectFirstAvailablePriority();
    }

    @When("User selects another available priority")
    public void userSelectsAnotherAvailablePriority() {
        getKickstartPage().selectAnotherAvailablePriority();
    }

    @And("User clicks Kickstart Projects")
    public void userClicksKickstartProjects() {
        getKickstartPage().clickKickstartProjects();
    }

    @Then("the collaborator warning popup should be displayed")
    public void theCollaboratorWarningPopupShouldBeDisplayed() {
        getKickstartPage().verifyCollaboratorWarningPopupDisplayed();
    }

    @Then("the collaborator warning popup should not be displayed")
    public void theCollaboratorWarningPopupShouldNotBeDisplayed() {
        getKickstartPage().verifyCollaboratorWarningPopupNotDisplayed();
    }

    @When("User chooses {string} on the collaborator warning popup")
    public void userChoosesOnTheCollaboratorWarningPopup(String action) {
        getKickstartPage().chooseCollaboratorWarningAction(action);
    }

    @Then("the Add Collaborators page should be displayed")
    public void theAddCollaboratorsPageShouldBeDisplayed() {
        getKickstartPage().verifyAddCollaboratorsPageDisplayed();
    }

    @Then("the project kickstart success popup or Projects page should be displayed")
    public void theProjectKickstartSuccessPopupOrProjectsPageShouldBeDisplayed() {
        getKickstartPage().verifyProjectKickstartSuccessPopupOrProjectsPageDisplayed();
    }

    @And("click Go to Projects on the success popup")
    public void clickGoToProjectsOnTheSuccessPopup() {
        getKickstartPage().clickGoToProjectsOnSuccessPopup();
    }

    @Then("the Projects page should be displayed")
    public void theProjectsPageShouldBeDisplayed() {
        getKickstartPage().verifyProjectsPageDisplayed();
    }

    @And("User navigates to the Priorities section again")
    public void userNavigatesToThePrioritiesSectionAgain() {
        getKickstartPage().navigateToPrioritiesSection();
    }
}
