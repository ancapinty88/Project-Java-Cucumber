Feature: User Story 7 Feature

  @test
  Scenario: Scenario 1
    When I am on Home Page
    Then I click on My Account

    Scenario: Verify Search Bar is displayed in Home Page, Shopping Cart Page and Checkout Page
      When I am on "<page>"
      Then I click on "<shopping bar>" field
      Then The search bar is displayed

