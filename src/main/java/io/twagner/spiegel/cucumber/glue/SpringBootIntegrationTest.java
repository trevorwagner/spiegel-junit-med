package io.twagner.spiegel.cucumber.glue;

import io.cucumber.spring.CucumberContextConfiguration;
import io.twagner.spiegel.framework.configuration.SpiegelConfiguration;
import io.twagner.spiegel.framework.context.SpiegelFrameworkContext;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@CucumberContextConfiguration
@ContextConfiguration(classes = SpiegelFrameworkContext.class)
public abstract class SpringBootIntegrationTest {
    /* All glue code classes should subclass this abstract class */
    @Autowired
    protected WebDriver webDriver;

    @Autowired
    protected SpiegelConfiguration frameworkConfig;

    @AfterAll
    static void frameworkTeardown() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpiegelFrameworkContext.class);
        WebDriver driver = ctx.getBean(WebDriver.class);
        driver.quit();
    }
}
