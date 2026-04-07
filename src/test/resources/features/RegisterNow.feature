Feature: Register Now page

  Background: Navigate to the Register page
    Given User navigates to the Register page

  @regression
  Scenario: Register with valid details
    When user enters full name "John Doe" email "john.doe@example.com" password "Password@123" confirm password "Password@123"
    And user clicks Register button
    Then user should be redirected to the company setup or success page

  @regression
  Scenario: Register with missing required fields
    When user leaves full name, email, password and confirm password empty
    And user clicks Register button
    Then validation messages should be displayed for required fields

  @regression
  Scenario: Register with invalid email format
    When user enters full name "John Doe" email "john.doe" password "Password@123" confirm password "Password@123"
    And user clicks Register button
    Then validation message "Invalid email address" should be displayed

  @regression
  Scenario: Register with password mismatch
    When user enters full name "John Doe" email "john.doe@example.com" password "Password@123" confirm password "Password@12"
    And user clicks Register button
    Then validation message "Passwords do not match" should be displayed

  @regression
  Scenario: Register with weak password
    When user enters full name "John Doe" email "john.doe@example.com" password "123456" confirm password "123456"
    And user clicks Register button
    Then validation message "Password does not meet security requirements" should be displayed

  @regression
  Scenario: Register with leading and trailing whitespace
    When user enters full name "  John Doe  " email "  john.doe@example.com  " password "Password@123" confirm password "Password@123"
    And user clicks Register button
    Then registration should succeed and whitespace should be trimmed
