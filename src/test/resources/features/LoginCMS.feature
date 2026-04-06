Feature: Login Test CMS

   Background: Navigate to Login page for Admin
      Given User navigate to Login Page for Admin "https://frontend-f2lm.onrender.com/login"

   @regression 
   Scenario: Login success
      When user enter email "traxxiaQa@gmail.com" password "Traxxia@123"
      And click Login button
      Then user is redirected to the Dashboard page