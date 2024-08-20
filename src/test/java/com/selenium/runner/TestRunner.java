package com.selenium.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = "src/test/resources/Feature",
                    glue = {"com.selenium.stepdefs"},
        plugin = {"pretty","html:target/cucumber-reports","json:target/cucumber.json"},
        monochrome = true,
        dryRun = false,
        publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    public Object[][] scenario(){
        return super.scenarios();
    }

}
