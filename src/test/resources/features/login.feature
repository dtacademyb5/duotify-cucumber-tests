@loginScenarios
Feature: As a user, I should be able to login using login page.


  Background: Common steps for all scenarios
    Given The user is on the homepage


  @smoke
  Scenario: Login using valid credentials

    When The user enters the valid credentials
    Then The user should be able to login and land on the homepage


  @login
    Scenario: Login using invalid credentials

      When the user enters invalid credentials
      Then the user should not be able to login and get an error message


  @smoke @login @regression
  Scenario: Login using empty credentials

    When the user enters empty credentials
    Then the user should not be able to login


    @current
  Scenario: Login using valid username and invalid password

    When the user enters valid username and invalid password
    Then the user should not be able to login and get an error message