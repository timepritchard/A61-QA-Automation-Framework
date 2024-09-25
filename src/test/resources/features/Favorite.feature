Feature: Create new playlist

  Background:
    Given I open the login page
    When I enter email "timothy.pritchard@testpro.io"
    And I enter password "q9RQ8fbN"
    And I submit
    Then I am logged in

  Scenario: Adding a song to the favorite list
    When I tap home
    And I tap All songs
    And I favorite song "Pluto"
    And I tap favorites
    Then I see the song in the favorite list

    Scenario: Removing a song from the favorite list
      When I tap home
      And I tap favorites
      And I remove favorite "Pluto"
      Then the song is removed from the favorite list

      Scenario: when all songs are removed from favorite list it should show empty
        When I tap home
        And I tap favorites
        Then I see no favorites yet