Feature: Database related Scenarios

  @db_only
  Scenario: Verify the playlists
    When I send a query to get all playlists
    Then The result should be correct