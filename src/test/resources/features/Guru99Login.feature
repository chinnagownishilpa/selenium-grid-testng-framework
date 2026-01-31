Feature: Guru99 Bank Login

  Scenario: Login to Guru99 Bank using generated credentials
    Given user is on Guru99 login page
    When user enters valid username and password
    And user clicks on login button
    Then user should be logged in successfully
