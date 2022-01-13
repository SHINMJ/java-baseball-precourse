package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumbersTest {

    @Test
    void 랜덤숫자3개_생성() {
        Numbers numbers = Numbers.createRandomNumbers();
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"398;1", "365;2", "361;3"}, delimiter = ';')
    void 스트라이크_갯수(String input, int expected) {
        Numbers numbers = Numbers.of(Arrays.asList(Number.valueOf(3), Number.valueOf(6), Number.valueOf(1)));
        assertThat(numbers.countStrike(convert(input))).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"136;3", "987;0", "315;1"}, delimiter = ';')
    void 볼_갯수(String input, int expected) {
        Numbers numbers = Numbers.of(Arrays.asList(Number.valueOf(3), Number.valueOf(6), Number.valueOf(1)));
        assertThat(numbers.countBall(convert(input))).isEqualTo(expected);
    }

    private Numbers convert(String input) {
        return Numbers.of(Arrays.stream(input.split(""))
            .map(Number::valueOfString)
            .collect(Collectors.toList()));
    }
}