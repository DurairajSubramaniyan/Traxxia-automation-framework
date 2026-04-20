@runthepage
Feature: Traxxia login

  Background: Navigate to the Traxxia login page
    Given User navigate to Login Page for Admin "https://trax-qa-app-cdeeceg5bxf2bmf4.centralus-01.azurewebsites.net/login"
    Then welcome message should be displayed

  
  Scenario: Login success
    When user enter email "traxxiaQa@gmail.com" password "Traxxia@123"
    And click Login button
    Then user is redirected to the Dashboard page

 
  Scenario: Login with invalid password
    When user enter email "admin@traxxia.com" password "Wrong@123"
    And click Login button
    Then error message "Incorrect password" should be displayed

  Scenario: Login with invalid email
    When user enter email "admin@traxxia.co" password "Wrong@123"
    And click Login button
    Then I can see the error message "Incorrect email address" 


  Scenario: Login with empty email and password
    When user leave email and password fields empty
    And click Login button
    Then validation message should be displayed

  
  Scenario: Login with empty password
    When user enter email "admin@traxxia.com" and leave password field empty
    And click Login button
    Then validation message "Password is required" should be displayed for empty password

 
  Scenario: Login with empty email
    When user leave email field empty and enter password "admin@123"
    And click Login button
    Then validation message "Email is required" should be displayed for empty email
