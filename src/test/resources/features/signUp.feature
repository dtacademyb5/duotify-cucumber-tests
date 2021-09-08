Feature: Sign Up related features

  @db_only
  Scenario: Sign up a new user
    Given I am in homepage and click on sign up
    When I fill up the fields with the following new user information
     | Username | First Name | Last Name | Email            | Password    |
     |m.young67 | Mathew    | Young     | matt.t@gmail.com | mattyoung67 |
     |m.young67 | Mathew    | Young     | matt.t@gmail.com | mattyoung67 |
     |m.young67 | Mathew    | Young     | matt.t@gmail.com | mattyoung67 |
     |m.young67 | Mathew    | Young     | matt.t@gmail.com | mattyoung67 |
     |m.young67 | Mathew    | Young     | matt.t@gmail.com | mattyoung67 |
     |m.young67 | Mathew    | Young     | matt.t@gmail.com | mattyoung67 |
     |m.young67 | Mathew    | Young     | matt.t@gmail.com | mattyoung67 |

    Then This information should be stored correctly in the database




   @db_only
  Scenario Outline: Sign up a new user using scenario outline
    Given I am in homepage and click on sign up
    When I fill up the fields with the following new user information
      | Username | First Name | Last Name | Email            | Password    |
      |<username> | <firstName>    | <lastName>    | <email> | <password>  |
    Then This information should be stored correctly in the database

    Examples:
      | username     | firstName | lastName | email                | password           |
      | m.young99    | Mathhew   | Young    | matt99@gmail.com     | mattyoung67        |
      | o.siroj92    | Oyat      | Siroj    | oyat@gmail.com       | oyatsiroj91        |
      | gulara96     | Gulara    | Gulara   | gulara@gmail.com     | gularaalakbarova96 |
      | n.guliyeva98 | Nazrin    | Guliyeva | n.giliyeva@gmail.com | nazringiliyeva98   |
      | kurush88     | Kurush    | Kurush   | kurush@gmail.com     | kurush88           |


  Scenario: Sign up a new user using csv file
    Given I am in homepage and click on sign up
    When I fill up the fields with the new user information from csv file "usernames.csv"
        Then This information should be stored correctly in the database


