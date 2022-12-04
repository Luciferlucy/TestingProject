@g15
Feature: user could use the follow us links
  Scenario: user open facebook link
    When user scroll down  the page
    And user open link "Facebook"
    Then new tap is opened expected "https://www.facebook.com/nopCommerce"

  Scenario: user open twitter link
    When user scroll down  the page
    And user open link "Twitter"
    Then new tap is opened expected "https://twitter.com/nopCommerce"

  Scenario: user open rss link
    When user scroll down  the page
    And user open link "RSS"
    Then new tap is opened expected "https://demo.nopcommerce.com/new-online-store-is-open"

  Scenario: user open youtube link
    When user scroll down  the page
    And user open link "YouTube"
    Then new tap is opened expected "https://www.youtube.com/user/nopCommerce"
