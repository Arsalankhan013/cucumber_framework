Feature:US-321 Searching the Employee

  Background:
    When user enters valid admin username and password
    And user clicks on login button
    Then admin user is successfully logged in
    When user clicks on PIM option
    And user clicks on employee list option
@id
    Scenario: Search Employee by id
      When user enters a valid employee id
      And employee clicks on search button
      Then user is able to see the employee

  Scenario: Search Employee by name
    When user enters a employee name
    And employee clicks on search button
    Then user is able to see the employee