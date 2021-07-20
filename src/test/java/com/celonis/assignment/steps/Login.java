package com.celonis.assignment.steps;

import com.celonis.assignment.pages.HomePage;
import com.celonis.assignment.pages.LoginPage;
import com.celonis.assignment.pages.PageFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

import static org.apache.log4j.Logger.getLogger;
import static org.assertj.core.api.Assertions.assertThat;

public class Login {

    private static Logger logger = getLogger(Login.class.getName());
    private LoginPage loginPage = PageFactory.getInstance(LoginPage.class);
    private HomePage homePage = PageFactory.getInstance(HomePage.class);

    @Given("^user is on login page$")
    public void userIsOnLoginPage() {
        assertThat(loginPage.getEmail().isDisplayed()).isTrue();
        logger.info("Assert Login page is displayed");
    }

    @When("^user logs in with valid credentials$")
    public void userLogsInWithValidCredentials() {
        loginPage.loginWithValidCredentials();
        logger.info("Login with valid credentials");
    }

    @Then("^user should be logged in successfully$")
    public void userShouldBeLoggedInSuccessfully() {
        assertThat(homePage.getHeader().isDisplayed()).isTrue();
        logger.info("Assert user logged in successfully");
    }

    @When("^user logs in with invalid credentials$")
    public void userLogsInWithInvalidCredentials() {
        loginPage.loginWithWrongCredentials();
        logger.info("Login with invalid credentials");
    }

    @And("^user should be shown an appropriate error message$")
    public void userShouldBeShownAnAppropriateErrorMessage() {
        assertThat(loginPage.getInvalidCredentialsErrorMessage().getText().contains("Email or password are incorrect.")).isTrue();
        logger.info("Assert invalid credentials shows validation error message");
    }

    @When("^user logs out$")
    public void userLogsOut() {
        homePage.logout();
        logger.info("user logs out");
    }

    @Then("^login page should be displayed$")
    public void loginPageShouldBeDisplayed() {
        userIsOnLoginPage();
    }
}
