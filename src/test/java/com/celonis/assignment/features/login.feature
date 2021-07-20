Feature: Login functionality
  As a registered account user
  I should be able to login to view my company environment, and when I logout,
  I should get logged out of the application.

  Scenario:  A registered user login
    Given user is on login page
    When user logs in with valid credentials
    Then user should be logged in successfully

  Scenario: A Invalid login
    Given user is on login page
    When user logs in with invalid credentials
    And user should be shown an appropriate error message

  Scenario: A registered user logs out
    Given user logs in with valid credentials
    When user logs out
    Then login page should be displayed