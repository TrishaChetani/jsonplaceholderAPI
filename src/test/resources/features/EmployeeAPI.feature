Feature: Employee API

  Scenario Outline: POST request for Employee
    When I request employee service to create employee detail
      | name   | <name>   |
      | salary | <salary> |
      | age    | <age>    |
    Then the service returns the status code <code>
    Examples:
      | name   | salary    | age | code |
      | Trisha | 987654321 | 15  | 200  |

  Scenario Outline: GET request for all employee
    When I request employee service to get all employee detail
    Then the service returns the status code <code>
    Examples:
      | code |
      | 200  |

  Scenario Outline: GET request for employee
    When I request employee service to get employee detail
      | employeeId | <employeeId> |
    Then the service returns the status code <code>
    Examples:
      | employeeId | code |
      | 1          | 200  |

  Scenario Outline: DELETE request for employee
    When I request employee service to remove employee detail
      | employeeId | <employeeId> |
    Then the service returns the status code <code>
    Examples:
      | employeeId | code |
      | 1          | 200  |


