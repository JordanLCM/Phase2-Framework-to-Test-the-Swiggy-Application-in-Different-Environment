Feature: Test Swiggy App in different environments

Scenario: Swiggy App Test Case
    Given I want to order food from "Bangalore"
    And I want to find "Top Rated" foods & click it
    And I want some "Biryani Bowl Company"
    And I want to filter for "Clean Bowled Bucket Biryani"
    Then I want to save the available types of Sundaes in my Excel File