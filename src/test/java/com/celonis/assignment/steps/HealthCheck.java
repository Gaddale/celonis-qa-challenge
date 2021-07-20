package com.celonis.assignment.steps;

import com.celonis.assignment.pages.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

import java.util.List;

import static org.apache.log4j.Logger.getLogger;
import static org.assertj.core.api.Assertions.assertThat;

public class HealthCheck {

    private static Logger logger = getLogger(Login.class.getName());
    private HomePage homePage = PageFactory.getInstance(HomePage.class);
    private ProcessAnalysisPage processAnalysisPage = PageFactory.getInstance(ProcessAnalysisPage.class);
    private PurchaseToPayPage purchaseToPayPage = PageFactory.getInstance(PurchaseToPayPage.class);
    private ServiceNowTicketingPage serviceNowTicketingPage = PageFactory.getInstance(ServiceNowTicketingPage.class);

    @When("^user is on Process Analysis page$")
    public void userIsOnProcessAnalysisPage() {
        homePage.getProcessAnalysis().click();
        logger.info("Process Analysis page is loaded");
    }

    @Then("^these components should be displayed under \"All Workspaces\"$")
    public void theseComponentsShouldBeDisplayedUnder(List<String> myList) {
        for (String list : myList) {
            assertThat(processAnalysisPage.VerifyComponentItem(list)).isTrue();
            logger.info("Assert component under All Workspaces");
        }
    }

    @When("^user clicks on \"([^\"]*)\"$")
    public void userClicksOn(String component) {
        if (component.equals("SAP ECC - Order to Cash")) {
            processAnalysisPage.openOrderToCashAnalysis();
        }
        if (component.equals("SAP ECC - Purchase to Pay")) {
            processAnalysisPage.openPurchaseToPayAnalysis();
        }
        if (component.equals("ServiceNow Ticketing")) {
            processAnalysisPage.openServiceNowTicketingAnalysis();
        }
        logger.info("Opening specific components: "+component);
    }

    @Then("^\"([^\"]*)\" analysis should be displayed to the user$")
    public void analysisShouldBeDisplayedToTheUser(String component) {
        if (component.equals("SAP ECC - Order to Cash")) {
            assertThat(processAnalysisPage.getBackToWorkspace().isDisplayed()).isTrue();
        }
        if (component.equals("SAP ECC - Purchase to Pay")) {
            assertThat(purchaseToPayPage.getProcessChart().isDisplayed()).isTrue();
        }
        if (component.equals("ServiceNow Ticketing")) {
            assertThat(serviceNowTicketingPage.getProcessOverview().isDisplayed()).isTrue();
        }
        logger.info("Assert specific components loaded successfully: "+ component);
    }
}
