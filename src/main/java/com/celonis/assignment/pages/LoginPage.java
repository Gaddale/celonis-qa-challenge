package com.celonis.assignment.pages;

import com.celonis.assignment.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private By email = By.id("ce-input-0");
    private By password = By.id("ce-input-1");
    private By signInBtn = By.cssSelector("[cetestinguid='login-form-submit-button']");
    private By invalidCredentialsErrorMessage = By.cssSelector("[class='ce-validation__hint'] > span");

    public WebElement getEmail() {
        return getElement(email);
    }

    public WebElement getInvalidCredentialsErrorMessage() {
        waitForElementToLoad(invalidCredentialsErrorMessage);
        return getElement(invalidCredentialsErrorMessage);
    }

    private WebElement getPassword() {
        return getElement(password);
    }

    private WebElement getSignInBtn() {
        return getElement(signInBtn);
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginWithValidCredentials() {
        getEmail().sendKeys(Configuration.TEST_USER.getValue());
        getPassword().sendKeys(Configuration.PASSWORD.getValue());
        getSignInBtn().click();
    }

    public void loginWithWrongCredentials() {
        getEmail().sendKeys(Configuration.INVALID_USER.getValue());
        getPassword().sendKeys(Configuration.PASSWORD.getValue());
        getSignInBtn().click();
    }
}
