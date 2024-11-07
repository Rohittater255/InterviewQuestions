@All
Feature: Search Scenario

  Background:
    Given User is logged in the application

  @Sanity
  Scenario Outline: User Searches for various brands
    Given User navigates to search page
    When User searches "<Brand>"
    And clicks on search button
    Then  "<Brand>" phones should be shown to the user

    Examples:
      | Brand    |
      | Samsung  |
      | Apple    |
      | Samsung2 |
      | Apple2   |
