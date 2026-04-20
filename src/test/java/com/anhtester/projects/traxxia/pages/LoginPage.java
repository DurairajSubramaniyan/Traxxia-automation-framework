package com.anhtester.projects.traxxia.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage {

    private final By inputEmail = By.xpath("//input[@type='email' or contains(@name,'email') or contains(@id,'email')]");
    private final By inputPassword = By.xpath("//input[@type='password' or contains(@name,'password') or contains(@id,'password')]");
    private final By buttonLogin = By.xpath("//button[@type='submit' or normalize-space()='Login' or normalize-space()='Sign In']");

    private final By popupMessage = By.xpath("//span[@class='error-message']");
    private final By popupMessageForInvalidEmail =By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[2]/form/div[1]/span");
    private final By tryAgainButton = By.xpath("//button[normalize-space()='Try Again']");

    private final By welcomeTitle = By.xpath("(//h5[text()='Welcome!'])[2] | //h2[text()='Welcome!'] | //*[contains(normalize-space(),'Welcome')]");
    private final By welcomeContent = By.xpath("//p[@class='text-muted mb-4']");
    private final By emailErrorMessage = By.xpath("//span[text()='Email is required'] | //*[contains(normalize-space(),'Email is required')]");
    private final By passwordErrorMessage = By.xpath("//span[text()='Password is required'] | //*[contains(normalize-space(),'Password is required')]");

    public void enterEmail(String email) {
        WebUI.setText(inputEmail, email);
    }

    public void enterPassword(String password) {
        WebUI.setText(inputPassword, password);
    }

    public void clickLoginButton() {
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
    }

    public void verifyWelcomeMessage() {
        WebUI.verifyElementPresent(welcomeTitle, 10, "Welcome message mismatch on the Traxxia login page.");
    }

    public void verifyValidationMessages() {
        WebUI.waitForElementVisible(emailErrorMessage);
        WebUI.waitForElementVisible(passwordErrorMessage);

        String actualEmailError = WebUI.getTextElement(emailErrorMessage);
        String actualPasswordError = WebUI.getTextElement(passwordErrorMessage);

        Assert.assertTrue(actualEmailError.contains("Email is required"), "Email error mismatch");
        Assert.assertTrue(actualPasswordError.contains("Password is required"), "Password error mismatch");
    }

    public void verifyLoginFailedPopup(String expectedMessage) {
        WebUI.waitForElementVisible(popupMessage);
        String actualMessage = WebUI.getTextElement(popupMessage);
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Message mismatch. Actual: " + actualMessage);
    }

     public void verifyLoginFailedPopupForInvalidEmail(String expectedMessage) {
        WebUI.waitForElementVisible(popupMessageForInvalidEmail);
        String actualMessage = WebUI.getTextElement(popupMessageForInvalidEmail);
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Message mismatch. Actual: " + actualMessage);
    }

    public void verifyDashboardPage() {
        WebUI.waitForElementVisible(welcomeContent);
        Assert.assertTrue(
                WebUI.getCurrentUrl().contains("dashboard")  || WebUI.checkElementExist(welcomeContent),
                "The user was not redirected to the Traxxia dashboard page. Current URL: " + WebUI.getCurrentUrl()
        );
    }

    public void verifyValidationPasswordMessage(String expectedMessage) {
        WebUI.waitForElementVisible(passwordErrorMessage);
        String actualPasswordError = WebUI.getTextElement(passwordErrorMessage);
        Assert.assertTrue(actualPasswordError.contains(expectedMessage), "Password error mismatch. Actual: " + actualPasswordError);
    }

    public void verifyValidationEmailMessage(String expectedMessage) {
        WebUI.waitForElementVisible(emailErrorMessage);
        String actualEmailError = WebUI.getTextElement(emailErrorMessage);
        Assert.assertTrue(actualEmailError.contains(expectedMessage), "Email error mismatch. Actual: " + actualEmailError);
    }

    public void clickTryAgain() {
        if (WebUI.checkElementExist(tryAgainButton)) {
            WebUI.clickElement(tryAgainButton);
        }
    }
}
