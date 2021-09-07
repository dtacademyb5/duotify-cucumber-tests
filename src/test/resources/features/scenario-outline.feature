Feature: Example scenario outline

  Scenario Outline: Example of sceanrio outline
    Given I have all the preresuisites
    When I navigate to a "<page name>" page
    Then The page title should be "<page title>" and api request should return "<status code>"
    Examples:
      | page name      | page title           | status code |
      | Login          | Login Page           | 200         |
      | SignUp         | Sign Up Page         | 201         |
      | BrowseProducts | Browse Products Page | 400         |
      | BrowseProducts | Browse Products Page | 400         |
