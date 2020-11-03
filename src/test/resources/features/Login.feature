Feature: As a user I want to login under different role

  @librarian
  Scenario: Login as a librarian
    Given user on the login page
    When user logs in as a "librarian"
    Then user should see "dashboard" page

  @student
  Scenario: Login as a student
    Given user on the login page
    When user logs in as a "student"
    Then user should see "books" page