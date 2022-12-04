@g15
Feature: user could switch between two different home-sliders
  Scenario: user could choose first slider
    When user press on the slider 0
    And user press on the image
    Then user must go to another webpage "https://demo.nopcommerce.com/nokia-lumia-1020"

  Scenario: user could choose second slider
    When user press on the slider 1
    And user press on the image
    Then user must go to another webpage "https://demo.nopcommerce.com/iphone-6"