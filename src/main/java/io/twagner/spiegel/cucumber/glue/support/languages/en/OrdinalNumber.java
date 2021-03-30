package io.twagner.spiegel.cucumber.glue.support.languages.en;

// Currently we support notating ordinal numbers like 1st, 2nd, 101st, etc.
public class OrdinalNumber {
    private final String ordinalName;

    public int getValue() {
        return Integer.parseInt(ordinalName.replaceAll("(?<=\\d)(st|nd|rd|th)", ""));
    }

    public int getZeroIndex() {
        return this.getValue() - 1;
    }

    public OrdinalNumber(String ordinalName) {
        this.ordinalName = ordinalName;
    }
}
