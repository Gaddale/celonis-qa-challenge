package com.celonis.assignment.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = "src/test/java/com/celonis/assignment/features/",
        glue = {"com.celonis.assignment.steps", "com.celonis.assignment.commons"},
        plugin = {
                "pretty",
                "html:target/cucumber-html-report",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"
        }
)
public class TestRunner {


}
