Feature: Login Functionality for OpenCart E-commerce Website
  As a user of OpenCart Website
  I want to be able to login to my account
  So that I can access my account related features and manage my orders
  Background:
    Given I am on my OpenCart login page
    Scenario: Successful login with valid credentials
      Given I have entered my valid username password
      When I click login button
      Then I should be logged in successfully
    Scenario Outline: Unsuccessful login with invalid or empty credentials
      Given I have entered invalid "<username>" and "<password>"
      When I click login button
      Then I should see an error message indicating "<error_message>"
      Examples:
        | username          | password        | error_message                              |
        | invalid@email.com | invalidPassword | Warning:No match for email and/or password |
        | aabbccc           | validPassword   | Warning:No match for email and/or password |
        | valid@email.com   | aabbcc          | Warning:No match for email and/or password |

    Scenario: Navigating to the forgotten password page
      When I click on the forgot password link
      Then I should be redirected to reset password page