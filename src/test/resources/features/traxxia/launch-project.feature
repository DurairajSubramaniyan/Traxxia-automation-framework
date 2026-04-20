Feature: Traxxia project launch flow

  Background: Navigate to login page for Admin
    Given User navigate to Login Page for Admin "https://trax-qa-app-cdeeceg5bxf2bmf4.centralus-01.azurewebsites.net/login"
    Then welcome message should be displayed

  @testing
  Scenario: Active business - launching an unranked draft project should show ranking validation
    Given User signs in to Application with email "traxxiaQa@gmail.com" and password "Traxxia@123"
    When I click profile icon on the top right corner
    And I click admin panel option from the dropdown
    And User ensures the business "Traxxia 3.1 phase" has no collaborators in the Admin Panel
    And User goes back to Dashboard from Admin Panel
    And User opens the Project Phase business list
    And User selects the existing business "Traxxia 3.1 phase"
    And User select the execution and select the project   
    And User opens the Projects tab for the selected business
    When User selects an unranked draft project for launch
    And User clicks Launch for the selected project
    Then the ranking validation message should be displayed

  @Regression
  Scenario: Active business - launching a ranked project without cadence should require project details
    Given User signs in to Application with email "traxxiaQa@gmail.com" and password "Traxxia@123"
    When I click profile icon on the top right corner
    And I click admin panel option from the dropdown
    And User ensures the business "cooper" has no collaborators in the Admin Panel
    And User goes back to Dashboard from Admin Panel
    And User opens the Project Phase business list
    And User selects the existing business "cooper"
    And User opens the Projects tab for the selected business
    When User selects the ranked project for launch
    And User clicks Launch for the selected project
    Then the project details form should be displayed for cadence completion

  @Regression
  Scenario: Active business - launching a ranked project after cadence completion should succeed
    Given User signs in to Application with email "traxxiaQa@gmail.com" and password "Traxxia@123"
    When I click profile icon on the top right corner
    And I click admin panel option from the dropdown
    And User ensures the business "cooper" has no collaborators in the Admin Panel
    And User goes back to Dashboard from Admin Panel
    And User opens the Project Phase business list
    And User selects the existing business "cooper"
    And User opens the Projects tab for the selected business
    And User ranks the selected project for launch
    And User opens the selected project for editing
    When User completes the required launch details with cadence "Weekly"
    And User saves the project changes
    And User opens the Projects tab for the selected business
    And User selects the ranked project for launch
    And User clicks Launch for the selected project
    Then the project launch success message should be displayed
