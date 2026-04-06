package com.anhtester.projects.website.cms.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage {

    // ================= LOCATORS =================

    private By inputEmail = By.xpath("//input[@type='email']");
    private By inputPassword = By.xpath("//input[@type='password']");
    private By buttonLogin = By.xpath("//button[@type='submit']");

    // Validation messages (form level)
    private By validationMessage = By.xpath("//div[contains(@class,'invalid-feedback')]");

    // Popup (Invalid login)
    private By popupTitle = By.xpath("//div[contains(@class,'error-modal-container')]//h5");
    private By popupMessage = By.xpath("//div[contains(@class,'error-modal-container')]//p");
    private By tryAgainButton = By.xpath("//button[text()='Try Again']");

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

    //  Validation message (empty fields, invalid format)
    public void verifyValidationMessage(String expectedMessage) {
        WebUI.waitForElementVisible(validationMessage);
        WebUI.verifyElementText(validationMessage, expectedMessage);
    }

    //  Popup verification (invalid credentials)
    public void verifyLoginFailedPopup(String expectedMessage) {
       WebUI.waitForElementVisible(popupTitle);

     String actualTitle = WebUI.getTextElement(popupTitle);
     String actualMessage = WebUI.getTextElement(popupMessage);

     Assert.assertEquals(actualTitle, "Login Failed", "Title mismatch");
     Assert.assertEquals(actualMessage, expectedMessage, "Message mismatch");
    }
    

    // ================= POPUP ACTION =================

    public void clickTryAgain() {
        WebUI.waitForElementVisible(tryAgainButton);
        WebUI.clickElement(tryAgainButton);
    }
}