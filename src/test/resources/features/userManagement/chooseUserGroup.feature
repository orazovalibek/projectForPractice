Feature: As a librarian I should be able to separate users by group

  @choose_librarian
  Scenario Outline: As a librarian I should be able to separate user by group
    Given user on the login page
    When user logs in as a "librarian"
    And user clicks "Users" tab
    And user choose "<role>" from Users Group dropdown
    Then user should see only "<role>" in the list

    Examples:
      | role      |
      | Librarian |
      | Students  |
