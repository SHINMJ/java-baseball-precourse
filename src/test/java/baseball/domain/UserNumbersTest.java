package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.exception.BusinessException;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserNumbersTest {

    @Test
    void 사용자입력_숫자생성() {
        UserNumbers userNumbers = UserNumbers.of("123");
        assertTrue(userNumbers.is(Numbers
            .of(Arrays.asList(Number.valueOf(1), Number.valueOf(2), Number.valueOf(3)))));
    }

    /**
     * 입력 길이가 3이 넘음 입력값에 영어가 포함됨 입력값에 한글이 포함됨 입력값에 특수문자가 포함됨 중복된 값을 입력함
     */
    @ParameterizedTest
    @CsvSource(value = {"1234;3자리의 숫자만 입력하세요.", "1d2;1~9까지의 숫자만 입력 가능합니다.",
        "1한2;1~9까지의 숫자만 입력 가능합니다.", "1%2;1~9까지의 숫자만 입력 가능합니다.",
        "111;중복된 숫자가 존재합니다."}, delimiter = ';')
    void 사용자입력_실패케이스(String input, String message) {
        assertThatThrownBy(() -> UserNumbers.of(input))
            .isInstanceOf(BusinessException.class)
            .hasMessage(message);
    }
}