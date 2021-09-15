Feature: API demo scenarios

  Scenario: API Scenario demo

    Given I add the header "Accept" "application/json"
    When I send a GET request to "/videogames/{videoGameId}" endpoint by passing 4 as videogame id
    Then the status code should be 200
    And The id should be 4
    And The name should be "Super Mario 64"