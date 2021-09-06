Feature: Sign Up related features

  @db_only
  Scenario: Sign up a new user
    Given I am in homepage and click on sign up
    When I fill up the fields with the following new user information
     | Username | First Name | Last Name | Email            | Password    |
     |m.young67 | Mathhew    | Young     | matt.t@gmail.com | mattyoung67 |
    Then This information should be stored correctly in the database

