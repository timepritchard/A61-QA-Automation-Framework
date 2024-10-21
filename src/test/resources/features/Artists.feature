Feature: Artists feature

  Background:
    Given I open the login page
    When I enter email "timothy.pritchard@testpro.io"
    And I enter password "q9RQ8fbN"
    And I submit
    Then I am logged in

  Scenario: Verify user can see artists in the app
    When I tap Artists
    Then I see all artists in the list

  Scenario: Verify user can find artists using the search field
    When I tap on the search bar and search artist "Chad"
    Then I see songs from this artist
    And I check that it is a song by the artist searched for "Chad"

  Scenario: Verify user should be able ot play a song of selected artist
    When I tap on the search bar and search artist "Chad"
    And I tap play on the song
    Then the song starts to play

