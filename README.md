##Task1: Component test on the Process Explorer
* `Process Explorer` scenarios are documented in BDD style
* FileName: `Task1-ProcessExplorerScenarios.feature`

##Task2: Automated health checks

### Tools used

* Selenium with Java, Cucumber and Junit
* Log4J for logging
* maven-cucumber-reporting

### Execution

* Default browser is set to `chrome`
* Default url is set to `https://applications.eu-1.celonis.cloud/ui/login`
* Default os is set to `windows`
* Run against chrome and windows `mvn verify -Dbrowser='chrome' -Dos='windows'` 
* Run against firefox and windows `mvn verify -Dbrowser='firefox' -Dos='windows'` 
* Run against specific url `mvn verify -Dbrowser='chrome' -Durl='https://google.co.in'`

### Logging

* Captured logging under file `log/logging.log`

### Reporting

* Cucumber html reports `target/cucumber-html-reports/overview-features.html`

### Note

* Did not test against linux machine, as I work on windows machine.
