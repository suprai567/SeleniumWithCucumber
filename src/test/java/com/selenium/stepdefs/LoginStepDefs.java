package com.selenium.stepdefs;

import com.selenium.dataProvider.ConfigFileReader;
import com.selenium.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
//StepDefination java class
public class LoginStepDefs {
    private WebDriver driver;
    private LoginPage loginPage;
    ConfigFileReader configFileReader;
    @Before
    public void setUp(){
        driver = new ChromeDriver();
    }
    @After
    public void tearDown(){
            driver.quit();
    }
    @Given("I am on my OpenCart login page")
    public void i_am_on_my_open_cart_login_page() {
        configFileReader= new ConfigFileReader();
        driver.get(configFileReader.getApplicationUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configFileReader.getImplicitlyWait()));
        loginPage = new LoginPage(driver);
    }
    @Given("I have entered my valid username password")
    public void i_have_entered_my_valid_username_password() {
        configFileReader= new ConfigFileReader();
        loginPage.enterEmail(configFileReader.getUsername());
        loginPage.enterPassword(configFileReader.getPassword());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @When("I click login button")
    public void i_click_login_button() {
        loginPage.clickLoginButton();
    }
    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertEquals(loginPage.checkLogoutLink(),true);
    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String string) {
        configFileReader= new ConfigFileReader();
        Assert.assertEquals(driver.findElement(By.cssSelector(configFileReader.getAlert())).isDisplayed(),true);
    }

    @When("I click on the forgot password link")
    public void i_click_on_the_forgot_password_link() {
        configFileReader= new ConfigFileReader();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configFileReader.getImplicitlyWait()));
        loginPage.clickForgotPassLink();
    }

    @Then("I should be redirected to reset password page")
    public void i_should_be_redirected_to_reset_password_page() {
        configFileReader= new ConfigFileReader();
        Assert.assertTrue(loginPage.getForgotPageURL().contains(configFileReader.getForgotPageContains()));
    }

}
