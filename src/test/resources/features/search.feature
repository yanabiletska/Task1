Feature: Heartland Retail Website

  Scenario: Perform a Product Purchase
    Given user accesses "https://magento.softwaretestingboard.com/"
    When user accesses the Shop
    And user filters for a certain category
    And user opens the Product Page
    And user adds multiple quantities of the product to the cart
    And user performs a Checkout
    And user fills out the necessary information
    Then user should be able to see successful checkout message