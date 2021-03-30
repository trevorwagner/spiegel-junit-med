package io.twagner.spiegel.pageobjects.duckduckgo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DuckDuckGoSerpPage {

    private static final String XPATH_HEADER = "//div[@id='header']";
    private static final String XPATH_HEADER_SEARCH_FORM = XPATH_HEADER + "//form[@id='search_form']";
    private static final String XPATH_DUCKBAR = "//div[@id='duckbar']";
    private static final String XPATH_RESULTS_LIST = "//div[@id='links_wrapper']/div[contains(@class, 'results--main')]";

    @CacheLookup
    @FindBy(xpath = XPATH_HEADER + "//div[contains(@class, 'header__search-wrap')]/a")
    public WebElement headerLogoLink;

    @CacheLookup
    @FindBy(xpath = XPATH_HEADER_SEARCH_FORM + "//input[@id='search_form_input']")
    public WebElement headerSearchField;

    @CacheLookup
    @FindBy(xpath = XPATH_HEADER_SEARCH_FORM + "//input[@id='search_button']")
    public WebElement headerSearchButton;

    @FindAll({@FindBy(xpath = XPATH_DUCKBAR + "//ul[@id='duckbar_static']/li/a")})
    public List<WebElement> resultNavigationLinks;

    @FindBy(xpath = XPATH_RESULTS_LIST)
    public WebElement allResultsDiv;

    // Search results are distinguished from "sponsored links"
    // TODO: Add support for sponsored links
    @FindBy(xpath = XPATH_RESULTS_LIST + "//div[@id='links']")
    public WebElement searchResultDiv;

    public WebElement getSearchResultByZeroIndex(int index) {
        return searchResultDiv.findElement(By.xpath(".//div[@id = 'r1-" + index + "']"));
    }
}
