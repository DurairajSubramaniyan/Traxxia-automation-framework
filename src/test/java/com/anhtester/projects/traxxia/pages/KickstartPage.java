package com.anhtester.projects.traxxia.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;

public class KickstartPage {

    private final By buttonCreateBusiness = By.xpath("(//button[contains(normalize-space(),'Create Business')])[2]");
    private final By modalCreateBusinessTitle = By.xpath("/html/body/div[3]/div/div");
    private final By inputBusinessName = By.xpath("//input[contains(@placeholder,'Business Name') or contains(@placeholder,'business name') or contains(@id,'business') and contains(@name,'name')]");
    private final By inputBusinessPurpose = By.xpath("//input[@name='business_name']");
    private final By buttonCreateBusinessModal = By.xpath("//button[@type='submit']");
    private final By buttonSuccessOk = By.xpath("//button[normalize-space()='OK' or normalize-space()='Ok' or normalize-space()='Okay']");
    private final By businessDashboardHeader = By.xpath("//*[contains(normalize-space(),'AHA INSIGHTS') or contains(normalize-space(),'Executive Summary') or contains(normalize-space(),'Where to Compete')]");
    private final By onboardingModal = By.xpath("//*[contains(normalize-space(),'PMF Onboarding') or (contains(normalize-space(),'Step') and contains(normalize-space(),'of 9'))]");
    private final By onboardingProgress = By.xpath("//*[contains(normalize-space(),'Step') and contains(normalize-space(),'of 9')]");
    private final By buttonNextOnboarding = By.xpath("//button[normalize-space()='Next' or normalize-space()='Continue' or contains(normalize-space(),'Next')]");
    private final By buttonCompleteOnboarding = By.xpath("//button[contains(normalize-space(),'Complete Onboarding') or normalize-space()='Complete' or normalize-space()='Finish' or normalize-space()='Done']");
    private final By buttonExecution = By.xpath("//button[contains(@class,'nav-dropdown-trigger') and normalize-space()='Execution']");
    private final By menuPriorities = By.xpath("//button[contains(@class,'dropdown-item') and normalize-space()='Priorities']");
    private final By firstPriorityCard = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div/div/input");
    private final By secondPriorityCard = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div/div/input");
    private final By buttonKickstartProjects = By.xpath("//button[contains(normalize-space(),'Kickstart Projects') or contains(normalize-space(),'Kickstart to Projects') or contains(normalize-space(),'Kickstart')]");
    private final By popupCollaboratorWarningTitle = By.xpath("//div[contains(@class,'modal-body') and .//button[normalize-space()='Add Collaborators First'] and .//button[contains(normalize-space(),'Kickstart to Projects') or normalize-space()='Kickstart']]");
    private final By buttonAddCollaboratorsFirst = By.xpath("/html/body/div[3]/div/div/div/div[2]/button[2]");
    private final By buttonKickstartToProjects = By.xpath("//button[normalize-space()='Kickstart to Projects'] | //button[contains(normalize-space(),'Kickstart to Projects') or normalize-space()='Kickstart']");
    private final By popupProjectKickstartSuccess = By.xpath("//div[contains(@class,'modal-body') and .//button[contains(normalize-space(),'Go to Projects')]]");
    private final By buttonGoToProjects = By.xpath("//button[contains(normalize-space(),'Go to Projects')]");
    private final By pageProjectsHeader = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div[7]/div[1]/button[1]");
    private final By pageAddCollaboratorsHeader = By.xpath("//*[@id=\"root\"]/div/div/div/div[3]");
    private final By clickBusinessesMenu = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[1]/h2/button");
    private final By backToPriority = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[1]/div[1]/div[2]/div[2]/button");
    private final By priorityTile = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[1]/div[1]/div[2]/div[2]/div/button[1]/span");
    private final By executiveSummaryHeader = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div");

    public void clickBusinessesMenu() {
        WebUI.verifyElementPresent(clickBusinessesMenu, 15, "Businesses menu button was not visible.");
        WebUI.clickElement(clickBusinessesMenu);
    }

