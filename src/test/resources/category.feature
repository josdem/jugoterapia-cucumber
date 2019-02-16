Feature: I can get categories
  Scenario: Client makes a call to list categories
    When I request categories
    Then I validate categories
