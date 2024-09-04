Feature: Login feature

  Scenario: Login Scenario
    Given I open login page
    When I enter email "timothy.pritchard@testpro.io"
    And I enter Password "q9RQ8fbN"
    And I submit
    Then I am logged in
