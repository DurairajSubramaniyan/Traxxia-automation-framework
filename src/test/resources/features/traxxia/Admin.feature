@adminrun
Feature: Traxxia admin panel

  Background: Navigate to the Traxxia login page
    Given User navigate to Login Page for Admin "https://trax-qa1-app-epf5b2egeaasevhg.centralus-01.azurewebsites.net/login"
    Then welcome message should be displayed
    When user enter email "traxxiaQa@gmail.com" password "Traxxia@123"
    And click Login button
    Then user is redirected to the Dashboard page
  



  Scenario: Open all admin panel tabs and verify headings
    Given  user navigates to the Admin section
    When user opens the "Company" tab
    Then the "My Company" heading should be displayed

    When user opens the "Businesses" tab
    Then the "Business Overview" heading should be displayed

    When user opens the "User Management" tab
    Then the "User Management" heading should be displayed

    When user opens the "Access Management" tab
    Then the "Access Management" heading should be displayed

    When user opens the "User History" tab
    Then the "User History & Chat Records" heading should be displayed

    When user opens the "Audit Trail" tab
    Then the "Audit Trail" heading should be displayed

    When user opens the "Subscription" tab
    Then the "Billing History" heading should be displayed