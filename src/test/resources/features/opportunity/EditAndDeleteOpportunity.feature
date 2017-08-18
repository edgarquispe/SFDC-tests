Feature: Edit Opportunity

  Background:
#    Given I go to "Account" Home Page
#    And I click on New "Account"
#    When I fill the Account form with:
#      | ACCOUNT_NAME          | New Account 1    |
    Given I go to "Campaign" Home Page
    And I click on New "Campaign"
    When I fill the Campaign form with:
      | CAMPAIGN_NAME | campaign9 |
    And the Campaign should be displayed

    Given I go to "Opportunit" Home Page
#    And I click on New "Opportunit"
    And I click on New Opportunit
    And I fill the Opportunity form with:
      | OPPORTUNITY_NAME    | OpportunityDemo1 |
      | OPPORTUNITY_ACCOUNT | New Account 1    |
      | DATE                | 13/08/2017       |
      | OPPORTUNITY_STAGE   | Proposal         |


  @deleteOpportunity @deleteCampaign
  Scenario: Edit the Opportunity on Detail Page
    When I click on Edit Opportunity
    And I fill the Opportunity form with:
      | OPPORTUNITY_NAME        | OpportunityDemo2  |
      | OPPORTUNITY_ACCOUNT     | New Account 1     |
      | DATE                    | 13/08/2017        |
      | OPPORTUNITY_TYPE        | Existing Business |
      | OPPORTUNITY_CAMPAIGN    | campaign9         |
      | OPPORTUNITY_PROBABILITY | 80                |
      | OPPORTUNITY_AMOUNT      | 70                |
      | OPPORTUNITY_REASON      | Price             |
      | OPPORTUNITY_LEAD        | Advertisement     |
      | OPPORTUNITY_NEXT        | step              |
      | OPPORTUNITY_DESCRIPTION | description       |
      | BUDGE                   | true              |
      | DISCOVERY               | true              |
      | ROI                     | true              |
#      | OPPORTUNITY_STAGE       | Proposal          |
    Then the Opportunity should be displayed
    And I go to "Opportunit" Home Page
    And the Opportunity should be displayed on Home Page

#  @deleteOpportunity
#  Scenario: Edit the Opportunity Home Page
#    When I go to "Opportunit" Home Page
#    And I click on Edit "Opportunit"
#    And I fill the Opportunity form with:
#      | OPPORTUNITY_NAME        | OpportunityDemo1  |
#      | OPPORTUNITY_ACCOUNT     | New Account 1     |
#      | DATE                    | 13/08/2017        |
#      | OPPORTUNITY_STAGE       | Proposal          |
#      | OPPORTUNITY_TYPE        | Existing Business |
#      | OPPORTUNITY_CAMPAIGN    | campaign8         |
#      | OPPORTUNITY_PROBABILITY | 80                |
#      | OPPORTUNITY_AMOUNT      | 70                |
#      | OPPORTUNITY_REASON      | Price             |
#      | OPPORTUNITY_LEAD        | Partner           |
#      | OPPORTUNITY_NEXT        | step              |
#      | OPPORTUNITY_DESCRIPTION | description       |
#      | BUDGE                   | true              |
#      | DISCOVERY               | true              |
#      | ROI                     | true              |
#    And I go to "Opportunit" Home Page
#    Then the Opportunity should be displayed on Home Page

  @deleteCampaign
  Scenario: Delete the Opportunity on Detail Page
    When I Click on Delete from Opportunity
    Then the Opportunity should not be displayed on Home Page

#  Scenario: Delete the Opportunity on Home Page
#    When I go to "Opportunit" Home Page
#    And I delete the "Opportunit"
#    Then the Opportunity should not be displayed on Home Page