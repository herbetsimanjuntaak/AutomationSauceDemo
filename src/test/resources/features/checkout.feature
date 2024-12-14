@regress @saucedemo @cart
Feature: Checkout

  Background:
    Given user access page "https://saucedemo.com/"
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click on login button

  @positive-checkout
  Scenario: Verify user able input buyer information when checkout
    Given user is logged in successfully
    When user clicks on the Add to Cart button for a product
    And user clicks on the Add to Cart button for a different product
    And the number on the cart icon should increase to 2
    Then user click button checkout