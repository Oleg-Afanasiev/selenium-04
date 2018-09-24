@LoginProfile
Feature: Login Profile
  As an employee of the company
  I want to login my employee profile using my credentials
  In order to collaborate with my colleagues

  Scenario: Successful login
    Given I am on home page
    Then I click on signIn link
    When I fill login 'wizik88@gmail.com'
    And I fill password 'Tomax1488'
    And click signIn button
    Then I should see 'Александр Томах' link
    Then I should make logout
