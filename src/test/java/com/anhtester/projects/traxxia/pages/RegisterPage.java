package com.anhtester.projects.traxxia.pages;

import com.anhtester.constants.FrameworkConstants;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterPage {

    private final By linkSignUp = By.xpath("//a[normalize-space()='Sign up'] | //a[contains(normalize-space(),'Sign Up')]");
    private final By inputFullName = By.xpath("//input[contains(translate(@placeholder,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'full name') or @id='fullName' or @name='fullName']");
    private final By inputRegisterEmail = By.xpath("//input[contains(translate(@placeholder,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'email') or @id='email' or @name='email']");
    private final By inputRegisterPassword = By.xpath("//input[(contains(translate(@placeholder,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'password') and not(contains(translate(@placeholder,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'confirm'))) or @id='password' or @name='password']");
    private final By inputConfirmPassword = By.xpath("//input[contains(translate(@placeholder,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'confirm password') or @id='confirmPassword' or @name='confirmPassword']");
    private final By buttonRegister = By.xpath("//button[normalize-space()='Register' or normalize-space()='Next Step' or contains(normalize-space(.),'Register') or contains(normalize-space(.),'Next Step')]");
    private final By labelRequiredFieldError = By.xpath("//*[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'required')]");
    private final By labelSuccessPage = By.xpath("//*[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'company setup') or contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'success') or contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'welcome')]");

    private String actualFullNameValue;
    private String actualEmailValue;

    public void openRegisterPage() {
        WebUI.openWebsite(FrameworkConstants.URL_TRAXXIA);
        WebUI.clickElement(linkSignUp);
        WebUI.waitForPageLoaded();
        WebUI.verifyElementPresent(buttonRegister, "Traxxia register page did not open or the Register button was not visible.");
    }

    public void enterFullName(String fullName) {
        WebUI.clearAndFillText(inputFullName, fullName);
        actualFullNameValue = WebUI.getAttributeElement(inputFullName, "value");
    }

    public void enterEmail(String email) {
        WebUI.clearAndFillText(inputRegisterEmail, email);
        actualEmailValue = WebUI.getAttributeElement(inputRegisterEmail, "value");
    }

    public void enterPassword(String password) {
        WebUI.clearAndFillText(inputRegisterPassword, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        WebUI.clearAndFillText(inputConfirmPassword, confirmPassword);
    }

    public void clearAllFields() {
        WebUI.clearAndFillText(inputFullName, "");
        WebUI.clearAndFillText(inputRegisterEmail, "");
        WebUI.clearAndFillText(inputRegisterPassword, "");
        WebUI.clearAndFillText(inputConfirmPassword, "");
    }

    public void clickRegisterButton() {
        WebUI.clickElement(buttonRegister);
        WebUI.waitForPageLoaded();
    }

    public void verifySuccessPage() {
        WebUI.waitForPageLoaded();
        String currentUrl = WebUI.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("company-setup")
                        || currentUrl.contains("success")
                        || currentUrl.contains("welcome")
                        || WebUI.checkElementExist(labelSuccessPage),
                "Registration did not navigate to the expected Traxxia success page. Current URL: " + currentUrl);
    }

    public void verifyRequiredFieldValidation() {
        WebUI.verifyElementPresent(labelRequiredFieldError, "Required field validation messages were not displayed.");
    }

    public void verifyValidationMessage(String expectedMessage) {
        By expectedMessageLocator = By.xpath("//*[contains(normalize-space(.),'" + expectedMessage + "')]");
        WebUI.verifyElementPresent(expectedMessageLocator, "Expected validation message not displayed: " + expectedMessage);
    }

    public String getActualFullNameValue() {
        return actualFullNameValue;
    }

    public String getActualEmailValue() {
        return actualEmailValue;
    }
}
