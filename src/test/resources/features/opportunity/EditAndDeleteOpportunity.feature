Feature: Edit Opportunity

  Background:
    Given I go to "Campaign" Home Page
    And I click on New "Campaign"
    And I fill the Campaign form with:
      | CAMPAIGN_NAME | campaign9 |
    And the Campaign should be displayed
    And I go to "Account" Home Page
    And I click on New "Account"
    And I fill the Account form with:
      | ACCOUNT_NAME | New Account 1 |
    And I go to "Opportunit" Home Page
    And I click on New "Opportunit"
    And I fill the Opportunity form with:
      | OPPORTUNITY_NAME    | OpportunityDemo1 |
      | OPPORTUNITY_ACCOUNT | New Account 1    |
      | DATE                | 13/08/2017       |
      | OPPORTUNITY_STAGE   | Proposal         |

  @deleteCampaign @deleteAccount
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
    Then the Opportunity should be displayed
    And I go to "Opportunit" Home Page
    And the Opportunity should be displayed on Home Page


  @deleteCampaign @deleteAccount
  Scenario: Delete the Opportunity on Detail Page
    When I Click on Delete from Opportunity
    Then the Opportunity should not be displayed on Home Page
