package com.anhtester.common;

import com.anhtester.keywords.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

public class CommonSteps {

    private static final By LOGIN_PAGE_HEADER = By.xpath(
            "//*[contains(normalize-space(),'Welcome') or contains(normalize-space(),'Sign In') or contains(normalize-space(),'Login')]"
    );

    @Given("User navigate to Login Page for Admin {string}")
    public void userNavigateToLoginPageForAdmin(String url) {
        WebUI.openWebsite(url);
        WebUI.waitForPageLoaded();
    }

    @Then("welcome message should be displayed")
    public void welcomeMessageShouldBeDisplayed() {
        WebUI.verifyElementPresent(LOGIN_PAGE_HEADER, 10, "Welcome message is not displayed on the login page");
    }
}
