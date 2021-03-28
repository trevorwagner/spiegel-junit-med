package io.twagner.spiegel.framework.configuration;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

public class ConfigLoader {
//    private static final Logger logger = LogManager.getLogger(ConfigLoader.class);

    private static final String CONFIG_FILE_LOCATION = "spiegel-config.json";

    public static SpiegelConfiguration loadConfiguration() {

        SpiegelConfiguration spiegelConfiguration = null;

        ObjectMapper mapper = new ObjectMapper();

        try {
            Path configFilePath = Paths.get(CONFIG_FILE_LOCATION);
//            logger.debug("Getting configuration file at " + configFilePath.toString());

            File configFile = configFilePath.toFile();
//            logger.debug("Config file: " + configFile.toString());

            spiegelConfiguration = mapper.readValue(configFile, SpiegelConfiguration.class);

        } catch (Exception ex) {
//            logger.error(ex.getMessage() + "\n" + Arrays.toString(ex.getStackTrace()));
            ex.printStackTrace();
        }

        //TODO: Reconcile this with settings from command line, env variables
        //TODO: Log the final configuration as debug before returning it

        // If for some reason there was an issue loading the file, just return null and let it break.

        return spiegelConfiguration;
    }
}
