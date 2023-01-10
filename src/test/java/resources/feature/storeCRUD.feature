Feature: Store Application
  As a user I want to test store application

  Scenario Outline: CRUD Test

    When I create store with name "<name>" type"<type>" address"<address>" address2"<address2>" city"<city>" state"<state>" zip"<zip>" lat"<lat>" lng"<lng>" hours"<hours>"
    And I verify store created
    And I update store with name "<name>" type"<type>" address"<address>" address2"<address2>" city"<city>" state"<state>" zip"<zip>" lat"<lat>" lng"<lng>" hours"<hours>"
    And I check store is updated successfully
    And I delete store
    Then I verify that store is deleted successfully
    Examples:
      | name  | type  | address     | address2 | city   | state       | zip   | lat | lng | hours |
      | Hello | Empty | 89 Lindwall |          | Mumbai | Maharashtra | 45025 | 654 | 87  | 8     |