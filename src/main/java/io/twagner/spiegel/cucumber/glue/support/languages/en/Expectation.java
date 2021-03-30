package io.twagner.spiegel.cucumber.glue.support.languages.en;

import java.util.Arrays;
import java.util.List;

public class Expectation {
    public boolean it;

    private final List<String> trueValues = Arrays.asList("true", "should");
    private final List<String> falseValues = Arrays.asList("false", "should not");

    private boolean parseValue(String provided) {
        if(provided == null){
            throw new IllegalArgumentException();
        }

        if (provided.replaceAll("\\s+", "").equals("")) {
            throw new IllegalArgumentException();
        }

        if (!trueValues.contains(provided)) {
            if (!falseValues.contains(provided)) {
                throw new Error("The provided string ( "
                        + provided
                        + " ) does not match either list defining true- or false values");
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public Expectation(String provided) {
        this.it = parseValue(provided);
    }
}