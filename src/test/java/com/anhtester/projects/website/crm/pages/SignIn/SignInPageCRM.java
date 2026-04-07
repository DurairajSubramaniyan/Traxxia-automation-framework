package com.anhtester.projects.website.crm.pages.SignIn;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;

public class SignInPageCRM {

    private final By inputEmail = By.xpath("//input[contains(@name,'email') or contains(@id,'email') or @type='email']");
    private final By inputPassword = By.xpath("//input[contains(@name,'password') or contains(@id,'password') or @type='password']");
    private final By buttonSignIn = By.xpath("//button[contains(normalize-space(),'Sign In') or contains(normalize-space(),'Login') or @type='submit']");
    public final By labelEmailError = By.xpath("//*[contains(@class,'error') and contains(normalize-space(.),'email')]");
    public final By alertErrorMessage = By.xpath("//*[contains(@class,'alert') or contains(@class,'error')][contains(normalize-space(.),'invalid') or contains(normalize-space(.),'error')]");

    public SignInPageCRM signIn(String email, String password) {
        WebUI.clearAndFillText(inputEmail, email);
        WebUI.clearAndFillText(inputPassword, password);
        WebUI.clickElement(buttonSignIn);
        WebUI.waitForPageLoaded();
        return this;
    }

    public void verifySignInSuccess() {
        WebUI.waitForPageLoaded();
        WebUI.verifyElementNotPresent(alertErrorMessage, "Expected sign in to succeed but an error message was displayed.");
    }

    public void verifySignInFail() {
        WebUI.verifyElementPresent(alertErrorMessage, "Expected sign in to fail but no error message was displayed.");
    }
}
