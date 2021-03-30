package unit.io.twagner.spiegel.cucumber.glue.support.languages.en;

import io.twagner.spiegel.cucumber.glue.support.languages.en.OrdinalNumber;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class OrdinalNumberTest {

    static Stream<Arguments> convertsOrdinalStringToIntValue() {
        return Stream.of(
                arguments("1st", 1),
                arguments("2nd", 2),
                arguments("3rd", 3),
                arguments("10th", 10),
                arguments("100th", 100),
                arguments("1000th", 1000)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void convertsOrdinalStringToIntValue(String inputString, int expectedResult) {
        int actualResult = new OrdinalNumber(inputString).getValue();
        MatcherAssert.assertThat(actualResult, is(equalTo(expectedResult)));
    }

    static Stream<Arguments> convertsOrdinalStringToZeroIndex() {
        return Stream.of(
                arguments("1st", 0),
                arguments("2nd", 1),
                arguments("3rd", 2),
                arguments("10th", 9),
                arguments("100th", 99),
                arguments("1000th", 999)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void convertsOrdinalStringToZeroIndex(String inputString, int expectedResult) {
        int actualResult = new OrdinalNumber(inputString).getZeroIndex();
        MatcherAssert.assertThat(actualResult, is(equalTo(expectedResult)));
    }
}
