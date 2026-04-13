package com.anhtester.projects.traxxia.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;

public class LaunchProjectPage {

    private final By adminBusinessesTab = By.xpath("//*[self::button or self::a or self::div][normalize-space()='Businesses']");
    private final By adminPanelHeader = By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div/div/div/h1");
    private final By profileDropdownIcon = By.xpath("//a[@id='user-dropdown'] | //button[@id='dropdown-user'] | //*[@id='user-dropdown' or @id='dropdown-user']");
    private final By adminPanelMenuOption = By.xpath("//*[@id=\"root\"]/div/div/nav/div/div/div[3]/div[2]/div/a[3]");
    private final By backToDashboardLink = By.xpath("//*[@id=\"root\"]/div/div/nav/div/div/div[3]/div[2]/div/a[1]");
    private final By projectPhaseSection = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[2]/h2/button");
    private final By topProjectsTab = By.xpath("(//a[contains(normalize-space(),'Projects')] | //button[contains(normalize-space(),'Projects')] | //div[contains(@class,'view-mode-tabs-container')]//*[contains(normalize-space(),'Projects')])[1]");
    private final By tabRanking = By.xpath("(//a[contains(normalize-space(),'Ranking')] | //button[contains(normalize-space(),'Ranking')] | //div[contains(@class,'view-mode-tabs-container')]//*[contains(normalize-space(),'Ranking')])[1]");
    private final By projectsListWrapper = By.xpath("//div[contains(@class,'projects-list-wrapper') or contains(@class,'projects-wrapper')]");
    private final By buttonNewProject = By.xpath("//button[contains(normalize-space(),'New Project')]");
    private final By draftProjectCheckbox = By.xpath("(//div[contains(@class,'project-card') and .//span[contains(@class,'status-badge') and contains(normalize-space(),'Draft')] and not(.//*[contains(normalize-space(),'Rank')])]//input[@type='checkbox' and not(@disabled)])[1]");
    private final By rankedProjectCheckbox = By.xpath("(//div[contains(@class,'project-card') and .//*[contains(normalize-space(),'Rank')]]//input[@type='checkbox' and not(@disabled)])[1]");
    private final By anyProjectCheckbox = By.xpath("(//div[contains(@class,'project-card')]//input[@type='checkbox' and not(@disabled)])[1]");
    private final By buttonLaunchProjects = By.xpath("//button[contains(normalize-space(),'Launch')]");
    private final By rankingValidationToast = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div[1]");
    private final By buttonRankProjects = By.xpath("//button[contains(normalize-space(),'Rank Projects')]");
    private final By rankingSelectionCheckbox = By.xpath("(//div[contains(@class,'selection-item')]//input[@type='checkbox' and not(@disabled)])[1]");
    private final By buttonNextRankProjects = By.xpath("//button[contains(normalize-space(),'Next: Rank Projects') or contains(normalize-space(),'Fetching AI Rankings')]");
    private final By rankingSavedToast = By.xpath("//*[contains(normalize-space(),'Rankings saved successfully')]");
    private final By rankedBadge = By.xpath("//*[contains(normalize-space(),'Rank 1') or contains(normalize-space(),'Rank 2') or contains(normalize-space(),'Rank 3')]");
    private final By projectMenuButton = By.xpath("(//div[contains(@class,'project-menu-container')]//*[contains(@class,'menu-button') or contains(@class,'menu-dropdown') or self::button])[1]");
    private final By menuItemEditProject = By.xpath("//div[contains(@class,'menu-item') and contains(normalize-space(),'Edit')] | //button[contains(normalize-space(),'Edit')]");
    private final By editProjectHeader = By.xpath("//*[contains(normalize-space(),'Edit Project') or contains(normalize-space(),'Project Information')]");
    private final By textareaSuccessCriteria = By.xpath("//label[contains(normalize-space(),'Continue If (Success Criteria)')]/ancestor::div[contains(@class,'field-row')]//textarea | //textarea[contains(@placeholder,'success criteria')]");
    private final By textareaKillCriteria = By.xpath("//label[contains(normalize-space(),'Stop If (Kill Criteria)')]/ancestor::div[contains(@class,'field-row')]//textarea | //textarea[contains(@placeholder,'kill criteria')]");
    private final By dropdownReviewCadence = By.xpath("//label[contains(normalize-space(),'Review Cadence')]/ancestor::div[contains(@class,'field-row')]//div[contains(@class,'sf-dropdown-header')] | (//label[contains(normalize-space(),'Review Cadence')]/following::div[contains(@class,'sf-dropdown-header')])[1]");
    private final By buttonSaveChanges = By.xpath("//button[contains(normalize-space(),'Save Changes')]");
    private final By launchSuccessToast = By.xpath("//*[contains(normalize-space(),'Projects launched! Ready for execution') or contains(normalize-space(),'Projects launched')]");
    private final By projectActiveBadge = By.xpath("(//div[contains(@class,'project-card')]//*[contains(normalize-space(),'ACTIVE')])[1]");


