
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


    @fail
  Scenario: Login using valid username and invalid password

    When the user enters valid username and invalid password
    Then the user should not be able to login and get an error message


  @fail
  Scenario: Login using valid credentials

    When The user enters the valid credentials as "duotech" for username and "duotech1" for password
    Then The user should be able to login and land on the homepage
  @fail
  Scenario: Login using valid credentials 2

    When The user enters the valid credentials as "donald.duck" for username and "donald" for password
    Then The user should be able to login and land on the homepage




  Scenario: Demo of the parametrized steps

    When I send a query "select * from users" and the id 45 also price 23.56



  Scenario: Demo of the parametrized steps 2

    When I send a query "update users where id='45'" and the id 34 also price 45



  Scenario Outline: Login using valid credentials through examples

    When The user enters the valid credentials as "<username>" for username and "<password>" for password
    Then The user should be able to login and land on the homepage

    Examples: valid username and password list
      | username       | password    |
      | duotech        | duotech     |
      | donald.duck    | donald      |
      | mickey.mouse   | mickeymouse |
      | minnie.mouse   | minniemouse |
      | scrooge.mcduck | scrooge     |