    public void createNewBusiness(String businessName, String businessPurpose) {
        WebUI.verifyElementPresent(buttonCreateBusiness, 15, "Create Business button was not visible.");
        WebUI.clickElement(buttonCreateBusiness);
        WebUI.verifyElementPresent(modalCreateBusinessTitle, 15, "Create business modal did not open.");
        WebUI.clearAndFillText(inputBusinessName, businessName);
        WebUI.clearAndFillText(inputBusinessPurpose, businessPurpose);
        WebUI.clickElement(buttonCreateBusinessModal);

        if (WebUI.checkElementExist(buttonSuccessOk)) {
            WebUI.clickElement(buttonSuccessOk);
        }
        WebUI.verifyElementPresent(businessDashboardHeader, 20, "New business dashboard did not load after business creation.");
    }

    public void selectExistingBusiness(String businessName) {
        By businessOption = By.xpath("//div[contains(@class,'business-item')]//h6[normalize-space()='" + businessName + "']/ancestor::div[contains(@class,'business-item')]//div[contains(@class,'flex-grow-1')]");
        WebUI.verifyElementPresent(businessOption, 15, "Business option '" + businessName + "' was not found.");
        WebUI.clickElementWithJs(businessOption);
        WebUI.waitForPageLoaded();
    }

    public void verifyExecutiveSummaryPageDisplayed() {
        WebUI.waitForPageLoaded();
        WebUI.verifyElementPresent(executiveSummaryHeader, 20, "Executive Summary page did not load after selecting business.");
        WebUI.sleep(3);
    }

    public void completeOnboardingFlow() {
        if (!WebUI.checkElementExist(onboardingModal, 3, 500) && !WebUI.checkElementExist(onboardingProgress, 3, 500)) {
            return;
        }
        WebUI.verifyElementPresent(onboardingModal, 15, "PMF onboarding flow did not appear after creating business.");

        int maxSteps = 12;
        int stepCount = 0;
        while (stepCount < maxSteps) {
            stepCount++;
            if (WebUI.checkElementExist(buttonCompleteOnboarding, 3, 500)) {
                WebUI.clickElement(buttonCompleteOnboarding);
                break;
            }
            if (WebUI.checkElementExist(buttonNextOnboarding, 3, 500)) {
                WebUI.clickElement(buttonNextOnboarding);
                WebUI.sleep(2);
                continue;
            }
            break;
        }

        WebUI.waitForElementVisible(menuPriorities, 60);
        WebUI.verifyElementPresent(menuPriorities, 60, "Priorities section did not appear after completing the 9-step PMF onboarding flow.");
    }

    public void clickExecutionMenu() {
        WebUI.verifyElementPresent(buttonExecution, 15, "Execution menu button was not visible.");
        WebUI.clickElement(buttonExecution);
        WebUI.waitForElementVisible(menuPriorities, 5);
        WebUI.clickElement(menuPriorities);
    }

    public void navigateToPrioritiesSection() {
        WebUI.verifyElementPresent(backToPriority, 15, "Back to priorities button was not visible.");
        WebUI.clickElementWithJs(backToPriority);
        WebUI.waitForPageLoaded();
        WebUI.verifyElementPresent(priorityTile, 15, "Priority tile was not visible.");
        WebUI.clickElementWithJs(priorityTile);
        WebUI.waitForPageLoaded();
    }

    public void selectFirstAvailablePriority() {
        By[] candidates = {
                firstPriorityCard,
                By.xpath("(//input[@type='checkbox' and not(@disabled)])[1]"),
                By.xpath("(//div[contains(@class,'priority') or contains(@class,'card')])[1]")
        };

        for (By candidate : candidates) {
            if (WebUI.checkElementExist(candidate, 3, 500)) {
                WebUI.clickElementWithJs(candidate);
                WebUI.waitForPageLoaded();
                return;
            }
        }

        throw new AssertionError("No priority card was visible to select.");
    }

    public void selectAnotherAvailablePriority() {
        By[] candidates = {
                secondPriorityCard,
            By.xpath("(//input[@type='checkbox' and not(@disabled)])[2]"),
            By.xpath("(//div[contains(@class,'priority') or contains(@class,'card')])[2]")
        };

        for (By candidate : candidates) {
            if (WebUI.checkElementExist(candidate, 3, 500)) {
                WebUI.clickElementWithJs(candidate);
                WebUI.waitForPageLoaded();
                return;
            }
        }

        throw new AssertionError("No alternate priority was available to select. The first priority may already be kickstarted.");
    }