    public void clickProfileIconOnTopRightCorner() {
        WebUI.verifyElementPresent(profileDropdownIcon, 15, "Profile icon on the top right corner was not visible.");
        WebUI.clickElementWithJs(profileDropdownIcon);
        WebUI.sleep(1);
    }

    public void clickAdminPanelOptionFromDropdown() {
        WebUI.verifyElementPresent(adminPanelMenuOption, 15, "Admin Panel option was not visible in the profile dropdown.");
        WebUI.clickElementWithJs(adminPanelMenuOption);
        WebUI.waitForPageLoaded();
    }

    public void ensureBusinessHasNoCollaboratorsInAdminPanel(String businessName) {
        if (!WebUI.checkElementExist(adminPanelHeader, 3, 300) && !WebUI.checkElementExist(adminBusinessesTab, 3, 300)) {
            clickProfileIconOnTopRightCorner();
        }

        if (WebUI.checkElementExist(adminBusinessesTab, 5, 500)) {
            WebUI.clickElementWithJs(adminBusinessesTab);
            WebUI.sleep(5);
        }

        By businessRow = By.xpath("//tr[.//*[normalize-space()='" + businessName + "']]");
        if (!WebUI.checkElementExist(businessRow, 5, 500)) {
            return;
        }

        By noCollaboratorsLabel = By.xpath("//tr[.//*[normalize-space()='" + businessName + "']]//*[contains(normalize-space(),'No collaborators')]");
        if (WebUI.checkElementExist(noCollaboratorsLabel, 2, 300)) {
            return;
        }

        
        By deleteCollaboratorIcon = By.xpath("(//tr[.//td[normalize-space()='" + businessName + "']]//button[contains(@class,'admin-collab-remove-btn') or @title='Remove Participant' or @title='Remove participant'])[1]");
        By RemoveParticipant = By.xpath("//button[@class='admin-primary-btn']");
        for (int attempt = 1; attempt <= 5; attempt++) {
            if (!WebUI.checkElementExist(deleteCollaboratorIcon, 2, 300)) {
                break;
            }
            WebUI.clickElementWithJs(deleteCollaboratorIcon);
            WebUI.checkElementExist(RemoveParticipant, 5, 500); 
            WebUI.clickElementWithJs(RemoveParticipant);
            WebUI.waitForPageLoaded();
            WebUI.sleep(1);

            if (WebUI.checkElementExist(noCollaboratorsLabel, 2, 300)) {
                return;
            }
        }
    }

    public void goBackToDashboardFromAdminPanel() {
        WebUI.verifyElementPresent(profileDropdownIcon, 15, "Profile icon on the top right corner was not visible.");
        WebUI.clickElementWithJs(profileDropdownIcon);
        WebUI.verifyElementPresent(backToDashboardLink, 15, "Back to Dashboard link was not visible in Admin Panel.");
        WebUI.clickElementWithJs(backToDashboardLink);
        WebUI.waitForPageLoaded();
        WebUI.sleep(3);
    }

    public void openProjectPhaseBusinessList() {
        WebUI.verifyElementPresent(projectPhaseSection, 15, "Project Phase section was not visible on the dashboard.");
        WebUI.clickElementWithJs(projectPhaseSection);
        WebUI.waitForPageLoaded();
    }

