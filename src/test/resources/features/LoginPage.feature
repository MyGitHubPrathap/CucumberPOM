Feature: Login page feature

  Scenario: Login page title
    Given user is in login page
    When user get the title of the page
    Then page title should be "Account Login"

  Scenario: Forgot passowrd link
    Given user is in login page
    Then forgot password page should be displayed

  Scenario: Login with correct credentials
    Given user is in login page
    When user enter valid username "prathapreddy.prp@gmail.com"
    And user enter valid password "Abcd@1234"
    And user click on login button
    Then user get the title of the page
    And page title should be "My Account"