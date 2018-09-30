Feature: Predict the future
  I want to use the magic 8 ball to answer a question 
  about the future

  Scenario: Predict the college football national champion
    Given I have a magic eight ball
    When I ask will Mississippi State be the national champion
    And I shake the magic eight ball
    Then I get a response
    And the response is one of the standard answers

  Scenario: Come to my senses and ask a realistic question
    Given I have a magic eight ball
    When I ask will Mississippi State ever be the national champion
    And I shake the magic eight ball
    Then I get a response
    And the response is one of the standard answers