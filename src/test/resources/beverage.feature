Feature: I can get a Beverage by id
  Scenario: Client makes a call to get a Beverage information based in id
    When the client wants a beverage
    Then the client receives a beverage by id
