package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {

    @ParameterizedTest
    @CsvSource(value = {"1;1", "2;2", "6;6"}, delimiter = ';')
    void 숫자_생성(String input, Integer expected) {
        assertTrue(Number.valueOfString(input).is(expected));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "e"})
    void 사용자입력시_실패케이스(String input) {
        assertThatThrownBy(() -> Number.valueOfString(input))
            .isInstanceOf(BusinessException.class)
            .hasMessage("1~9까지의 숫자만 입력 가능합니다.");
    }

    @Test
    void 동등성비교() {
        assertAll(
            () -> assertThat(Number.valueOf(1)).isEqualTo(Number.valueOfString("1")),
            () -> assertThat(Number.valueOf(1)).isEqualTo(Number.valueOf(1)),
            () -> assertThat(Number.valueOf(2)).isNotEqualTo(Number.valueOfString("1")),
            () -> assertFalse(Number.valueOf(2).equals(2)),
            () -> assertTrue(Number.valueOf(2).is(2))
        );
    }
}
