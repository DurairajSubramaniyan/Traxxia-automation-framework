Feature: Traxxia login

  Background: Navigate to the Traxxia login page
    Given User navigate to Login Page for Admin "https://trax-qa-app-cdeeceg5bxf2bmf4.centralus-01.azurewebsites.net/login"
    Then welcome message should be displayed

  @regression
  Scenario: Login success
    When user enter email "traxxiaQa@gmail.com" password "Traxxia@123"
    And click Login button
    Then user is redirected to the Dashboard page

  @regression
  Scenario: Login with invalid password
    When user enter email "admin@traxxia.com" password "Wrong@123"
    And click Login button
    Then error message "Invalid credentials" should be displayed

  @regression
  Scenario: Login with empty email and password
    When user leave email and password fields empty
    And click Login button
    Then validation message should be displayed

  @regression
  Scenario: Login with empty password
    When user enter email "admin@traxxia.com" and leave password field empty
    And click Login button
    Then validation message "Password is required" should be displayed for empty password

  @regression
  Scenario: Login with empty email
    When user leave email field empty and enter password "admin@123"
    And click Login button
    Then validation message "Email is required" should be displayed for empty email
