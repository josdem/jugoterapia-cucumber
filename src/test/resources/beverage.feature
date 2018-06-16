Feature: I can get a Beverage by id
  Scenario: Client makes a call to get a Beverage information based in id
    When the client wants a Beverage
    Then the client receives a Beverage by id
