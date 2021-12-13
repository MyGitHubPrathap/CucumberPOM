Feature: Account page feature

  Background:
    Given user has already loged in
      | username                   | password  |
      | prathapreddy.prp@gmail.com | Abcd@1234 |


  Scenario: Account page title
    Given user is on account page
    When user get the title of the page
    Then page title should be "My Account"

  Scenario: Your Store sections
    Given user is on account page
    Then user gets Your Store section
      | Edit your account information         |
      | Change your password                  |
      | Modify your address book entries      |
      | Modify your wish list                 |
      | View your order history               |
      | Downloads                             |
      | Your Reward Points                    |
      | View your return requests             |
      | Your Transactions                     |
      | Recurring payments                    |
      | Register for an affiliate account     |
      | Subscribe / unsubscribe to newsletter |
    And Store section count should be 12