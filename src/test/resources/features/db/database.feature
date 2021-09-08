Feature: Database related Scenarios

  @db_only
  Scenario: Verify the playlists
    When I send a query to get all playlists
    Then The result should be correct


  @temp @db_only
  Scenario: Verify the first 5 users in users table
    When I send a query to get the first 5 users from users table
    Then The result should be the following
      | 1 | duotech        | Duotech | Academy    | duotech2020@gmail.com      | 4934cbd16be4fb1019f241180cc9b937 | 2020-04-30T00:00 | assets/images/profile-pics/head_ |
      | 4 | leon.schroeder | Maritza | Mcclure    | hello@gmail.com            | ffe18fb6ca7a325d5d7b4b8d72c4256e | 2020-04-30T00:00 | assets/images/profile-pics/head_ |
      | 5 | daron.goodwin  | Shelby  | Wintheiser | Leonel.fadel@yahoo.com     | 291db07ea47d3ebded686a7c7c759688 | 2020-04-30T00:00 | assets/images/profile-pics/head_ |
      | 6 | alexis.johns   | Sueann  | Bins       | Isaac.kohler@hotmail.com   | 5e367519403a073778c4db71c0d54e5e | 2020-04-30T00:00 | assets/images/profile-pics/head_ |
      | 7 | giovanni.rice  | Marline | Stark      | Melissa.schuster@gmail.com | 24d9324327b32adb4485c6dba6e2ed90 | 2020-04-30T00:00 | assets/images/profile-pics/head_ |


