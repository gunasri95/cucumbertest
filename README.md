# API Testing Framework with Cucumber

## Introduction
This is a Java-based API testing framework with Cucumber for testing the given currency exchange API.

## Setup
1. Clone the repository.
2. Install Maven if not already installed.
3. Run mvn test to execute the Cucumber test suite.

## Features
### CurrencyExchange.feature
This feature file contains scenarios to test various aspects of the currency exchange API, including:
- API call success and response status
- Response time
- Currency pairs count
- USD price range for AED
- Response schema validation

## Step Definitions
### CurrencyExchangeStepDefinitions.java
This file contains step definitions for the scenarios defined in the feature file. Each step definition corresponds to a step in the feature file and contains the logic to execute that step.

## Framework Components
### APIClient.java
Contains methods to make API requests using RestAssured.

### JsonSchemaValidator.java
Contains logic to validate the API response against a JSON schema.
