package io.twagner.spiegel.framework.context;

import io.twagner.spiegel.framework.configuration.SpiegelConfiguration;
import io.twagner.spiegel.framework.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

/**
 * This class defines the Spring configuration for the overall framework
 */
@Configuration
@ComponentScan(basePackages = {"io.twagner.spiegel.framework"})
public class SpiegelFrameworkContext {
    SpiegelConfiguration frameworkConfig = SpiegelConfiguration.getInstance();

    @Bean
    @Scope(value = SCOPE_SINGLETON)
    WebDriver getWebDriver() {
        return WebDriverFactory.getWebDriver(frameworkConfig.browserType);
    }

    @Bean
    @Scope(value = SCOPE_SINGLETON)
    SpiegelConfiguration getFrameworkConfig() {
        return this.frameworkConfig;
    }
}
