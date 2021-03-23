package io.twagner.spiegel.framework.suites;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = "io.twagner.spiegel.cucumber.glue"
//        plugin = {"progress"}
)
public class AllTestsSuite {
}
