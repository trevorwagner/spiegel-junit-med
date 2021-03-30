package unit.io.twagner.spiegel.cucumber.glue.support.languages.en;

import io.twagner.spiegel.cucumber.glue.support.languages.en.Expectation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ExpectationTest {

    @Test
    public void assertTrueIsTrue() {
        assertThat(true, is(equalTo(true)));
    }

    @Test
    public void unknownStringReturnsError() {
        assertThrows(
                Error.class,
                () -> new Expectation("unknown string")
        );
    }

    @Test
    public void emptyStringReturnsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Expectation("")
        );
    }

    @Test
    public void nullStringReturnsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Expectation(null)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void expectedStringsConvertedToExpectedBooleanValues(String inputString, boolean expectedResult) {
        boolean actualResult = new Expectation(inputString).it;

        assertThat(actualResult, is(equalTo(expectedResult)));
    }

    static Stream<Arguments> expectedStringsConvertedToExpectedBooleanValues() {
        return Stream.of(
                arguments("should", true), // null strings should be considered blank
                arguments("should not", false),
                arguments("true", true),
                arguments("false", false)
        );
    }
}
