
Feature: As a user, I should be able to login using login page.


  Background: Common steps for all scenarios
    Given The user is on the homepage



  Scenario: Login using valid credentials

    When The user enters the valid credentials
    Then The user should be able to login and land on the homepage