    public void clickKickstartProjects() {
        WebUI.verifyElementPresent(buttonKickstartProjects, 15, "Kickstart Projects button was not visible.");

        for (int attempt = 1; attempt <= 3; attempt++) {
            try {
                WebUI.clickElement(buttonKickstartProjects);
                WebUI.waitForPageLoaded();
                return;
            } catch (AssertionError | Exception ignored) {
                if (attempt == 3) {
                    break;
                }
                WebUI.sleep(1);
            }

            try {
                WebUI.clickElementWithJs(buttonKickstartProjects);
                WebUI.waitForPageLoaded();
                return;
            } catch (AssertionError | Exception ignored) {
                if (attempt == 3) {
                    break;
                }
                WebUI.sleep(1);
            }
        }

        throw new AssertionError("Kickstart Projects button was visible but could not be clicked after retries.");
    }

    public void verifyCollaboratorWarningPopupDisplayed() {
        WebUI.verifyElementPresent(popupCollaboratorWarningTitle, 15, "The collaborator warning popup did not appear.");
    }

    public void verifyCollaboratorWarningPopupNotDisplayed() {
        WebUI.verifyElementNotPresent(popupCollaboratorWarningTitle, "The collaborator warning popup was displayed unexpectedly.");
    }

    public void chooseCollaboratorWarningAction(String action) {
        if (action.equalsIgnoreCase("Add Collaborators First")) {
            WebUI.verifyElementPresent(buttonAddCollaboratorsFirst, 15, "The Add Collaborators First button was not visible.");
            WebUI.clickElement(buttonAddCollaboratorsFirst);
        } else if (action.equalsIgnoreCase("Kickstart to Projects")) {
            if (!WebUI.checkElementExist(buttonKickstartToProjects, 5, 500)) {
                // On already-kickstarted flows this popup can be skipped by the app.
                return;
            }
            WebUI.clickElement(buttonKickstartToProjects);
        } else {
            throw new IllegalArgumentException("Unsupported action on collaborator warning popup: " + action);
        }
    }

    public void verifyAddCollaboratorsPageDisplayed() {
        WebUI.verifyElementPresent(pageAddCollaboratorsHeader, 15, "The Add Collaborators page did not display after choosing Add Collaborators First.");
    }

    public void verifyProjectKickstartSuccessPopupOrProjectsPageDisplayed() {
        if (WebUI.checkElementExist(popupProjectKickstartSuccess, 10, 500)
                || WebUI.checkElementExist(buttonGoToProjects, 10, 500)) {
            return;
        }

        throw new AssertionError("Expected the kickstart success popup with the Go to Projects button, but it was not visible.");
    }

    public void clickGoToProjectsOnSuccessPopup() {
        for (int attempt = 1; attempt <= 5; attempt++) {
            if (!WebUI.checkElementExist(buttonGoToProjects, 2, 300)) {
                WebUI.sleep(1);
                continue;
            }
            try {
                WebUI.clickElementWithJs(buttonGoToProjects);
                WebUI.waitForPageLoaded();
                WebUI.sleep(2);
                return;
            } catch (Exception ignored) {
                WebUI.sleep(1);
            }
        }
        throw new AssertionError("Go to Projects button was not stable/clickable after retries.");
    }

    public void verifyProjectsPageDisplayed() {
        for (int attempt = 1; attempt <= 10; attempt++) {
            WebUI.waitForPageLoaded();

            if (WebUI.checkElementExist(pageProjectsHeader, 2, 500)) {
                return;
            }

            WebUI.sleep(1);
        }

        if (WebUI.checkElementExist(backToPriority, 2, 300) || WebUI.checkElementExist(priorityTile, 2, 300)) {
            throw new AssertionError("After clicking Go to Projects, the app returned to the Priorities page instead of loading the Projects page.");
        }

        throw new AssertionError("The Projects page did not fully load or its header was not visible.");
    }
}
