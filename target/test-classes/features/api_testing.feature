Feature: Get "available" pets. Assert expected result , Post a new available pet to the store. Assert new pet added , Update this pet status to "sold". Assert status updated , Delete this pet. Assert deletion.

  @db
  Scenario: All requests
    Given the user should enter status as the following
      | available |
    When the user get the pets from api with the following endPoints
      | pet/findByStatus |
    Then status code should be 200
    And content type of payload should be JSON
    And the user should be able to verify the payload
    When post method should be able to use with following endPoint to create a new pet
      | pet |
    Then put method should be used to update the pet status
    Then the user should be able to delete a pet with id
      |13|