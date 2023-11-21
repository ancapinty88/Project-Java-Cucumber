@testSearch
Feature: User Story 7 Feature


Scenario: Verify Search Bar is displayed in Home Page
  Given I am on Home Page
  When I click on search bar field
  Then The search bar is displayed

Scenario: Verify Search Bar is displayed in Shopping Cart Page
  Given I am on Shopping cart page
  When I click on search bar field
  Then The search bar is displayed

Scenario: Verify Search Bar is displayed in Checkout Page
  Given I am on Checkout page
  When I click on search bar field
  Then The search bar is displayed

Scenario: Verify Search Button is displayed in Home Page
  Given I am on Home Page
  When I click on search button
  Then The search button is displayed

Scenario: Verify Search Button is displayed in Shopping Cart Page
  Given I am on Shopping cart page
  When I click on search button
  Then The search button is displayed

Scenario: Verify Search Button is displayed in Checkout Page
  Given I am on Checkout page
  When I click on search button
  Then The search button is displayed

Scenario: Search by Name (RegExp)
  Given I am on Home Page
  When I click on search bar
  And I write iph in the search bar
  Then I click on search button and check

Scenario: Search in Product Descriptions
  Given I am on Home Page
  When I click on search button
  Then Click on Search in product descriptions checkbox
  And Write mac into Search Criteria input
  Then I click on button search
  And Check if word mac is in product description

Scenario: Search in Subcategories - Product belongs to Parent category
  Given I am on Home Page
  When I click on search button
  Then Write mac into Search Criteria input
  And Select the parent category from the dropdown field
  And I click on Search in Subcategories checkbox
  And I click on button search
  Then Check if mac is in the name of the results

Scenario: Search in Subcategories - Product does not belong to Parent category
  Given I am on Home Page
  When I click on search button
  Then Write mac into Search Criteria input
  And Select another parent category from the dropdown field
  And I click on Search in Subcategories checkbox
  And I click on button search
  Then Check if there is no results

Scenario: User is able to sort the Products displayed in the Search Results
  Given I am on Home Page
  When Write mac into Search bar
  And I click on search button
  Then Select option from the Sort by dropdown

Scenario: User can select how many products can be displayed in the Search Results
  Given I am on Home Page
  When Write mac into Search bar
  And I click on search button
  Then Select number of products from the Show dropdown

# Bug No 1
Scenario: The maximum allowed input characters count is 15
  Given I am on Home Page
  When Write a text with more than allowed characters
  And I click on search button
  Then A message1 should be displayed

# Bug No 2
Scenario: Special character like a “, ()!@#$%^* are not allowed(should be truncated)
  Given I am on Home Page
  When Write a text with characters that are not allowed
  And I click on search button
  Then A message2 should be displayed

# Bug No 3
Scenario: The minimum allowed input characters count is 5
  Given I am on Home Page
  When Write a text with less than allowed characters
  And I click on search button
  Then A message3 should be displayed


