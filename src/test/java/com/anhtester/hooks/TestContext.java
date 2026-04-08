package com.anhtester.hooks;

import com.anhtester.driver.DriverManager;
import com.anhtester.driver.TargetFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class TestContext {

    private final WebDriver driver;

    public TestContext() {
        driver = ThreadGuard.protect(new TargetFactory().createInstance());
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
    }

    public WebDriver getDriver() {
        return DriverManager.getDriver();
    }
}

