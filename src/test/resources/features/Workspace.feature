Feature: Workspace
  As an api user I want to execute request in order to get proper responses

@GetWorkspaces
  Scenario Outline: Get all workspaces
    Given An account created in clockify and x-api-key generated
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    Then I obtain the data from my workspace

    Examples:
      | jsonName         | statusCode | operation | entity    |
      | getAllWorkspaces | 200        | GET       | WORKSPACE |