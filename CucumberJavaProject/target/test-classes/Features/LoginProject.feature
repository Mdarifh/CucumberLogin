Feature: Test Login Functionality

  Scenario Outline: Check login is Successfully with valid credentials
    Given Browser is open
    And user is on login page
    When user enters <username> and <password>
    And user clicks on login
    Then user is navigate to home page

    Examples: 
      | username | password |
      | Arif     |    12345 |
      | Hussain  |    12345 |
