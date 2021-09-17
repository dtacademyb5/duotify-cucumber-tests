Feature: Test endpoints in isolation

  Scenario: Test PUT request

    Given I add the header "Content-Type" "application/json" and header "Accept"  "application/json" and parameter "videoGameId" with value 20010 and the following payload
      | name      | releaseDate | reviewScore | category | rating |
      | Safe Game | 2021-09-15  | 99          | FPS      | PG13   |
    When I send a PUT request to "/videogames/{videoGameId}" endpoint
    Then The response status code should be 200
    And The response body should contain the same data
    And The header "content-type" should be "application/json"
    And The response should be returned less than 2 seconds