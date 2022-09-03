#Author: your.email@your.domain.com
Feature: Google Api
  I want to use this template for my feature file

  Scenario: Add Google Location
    Given I want to add payload
    When user submit "post" api
    Then user validate the status code is 200
