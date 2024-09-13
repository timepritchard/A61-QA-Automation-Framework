Feature: Create new playlist

  Background:
    Given I open the login page
    When I enter email "timothy.pritchard@testpro.io"
    And I enter password "q9RQ8fbN"
    And I submit
    Then I am logged in

  Scenario: Create new playlist
    When I tap to create a new playlist
    And I select new playlist
    And I type "best playlist ever"
    Then I see the new playlist notification