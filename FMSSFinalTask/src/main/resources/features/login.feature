Feature: Login

  Scenario Outline: Successful login
    Given User opens app
    And User fills email as "<email>"
    And User fills password as "<password>"
    When User clicks on login button
    Then User should see the profile page

    Examples:
      | email  | password |
      | testuser1@gmail.com | pass123  |
      | testuser1@gmail.com | pass456  |

  Scenario Outline: Unsuccessful login with invalid credentials
    Given User opens app
    And User fills email as "<email>"
    And User fills password as "<password>"
    When User clicks on login button
    Then User should see an error message "Invalid credentials"

    Examples:
      | email  | password |
      | testuser1@gmail.com | wrongpass |
      | testuser1@gmail.com | wrongpass |

  Scenario Outline: Unsuccessful login with invalid email format
    Given User opens app
    And User fills email as "<email>"
    And User fills password as "<password>"
    When User clicks on login button
    Then User should see an error message "Invalid email format"

    Examples:
      | email          | password |
      | invalidemail   | pass123  |
      | another@wrong  | pass456  |