Feature: Business rules related sceanrios


 Scenario: Verify album details
  Given The user is on the homepage
  Given I am logged in using "duotech" and "duotech"
  When I retrieve details for album "Werk"
  Then The album artist name should be "Maya Jane Coles"


 @db_only
 Scenario: Verify song play count
  Given The user is on the homepage
  Given I am logged in using "duotech" and "duotech"
  When I click on the song "Marisa" from the album "Marisa" 5 times
  Then The plays should be incremented accordingly in the db

  @db_only
 Scenario: Verify database insert transaction to demonstrate docString
  When I send an insert query to insert a new user
       """
       INSERT INTO users ( username, firstName, lastName, email, password, signUpDate, profilePic)
       values ('jaime.macgyver', 'Rena', 'Mammadova', 'rena.mammadova@gmail.com', '3a1a72ac880d266f06abcb2830866360', '2021-08-26 00:00:00', 'assets/images/profile-pics/head' )
       """
  Then The user should be inserted into the database


  @db_only
 Scenario: Verify genres
   When I send a query to retrieve genres from the db
   Then The result should contain the following genres
    | rap        |
    | pop        |
    | techno     |
    | rnb        |
    | house      |
    | classical  |
    | jazz       |
    | electronic |
    | dance      |
    | reggae     |
    | reggaeton  |


