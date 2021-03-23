package io.twagner.spiegel.framework.suites;

import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/features",
        glue = "io.twagner.spiegel.cucumber.glue",
        plugin = {"progress"}
)
public class AllTestsSuite extends SuiteParent {
}
