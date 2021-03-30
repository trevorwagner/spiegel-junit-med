package io.twagner.spiegel.framework.configuration;

import io.twagner.spiegel.framework.webdriver.SupportedDriverTypes;

import static io.twagner.spiegel.framework.webdriver.SupportedDriverTypes.CHROME;

public class SpiegelConfiguration {
    /*  The values provided here will serve as hard-coded defaults.  The designed order of preference
        for these
        1. Environment Variables
        2. Command-line Arguments
        3. spiegel-configuration.json
        4. Defaults provided within this class
     */
    public SupportedDriverTypes browserType = CHROME;
    public boolean browserHeadless = true;

    private static SpiegelConfiguration instance;

    public static SpiegelConfiguration getInstance(){
        if(instance == null) {
            instance = ConfigLoader.loadConfiguration();
        }
        return instance;
    }
}
