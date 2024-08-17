Feature: Car Rental System
  The car rental system allows users to register, log in, reserve cars, and manage their accounts, while admins can manage cars, customers, and reports


Scenario: Successful Registration
  Given the user is on the registration page
  When the user enters valid details
  And clicks the "Register" button
  Then the user should see a registration confirmation message


Scenario: Failed Registration with Missing Fields
  Given the user is on the registration page
  When the user leaves mandatory fields blank
  And clicks the "Register" button
  Then the user should see an error message stating "Fields cannot be blank"


Scenario: Successful Login
  Given the user is on the login page
  When the user enters valid credentials
  And clicks the "Login" button
  Then the user should be redirected to the home page


Scenario: Failed Login with Invalid Credentials
  Given the user is on the login page
  When the user enters invalid credentials
  And clicks the "Login" button
  Then the user should see an error message stating "Invalid credentials"


Scenario: Two-Factor Authentication
  Given the user has successfully logged in
  When the system requests two-factor authentication
  And the user enters the valid verification code
  Then the user should be logged in successfully


Scenario: Admin Adds a New Car
  Given the admin is on the "Add Car" page
  When the admin enters valid car details
  And clicks the "Add Car" button
  Then the car should be added to the system


Scenario: Admin Edits Car Details
  Given the admin is on the "Car List" page
  When the admin selects a car to edit
  And updates the car details
  And clicks the "Save" button
  Then the car details should be updated


Scenario: Admin Deletes a Car
  Given the admin is on the "Car List" page
  When the admin selects a car to delete
  And clicks the "Delete" button
  Then the car should be removed from the system


Scenario: Admin Views Reservation List
  Given the admin is on the "Reservations" page
  When the admin views the reservation list
  Then the admin should see all active reservations


Scenario: Admin Creates a Report
  Given the admin is on the "Reports" page
  When the admin selects a date range
  And clicks the "Generate Report" button
  Then the report should be generated and displayed


Scenario: User Searches for Cars
  Given the user is logged in
  When the user enters search criteria on the "Car Search" page
  And clicks the "Search" button
  Then the user should see a list of available cars


Scenario: User Reserves a Car
  Given the user has searched for available cars
  When the user selects a car and reservation dates
  And clicks the "Reserve" button
  Then the car should be reserved for the user


Scenario: User Views Reservation Details
  Given the user is logged in
  When the user navigates to the "My Reservations" page
  Then the user should see all their active reservations


Scenario: User Cancels a Reservation
  Given the user has an active reservation
  When the user clicks the "Cancel Reservation" button
  Then the reservation should be canceled


Scenario: User Makes a Payment
  Given the user has an active car reservation
  When the user clicks the "Make Payment" button
  And enters valid payment details
  Then the payment should be processed successfully


Scenario: User Updates Account Information
  Given the user is logged in
  When the user navigates to the "Account Settings" page
  And updates their personal information
  And clicks the "Save" button
  Then the account information should be updated


Scenario: User Deletes Account
  Given the user is logged in
  When the user navigates to the "Account Settings" page
  And clicks the "Delete Account" button
  Then the user account should be deleted from the system


Scenario: Admin Views Customer Information
  Given the admin is logged in
  When the admin navigates to the "Customer Information" page
  Then the admin should see details of all registered customers


Scenario: Admin Suspends a Customer Account
  Given the admin is logged in
  When the admin selects a customer
  And clicks the "Suspend Account" button
  Then the customer account should be suspended


Scenario: System Sends Reservation Confirmation Email
  Given the user has successfully reserved a car
  When the reservation is confirmed
  Then the user should receive a confirmation email with the reservation details