Feature: Guru99 Manager Home and Logout

  Scenario: Verify Manager home page after successful login
    Given user is on Guru99 login page
    When user enters valid username and password
    And user clicks on login button
    Then manager home page should be displayed

  Scenario: Login with invalid credentials
    Given user is on Guru99 login page
    When user enters invalid username and password
    And user clicks on login button
    Then error alert should be displayed
