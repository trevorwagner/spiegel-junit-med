package io.twagner.spiegel.pageobjects.duckduckgo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DuckDuckGoHomePage {
    public static final String PAGE_URL = "https://duckduckgo.com/";

    private static final String XPATH_SEARCH_FORM = "//form[@id='search_form_homepage']";

    @CacheLookup
    @FindBy(xpath = "//a[@id='logo_homepage_link']")
    public WebElement homePageLink;

    @CacheLookup
    @FindBy(xpath = XPATH_SEARCH_FORM + "/input[@id='search_form_input_homepage']")
    public WebElement searchField;

    @CacheLookup
    @FindBy(xpath = XPATH_SEARCH_FORM + "/input[@id='search_button_homepage']")
    public WebElement searchButton;

    public DuckDuckGoHomePage enterSearchString(String searchQuery) {
        this.searchField.sendKeys(searchQuery);
        return this;
    }
}
