@TimeEntry
Feature: Time Entry

  As a Clockify user
  I want to use the time entry functionality
  To manage my work hours

  @AddTimeEntry @Clockify @DeleteTimeEntryAfter
  Scenario Outline: Add a new time entry
    Given An account created in clockify and x-api-key generated
    And I perform a 'GET' to 'WORKSPACE' endpoint with the 'getAllWorkspaces' and ''
    And I get a workspaceId
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And I get a timeEntryID
    Then I obtain the data from the time entry

    Examples:
      | jsonName     | statusCode | operation | entity     |
      | addTimeEntry | 201        | POST      | TIME_ENTRY |

  @GetTimeEntry @DeleteTimeEntryAfter
  Scenario Outline: Get a specific time entry
    Given An account created in clockify and x-api-key generated
    And I perform a 'GET' to 'WORKSPACE' endpoint with the 'getAllWorkspaces' and ''
    And I get a workspaceId
    And I perform a 'POST' to '<entity>' endpoint with the 'addTimeEntry' and ''
    And I get a timeEntryID
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    Then I obtain the data from the time entry

    Examples:
      | jsonName     | statusCode | operation | entity     |
      | getTimeEntry | 200        | GET       | TIME_ENTRY |

  @UpdateTimeEntry @DeleteTimeEntryAfter
  Scenario Outline: Update time entry on workspace
    Given An account created in clockify and x-api-key generated
    And I perform a 'GET' to 'WORKSPACE' endpoint with the 'getAllWorkspaces' and ''
    And I get a workspaceId
    And I perform a 'POST' to '<entity>' endpoint with the 'addTimeEntry' and ''
    And I get a timeEntryID
    And I set description to '<description>'
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And description is '<description>'

    Examples:
      | jsonName        | statusCode | operation | entity     | description               |
      | updateTimeEntry | 200        | PUT       | TIME_ENTRY | Modificado por automation |

  @DeleteTimeEntry @Clockify
  Scenario Outline: Delete time entry from workspace
    Given An account created in clockify and x-api-key generated
    And I perform a 'GET' to 'WORKSPACE' endpoint with the 'getAllWorkspaces' and ''
    And I get a workspaceId
    And I perform a 'POST' to '<entity>' endpoint with the 'addTimeEntry' and ''
    And I get a timeEntryID
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained

    Examples:
      | jsonName     | statusCode | operation | entity     |
      | getTimeEntry | 204        | DELETE    | TIME_ENTRY |