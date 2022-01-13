package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.exception.BusinessException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class UserInputContinueTest {

    @ParameterizedTest
    @CsvSource(value = {"1;true", "2;false"}, delimiter = ';')
    void 게임지속여부_사용자입력(String input, boolean expected) {
        UserInputContinue userInputContinue = UserInputContinue.from(input);
        assertTrue(userInputContinue.is(expected));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2222", "1111", "4", "0", "d", "#", "신"})
    void 게임지속여부_실패케이스(String input) {
        assertThatThrownBy(() -> UserInputContinue.from(input))
            .isInstanceOf(BusinessException.class)
            .hasMessage("1 혹은 2만 입력가능합니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 게임지속여부_실패케이스_공백(String input) {
        assertThatThrownBy(() -> UserInputContinue.from(input))
            .isInstanceOf(BusinessException.class)
            .hasMessage("1 혹은 2만 입력가능합니다.");
    }
}