@chatter
Feature: Create Post

  @deletePost
  Scenario: Create a new Post
    Given I go to "Chatter" Home Page
    When I create a new Post with "Hi my name is Simon"
    Then On Chatter Home Page "Hi my name is Simon" should be displayed