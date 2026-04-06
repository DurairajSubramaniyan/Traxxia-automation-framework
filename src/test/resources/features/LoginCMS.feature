@regression
Feature: Login Test CMS

   Background: Navigate to Login page for Admin
      Given User navigate to Login Page for Admin "https://frontend-f2lm.onrender.com/login"

  
   Scenario: Login success
      When user enter email "traxxiaQa@gmail.com" password "Traxxia@123"
      And click Login button
      Then user is redirected to the Dashboard page

   
   Scenario: Login with invalid password
      When user enter email "admin@traxxia.com" password "Wrong@123"
      And click Login button
      Then error message "Invalid credentials" should be displayed

  
   Scenario: Login with empty email and password
      When user leave email and password fields empty
      And click Login button
      Then validation message "Email and Password are required" should be displayed

  
   Scenario: Login with invalid email format
      When user enter email "invalidemail" password "admin@123"
      And click Login button
      Then validation message "Enter valid email address" should be displayed

  
   Scenario: Login with empty password
      When user enter email "admin@tarxxia.com" and leave password field empty
      And click Login button
      Then validation message "Password is required" should be displayed

  
   Scenario: Login with empty email
      When user leave email field empty and enter password "admin@123"
      And click Login button
      Then validation message "Email is required" should be displayed

   
   Scenario: Login with case sensitivity check
      When user enter email "ADMIN@TRAXXIA.COM" password "Admin@123"
      And click Login button
      hen user should be logged in successfully

   