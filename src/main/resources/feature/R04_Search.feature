@g15
Feature: User could search for products
  Scenario: user could search using product name
    When user enter product "book"
    And user press on search button
    Then results must be shown

  Scenario: user could search for product using sku
    When user enter product "SCI_FAITH"
    And user press on search button
    And user press on the product
    Then sku of the product must be same like on search