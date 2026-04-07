package com.anhtester.projects.website.crm.stepdefinitions;

import com.anhtester.common.CommonPageCRM;
import com.anhtester.projects.website.crm.pages.KickstartPageCRM;
import com.anhtester.keywords.WebUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class KickstartProjectSteps extends CommonPageCRM {

    private KickstartPageCRM kickstartPage;

    @Given("User signs in to Application with email {string} and password {string}")
    public void userSignsInToCRMWithEmailAndPassword(String email, String password) {
        getSignInPage().signIn(email, password);
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

    @And("User clicks Execution")
    public void userClicksExecution() {
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

    @Then("the Projects page should be displayed")
    public void theProjectsPageShouldBeDisplayed() {
        getKickstartPage().verifyProjectsPageDisplayed();
    }

    @And("User navigates to the Priorities section again")
    public void userNavigatesToThePrioritiesSectionAgain() {
        getKickstartPage().navigateToPrioritiesSection();
    }
}
