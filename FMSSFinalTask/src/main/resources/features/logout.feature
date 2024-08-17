Feature: Logout

  Scenario: Successful logout
    Given User is logged in
    When User clicks on logout button
    Then User should see the login page

  Scenario: Attempt to access profile after logout
    Given User is logged in
    When User clicks on logout button
    And User tries to access the profile page directly
    Then User should be redirected to the login page
