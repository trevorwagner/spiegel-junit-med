Feature: Evaluate the DuckDuckGo Homepage

  Background:
    When the user navigates to the DuckDuckGo homepage

  Scenario: The home page displays the expected title
    Then the page title on the DuckDuckGo home page should display as DuckDuckGo — Privacy, simplified.

  Scenario: The home page logo displays on the DuckDuckGo Homepage
    Then the home page logo should display on the DuckDuckGo home page

  Scenario: The search field displays on the DuckDuckGo Homepage
    Then the search query field should display on the DuckDuckGo home page

  Scenario: The search button displays on the DuckDuckGo Homepage
    Then the search button should display on the DuckDuckGo home page