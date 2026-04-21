
package com.anhtester.projects.traxxia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.anhtester.keywords.WebUI;


public class AdminPage {

    

    private final By companyTab = By.xpath("//button[normalize-space()='Company']");
    

     private final By businessesTab = By.xpath("//button[normalize-space()='Businesses']");
   
    private final By userManagementTab = By.xpath("//button[normalize-space()='User Management']");
   

     private final By accessManagementTab = By.xpath("//button[normalize-space()='Access Management']");
   
     private final By userHistoryTab = By.xpath("//button[normalize-space()='User History']");
    
     private final By auditTrailTab = By.xpath("//button[normalize-space()='Audit Trail']");
   
     private final By subscriptionTab = By.xpath("//button[normalize-space()='Subscription']");
    
    private final By PageHeader = By.xpath("//h2[@class='admin-table-title']");


    public void openAdminTab(String tabName) {

    switch (tabName.trim()) {

        case "Company":

            WebUI.clickElement(companyTab);

            break;

        case "Businesses":

            WebUI.clickElement(businessesTab);

            break;

        case "User Management":

            WebUI.clickElement(userManagementTab);

            break;

        case "Access Management":

            WebUI.clickElement(accessManagementTab);

            break;

        case "User History":

            WebUI.clickElement(userHistoryTab);

            break;

        case "Audit Trail":

            WebUI.clickElement(auditTrailTab);

            break;

        case "Subscription":

            WebUI.clickElement(subscriptionTab);

            break;

        default:

            throw new IllegalArgumentException("Unknown admin tab: " + tabName);

    }

}
 
    public void navigateToAdminSection() {
        WebUI.waitForElementVisible(By.xpath("//*[@id=\"dropdown-user\"]"));
        WebUI.clickElement(By.xpath("//*[@id=\"dropdown-user\"]"));
        WebUI.waitForElementVisible(By.xpath("//*[@id=\"main-menu-bar\"]/div/div/div[3]/div[2]/div/a[3]"));
        WebUI.clickElement(By.xpath("//*[@id=\"main-menu-bar\"]/div/div/div[3]/div[2]/div/a[3]"));
    }

    public void verifyAdminHeading(String expectedHeading) {
        WebUI.waitForElementVisible(PageHeader);
        String headingText = WebUI.getTextElement(PageHeader);
        Assert.assertTrue(headingText.contains(expectedHeading), "Expected heading not displayed: " + headingText);
    }
}