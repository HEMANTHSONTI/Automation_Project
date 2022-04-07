@tag
Feature: Sign Up
  I want to use this template to check SignUp

  @tag1
  Scenario: Check user Sign Up
    Given I open browser with url "https://shareon.in/"
    Then I should see Shareon logo
    When I click on Sign in
    Then I should see Sign In page
    When I click on Sign Up
    Then I should see Sign Up page
    When I click on i want to donate
    When i enter full name
    And I enter mobileno
    And I enter email
    And I enter password
    And I enter retype password
    And I click on submit
    When I click on close
    Then I should see username
    When I click on username
    And I click on Logout
    Then I should see Shareon logo
    And I close browser

  @tag2
  Scenario: Check user Sign In
    Given I open browser with url "https://shareon.in/"
    Then I should see Shareon logo
    When I click on Sign in
    Then I should see Sign In page
    When I click on donate
    And I enter email and password
    And I clicked submit
    And I click on Donate
    When I scroll down to Support rural youth
    And I click on DonateNow
    When I click on selected amount
    And I click on pay
    Then I click close
    Then I should see error message
    And I close browser

  @tag3
  Scenario: Email subscription
    Given I open browser with url "https://shareon.in/"
    Then I should see Shareon logo
    When I click on Sign in
    Then I should see Sign In page
    When I click on donate
    And I enter email and password
    And I clicked submit
    When I scroll down to email id
    And I click on subscription
    And I close browser

  @tag4
  Scenario: Contact the Admin
    Given I open browser with url "https://shareon.in/"
    When I click on contact us
    And I enter contact name and contact email
    And I enter contact number
    Then I select a question from list
    And I write a message
    And I click on contact_submit
    And I close browser

  @tag5
  Scenario: Check Search option
    Given I open browser with url "https://shareon.in/"
    Then I click on search button and pass the data
    And I close browser

  @tag6
  Scenario: Check window_handling
    Given I open browser with url "https://shareon.in/"
    When I scroll down to Learn About SDGs
    And I click on it
    Then I should redirect to child page
    And I close popup
    And I redirect to parent page
    And I close browser

  @tag7
  Scenario: Check read more about
    Given I open browser with url "https://shareon.in/"
    Then I should see Shareon logo
    When I click on Donate
    When I scroll down to Support rural youth
    And I  click content
    Then I perform scroll to read more about and click it
    And I close browser

  @tag8
  Scenario: Check Sharenow option
    Given I open browser with url "https://shareon.in/"
    Then I should see Shareon logo
    When I click on Donate
    And I scroll down to Support rural youth
    And I click on sharenow
    And I click on fb image
    Then I should see new window opened with facebook
    And I enter email and Password
    And I click Login
    Then I click on post to fb
    And I close browser
    
    
    
