@g15
Feature: users could switch between different currencies
  Scenario: verify that dollar selected first option
    Then first option is dollar

  Scenario: user could select different option than dollar
    When user select Euro option
    Then prices changed successfully