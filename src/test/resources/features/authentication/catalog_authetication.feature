@test
Feature: Demo app for authenticate to catalog

  Scenario: Login to a catalog instance
    Given Canvas creates a canvas account
    When she logs in to catalog
    Then she see the catalog homepage