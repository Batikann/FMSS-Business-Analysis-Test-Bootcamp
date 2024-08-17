Feature: Signup

  Scenario: Successful registration for IdentityNumber
    Given User opens app
    And User navigates to register page
    And User fills registration details with:
      | Name     | John     |
      | Surname  | Doe      |
      | Email    | john@example.com |
      | Identity Number    | 11111111111 |
      | Phone Number | 5444444444  |
      | Password | pass123  |
    When User clicks on register button
    Then User should be redirected to the login page

  Scenario: Successful registration for Passport Number
    Given User opens app
    And User navigates to register page
    And User fills registration details with:
      | Name     | John     |
      | Surname  | Doe      |
      | Email    | john@example.com |
      | Passport Number    | 11111111111 |
      | Phone Number | 5444444444  |
      | Password | pass123  |
    When User clicks on register button
    Then User should be redirected to the login page


  Scenario: Registration fails due to missing Identity Number
    Given User opens app
    And User navigates to register page
    And User fills registration details with:
      | Name     | John     |
      | Surname  | Doe      |
      | Email    | john@example.com |
      | Phone Number | 5444444444  |
      | Password | pass123  |
    When User clicks on register button
    Then User should see an error message "Identity Number is required"
    And User should stay on the register page

  Scenario: Registration fails due to missing Passport Number
    Given User opens app
    And User navigates to register page
    And User fills registration details with:
      | Name     | John     |
      | Surname  | Doe      |
      | Email    | john@example.com |
      | Phone Number | 5444444444  |
      | Password | pass123  |
    When User clicks on register button
    Then User should see an error message "Passport Number is required"
    And User should stay on the register page

  Scenario: Registration fails due to missing Phone Number
    Given User opens app
    And User navigates to register page
    And User fills registration details with:
      | Name     | John     |
      | Surname  | Doe      |
      | Email    | john@example.com |
      | Identity Number | 11111111111 |
      | Password | pass123  |
    When User clicks on register button
    Then User should see an error message "Phone Number is required"
    And User should stay on the register page

  Scenario: Registration fails due to missing Email Address
    Given User opens app
    And User navigates to register page
    And User fills registration details with:
      | Name     | John     |
      | Surname  | Doe      |
      | Identity Number | 11111111111 |
      | Phone Number | 5444444444  |
      | Password | pass123  |
    When User clicks on register button
    Then User should see an error message "Email Address is required"
    And User should stay on the register page


  Scenario: Registration fails due to invalid email format
    Given User opens app
    And User navigates to register page
    And User fills registration details with:
      | Name     | John     |
      | Surname  | Doe      |
      | Email    | johnexample.com |
      | Identity Number | 11111111111 |
      | Phone Number | 5444444444  |
      | Password | pass123  |
    When User clicks on register button
    Then User should see an error message "Please enter a valid email address"
    And User should stay on the register page


  Scenario: Registration fails due to invalid Phone Number format
    Given User opens app
    And User navigates to register page
    And User fills registration details with:
      | Name     | John     |
      | Surname  | Doe      |
      | Email    | john@example.com |
      | Identity Number | 11111111111 |
      | Phone Number | 12345  |
      | Password | pass123  |
    When User clicks on register button
    Then User should see an error message "Please enter a valid phone number"
    And User should stay on the register page


  Scenario: Registration fails due to invalid Identity Number format
    Given User opens app
    And User navigates to register page
    And User fills registration details with:
      | Name     | John     |
      | Surname  | Doe      |
      | Email    | john@example.com |
      | Identity Number | abcdefghijk |
      | Phone Number | 5444444444  |
      | Password | pass123  |
    When User clicks on register button
    Then User should see an error message "Please enter a valid identity number"
    And User should stay on the register page


  Scenario: Registration fails due to invalid Passport Number format
    Given User opens app
    And User navigates to register page
    And User fills registration details with:
      | Name     | John     |
      | Surname  | Doe      |
      | Email    | john@example.com |
      | Passport Number | 1234abcd567 |
      | Phone Number | 5444444444  |
      | Password | pass123  |
    When User clicks on register button
    Then User should see an error message "Please enter a valid passport number"
    And User should stay on the register page
