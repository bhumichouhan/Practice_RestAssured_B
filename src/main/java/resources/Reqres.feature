Feature: to test  Reqres.in application

  Background:
    Given I am on Reqres application

  Scenario Outline: to test the list of users in Reqres
    When  I pass the <endpoint> for get api call
    Then  I get the statuscode <statuscode>
    Examples:
      | endpoint         | statuscode |
      | api/users?page=2 | 200        |
      | api/users/2      | 200        |
      | api/users/23     | 404        |
      | api/unknown      | 200        |
      | api/unknown/2    | 200        |

  Scenario Outline: to test the create users in Reqres
    When  I pass the <endpoint> for post api call
    Then  I get the statuscodes for create users <statuscode>

    Examples:
      | endpoint     | statuscode |
      | api/users    | 201        |
      | api/register | 200        |