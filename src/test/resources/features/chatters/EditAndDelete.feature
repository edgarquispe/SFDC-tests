@chatter
Feature: Edit Post

  Background: Create Post
    Given I go to "Chatter" Home Page
    When I create a new Post with "Hi my name is Simon"

  @deletePost
  Scenario: Edit an existing Post
    When I Edit the Post with "Hi my name is Simon Ovidio Miranda Chiri"
    Then On the Chatter page should be display the "Hi my name is Simon Ovidio Miranda Chiri"

  Scenario: Delete the Post
    When I Delete the Post
    Then On the Chatter page should not display the "This is Test for Delete"