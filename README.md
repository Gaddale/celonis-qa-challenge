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

### Automated test Orchestration

* Good practice is every product development should have CI/CD pipeline for their development process. Let's call this environment as `smoke`  
* Automated test should be integrated to the pipeline, which has to be run against this `smoke` environment for every check-in done by the development team and help them to give immediate feedback. 
* When all the automation scripts are passed against `smoke` environment then stable build has to be deployed to another environment let's call it as `demo` environment.
* Best practice is to maintain `Build radiator` for all different features running against `smoke` environment.

### Note

* Did not test against linux machine, as I work on windows machine.
