package com.celonis.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ServiceNowTicketingPage extends BasePage {

    private By processOverview = By.cssSelector("[class='responsive-nav__body']");

    public WebElement getProcessOverview() {
        return getElement(processOverview);
    }

    public ServiceNowTicketingPage(WebDriver driver) {
        super(driver);
    }
}
