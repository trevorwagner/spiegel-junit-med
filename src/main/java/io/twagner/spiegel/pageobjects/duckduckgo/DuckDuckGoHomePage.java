package io.twagner.spiegel.pageobjects.duckduckgo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/* For some reason right now when this page is loaded in Chromedriver,
   different DOM elements (like for homePageLogo -- see below). than
   what display within Chrome desktop.  For a demonstration framework
   I have no problem working around this, but if if this was a test
   framework used by a delivery team I expect that I might try
   inquiring into the difference.
 */
public class DuckDuckGoHomePage {
    public static final String PAGE_URL = "https://duckduckgo.com/";

    private static final String XPATH_SEARCH_FORM = "//form[@id='searchbox_homepage']";

    @CacheLookup
    // xpath for Chrome desktop: "//div[contains(@class, 'header_logoStacked')]/img"
    @FindBy(xpath = "//section[contains(@class, 'legacy-homepage_searchSection')]/img")
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
