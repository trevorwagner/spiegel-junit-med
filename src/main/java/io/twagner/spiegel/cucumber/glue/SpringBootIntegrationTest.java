package io.twagner.spiegel.cucumber.glue;

import io.cucumber.spring.CucumberContextConfiguration;
import io.twagner.spiegel.framework.context.SpiegelFrameworkContext;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = SpiegelFrameworkContext.class)
public abstract class SpringBootIntegrationTest {
}
