@acc
Feature: Edit Account

  Background:
    Given I go to "Account" Home Page
    And I click on New "Account"
    When I fill the Account form with:
      | ACCOUNT_NAME             | AutomatedDemoAT04          |

  @deleteAccount
  Scenario: Edit the Account on Detail Page
    When I click on Edit from Account
    And I fill the Account form with:
      | ACCOUNT_NAME             | AutomatedDemoAT04          |
      | ACCOUNT_TYPE             | Analyst                    |
      | ACCOUNT_WEBSITE          | www.somepage.com           |
      | ACCOUNT_DESCRIPTION      | This is a Description test |
      | ACCOUNT_PHONE            | 59179732801                |
      | ACCOUNT_INDUSTRY         | Banking                    |
      | ACCOUNT_EMPLOYEES        | 25                         |
      | ACCOUNT_BILLING_STREET   | Some Street                |
      | ACCOUNT_BILLING_CITY     | Cochabamba                 |
      | ACCOUNT_BILLING_ZIP      | 3001                       |
      | ACCOUNT_BILLING_STATE    | Cercado                    |
      | ACCOUNT_BILLING_COUNTRY  | Bolivia                    |
      | ACCOUNT_SHIPPING_STREET  | This is a Shipping Street  |
      | ACCOUNT_SHIPPING_CITY    | Cochabamba                 |
      | ACCOUNT_SHIPPING_ZIP     | 3001                       |
      | ACCOUNT_SHIPPING_STATE   | Cercado                    |
      | ACCOUNT_SHIPPING_COUNTRY | Bolivia                    |
    Then the Account should be displayed
    And I go to "Account" Home Page
    And the Account should be displayed on Home Page

#  @deleteProduct
#  Scenario: Edit the Product Home Page
#    When I go to "Product" Home Page
#    And I click on Edit "Product"
#    And I fill the Product form with:
#      | PRODUCT_NAME        | AutomatedDemoAT04Edited |
#      | PRODUCT_CODE        | 123Edited               |
#      | PRODUCT_DESCRIPTION | Just Something Edited   |
#      | PRODUCT_FAMILY      | None                    |
#    And I go to "Product" Home Page
#    Then the Product should be displayed on Home Page

  Scenario: Delete the Account on Detail Page
    When I Click on Delete from Account
    Then the Account should not be displayed on Home Page

#  Scenario: Delete the Product on Home Page
#    When I go to "Product" Home Page
#    And I delete the "Product"
#    Then the Product should not be displayed on Home Page