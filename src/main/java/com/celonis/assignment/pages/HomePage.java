package com.celonis.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private By header = By.cssSelector("[variant='citronis']");
    private By userMenu = By.cssSelector("[cetestinguid='userMenu-avatar-button']");
    private By logoutBtn = By.cssSelector("[data-testing-uid='userMenu-logout-button']");
    private By processAnalysis = By.cssSelector("[data-testing-uid='ceAppSwitcher-process-mining-link']");

    public WebElement getHeader() {
        return getElement(header);
    }

    public WebElement getLogoutBtn() {
        return getElement(logoutBtn);
    }

    public WebElement getUserMenu() {
        return getElement(userMenu);
    }

    public WebElement getProcessAnalysis(){
        return getElement(processAnalysis);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        waitForElementToLoad(userMenu);
        getUserMenu().click();
        waitForElementToLoad(logoutBtn);
        getLogoutBtn().click();
    }
}
