@All
Feature: Order Scenario

  Background:
    Given User is logged in the application

  @Regression
  Scenario Outline: User Searches for various brands
    Given User adds "<Brand>" phone to cart worth "<Amount>"
    When makes payment on Payment screen
    And clicks on Submit Order Button
    Then Verify "<Brand>" phones is purchased


    Examples:
      | Brand    | Amount
      | Samsung  | 100
      | Apple    | 200
      | Xiaomi   | 300
      | Motorola | 598.8
