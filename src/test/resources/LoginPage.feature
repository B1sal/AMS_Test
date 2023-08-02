Feature: Login Functionality

  Background:
    Given user opens AMS website

  @AMS-001
  Scenario Outline: Verify that user should be able to login using correct username and password
    When user enters username <userName> and password <password>
    And user clicks on login button
    Then user should be redirected to courses page
    Examples:
      | userName      |   password     |
      |  Badstriker7  |  ggmunited12   |
      |   R0cket33r   |   windows10    |
      |   R0naldo     |  Al-nasar23#   |

  @AMS-002
  Scenario Outline: Verify that user should not be able to login to application using wrong username or password and both
    When user enters username <userName> and password <password>
    And user clicks on login button
    Then user validates Invalid credentials error message
    Examples:
      | userName      |   password    |
      |  Badstiker7   |  ggmunited12  |
      |   R0cket33r   |   windws10    |
      |   R0nldo      |  Al-naar3#    |



  @AMS-004
  Scenario Outline: Verify that username and password are case sensitives and user gets error message while trying to login
    When user enters username <userName> and password <password>
    And user clicks on login button
    Then user validates Invalid credentials error message
    Examples:
      | userName      |   password     |
      |  badstriker7  |  ggmunited12   |
      |   R0cket33r   |   Windows10    |
      |   R0nalDo     |  al-nasar23#   |

  @AMS-005
  Scenario: Verify that user can logout successfully after logging into the application
    When user enters username Badstriker7 and password ggmunited12
    And user clicks on login button
    And user clicks on logout button
    Then user should be on the login page

  @AMS-006
  Scenario: Verify that user should not be logged in again after logging out and clicking on browser back button
    When user enters username <userName> and password <password>
    And user clicks on login button
    And user clicks on logout button
    And user clicks on browser back button
    Then user should be on the login page

    @AMS-007
    Scenario Outline: Verify that user is not logged in after spamming sign in button several times with either empty or wrong username and password
      When user enters username <userName> and password <password>
      And user spam clicks on login button
      Then user should be on the login page
      Examples:
        | userName      |   password    |
        |  Badstiker7   |  ggmunited12  |
        |   R0cket33r   |   windws10    |
        |   R0nldo      |  Al-naar3#    |
        |               |               |

#  @AMS-003
#  Scenario: Verify that user should not be able to login to application with empty username and password
#    And user clicks on login button
#    Then user validates empty fields errror message


