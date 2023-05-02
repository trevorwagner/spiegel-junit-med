package io.twagner.spiegel.pageobjects.duckduckgo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DuckDuckGoHomePage {
    public static final String PAGE_URL = "https://duckduckgo.com/";

    private static final String XPATH_SEARCH_FORM = "//form[@id='searchbox_homepage']";

    @CacheLookup
    @FindBy(xpath = "//div[contains(@class, 'header_logoStacked')]/img")
    public WebElement homePageLogo;

    @CacheLookup
    @FindBy(xpath = XPATH_SEARCH_FORM + "//input[@id='searchbox_input']")
    public WebElement searchField;

    @CacheLookup
    @FindBy(xpath = XPATH_SEARCH_FORM + "//button[@type='submit']")
    public WebElement searchButton;

    public DuckDuckGoHomePage enterSearchString(String searchQuery) {
        this.searchField.sendKeys(searchQuery);
        return this;
    }
}
