Feature: As a user, I should be able to login using login page.

  Scenario: Login using valid credentials
    Given The user is on the homepage
    When The user enters the valid credentials
    Then The user should be able to login and land on the homepage