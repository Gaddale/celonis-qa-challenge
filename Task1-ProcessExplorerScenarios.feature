Feature: Process Explorer

#  Background is ran for each scenario in the feature file
  Background:
    Given user login with valid credentials
    And user is on "Process Analytics" page
    And user clicks on "Purchase of Pay" process
    When user is on "Process Explorer"

  Scenario: Verify Process Explorer loads successfully
    Then "Process Explorer" is loaded successfully with these most frequent used end-to-end variants of the process start to process end
      | Create Purchase Requisition Item |
      | Create Purchase Order Item       |
      | Send Purchase Order              |
      | Record Goods Receipt             |
      | Record Invoice Receipt           |
      | Clear Invoice                    |

#---------------------Activities Panel----------------------------------------

  Scenario: Verify adding next important activity to the chart from the activities panel
    When user clicks on "More +" button until the button gets disabled
    Then for each click new nodes and their corresponding edges should be added in the Process Map

  Scenario: Verify removing least important activity on the chart for Activities
    When some/all the activities are added into the chart
    And user clicks on "Less -" button until the button gets disabled
    Then for each click existing nodes with their corresponding edges should be removed from the Process Map

  Scenario: verify slider operation on the activities panel
    When user drags the slider up and down
    Then new nodes and their corresponding edges should be displayed for each slider up operation
    And nodes and their corresponding edges should be removed for each slider down operation

  Scenario: verify list view operation on the activities panel
    When user clicks on list view
    Then user should be displayed with all the activities as a list
    When user selects any of the activities from the list
    Then the selected activity should be displayed on the process chart with their corresponding edges

  Scenario: Verify reset operation on the activities/connections panel
    And user clicks on "Reset" button on activities/connections panel
    Then all the newly added activities should be removed on the activities panel
    And all the newly added connections should be removed on the connections panel

#------------------------Connections panel----------------------------

  Scenario: Verify adding next important connection step to the chart from the connections panel
    When user clicks on "More +" button until the button gets disabled
    Then for each click new edges between the existing activities should be added in the Process Map

  Scenario: Verify removing least important connection step from the chart for connections
    When some/all the connections are already added into the chart
    And user clicks on "Less -" button until the button gets disabled
    Then for each click edges between the existing activities should be removed in the Process Map

  Scenario: verify slider operation on the connections panel
    When user drags the slider up and down
    Then new edges between the existing activities should be displayed in the Process Map for each slider up operation
    And edges between the existing activities should be removed in the Process Map for each slider down operation

  Scenario: verify list view operation on the connections panel
    When user clicks on list view
    Then user should be displayed with connections between the displayed activities as a list
    When user selects any of the connections from the list
    Then the selected connection should be highlighted on the process chart with their corresponding activities


#---------------------------Each Activity---------------------------------------------------

  Scenario: Verify contents clicking on each activity
    When user clicks on each one these activities
      | Create Purchase Requisition Item |
      | Create Purchase Order Item       |
      | Send Purchase Order              |
      | Record Goods Receipt             |
      | Record Invoice Receipt           |
      | Clear Invoice                    |
    Then user should be displayed total number of cases passing through it on each activity
    And user should see a right hand side window pop-up with these details
      | Activity name            |
      | Percentage of occurrence |
      | Cases come from tab      |
      | Cases go to tab          |

  Scenario: Verify contents inside "Cases come from" section for each activity
    When user clicks on each activity
    Then user should be displayed with "Cases come from" section with columns
      | Activity                   | Case Frequency                              |
      | <<previous activity name>> | <<frequency number from previous activity>> |
      | Change Quantity            | <<change quantity number>>                  |
      | Cancel Goods Receipt       | <<cancel goods numbers>>                    |
    And the number displayed on each activity should be sum of all numbers in the Case Frequency column

  Scenario: Verify contents inside "Cases go to" section for each activity
    When user clicks on each activity
    And user should be displayed with "Cases go to" section with columns
      | Activity               | Case Frequency                         |
      | <<next activity name>> | <<frequency number for next activity>> |
      | Change Quantity        | <<change quantity number>>             |
      | Cancel Goods Receipt   | <<cancel goods numbers>>               |
    And the number displayed on activity should be sum of all numbers in the Case Frequency column

  Scenario:Verify select cases for a activity in the Process Map
    When user selects each activity
    And in the "Select cases" drop down option "With this activity" is selected
    Then process chart should only show variants that contain the selected activity
    When in the "Select cases" drop down option "Without this activity" is selected
    Then process chart should only show variants that do not contain the selected activity
    When in the "Select cases" drop down option "Starting with this activity" is selected
    Then process chart should only show variants that begin with the selected activity
    When in the "Select cases" drop down option "Ending with this activity" is selected
    Then process chart should only show variants that finish on the selected activity

  Scenario: Verify "Process Start" activity should not contain "Cases come from" section
    When user clicks on "Process start" Activity
    Then user should see a right hand side window pop-up with activity name
    And "Cases come from" section should not be displayed
    And "Cases go to" section should not be displayed

  Scenario: Verify "Process End" activity should show all the traversed activities
    When user clicks on "Process End" Activity
    Then user should see a right side window pop-up with activity name
    And "Cases go to" section should not be displayed
    And "Cases come from" section should display all the traversed activities
      | Block Purchase Order Item        |
      | Create Purchase Requisition Item |
      | Create Purchase Order Item       |
      | Change Currency                  |
      | Change Price                     |
      | Change Quantity                  |
      | Clear Invoice                    |
      | Delete Purchase Order Item       |
      | Dun Order Confirmation           |
      | Send Purchase Order              |
      | Record Goods Receipt             |
      | Remove Payment Block             |
      | Receive Order Confirmation       |
      | Refuse Purchase Order Item       |
      | Release Purchase Order           |
      | Record Invoice Receipt           |
      | Send Overdue Notice              |
      | Send Purchase Order              |
      | Send Purchase Order Update       |
      | Set Payment Block                |

