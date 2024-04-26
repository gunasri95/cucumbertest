Feature: Currency Exchange API Testing

  Scenario: Validate API call success and response status
    Given I make a GET request to the latest USD rates endpoint
    Then the status code should be 200
    And the API response status should be "SUCCESS"

  Scenario: Validate response time
    Given I make a GET request to the latest USD rates endpoint
    Then the API response time should not be less than 3 seconds

  Scenario: Validate currency pairs count
    Given I make a GET request to the latest USD rates endpoint
    Then the number of currency pairs should be 162

  Scenario: Validate USD price range for AED
    Given I make a GET request to the latest USD rates endpoint
    Then the USD price against AED should be in the range of 3.6 to 3.7

  Scenario: Validate response schema
    Given I make a GET request to the latest USD rates endpoint
    Then the API response should match the JSON schema