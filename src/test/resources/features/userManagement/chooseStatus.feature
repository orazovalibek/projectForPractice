@chooseStatus
Feature: User should be able to use filters on Users page


  Background:
    When user on the login page
    And user logs in as a "librarian"
    And user clicks "Users" tab

  Scenario Outline:
  User should be able to use filter and select only ACTIVE records

    And user choose "<status>" from Status dropdown
    Then user should see only "<status>" records in the list


    Examples:
      | status   |
      | ACTIVE   |
      | INACTIVE |