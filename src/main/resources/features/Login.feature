@smoke_TCs
Feature: User Login to the website
  Scenario Outline: User enters the website with valid credentials
    Given user is on the login page
    When user Enter Email_Address "<email>"
    And user Enter Password "<password>"
    Then user clicks the login button

    Examples:
      | email                | password |
      | eslamzmkan@gmail.com | 1234567  |