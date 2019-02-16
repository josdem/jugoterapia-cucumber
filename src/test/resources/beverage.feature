Feature: I can get a beverage by id
  Scenario: Client can get a beverage by id
    When I request beverage by id
    Then I validate beverage data