#--------------------------Each connection---------------------------------------------------

  Scenario: Verify contents clicking on each connection
    When user clicks on each connection flow between two activities
    Then connection flow is highlighted
    And every edge should show total number of cases passing through it
    And user should see a right hand side window pop-up with these details
      | Connection flow names as heading                             |
      | Percentage of occurrence                                     |
      | Activity Details view                                        |
      | Total number of cases same as the number highlighted on edge |

  Scenario: Verify select cases for a connection in the Process Map
    When user clicks on each connection flow between two activities
    And user selects "Select cases" drop down is selected with option "With this connection"
    Then process chart only shows variants that contain the selected connection
    And user selects "Select cases" drop down is selected with option "Without this connection"
    Then process chart only shows variants that do not contain the selected connection

#-------------------KPI's----------------------------------------------------------------------

  Scenario: Verify KPI's selection changes the activities display on the process map
    When user selects each of these KPI's
      | Case Frequency                 |
      | Activity Frequency             |
      | Throughput Time (Median)       |
      | Throughput Time (AVG)          |
      | Throughput Time (Trimmed mean) |
    Then user should be displayed with corresponding view based on the KPI value selected

#-----------------------Process Animation--------------------------------------------------------

  Scenario: Verify grouping selection
    When user selects each of these groups
      | Group by day  |
      | Group by hour |
      | No grouping   |
    Then user should be displayed with connection flow in the form of a video with options
      | Play         | starts or stops the Process Animation             |
      | Pause        | pauses the animation                              |
      | Speed slider | varies the speed in which the animation is played |
    And video play should show cases flow in the form "Animation bubbles"

#-------------------Hide or display activities-------------------------------------------------

  Scenario: Verify only the selected activities are displayed on the process chart
    When user deselects any of the activities
    Then those activities are not displayed in the chart
    And only the selected activities are displayed on the chart

#--------------------Zoom operation-----------------------------------------------------------

  Scenario: Verify zoom out (' - '), zoom in (' + ') and Reset operations
    When user clicks on zoom out (' - ') button
    Then process map should zoom out as expected
    When user clicks on zoom out (' + ') button
    Then process map should zoom in as expected
    When user clicks "Reset" button
    Then Process map zoom should reset and process map should load fitting to the screen

#---------------------Settings---------------------------------------------------------------
  Scenario: Verify "Active Grouping" under settings
    When user selects the "Active Grouping" under settings
    And user creates new group by selecting the activities
    Then new group should be created and visible under the Active Grouping --> GROUPS
    And the same group should be visible in the process map

  Scenario: Verify "Activity colors" under settings
    When user selects the "Active colors" under settings
    And user selects the color adjacent to the Activity in the Activity list
    Then the same color should reflect in the process map for the corresponding activity