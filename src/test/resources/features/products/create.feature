Feature: Create Product

  @login @deleteProduct
  Scenario: Create a new Product
    Given I go to Products Home Page
    When I create a new Product with:
      | PRODUCT_NAME        | AutomatedDemoAT04 |
      | PRODUCT_CODE        | 123               |
      | PRODUCT_DESCRIPTION | Just Something    |
      | PRODUCT_FAMILY      | None              |
      | ACTIVE              | true              |
    Then On Products Details Page the new Product should be displayed
    And I go to Products Home Page
    And On Products Home Page the new Product should be displayed