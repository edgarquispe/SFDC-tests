Feature: Edit Product

  Background:
    Given I go to "Product" Home Page
    And I click on New "Product"
    And I fill the Product form with:
      | PRODUCT_NAME | AutomatedDemoAT04 |

  @deleteProduct
  Scenario: Edit the Product on Detail Page
    When I click on Edit from Product
    And I fill the Product form with:
      | PRODUCT_NAME        | AutomatedDemoAT04Edited |
      | PRODUCT_CODE        | 123Edited               |
      | PRODUCT_DESCRIPTION | Just Something Edited   |
      | PRODUCT_FAMILY      | None                    |
    Then the Product should be displayed
    And I go to "Product" Home Page
    And the Product should be displayed on Home Page

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

  Scenario: Delete the Product on Detail Page
    When I Click on Delete from Product
    Then the Product should not be displayed on Home Page

#  Scenario: Delete the Product on Home Page
#    When I go to "Product" Home Page
#    And I delete the "Product"
#    Then the Product should not be displayed on Home Page