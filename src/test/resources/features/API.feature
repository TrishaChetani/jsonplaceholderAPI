Feature: Post API

  Scenario Outline: POST request to create post record.
    When I request the service to create post detail
      | title   | <title>   |
      | body    | <body> |
      | userId  | <userId>    |
    Then the service returns the status code <code>
    Examples:
      | title   | body    | userId | code |
      | foo     | bar     | 1      | 201  |

  Scenario Outline: GET request to view details of all post
    When I request the service to get all post detail
    Then the service returns the status code <code>
    Examples:
      | code |
      | 200  |

  Scenario Outline: GET request to view details post by Id
    When I request the service to get post detail by Id
      | id | <id> |
    Then the service returns the status code <code>
    Examples:
      | id         | code |
      | 2          | 200  |


  Scenario Outline: DELETE request to delete post record by Id
    When I request the service to remove post detail by Id
      | id | <id> |
    Then the service returns the status code <code>
    Examples:
      | id         | code |
      | 1          | 200  |
      | 2          | 200  |


