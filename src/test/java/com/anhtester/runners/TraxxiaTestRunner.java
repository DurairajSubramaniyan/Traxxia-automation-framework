package com.anhtester.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/traxxia/launch-project.feature",
        glue = {
                "com.anhtester.common",
                "com.anhtester.hooks",
                "com.anhtester.projects.traxxia.stepdefinitions"
        },
        plugin = {
                "com.anhtester.hooks.CucumberListener",
                "pretty",
                "html:target/cucumber-reports/traxxia-regression.html",
                "json:target/cucumber-reports/traxxia-regression.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,
        tags = "@testing"
)

public class TraxxiaTestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
