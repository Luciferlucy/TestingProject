@g15
Feature: user could add product to wishList
  Scenario: user add product to wishList
    When user click on wishList button
    Then successfully added to WishList

  Scenario: user open the wishlist
    When user click on wishList button
    And user click on WishListTap
    Then get QTy value bigger than zero

