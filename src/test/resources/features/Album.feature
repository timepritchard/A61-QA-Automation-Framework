Feature: Album feature

  Background:
    Given I open the login page
    When I enter email "timothy.pritchard@testpro.io"
    And I enter password "q9RQ8fbN"
    And I submit
    Then I am logged in

  Scenario: All albums should have a cover
    When I tap home
    And I tap Albums
    Then all of them have cover photos

  Scenario: Album name should be displayed
    When I tap home
    And I tap Albums
    Then all of them should have an album name

  Scenario: songs should be displayed and reflect the actual number of songs in the album
    When I tap home
    And I tap Albums
    And I open album "Airbit"
    Then I check the songs in the album are displayed
    And the correct number of songs are displayed

  Scenario: Shuffle icon should be present
    When I tap home
    And I tap Albums
    And I open album "Airbit"
    Then the shuffle icon should be shown

  Scenario: Download icon should be present
    When I tap home
    And I tap Albums
    And I open album "Airbit"
    Then download all button should be shown

