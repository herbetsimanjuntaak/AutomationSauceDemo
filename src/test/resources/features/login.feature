@regress @saucedemo @login

Feature: Login


  Scenario: Login Successfully
    Given users access page "https://saucedemo.com/"
    When users input username "standard_user"
    And users input password "secret_sauce"
    And users click on login button
    Then users should see display burger menu

  Scenario Outline: Login with Unregistered Account
    Given users access page "https://saucedemo.com/"
    When users input username "<Username>"
    And users input password "<Password>"
    And users click on login button
    Then system display error message "<Error Message>"

    Examples:
      | Username        | Password      | Error Message                                                             |
      | locked_out_user | secret_sauce  | Epic sadface: Sorry, this user has been locked out.                       |
      |                 | secret_saucee | Epic sadface: Username is required                                        |
      | standard_user   |               | Epic sadface: Password is required                                        |
      |                 |               | Epic sadface: Username is required                                        |
      | username        | secret_saucee | Epic sadface: Username and password do not match any user in this service |
      | standard_user   | password      | Epic sadface: Username and password do not match any user in this service |

  Scenario: Logged Out Successfully
    Given users access page "https://saucedemo.com/"
    And user successfully using username "standard_user" and password "secret_sauce"
    When user click burger button
    And user click logout link
    Then user should see display form login
