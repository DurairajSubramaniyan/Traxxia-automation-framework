Feature: Traxxia kickstart project flow

  Background: Navigate to login page for Admin
    Given User navigate to Login Page for Admin "https://trax-qa-app-cdeeceg5bxf2bmf4.centralus-01.azurewebsites.net/login"
    Then welcome message should be displayed

  @Regression
  Scenario: Complete flow - create business and complete the 9-step PMF onboarding flow
    Given User signs in to Application with email "traxxiaQa@gmail.com" and password "Traxxia@123"
    And User creates a new business with name "Sample Business" and purpose "Provide mortgage lending solutions"
    And User completes the 9-step PMF onboarding flow

  @Regression
  Scenario: Existing business - select business, navigate to priorities, and kickstart first project
    Given User signs in to Application with email "traxxiaQa@gmail.com" and password "Traxxia@123"
    And Click Businesses menu
    And User selects the existing business "NoCollab4"
    And verify that I Land on Executive summary Page
    And User clicks Execution and select the priority
    When User selects the first available priority
    And User clicks Kickstart Projects
    Then the collaborator warning popup should be displayed
    When User chooses "Add Collaborators First" on the collaborator warning popup
    Then the Add Collaborators page should be displayed

  @Regression
  Scenario: Existing business - second project kickstart without warning popup
    Given User signs in to Application with email "traxxiaQa@gmail.com" and password "Traxxia@123"
    And Click Businesses menu
    And User selects the existing business "NoCollab4"
    And User clicks Execution and select the priority
    When User selects the first available priority
    And User clicks Kickstart Projects
    Then the collaborator warning popup should be displayed
    When User chooses "Kickstart to Projects" on the collaborator warning popup
    Then the project kickstart success popup or Projects page should be displayed
    And click Go to Projects on the success popup
    And the Projects page should be displayed
    When User navigates to the Priorities section again
    And User selects another available priority
    And User clicks Kickstart Projects
    Then the collaborator warning popup should not be displayed
