Feature:  API workflow test
  Background: for generating the token before every request
   Given a JWT is generated


  Scenario: API test case for creating the employee
    Given a request is prepared for creating an employee
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    And the response body contains key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as global to be used for other request

  Scenario: Getting the created employee
    Given a request is prepared for getting a created employee
    When a GET call is made to get this employee
    Then the status code for this emp is 200
    And the employee id "employee.employee_id" should match with global emp id
    And the retrieved data at "employee" object should match with the data used for creating the employee
  |employee_id|emp_firstname|emp_middle_name|emp_lastname|emp_birthday|emp_gender|emp_job_title|emp_status|
  |54511A  |checking     |null        |api             |1994-09-09   |Male        |QA |N?A |


  @apidynamic
  Scenario: API test case for creating the employee using highly dynamic body
    Given a request is prepared for creating an employee with dynamic data "Sara" , "bou"  , "ms" , "F" , "2011-01-12" , "confirmed" , "QA Engineer"
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    And the response body contains key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as global to be used for other request