        public void selectExecutionAndSelectTheProject() {
            By executionOption = By.xpath("//button[contains(@class,'nav-dropdown-trigger') and normalize-space()='Execution']");
            WebUI.verifyElementPresent(executionOption, 15, "Execution option was not visible in the Project Phase business list.");
            WebUI.clickElementWithJs(executionOption);
            WebUI.sleep(2);

            By projectOption = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[1]/div[1]/div[2]/div[2]/div/button[2]");
            WebUI.verifyElementPresent(projectOption, 15, "Projects option was not visible in the Project Phase business list.");
            WebUI.clickElementWithJs(projectOption);
            WebUI.waitForPageLoaded();
            WebUI.sleep(5);
        }

    public void openProjectsTabForSelectedBusiness() {
        if (WebUI.checkElementExist(projectsListWrapper, 2, 300)
                || WebUI.checkElementExist(buttonNewProject, 2, 300)
                ) {
            return;
        }

        By[] candidates = {
                topProjectsTab,
                By.xpath("//button[contains(normalize-space(),'Projects (')]")
        };

        for (By candidate : candidates) {
            if (WebUI.checkElementExist(candidate, 3, 500)) {
                WebUI.clickElementWithJs(candidate);
                WebUI.waitForPageLoaded();
                verifyProjectsPageDisplayed();
                return;
            }
        }

        throw new AssertionError("Projects tab was not visible for the selected business.");
    }

    public void selectUnrankedDraftProjectForLaunch() {
        openProjectsTabForSelectedBusiness();
        By[] candidates = {
                draftProjectCheckbox
                
        };

        for (By candidate : candidates) {
            if (WebUI.checkElementExist(candidate, 3, 500)) {
                WebUI.clickElementWithJs(candidate);
                WebUI.waitForPageLoaded();
                return;
            }
        }

        throw new AssertionError("No project was available to select for launch.");
    }

    public void selectRankedProjectForLaunch() {
        openProjectsTabForSelectedBusiness();
        By[] candidates = {
                rankedProjectCheckbox,
                anyProjectCheckbox
        };

        for (By candidate : candidates) {
            if (WebUI.checkElementExist(candidate, 3, 500)) {
                WebUI.clickElementWithJs(candidate);
                WebUI.waitForPageLoaded();
                return;
            }
        }

        throw new AssertionError("No ranked project was available to select for launch.");
    }

    public void clickLaunchForSelectedProject() {
        WebUI.verifyElementPresent(buttonLaunchProjects, 15, "Launch button was not visible for the selected project.");
        WebUI.clickElementWithJs(buttonLaunchProjects);
        WebUI.waitForPageLoaded();
    }

    public void verifyRankingValidationMessageDisplayed() {
        WebUI.verifyElementPresent(rankingValidationToast, 15, "The ranking validation message was not displayed when launching an unranked project.");
        String toastText = WebUI.getTextElement(rankingValidationToast).toLowerCase();
        assert toastText.contains("rank") && toastText.contains("launching");
    }

    public void rankSelectedProjectForLaunch() {
        openProjectsTabForSelectedBusiness();

        if (WebUI.checkElementExist(rankedBadge, 3, 500)) {
            return;
        }

        if (WebUI.checkElementExist(tabRanking, 5, 500)) {
            WebUI.clickElementWithJs(tabRanking);
            WebUI.waitForPageLoaded();
        }

        if (WebUI.checkElementExist(buttonRankProjects, 5, 500)) {
            WebUI.clickElementWithJs(buttonRankProjects);
            WebUI.waitForPageLoaded();
        }

        if (WebUI.checkElementExist(rankingSelectionCheckbox, 5, 500)) {
            WebUI.clickElementWithJs(rankingSelectionCheckbox);
        }

        if (WebUI.checkElementExist(buttonNextRankProjects, 5, 500)) {
            WebUI.clickElementWithJs(buttonNextRankProjects);
        }

        for (int attempt = 1; attempt <= 20; attempt++) {
            WebUI.waitForPageLoaded();

            if (WebUI.checkElementExist(rankingSavedToast, 2, 300)
                    || WebUI.checkElementExist(rankedBadge, 2, 300)) {
                openProjectsTabForSelectedBusiness();
                return;
            }

            WebUI.sleep(1);
        }

        throw new AssertionError("Project ranking did not complete successfully.");
    }

