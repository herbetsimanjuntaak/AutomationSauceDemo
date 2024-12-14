@regress @saucedemo @menu
Feature: Menu

  Background:
    Given user access page "https://saucedemo.com/"
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click on login button

  @positive-menu
  Scenario: Verify system direct to https://saucelabs.com/ when click on About Menu
    Given user is logged in successfully
    When user clicks on the burger menu
    Then user should see display sidebar menu
    When user selects About from the menu options
    Then the system should redirect to "https://saucelabs.com/"