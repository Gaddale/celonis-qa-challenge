Feature: Validate presence and availability of all 3 Demo analysis
  Order to cash, Purchase to pay and Servicenow Ticketing

  Background:
    Given user logs in with valid credentials
    When user is on Process Analysis page

  Scenario: Verify components visibility under "All Workspaces"
    Then these components should be displayed under "All Workspaces"
      | SAP ECC - Order to Cash   |
      | SAP ECC - Purchase to Pay |
      | ServiceNow Ticketing      |

  Scenario Outline: Verify clicking on component analysis load successfully
    When user clicks on "<component_name>"
    Then "<component_name>" analysis should be displayed to the user
    Examples:
      | component_name            |
      | SAP ECC - Order to Cash   |
      | SAP ECC - Purchase to Pay |
      | ServiceNow Ticketing      |

