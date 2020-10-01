Feature: Check that user gets the help or not from Checker tool based on circumstances

  #Scenarion Description: Validate one end to end follow starting from Start/Homepage to Result Page
  @TestScenario1
  Scenario Outline: User checking for help could get to pay for NHS costs
    Given I am a person from the UK "<Confirmation>"
    And open the "<browser>" and launch NHS website
    When User verifies the NHS homepage and clicks on START button
    Then User selects "<Country>" from where to live page and clicks on NEXT button
    And User selectes "<GPConfirmation>" GP Practice from current page and clicks on NEXT button
    And User selectes Date of Birth "<DD>", "<MM>", "<Year>" and clicks on  NEXT button
    And User confirms about the living partner "<partnerAvailablity>" and clicks on  NEXT button
    And User confirms on claiming benefits or tax credits "<claimConfirmation>" and clicks on  NEXT button
    And User confirms about pregnancy "<pregnancyConfirmation>" and clicks on  NEXT button
    And User shares confrimation about war pensioner "<warpensionerConfirmation>" and clicks on  NEXT button
    And User confirms about diabetes "<diabetesConfirmation>" and clicks on  NEXT button
    And User confirms about pre-medical condition "<premedicalConfirmation>" and clicks on  NEXT button
    And User confirms about glaucoma "<glaucomaConfirmation>" and clicks on  NEXT button
    And User confirms about care home "<carehomeConfirmation>" and clicks on  NEXT button
    And User provides savings infromation "<savingsConfirmation>" and clicks on  NEXT button
    Then User navigates with result page
    And User closes the websites

    Examples: 
      | Confirmation | browser | Country | GPConfirmation | DD | MM | Year | partnerAvailablity | claimConfirmation | pregnancyConfirmation | warpensionerConfirmation | diabetesConfirmation | premedicalConfirmation | glaucomaConfirmation | carehomeConfirmation | savingsConfirmation |
      | Yes          | Chrome  | England | No             | 26 | 05 | 1989 | No                 | No                | No                    | No                       | No                   | No                     | No                   | No                   | No                  |
      | No           | Firefox | England | Yes            | 26 | 12 | 1990 | No                 | No                | No                    | No                       | No                   | No                     | No                   | No                   | No                  |

  #Scenario Description: Validate Date of Birth page, perform boundary value analysis for Day, Month and Year fields and verify error message while user provides wrong value for these fields
  @TestScenario2
  Scenario Outline: Error Validation for Date of Birth page and fields
    Given I am a person from the UK "<Confirmation>"
    And open the "<browser>" and launch NHS website
    When User verifies the NHS homepage and clicks on START button
    Then User selects "<Country>" from where to live page and clicks on NEXT button
    And User does not select any values in DOB page and clicks on NEXT button
    Then Application displays error on date of birth page
    When User clicks on error link and verifies the error message
    Then User selectes Date of Birth "<DD>", "<MM>", "<Year>" and clicks on  NEXT button
    Then Application displays error on date of birth page
    When User clicks on error link and verifies the error message
    And User closes the websites

    Examples: 
      | Confirmation | browser | Country | DD   | MM   | Year     |
      | Yes          | Chrome  | Wales   | 2665 | 0509 | 19891989 |
      | Yes          | Firefox | Wales   |  133 |  059 |   198919 |
      | Yes          | Chrome  | Wales   |   45 |   05 |     1989 |
      | Yes          | Firefox | Wales   |   26 |   50 |     1989 |
      | Yes          | Chrome  | Wales   |   45 |   05 |     1989 |
      | Yes          | Firefox | Wales   |   26 |   05 |     9819 |
      | Yes          | Chrome  | Wales   |    0 |    0 |        0 |
