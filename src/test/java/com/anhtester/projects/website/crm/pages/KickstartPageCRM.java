package com.anhtester.projects.website.crm.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;

public class KickstartPageCRM {

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
    private final By secondPriorityCard = By.xpath("(//div[contains(@class,'card') or contains(@class,'priority') or contains(@class,'list-group-item')])[2]");
    private final By buttonKickstartProjects = By.xpath("//button[contains(normalize-space(),'Kickstart Projects') or contains(normalize-space(),'Kickstart to Projects') or contains(normalize-space(),'Kickstart')]");
    private final By popupCollaboratorWarningTitle = By.xpath("/html/body/div[3]/div/div/div");
    private final By buttonAddCollaboratorsFirst = By.xpath("/html/body/div[3]/div/div/div/div[2]/button[2]");
    private final By buttonKickstartToProjects = By.xpath("//button[normalize-space()='Kickstart to Projects'] | //button[contains(normalize-space(),'Kickstart to Projects') or normalize-space()='Kickstart']");
    private final By popupProjectKickstartSuccess = By.xpath("//*[contains(normalize-space(),'Project Kickstart Successful') or contains(normalize-space(),'Kickstart Successful') or contains(normalize-space(),'draft projects have been created')]");
    private final By buttonGoToProjects = By.xpath("//button[contains(normalize-space(),'Go to Projects') or contains(normalize-space(),'Projects')]");
    private final By pageProjectsHeader = By.xpath("//*[contains(normalize-space(),'Projects') and (self::h1 or self::h2 or self::h3 or self::div)]");
    private final By pageAddCollaboratorsHeader = By.xpath("//*[@id=\"root\"]/div/div/div/div[3]");
    private final By clickBusinessesMenu = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[1]/h2/button");
    
    public void clickBusinessesMenu() {
        WebUI.waitForPageLoaded();
        WebUI.verifyElementPresent(clickBusinessesMenu, 15, "Execution menu button was not visible.");
        WebUI.clickElement(clickBusinessesMenu);
       
    }
    public void createNewBusiness(String businessName, String businessPurpose) {
        WebUI.waitForPageLoaded();
        WebUI.verifyElementPresent(buttonCreateBusiness, 15, "Create Business button was not visible.");
        WebUI.clickElement(buttonCreateBusiness);
        WebUI.verifyElementPresent(modalCreateBusinessTitle, 15, "Create business modal did not open.");
        WebUI.clearAndFillText(inputBusinessName, businessName);
        WebUI.clearAndFillText(inputBusinessPurpose, businessPurpose);
        WebUI.clickElement(buttonCreateBusinessModal);
        WebUI.waitForPageLoaded();
        if (WebUI.checkElementExist(buttonSuccessOk)) {
            WebUI.clickElement(buttonSuccessOk);
            WebUI.waitForPageLoaded();
        }
        WebUI.verifyElementPresent(businessDashboardHeader, 20, "New business dashboard did not load after business creation.");
    }

    public void selectExistingBusiness(String businessName) {
        WebUI.waitForPageLoaded();
        By businessOption = By.xpath("//div[contains(@class,'business-item')]//h6[normalize-space()='" + businessName + "']/ancestor::div[contains(@class,'business-item')]//div[contains(@class,'flex-grow-1')]");
        WebUI.verifyElementPresent(businessOption, 15, "Business option '" + businessName + "' was not found.");
        WebUI.clickElementWithJs(businessOption);
        WebUI.waitForPageLoaded();
        WebUI.verifyElementPresent(businessDashboardHeader, 20, "Business dashboard did not load after selecting business.");
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
                WebUI.waitForPageLoaded();
                break;
            }
            if (WebUI.checkElementExist(buttonNextOnboarding, 3, 500)) {
                WebUI.clickElement(buttonNextOnboarding);
                WebUI.waitForPageLoaded();
                WebUI.sleep(2);
                continue;
            }
            break;
        }

        WebUI.waitForPageLoaded();
        WebUI.waitForElementVisible(menuPriorities, 60);
        WebUI.verifyElementPresent(menuPriorities, 60, "Priorities section did not appear after completing the 9-step PMF onboarding flow.");
    }

    public void clickExecutionMenu() {
        WebUI.waitForPageLoaded();
        WebUI.verifyElementPresent(buttonExecution, 15, "Execution menu button was not visible.");
        WebUI.clickElement(buttonExecution);
        WebUI.waitForElementVisible(menuPriorities, 15);
    }

    public void navigateToPrioritiesSection() {
        WebUI.waitForPageLoaded();
        WebUI.verifyElementPresent(menuPriorities, 15, "Priorities section menu was not visible.");
        WebUI.clickElement(menuPriorities);
    }

    public void selectFirstAvailablePriority() {
        WebUI.verifyElementPresent(firstPriorityCard, 15, "No priority card was visible to select.");
        WebUI.clickElement(firstPriorityCard);
        WebUI.waitForPageLoaded();
    }

    public void selectAnotherAvailablePriority() {
        if (WebUI.checkElementExist(secondPriorityCard)) {
            WebUI.clickElement(secondPriorityCard);
        } else {
            WebUI.clickElement(firstPriorityCard);
        }
        WebUI.waitForPageLoaded();
    }

    public void clickKickstartProjects() {
        WebUI.verifyElementPresent(buttonKickstartProjects, 15, "Kickstart Projects button was not visible.");
        WebUI.clickElement(buttonKickstartProjects);
        WebUI.waitForPageLoaded();
    }

    public void verifyCollaboratorWarningPopupDisplayed() {
        WebUI.verifyElementPresent(popupCollaboratorWarningTitle, 15, "The collaborator warning popup did not appear.");
    }

    public void verifyCollaboratorWarningPopupNotDisplayed() {
        WebUI.verifyElementNotPresent(popupCollaboratorWarningTitle, "The collaborator warning popup was displayed unexpectedly.");
    }

    public void chooseCollaboratorWarningAction(String action) {
        WebUI.waitForPageLoaded();
        if (action.equalsIgnoreCase("Add Collaborators First")) {
            WebUI.verifyElementPresent(buttonAddCollaboratorsFirst, 15, "The Add Collaborators First button was not visible.");
            WebUI.clickElement(buttonAddCollaboratorsFirst);
        } else if (action.equalsIgnoreCase("Kickstart to Projects")) {
            WebUI.verifyElementPresent(buttonKickstartToProjects, 15, "The Kickstart to Projects button was not visible.");
            WebUI.clickElement(buttonKickstartToProjects);
        } else {
            throw new IllegalArgumentException("Unsupported action on collaborator warning popup: " + action);
        }
        WebUI.waitForPageLoaded();
    }

    public void verifyAddCollaboratorsPageDisplayed() {
        WebUI.verifyElementPresent(pageAddCollaboratorsHeader, 15, "The Add Collaborators page did not display after choosing Add Collaborators First.");
    }

    public void verifyProjectKickstartSuccessPopupOrProjectsPageDisplayed() {
        boolean successPopup = WebUI.checkElementExist(popupProjectKickstartSuccess);
        boolean projectsPage = WebUI.checkElementExist(pageProjectsHeader);
        if (!successPopup && !projectsPage) {
            throw new AssertionError("Expected either a kickstart success popup or the Projects page, but none were displayed.");
        }
    }

    public void verifyProjectsPageDisplayed() {
        if (WebUI.checkElementExist(buttonGoToProjects)) {
            WebUI.clickElement(buttonGoToProjects);
            WebUI.waitForPageLoaded();
        }
        WebUI.verifyElementPresent(pageProjectsHeader, 15, "The Projects page did not display as expected.");
    }
}
