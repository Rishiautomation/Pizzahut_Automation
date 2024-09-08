Feature: This Feature will automate the Pizzahut website

  Scenario: This scenario is used to place an order
    Given I have launched the Website
    When I entered the location "Pune"
    And I select the very first suggestion from the list
    Then I should land on the Deals page
    And I select the tab as "Pizzas"
    And I add "Mazedar Makhni Paneer" to the basket
    And I note down the price displayed on the screen
    Then I should see the pizza "Mazedar Makhni Paneer" is added to the cart
    And price is also displayed correctly
    And I click on the Checkout button
    Then I should be landed on the secured checkout page
    And I enter the personal details
       | Key    | Value        |
      | Name   | Rajesh Sharma |
      | Mobile |     888888888 |
      | Email  | abc@xyz.com   |
    And I enter the address details
      | 123 Main Street |
      | Some Landmark   |
