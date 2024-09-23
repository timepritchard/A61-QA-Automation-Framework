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
    And I type "best list"
    Then I see the new playlist notification

  Scenario: attempt to create a playlist with the same name as another playlist
    When I tap to create a new playlist
    And I select new playlist
    And I type "best list"
    Then I should not see the new playlist notification

    Scenario: attempt to create a playlist with a name longer than 10 characters
      When I tap to create a new playlist
      And I select new playlist
      And I type "more than 10 characters"
      And I submit
      Then I should not see the new playlist notification

  Scenario: attempt to create a playlist with a name shorter than 3 characters
    When I tap to create a new playlist
    And I select new playlist
    And I type "TP"
    And I submit
    Then I should not see the new playlist notification


