Feature: I can get a beverage by id
  Scenario: Client can get a beverage by id
    When I request beverage by id "66"
    Then I validate beverage data
  Scenario: Client can get beverages by keyword
    When I request beverages by keyword "pear"
    Then I validate beverages is not empty
