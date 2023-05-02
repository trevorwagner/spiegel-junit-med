package io.twagner.spiegel.cucumber.glue.duckduckgo;

import io.cucumber.java.en.Then;
import io.twagner.spiegel.cucumber.glue.SpringBootIntegrationTest;
import io.twagner.spiegel.cucumber.glue.support.languages.en.Expectation;
import io.twagner.spiegel.cucumber.glue.support.languages.en.OrdinalNumber;
import io.twagner.spiegel.pageobjects.duckduckgo.DuckDuckGoSerpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DuckDuckGoSerpPageSteps extends SpringBootIntegrationTest {
    DuckDuckGoSerpPage serpPage;

    @Then("^the DuckDuckGo search results page should display$")
    public void theDuckDuckGoSearchResultsPageShouldDisplay() throws Throwable {
        this.serpPage = PageFactory.initElements(webDriver, DuckDuckGoSerpPage.class);
        assertThat(serpPage.headerSearchButton.isDisplayed(), is(true));
        assertThat(serpPage.headerSearchField.isDisplayed(), is(true));
        assertThat(serpPage.headerSearchButton.isDisplayed(), is(true));
//        assertThat(serpPage.resultNavigationLinks.length, is(greaterThan(0)));
    }

    @Then("^the header logo link (should|should not) display on the DuckDuckGo search results page$")
    public void theHeaderLogoLinkShouldShouldNotDisplayOnTheDuckDuckGoSearchResultsPage(String shouldIt) throws Throwable {
        Expectation should = new Expectation(shouldIt);
        this.serpPage = PageFactory.initElements(webDriver, DuckDuckGoSerpPage.class);
        assertThat(serpPage.headerLogoLink.isDisplayed(), is(equalTo(should.it)));
    }

    @Then("^the header search field (should|should not) display on the DuckDuckGo search results page")
    public void theHeaderSearchFieldShouldShouldNotDisplayOnTheDuckDuckGoSearchResultsPage(String shouldIt) throws Throwable {
        Expectation should = new Expectation(shouldIt);
        this.serpPage = PageFactory.initElements(webDriver, DuckDuckGoSerpPage.class);
        assertThat(serpPage.headerSearchField.isDisplayed(), is(equalTo(should.it)));
    }

    @Then("^the header search button (should|should not) display on the DuckDuckGo search results page")
    public void theHeaderSearchButtonShouldShouldNotDisplayOnTheDuckDuckGoSearchResultsPage(String shouldIt) throws Throwable {
        Expectation should = new Expectation(shouldIt);
        this.serpPage = PageFactory.initElements(webDriver, DuckDuckGoSerpPage.class);
        assertThat(serpPage.headerSearchButton.isDisplayed(), is(equalTo(should.it)));
    }

    @Then("^the ([0-9]+(?:st|nd|rd|th)) search result on the DuckDuckGo search results page should have a title of (.*)")
    public void theNthPositionResultOnTheDuckDuckGoSearchresultsPageShouldShouldNotHaveATitleSpecifiedTitle(
            String position, String specifiedTitle
    ) throws Throwable {
        this.serpPage = PageFactory.initElements(webDriver, DuckDuckGoSerpPage.class);

        WebElement result = serpPage.getSearchResultByZeroIndex(
                new OrdinalNumber(position).getZeroIndex()
        );
        String actualTitle = result.findElement(By.xpath("./div/h2")).getText();

        assertThat(actualTitle, is(equalTo(specifiedTitle)));
    }
}
