package com.celonis.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProcessAnalysisPage extends BasePage {

    private By workspaceList = By.cssSelector("[class='ce-item-group ce-item-group--middle']");
    private By workspaceOrderToCash = By.cssSelector("a[title='--> SAP ECC - Order to Cash']");
    private By workspacePurchaseToPay = By.xpath("//a[contains(.,'--> SAP ECC - Purchase to Pay')]");
    private By workspaceServiceNowTicketing = By.cssSelector("a[title='--> ServiceNow Ticketing']");
    private By analysis = By.cssSelector("a[aria-label^='Analysis_']");
    private By backToWorkspace = By.xpath("//span[contains(.,'Back to Workspace')]");

    public ProcessAnalysisPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getWorkspaceItems() {
        return elementsList(workspaceList);
    }

    public WebElement getWorkspaceOrderToCash() {
        return getElement(workspaceOrderToCash);
    }

    public WebElement getWorkspacePurchaseToPay() {
        return getElement(workspacePurchaseToPay);
    }

    public WebElement getWorkspaceServiceNowTicketing() {
        return getElement(workspaceServiceNowTicketing);
    }

    public WebElement getAnalysis() {
        return getElement(analysis);
    }

    public WebElement getBackToWorkspace() {
        return getElement(backToWorkspace);
    }

    public boolean VerifyComponentItem(String item) {
        List<WebElement> elements = getWorkspaceItems();
        for (WebElement element : elements) {
            if (element.getText().contains(item)) {
                return true;
            }
        }
        return false;
    }

    public void openOrderToCashAnalysis() {
        waitForElementToLoad(workspaceOrderToCash);
        getWorkspaceOrderToCash().click();
        getAnalysis().click();
    }

    public void openPurchaseToPayAnalysis() {
        waitForElementToLoad(workspacePurchaseToPay);
        getWorkspacePurchaseToPay().click();
        getAnalysis().click();
    }

    public void openServiceNowTicketingAnalysis() {
        waitForElementToLoad(workspaceServiceNowTicketing);
        getWorkspaceServiceNowTicketing().click();
        getAnalysis().click();
    }
}
