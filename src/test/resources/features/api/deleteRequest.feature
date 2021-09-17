Feature: Test DELETE request


  Scenario: Delete request test in isolation
    Given I add header "Accept" "application/json"
    And I add path parameter video game id 9103
    When I send a DELETE request to "/videogames/{videoGameId}" endpoint
    Then The status code should be 200
    And The header values "content-type" should be "application/json"
    And the response body "status" should be "Record Deleted Successfully"