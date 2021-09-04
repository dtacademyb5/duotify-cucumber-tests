Feature: Business rules related sceanrios


 Scenario: Verify album details
  Given The user is on the homepage
  Given I am logged in using "duotech" and "duotech"
  When I retrieve details for album "Werk"
  Then The album artist name should be "Maya Jane Coles"


 @temp @db_only
 Scenario: Verify song play count
  Given The user is on the homepage
  Given I am logged in using "duotech" and "duotech"
  When I click on the song "Marisa" from the album "Marisa" 5 times
  Then The plays should be incremented accordingly in the db


