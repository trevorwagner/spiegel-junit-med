package io.twagner.spiegel.cucumber.glue.duckduckgo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.twagner.spiegel.cucumber.glue.SpringBootIntegrationTest;
import io.twagner.spiegel.cucumber.glue.support.languages.en.Expectation;
import io.twagner.spiegel.pageobjects.duckduckgo.DuckDuckGoHomePage;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DuckDuckGoHomePageSteps extends SpringBootIntegrationTest {
    DuckDuckGoHomePage duckDuckGoHomePage;

    @Given("^the user navigates to the DuckDuckGo homepage$")
    public void theUserNavigatesToTheDuckDuckGoHomepage() throws Throwable {
        if(!webDriver.getCurrentUrl().equals(DuckDuckGoHomePage.PAGE_URL)) {
            webDriver.get(DuckDuckGoHomePage.PAGE_URL);
        }
    }

    @Given("^the user enters a search query of (.*) to the search field on the DuckDuckGo home page$")
    public void theUserEntersASearchQueryOfSearchQueryToTheSearchField(String searchQuery) throws Throwable {
        this.duckDuckGoHomePage = PageFactory.initElements(webDriver, DuckDuckGoHomePage.class);
        this.duckDuckGoHomePage.searchField.sendKeys(searchQuery);
    }

    @Given("^the user clicks the search button on the DuckDuckGo home page$")
    public void theUserClicksTheSearchButton() throws Throwable {
        this.duckDuckGoHomePage = PageFactory.initElements(webDriver, DuckDuckGoHomePage.class);
        duckDuckGoHomePage.searchButton.click();
    }

    @When("^the user executes a search for (.*) on the DuckDuckGo home page$")
    public void theUserExecutesASearchForSearchQuery(String searchQuery) throws Throwable {
        this.duckDuckGoHomePage = PageFactory.initElements(webDriver, DuckDuckGoHomePage.class);
        this.duckDuckGoHomePage.searchField.sendKeys(searchQuery);
        this.duckDuckGoHomePage.searchButton.click();
    }

    @Then("^the page title on the DuckDuckGo home page (should|should not) display as (.*)$")
    public void thePageTitleShouldShouldNotBeTitle(String shouldIt, String title) throws Throwable {
        Expectation should = new Expectation(shouldIt);
        this.duckDuckGoHomePage = PageFactory.initElements(webDriver, DuckDuckGoHomePage.class);
        assertThat(webDriver.getTitle().equals(title), equalTo(should.it));
    }

    @Then("^the home page link (should|should not) display on the DuckDuckGo home page$")
    public void theHomePageLinkShouldShouldNotDisplayOnTheDuckDuckGoHomePage(String shouldIt) throws Throwable {
        this.duckDuckGoHomePage = PageFactory.initElements(webDriver, DuckDuckGoHomePage.class);
        Expectation should = new Expectation(shouldIt);
        assertThat(this.duckDuckGoHomePage.homePageLink.isDisplayed(), equalTo(should.it));
    }

    @Then("^the search query field (should|should not) display on the DuckDuckGo home page$")
    public void theSearchQueryFieldShouldShouldNotDisplayOnThePage(String shouldIt) throws Throwable {
        this.duckDuckGoHomePage = PageFactory.initElements(webDriver, DuckDuckGoHomePage.class);
        Expectation should = new Expectation(shouldIt);
        assertThat(this.duckDuckGoHomePage.searchField.isDisplayed(), equalTo(should.it));
    }

    @Then("^the search button (should|should not) display on the DuckDuckGo home page$")
    public void theSearchButtonShouldShouldNotDisplayOnThePage(String shouldIt) throws Throwable {
        this.duckDuckGoHomePage = PageFactory.initElements(webDriver, DuckDuckGoHomePage.class);
        Expectation should = new Expectation(shouldIt);
        assertThat(this.duckDuckGoHomePage.searchButton.isDisplayed(), equalTo(should.it));
    }
}
