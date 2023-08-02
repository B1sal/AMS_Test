Feature: Profile Functionality

  Background:
    Given user opens AMS website
    When user signs into the AMS application and clicks on Profile tab in navbar

  @AMS-011
  Scenario: Verify that user should be redirected to the profile page when clicked on profile tab in navbar
    Then user should land on Profile page

  @AMS-012
  Scenario: Verify that user’s photo should be displayed on the profile page
    Then user's profile photo should be displayed

  @AMS-013
  Scenario: Verify that user lands on edit profile page when clicked on edit profile button
    And user clicks on edit profile button
    Then user lands of edit profile form page

  @AMS-014
  Scenario Outline: Verify that user information can be edited and saved with valid data in each enable input field
    And user clicks on edit profile button
    And user should change <email>, <address>, <primaryNumber> and <secondaryNumber> with valid data in each enabled required fields
    And user clicks on submit button
    Examples:
      |           email                 |         address          | primaryNumber            |     secondaryNumber   |
      |  sabal.chhetri21@gmail.com      |    Boudha, Kathmandu     |      94958522523         |       9842918238      |

  @AMS-016
  Scenario: Verify that user can remove profile photo
    And user clicks on remove button
    Then user's profile photo should be replaced with default one

#  @AMS-015
#  Scenario Outline: Verify that user information can't be saved with invalid data in each enable input field
#    And user should change <userName>, <address>, <primaryNumber> and <secondaryNumber> with invalid data in each enabled required fields
#    And user clicks on submit button
#    Then user should get error message on profile page
#    Examples:
#        | userName | address | primaryNumber | secondaryNumber |
#        |          |         |               |                 |

#  @AMS-013
#  Scenario: Verify that user information like username, fullname, gender, address and contact details should be displayed properly
#    Then user's information <userName>, <fullName>, <gender>, <address>, <primaryNumber> and <secondaryNumber> should be displayed





