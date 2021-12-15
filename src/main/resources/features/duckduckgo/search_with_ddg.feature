Feature: Search with DuckDuckGo

  Provides basic coverage of executing searches with DuckDuckGo.

  Scenario: Executing a Search causes the search engine results page to display
    Given the user navigates to the DuckDuckGo homepage
    And the user enters a search query of search to the search field on the DuckDuckGo home page
    When the user clicks the search button on the DuckDuckGo home page

  Scenario: Executing a Search causes the search engine results page to display (short version)
    Given the user navigates to the DuckDuckGo homepage
    And the user enters a search query of search to the search field on the DuckDuckGo home page
    When the user clicks the search button on the DuckDuckGo home page
    Then the DuckDuckGo search results page should display

  Scenario: If the user searches for a specific company name,
    Given the user navigates to the DuckDuckGo homepage
    And the user enters a search query of duckduckgo to the search field on the DuckDuckGo home page
    And the user clicks the search button on the DuckDuckGo home page
    Then the 1st search result on the DuckDuckGo search results page should have a title of DuckDuckGo — Privacy, simplified.
    And the 1st search result on the DuckDuckGo search results page should show a link URL of https://duckduckgo.com
    And the 2nd search result on the DuckDuckGo search results page should have a title of DuckDuckGo Privacy Browser - Apps on Google Play
