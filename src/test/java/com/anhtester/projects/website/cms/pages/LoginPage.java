package com.anhtester.projects.website.cms.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage {

    // ================= LOCATORS =================

    private By inputEmail = By.xpath("//input[@type='email']");
    private By inputPassword = By.xpath("//input[@type='password']");
    private By buttonLogin = By.xpath("//button[@type='submit']");


    // Popup (Invalid login)
    private By popupTitle = By.xpath("//div[contains(@class,'error-modal-container')]//h5");
    private By popupMessage = By.xpath("//div[contains(@class,'error-modal-container')]//p");
    private By tryAgainButton = By.xpath("//button[text()='Try Again']");

    // Dashboard page elements (for successful login validation)
    private By welcomeTitle = By.xpath("(//h5[text()='Welcome!'])[2]");
    private By welcomeContent = By.xpath("//p[@class='text-muted mb-4']");

    // Validation messages (field level)
    By emailErrorMessage = By.xpath("//span[text()='Email is required']");
    By passwordErrorMessage = By.xpath("//span[text()='Password is required']");

    By welcomeHeader = By.xpath("//h2[text()='Welcome!']");

    // ================= ACTION METHODS =================

    public void enterEmail(String email) {
        WebUI.setText(inputEmail, email);
    }

    public void enterPassword(String password) {
        WebUI.setText(inputPassword, password);
    }

    public void clickLoginButton() {
        WebUI.clickElement(buttonLogin);
    }

    // Combined login
    public CommonPageCMS loginCMS(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        return new CommonPageCMS();
    }





    // ================= VALIDATIONS =================
// Welcome message verification
    public void verifyWelcomeMessage() {
    WebUI.waitForElementVisible(welcomeHeader);
    String actualText = WebUI.getTextElement(welcomeHeader);
    Assert.assertEquals(actualText, "Welcome!", "Welcome message mismatch");
}

    //  Validation message (empty fields, invalid format)
    public void verifyValidationMessages() {

    WebUI.waitForElementVisible(emailErrorMessage);
    WebUI.waitForElementVisible(passwordErrorMessage);

    String actualEmailError = WebUI.getTextElement(emailErrorMessage);
    String actualPasswordError = WebUI.getTextElement(passwordErrorMessage);

    Assert.assertEquals(actualEmailError, "Email is required", "Email error mismatch");
    Assert.assertEquals(actualPasswordError, "Password is required", "Password error mismatch");
   }


    //  Popup verification (invalid credentials)
    public void verifyLoginFailedPopup(String expectedMessage) {
       WebUI.waitForElementVisible(popupTitle);

     String actualTitle = WebUI.getTextElement(popupTitle);
     String actualMessage = WebUI.getTextElement(popupMessage);

     Assert.assertEquals(actualTitle, "Login Failed", "Title mismatch");
     Assert.assertEquals(actualMessage, expectedMessage, "Message mismatch");
    }


    public void verifyDashboardPage() {
    WebUI.waitForElementVisible(welcomeTitle);

    String actualTitle = WebUI.getTextElement(welcomeTitle);
    String actualContent = WebUI.getTextElement(welcomeContent);

    Assert.assertEquals(actualTitle, "Welcome!", "Title mismatch");

    Assert.assertTrue(
        actualContent.contains("Create business plans step by step with the S.T.R.A.T.E.G.I.C framework. Activate AI capabilities for analysis, prediction, and decision-making."),
        "Content mismatch"
    );
    }
  
    public void verifyValidationPasswordMessage(String expectedMessage) {
    WebUI.waitForElementVisible(passwordErrorMessage);
    String actualPasswordError = WebUI.getTextElement(passwordErrorMessage);
    Assert.assertEquals(actualPasswordError, "Password is required", "Password error mismatch");
   }
    
   public void verifyValidationEmailMessage(String expectedMessage) {
    WebUI.waitForElementVisible(emailErrorMessage);
    String actualEmailError = WebUI.getTextElement(emailErrorMessage);
    Assert.assertEquals(actualEmailError, "Email is required", "Email error mismatch");
   }
   

    // ================= POPUP ACTION =================

    public void clickTryAgain() {
        WebUI.waitForElementVisible(tryAgainButton);
        WebUI.clickElement(tryAgainButton);
    }
}