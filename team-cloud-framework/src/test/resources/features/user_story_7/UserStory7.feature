Feature: User Story 7 Feature

#  @test
#  Scenario: Scenario 1
#    When I am on Home Page
#    Then I click on My Account

  @test1
    Scenario: Verify Search Bar is displayed in Home Page, Shopping Cart Page and Checkout Page
      Given I am on Home Page
      When I click on shopping bar field
      Then The search bar is displayed

  @test1
    Scenario: Verify Search Bar is displayed in Shopping Cart Page
      Given I am on Shopping cart page
      When I click on shopping bar field
      Then The search bar is displayed

  @test1
    Scenario: Verify Search Bar is displayed in Checkout Page
      Given I am on Checkout page
      When I click on shopping bar field
      Then The search bar is displayed


  @test2
  Scenario: Verify Search Button is displayed in Home Page
      Given I am on Home Page
      When I click on search button
      Then The search button is displayed

  @test2
  Scenario: Verify Search Button is displayed in Shopping Cart Page
      Given I am on Shopping cart page
      When I click on search button
      Then The search button is displayed

  @test2
  Scenario: Verify Search Button is displayed in Checkout Page
      Given I am on Checkout page
      When I click on search button
      Then The search button is displayed


    @test3
      Scenario: Search by Name (RegExp)
      Given I am on Home Page
      When I click on search bar
      And I write iph in the search bar
      Then I click on search button

    #The search results should include products with names matching the regular expression "Iph," such as "iPhone."
    #Other products not matching the regular expression should not be included in the results.

  @test4
  Scenario: Search in Product Descriptions
    Given I am on Home Page
    When I click on search button
    Then Click on Search in product descriptions checkbox
    And Write mac into Search Criteria input
    Then I click on button search
    And Check if word mac is in product description

  @test5
  Scenario: Search in Subcategories - Product belongs to Parent category
    Given I am on Home Page
    When I click on search button
    Then Write mac into Search Criteria input
    And Select the parent category from the dropdown field
    And I click on Search in Subcategories checkbox
    And I click on button search
    Then Check if mac is in the name of the results

    @test6
    Scenario: Search in Subcategories - Product does not belong to Parent category
      Given I am on Home Page
      When I click on search button
      Then Write mac into Search Criteria input
      And Select another parent category from the dropdown field
      And I click on Search in Subcategories checkbox
      And I click on button search
      Then Check if there is no results


    @test7
    Scenario: User is able to sort the Products displayed in the Search Results
      Given I am on Home Page
      When Write mac into Search bar
      And I click on search button
      Then Select option from the Sort by dropdown



      @Test8
      Scenario: User can select how many products can be displayed in the Search Results
        Given I am on Home Page
        When Write mac into Search bar
        And I click on search button
        Then Select number of products from the Show dropdown



