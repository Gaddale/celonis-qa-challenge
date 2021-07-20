package com.celonis.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PurchaseToPayPage extends BasePage {

    private By processChart = By.cssSelector("[class='canvas']");

    public WebElement getProcessChart() {
        waitForElementToLoad(processChart);
        return getElement(processChart);
    }

    public PurchaseToPayPage(WebDriver driver) {
        super(driver);
    }
}
