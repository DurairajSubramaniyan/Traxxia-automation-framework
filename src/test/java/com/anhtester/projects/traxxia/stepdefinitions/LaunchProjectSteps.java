package com.anhtester.projects.traxxia.stepdefinitions;

import com.anhtester.common.TraxxiaPageManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LaunchProjectSteps extends TraxxiaPageManager {

    @When("I click profile icon on the top right corner")
    public void iClickProfileIconOnTheTopRightCorner() {
        getLaunchProjectPage().clickProfileIconOnTopRightCorner();
    }
    @And("I click admin panel option from the dropdown")
    public void iClickAdminPanelOptionFromTheDropdown() {
        getLaunchProjectPage().clickAdminPanelOptionFromDropdown();
    }

    @And("User ensures the business {string} has no collaborators in the Admin Panel")
    public void userEnsuresTheBusinessHasNoCollaboratorsInTheAdminPanel(String businessName) {
        getLaunchProjectPage().ensureBusinessHasNoCollaboratorsInAdminPanel(businessName);
    }

    @And("User goes back to Dashboard from Admin Panel")
    public void userGoesBackToDashboardFromAdminPanel() {
        getLaunchProjectPage().goBackToDashboardFromAdminPanel();
    }

    @And("User opens the Project Phase business list")
    public void userOpensTheProjectPhaseBusinessList() {
        getLaunchProjectPage().openProjectPhaseBusinessList();
    }

    @And ("User select the execution and select the project")
    public void userSelectExecutionAndSelectTheProject() {
        getLaunchProjectPage().selectExecutionAndSelectTheProject();
    }

    @And("User opens the Projects tab for the selected business")
    public void userOpensTheProjectsTabForTheSelectedBusiness() {
        getLaunchProjectPage().openProjectsTabForSelectedBusiness();
    }

    @When("User selects an unranked draft project for launch")
    public void userSelectsAnUnrankedDraftProjectForLaunch() {
        getLaunchProjectPage().selectUnrankedDraftProjectForLaunch();
    }

    @When("User selects the ranked project for launch")
    public void userSelectsTheRankedProjectForLaunch() {
        getLaunchProjectPage().selectRankedProjectForLaunch();
    }

    @And("User clicks Launch for the selected project")
    public void userClicksLaunchForTheSelectedProject() {
        getLaunchProjectPage().clickLaunchForSelectedProject();
    }

    @Then("the ranking validation message should be displayed")
    public void theRankingValidationMessageShouldBeDisplayed() {
        getLaunchProjectPage().verifyRankingValidationMessageDisplayed();
    }

    @And("User ranks the selected project for launch")
    public void userRanksTheSelectedProjectForLaunch() {
        getLaunchProjectPage().rankSelectedProjectForLaunch();
    }

    @Then("the project details form should be displayed for cadence completion")
    public void theProjectDetailsFormShouldBeDisplayedForCadenceCompletion() {
        getLaunchProjectPage().verifyProjectDetailsFormDisplayedForCadenceCompletion();
    }

    @And("User opens the selected project for editing")
    public void userOpensTheSelectedProjectForEditing() {
        getLaunchProjectPage().openSelectedProjectForEditing();
    }

    @When("User completes the required launch details with cadence {string}")
    public void userCompletesTheRequiredLaunchDetailsWithCadence(String cadence) {
        getLaunchProjectPage().completeRequiredLaunchDetails(cadence);
    }

    @And("User saves the project changes")
    public void userSavesTheProjectChanges() {
        getLaunchProjectPage().saveProjectChanges();
    }

    @Then("the project launch success message should be displayed")
    public void theProjectLaunchSuccessMessageShouldBeDisplayed() {
        getLaunchProjectPage().verifyProjectLaunchSuccessMessageDisplayed();
    }
}
