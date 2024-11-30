@smoke_TCs
Feature: user Register to the website
  Scenario Outline: Enter data from Excel sheet
    Given I read test data from excel sheet <row_number>
    When user Enter valid First_Name
    And user Enter Middle_Name
    And user Enter Last_Name
    And user Enter Email_Address
    And user Enter Password
    And user Enter ConfirmPassword
    Then click Register button

    Examples:
      | row_number |
      | 0          |
      | 1          |
      | 2          |
      | 3          |
      | 4          |

