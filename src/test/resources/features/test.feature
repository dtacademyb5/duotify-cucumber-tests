Feature: Test feature
  #Feature represents a feature that is being worked on, such as login, update_user_details



  Scenario: Test scenario
    Given I have set up all the pre-conditions for the test
    When I execute a specific step
    Then The result should be as expected
    And The result should also have this outcome
    And The result should also should contain this outcome
    But The result should not contain this outcome
#    And Testing the snippet generation option


  Scenario: Test cucumber datatable list of lists

    Given The user is on the homepage
    When the user passes this information as a table
      | Oyat    | Siroj   | 23/04/1990 | VA | 236-23-3526 |
      | Parviz  | Hatamov | 11/06/1960 | MD | 444-66-0902 |
      | Rafael  | Aziz    | 11/05/1980 | NY | 123-99-5643 |
      | Firdavs | Mirzaev | 11/4/2000  | NJ | 832-12-8764 |

    Then It should passed correctly


  Scenario: Test cucumber datatable list of Strings
# Cucumber DataTable belongs to a single step
    Given The user is on the homepage
    When the user passes this information
      | Dresses    |
      | Sunglasses |
      | Watches    |
      | Socks      |
      | Belts      |

    Then It should passed correctly



  Scenario: Test cucumber datatable list of maps

    Given The user is on the homepage
    When the user passes this information as a table as a map
      | First Name | Last Name | Date oF Birth | State | SSN         |
      | Oyat       | Siroj     | 23/04/1990    | VA    | 236-23-3526 |
      | Parviz     | Hatamov   | 11/06/1960    | MD    | 444-66-0902 |
      | Rafael     | Aziz      | 11/05/1980    | NY    | 123-99-5643 |
      | Firdavs    | Mirzaev   | 11/4/2000     | NJ    | 832-12-8764 |

    Then It should passed correctly




  Scenario: Test cucumber datatable map of string and list

    Given The user is on the homepage
    When the user passes this information as a table as a map of string and list
      | KMSY | 29.993333 |  -90.258056 |
      | KSFO | 37.618889 | -122.375000 |
      | KSEA | 47.448889 | -122.309444 |
      | KJFK | 40.639722 |  -73.778889 |

    Then It should passed correctly



  Scenario: Test cucumber datatable map of maps

    Given The user is on the homepage
    When the user passes this information as a table as a map of maps
      |      |       lat  |         lon| airport id |
      | KMSY | 29.993333 |  -90.258056 | 455324432  |
      | KSFO | 37.618889 | -122.375000 |  234324234 |
      | KSEA | 47.448889 | -122.309444 | 4353454    |
      | KJFK | 40.639722 |  -73.778889 | 623523435  |

    Then It should passed correctly






