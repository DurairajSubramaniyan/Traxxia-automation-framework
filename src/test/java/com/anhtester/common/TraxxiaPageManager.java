package com.anhtester.common;

import com.anhtester.keywords.WebUI;
import com.anhtester.projects.traxxia.pages.AdminPage;
import com.anhtester.projects.traxxia.pages.KickstartPage;
import com.anhtester.projects.traxxia.pages.LaunchProjectPage;
import com.anhtester.projects.traxxia.pages.LoginPage;
import com.anhtester.projects.traxxia.pages.RegisterPage;
import org.openqa.selenium.By;

public class TraxxiaPageManager {

    private LoginPage loginPage;
    private RegisterPage registerPage;
    private KickstartPage kickstartPage;
    private LaunchProjectPage launchProjectPage;
    private AdminPage adminPage;

    private final By dropdownAccount = By.xpath("//a[@id='user-dropdown']//span[2]");
    private final By buttonSignOut = By.xpath("//a[normalize-space()='Sign Out']");

    public LoginPage signOut() {
        WebUI.clickElement(dropdownAccount);
        WebUI.clickElement(buttonSignOut);
        return new LoginPage();
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public RegisterPage getRegisterPage() {
        if (registerPage == null) {
            registerPage = new RegisterPage();
        }
        return registerPage;
    }

    public KickstartPage getKickstartPage() {
        if (kickstartPage == null) {
            kickstartPage = new KickstartPage();
        }
        return kickstartPage;
    }

    public AdminPage getAdminPage() {
        if(adminPage == null) {
            adminPage = new AdminPage();
        }
        return adminPage;
    }

    public LaunchProjectPage getLaunchProjectPage() {
        if (launchProjectPage == null) {
            launchProjectPage = new LaunchProjectPage();
        }
        return launchProjectPage;
    }
}
