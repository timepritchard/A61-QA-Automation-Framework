Feature: Move song to the top of the queue

  Background:
    Given I open the login page
    When I enter email "timothy.pritchard@testpro.io"
    And I enter password "q9RQ8fbN"
    And I submit
    Then I am logged in

  Scenario: Top of the queue
    When I tap current queue
    And I select the 10th song
    And I check its name
    And I tap 'add to
    And I select top of queue
    And I check the new song is at the top of the queue
    Then the song is placed at the top of the queue

