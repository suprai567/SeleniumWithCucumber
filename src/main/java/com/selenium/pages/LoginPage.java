package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {

    private WebDriver driver;
    private By emailLocator = By.name("email");
    private By passwordLocator = By.name("password");
    private By loginButtonLocator = By.xpath("//input[@type='submit']");
    private By forgotPasswordLocator = By.linkText("Forgotten Password");
    private By logoutLocator = By.linkText("Logout");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public void enterEmail(String email){
        WebElement emailInput = driver.findElement(emailLocator);
        emailInput.sendKeys(email);
    }
    public void enterPassword(String password){
        WebElement passwordInput = driver.findElement(passwordLocator);
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }
    public void clickForgotPassLink(){
        WebElement forgotPassLink = driver.findElement(forgotPasswordLocator);
        forgotPassLink.click();
    }
    public boolean checkForgotPassLink(){
        return driver.findElement(forgotPasswordLocator).isDisplayed();

    }
    public boolean checkLogoutLink(){
        return driver.findElement(logoutLocator).isDisplayed();
    }
    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
    public String getForgotPageURL(){
        String forgotPageURL = driver.getCurrentUrl();
        return forgotPageURL;
    }






}
