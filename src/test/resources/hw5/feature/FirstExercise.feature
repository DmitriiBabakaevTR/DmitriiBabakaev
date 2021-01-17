Feature: First exercise Selenium

  Scenario: Exercise 1
    Given I open JDI GitHub site
    Then 'Home Page' page should be opened
    When I login as 'Roman' with password - 'Jdi1234'
    Then User name should be displayed and equals to 'Roman Iovlev'
    When I click on the Service dropdown and then on the 'Different Elements' button
    Then 'Different Elements' page should be opened
    When I select 'Earth' and 'Wind' checkboxes
    And I select 'Selen' radiobutton
    And I select 'Yellow' in dropdown
    Then Each element should be corresponds to itself with positive status