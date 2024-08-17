Feature: Database Schema Validation via Mobile App

  Background: User Opens App
    Given User opens the app
    And User is connected to the backend API

  # User Table Validation via Mobile App

  Scenario: Validate that user_id is correctly set as AUTO_INCREMENT and PRIMARY KEY in Users table via app
    When User navigates to the registration screen
    And User submits the registration form with valid details
    Then the app should display the user's profile with a unique "user_id"
    And the "user_id" should be greater than 0

  Scenario: Validate that email is UNIQUE and NOT NULL in Users table via app
    When User navigates to the registration screen
    And User submits the registration form with an existing email
    Then the app should show an error message indicating the email already exists
    When User submits the registration form without an email
    Then the app should show an error message indicating the email is required

  Scenario: Validate column data types and constraints in Users table via app
    When User navigates to the registration screen
    And User submits the registration form with valid details
    Then the app should create the user successfully
    And the app should display the user details with correct data types and constraints

  Scenario: Validate that status column accepts only valid ENUM values in Users table via app
    When User navigates to the registration screen
    And User submits the registration form with "status" as "pending"
    Then the app should show an error message indicating that "pending" is not a valid status

  Scenario: Validate that either identity_number or passport_number must be present in Users table via app
    When User navigates to the registration screen
    And User submits the registration form without "identity_number" or "passport_number"
    Then the app should show an error message indicating that one of these fields is required

  Scenario: Validate that created_at and updated_at are automatically set in Users table via app
    When User navigates to the registration screen
    And User submits the registration form without specifying "created_at" or "updated_at"
    Then the app should display the user details with "created_at" and "updated_at" set to the current timestamp

  Scenario: Validate that email format is correct in Users table via app
    When User navigates to the registration screen
    And User submits the registration form with an invalid email format
    Then the app should show an error message indicating the email format is invalid

  # User Role Table Validation via Mobile App

  Scenario: Validate that role_id is correctly set as AUTO_INCREMENT and PRIMARY KEY in User_Roles table via app
    When Admin user navigates to the roles management screen
    And Admin user creates a new role with a role name
    Then the app should display the role with a unique "role_id"
    And the "role_id" should be greater than 0

  Scenario: Validate that role_name is UNIQUE and NOT NULL in User_Roles table via app
    When Admin user navigates to the roles management screen
    And Admin user creates a new role with an existing role name
    Then the app should show an error message indicating the role name already exists
    When Admin user tries to create a role without a role name
    Then the app should show an error message indicating the role name is required

  # User Role Assignments Table Validation via Mobile App

  Scenario: Validate that assignment_id is correctly set as AUTO_INCREMENT and PRIMARY KEY in User_Role_Assignments table via app
    When Admin user navigates to the user roles assignment screen
    And Admin user assigns a role to a user
    Then the app should display the assignment with a unique "assignment_id"
    And the "assignment_id" should be greater than 0

  Scenario: Validate foreign keys and cascading delete in User_Role_Assignments table via app
    When Admin user navigates to the user roles assignment screen
    And Admin user creates a new assignment with valid user_id and role_id
    Then the app should display the assignment correctly
    When Admin user deletes the referenced user from the Users table
    Then the corresponding assignment should be automatically deleted from the assignments list
    When Admin user deletes the referenced role from the Roles table
    Then the corresponding assignment should also be automatically deleted from the assignments list