    public void verifyProjectDetailsFormDisplayedForCadenceCompletion() {
        for (int attempt = 1; attempt <= 10; attempt++) {
            WebUI.waitForPageLoaded();

            if (WebUI.checkElementExist(editProjectHeader, 2, 300)
                    || WebUI.checkElementExist(dropdownReviewCadence, 2, 300)
                    || WebUI.checkElementExist(textareaSuccessCriteria, 2, 300)) {
                return;
            }

            WebUI.sleep(1);
        }

        throw new AssertionError("The project details form for cadence completion was not displayed.");
    }

    public void openSelectedProjectForEditing() {
        openProjectsTabForSelectedBusiness();

        if (WebUI.checkElementExist(editProjectHeader, 2, 300)) {
            return;
        }

        WebUI.verifyElementPresent(projectMenuButton, 15, "Project action menu was not visible.");
        WebUI.clickElementWithJs(projectMenuButton);
        WebUI.verifyElementPresent(menuItemEditProject, 10, "Edit option was not visible in the project action menu.");
        WebUI.clickElementWithJs(menuItemEditProject);
        WebUI.waitForPageLoaded();
        verifyProjectDetailsFormDisplayedForCadenceCompletion();
    }

    public void completeRequiredLaunchDetails(String cadence) {
        WebUI.verifyElementPresent(textareaSuccessCriteria, 15, "Success criteria field was not visible.");
        WebUI.clearAndFillText(textareaSuccessCriteria, "Proceed if the project meets the agreed quality and execution readiness checkpoints.");

        WebUI.verifyElementPresent(textareaKillCriteria, 15, "Kill criteria field was not visible.");
        WebUI.clearAndFillText(textareaKillCriteria, "Stop if the project fails the agreed launch validation or quality threshold.");

        selectDropdownOption(dropdownReviewCadence, cadence);
    }

    public void saveProjectChanges() {
        WebUI.verifyElementPresent(buttonSaveChanges, 15, "Save Changes button was not visible.");
        WebUI.clickElementWithJs(buttonSaveChanges);

        for (int attempt = 1; attempt <= 10; attempt++) {
            WebUI.waitForPageLoaded();

            if (!WebUI.checkElementExist(buttonSaveChanges, 1, 200)
                    || WebUI.checkElementExist(projectsListWrapper, 2, 300)
                    || WebUI.checkElementExist(buttonNewProject, 2, 300)) {
                return;
            }

            WebUI.sleep(1);
        }
    }

    public void verifyProjectLaunchSuccessMessageDisplayed() {
        for (int attempt = 1; attempt <= 10; attempt++) {
            WebUI.waitForPageLoaded();

            if (WebUI.checkElementExist(launchSuccessToast, 2, 300)
                    || WebUI.checkElementExist(projectActiveBadge, 2, 300)) {
                return;
            }

            WebUI.sleep(1);
        }

        throw new AssertionError("The project launch success message was not displayed.");
    }

    public void verifyProjectsPageDisplayed() {
        for (int attempt = 1; attempt <= 10; attempt++) {
            WebUI.waitForPageLoaded();

            if (WebUI.checkElementExist(projectsListWrapper, 2, 300)
                    || WebUI.checkElementExist(buttonNewProject, 2, 300)
                    || WebUI.checkElementExist(buttonLaunchProjects, 2, 300)
                    || WebUI.checkElementExist(tabRanking, 2, 300)) {
                return;
            }

            WebUI.sleep(1);
        }

        throw new AssertionError("The Projects page did not fully load or its main content was not visible.");
    }

    private void selectDropdownOption(By dropdownHeader, String optionText) {
        WebUI.verifyElementPresent(dropdownHeader, 15, "Dropdown was not visible for option: " + optionText);
        WebUI.clickElementWithJs(dropdownHeader);

        By option = By.xpath("//*[contains(@class,'sf-option') and normalize-space()='" + optionText + "'] | //li[normalize-space()='" + optionText + "']");
        WebUI.verifyElementPresent(option, 10, "Option '" + optionText + "' was not visible.");
        WebUI.clickElementWithJs(option);
        WebUI.waitForPageLoaded();
    }
}
