Feature: I can get categories
  Scenario: Client list categories
    When I request default categories
    Then I validate default categories
  Scenario: Client get English categories
    When I request categories i18n "en"
    Then I validate English categories
