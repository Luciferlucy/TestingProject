@g15
Feature: users could create new accounts with valid credentials

  Scenario: user register new account successfully
    Given user go to register page
    When user select gender type
    And user enter first "mina" and last name "maged"
    And user enter Date of birth
    And user enter valid email "minamaged2121@gmail.com"
    And user enter password "minamina" & confirm password "minamina"
    And user click on register button
    Then account created successfully
