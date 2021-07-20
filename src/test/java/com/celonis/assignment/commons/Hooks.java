package com.celonis.assignment.commons;

import com.celonis.assignment.driver.DriverFactory;
import com.celonis.assignment.pages.PageFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.celonis.assignment.utils.CommonUtils.setBrowser;
import static com.celonis.assignment.utils.CommonUtils.setOs;
import static com.celonis.assignment.utils.CommonUtils.setUrl;

public class Hooks {
    private WebDriver driver;
    private String userMenu = "[cetestinguid='userMenu-avatar-button']";
    private String logoutBtn = "[data-testing-uid='userMenu-logout-button']";

    @Before
    public void initialiseTest() {

        String browser = setBrowser();
        String url = setUrl();
        String os = setOs();
        driver = DriverFactory.getNewDriver(os, browser);
        driver.get(url);
        PageFactory.updateDriver(driver);
    }

    @After
    public void endTest(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        logout();
        driver.close();
        driver.quit();
    }

    public void logout() {
        if (driver.findElements(By.cssSelector(userMenu)).size() > 0) {
            driver.findElement(By.cssSelector(userMenu)).click();
            Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(logoutBtn)));
            driver.findElement(By.cssSelector(logoutBtn)).click();
        }
    }
}
