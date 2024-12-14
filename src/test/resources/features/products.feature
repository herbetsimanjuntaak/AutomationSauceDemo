@regress @saucedemo @product

Feature: Product

  Background: Login successfully
    Given users access page "https://saucedemo.com/"
    And user successfully using username "standard_user" and password "secret_sauce"


  Scenario: Verify system display button Add to Cart by default for all product
    Then user views the product list
    And system displays the Add to Cart button for all products

  Scenario: Verify system display button remove after add selected product to cart
    When user clicks on the Add to Cart button for a product
    Then the Add to Cart button for that product should change to Remove

  Scenario: Verify system increases the number of items added each time a user adds a product
    When user clicks on the Add to Cart button for a product
    And user clicks on the Add to Cart button for a different product
    Then the number on the cart icon changes to "2"

  Scenario: Verify system reduces the number of items added each time a user deletes a product
    Given user has added 2 products to the cart
    When user clicks on the Remove button for one of the products list
    Then the number on the cart icon changes to "1"

  Scenario: Sort product base on product name - ascending
    When user selects "Name (A to Z)" from the sorting options
    Then the product list should be displayed in ascending order by product name

  Scenario: Sort product base on product name - descending
    When user selects "Name (Z to A)" from the sorting options
    Then the product list should be displayed in descending order by product name

  Scenario: Sort product base on product price - descending
    When user selects "Price (high to low)" from the sorting options
    Then the product list should be displayed in descending order by price name
  @Test
  Scenario: Sort product base on product name - ascending
    When user selects "Price (low to high)" from the sorting options
    Then the product list should be displayed in ascending order by price name

  Scenario: Verify system display button remove after add selected product to cart
    #//button[text()='Add to cart'][0]
    When user clicks on the Add to Cart button for a product
    #//button[text()='Remove'][0]
    Then the Add to Cart button for that product should change to Remove
    #//button[text()='Add to cart'][0]
    When user clicks on the Add to Cart button for a product
    #//button[text()='Remove'][1]
    Then the Add to Cart button for that product should change to Remove
    When user clicks on the Remove button for one of the products list
    And the Remove button should change to Add to Cart
    When user clicks on the Remove button for one of the products list
    And the Remove button should change to Add to Cart

  Scenario: Sort product base on product price from the highest
    And user selects "Price (high to low)s" from the sorting options
#    Then system displays product list based on product price from the "highest"

  Scenario: Sort product base on product price from the highest
    And user selects "Price (low to high)" from the sorting options
    Then system displays product list based on product price from the "cheapest"