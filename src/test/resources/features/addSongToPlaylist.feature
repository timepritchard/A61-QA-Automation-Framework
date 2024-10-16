Feature: Add song to playlist feature

  Background:
    Given I open the login page
    When I enter email "timothy.pritchard@testpro.io"
    And I enter password "q9RQ8fbN"
    And I submit
    Then I am logged in

    Scenario: Add song to playlist
      When I tap All songs
      And I tap on song "Frantic"
      And I tap add to
      And I select playlist "sunday"
      Then I check the song is shown in the correct playlist "sunday"