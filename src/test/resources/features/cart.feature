@regress @saucedemo @cart
Feature: Cart

  Background: Login successfully
    Given user access page "https://saucedemo.com/"
    And user successfully using username "standard_user" and password "secret_sauce"

  Scenario: Verify system display cart page with click on cart icon
    When user clicks on the cart link
    Then the system should display the cart page

  Scenario: Verify system display product list with click on button Continue shopping
    Given user is on the cart page
    When user clicks on the Continue Shopping button
    Then the system should redirect to the product list page

  Scenario: Verify system remove product with click on button Remove on product list page
    Given user has added 2 products to the cart
    When user clicks on the Remove button for one of the products list
    And the Remove button should change to Add to Cart
#    And user clicks on the cart link
#    Then The removed product should not appear in the cart

  Scenario: Verify system clears all items from the cart by clicking on Reset App State
    Given user has added 2 products to the cart
    And user clicks on the burger menu
    And user should see display sidebar menu
    When user clicks Reset App State on the sidebar menu
    Then the cart icon should be empty

  Scenario: Verify system remove product with click on button Remove on cart page
    Given user has added 2 products in the cart and is on the cart page
    When user clicks on the Remove button for one of the products in the cart
    Then The removed product should not appear in the cart
    And user clicks on the Continue Shopping button
    And the Remove button should change to Add to Cart