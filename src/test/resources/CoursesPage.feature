Feature: Courses Functionality

  Background:
    Given user opens AMS website
    When user signs into the AMS application with valid credentials

  @AMS-030
  Scenario Outline: Verify that user's course cards are displayed in the page
    Then user's <courseId> courses <courseName> are displayed in courses page
    Examples:
    | courseId |         courseName         |
    |    1     | Diploma in Python & Django |
    |    2     | Diploma in Software QA/QC  |

  @AMS-031
  Scenario: Verify that user can take attendance of students for a specific course
    And user clicks on take attendance button of a course
    And user clicks on today's date in the calendar page
    And user select attendance status for all students and submit