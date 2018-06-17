Feature: I can get categories
  Scenario: Client makes a call to list categories
    When the client wants category list
    Then the client receives categories
