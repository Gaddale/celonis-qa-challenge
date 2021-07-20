package com.celonis.assignment.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.HashMap;
import java.util.Map;

public class ChromeConfig implements BrowserConfig {

    @Override
    public WebDriver getDriver() {
        return new ChromeDriver(getCapabilities());
    }

    @Override
    public ChromeOptions getCapabilities() {
        ChromeOptions cap = new ChromeOptions();
        cap.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability (CapabilityType.ACCEPT_INSECURE_CERTS, true);
        cap.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        cap.setExperimentalOption("prefs", prefs);
        return cap;
    }
}
