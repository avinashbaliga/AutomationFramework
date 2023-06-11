Feature: HerokuApp Checkbox, Context menu, and Dropdown test

  @basicFeatures
  Scenario: Checkbox test
    Given I'm in the homepage
    And The page heading is "Welcome to the-internet"
    When I click on "Checkboxes" option
    And The page sub heading is "Checkboxes"
    Then I should be able to check the checkboxes

  @basicFeatures
  Scenario: Dropdown test
    Given I'm in the homepage
    And The page heading is "Welcome to the-internet"
    When I click on "Dropdown" option
    And The page sub heading is "Dropdown List"
    Then The dropdown should contain below options
    |Option 1|
    |Option 2|
    And I should be able to select the available options
    |Option 2|
    |Option 1|