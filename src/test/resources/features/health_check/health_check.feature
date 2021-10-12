@api
Feature: Checking the api is working
  Scenario: Health Checking plain text
    Given Canvas sends a health check in API to "healthcheck"
    Then she get back OK

  Scenario: Health Checking json
    Given Canvas sends a health check in API to "healthcheck_json"
    Then she get back "OK"