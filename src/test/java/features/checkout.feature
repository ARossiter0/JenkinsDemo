Feature: Place order for products

  @PlaceOrder
  Scenario Outline: Adding items to cart
    Given User is on GreenCart Landing page
    When User searched with Shortname <Name> and extracted actual name of product
    And Added "3" items of the selected product to cart
    Then User proceeds to Checkout
    And validates the item name in checkout page
    And verify user has ability to enter promo code and place the order
    Examples:
      | Name |
      | Tom  |
      | Beet |