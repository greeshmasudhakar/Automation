Feature: validating Place APIs

  Scenario: verify if place has been added.
    Given Add place payload
    When user calls "AddPlaceApi" with post http request
    Then the api call is success with status code 200
    And "Status" in response is "ok"