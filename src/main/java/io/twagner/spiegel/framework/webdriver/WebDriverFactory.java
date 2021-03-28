package io.twagner.spiegel.framework.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.twagner.spiegel.framework.configuration.SpiegelConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

    // NOTE: We will depend on gradle to make sure the selected browser/
    // driver type is usable in the current system (e.g. we're not trying
    // to run MSIE on a mac).
    //
    public static WebDriver getWebDriver(){
        return getWebDriver(SupportedDriverTypes.CHROME);
    }

    public static WebDriver getWebDriver(SupportedDriverTypes browserType) {
//        System.out.println("HELLO DEBUGGER");
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpiegelContext.class);
//        SpiegelConfiguration frameworkConfig = ctx.getBean("SpiegelConfiguration", SpiegelConfiguration.class);
//        System.out.println("HELLO DEBUGGER");

        WebDriver driver;
        // TODO: Configure options for the individual browsers (where supported), as well.
        // TODO: Log the interpreted browser configuration either before configuring or returning the browser.
        switch (browserType) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                System.out.println("HELLO DEBUGGER");
                break;
            case SAFARI:
                // NOTE: webdrivermanager does not manage or configure Safari
                driver = new SafariDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case INTERNET_EXPLORER:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                System.out.println("HELLO DEBUGGER");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }

        System.out.println("HELLO DEBUGGER");
        return driver;
    }
}
