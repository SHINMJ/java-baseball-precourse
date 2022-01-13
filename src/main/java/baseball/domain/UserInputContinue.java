package baseball.domain;

import baseball.exception.BusinessException;
import java.util.Objects;

public class UserInputContinue {
    private static final String CONTINUE_TRUE_INPUT = "1";
    private static final String CONTINUE_FALSE_INPUT = "2";
    private static final String CONTINUE_EXCEPTION_MESSAGE = "1 혹은 2만 입력가능합니다.";
    private final boolean isContinue;

    private UserInputContinue(String input) {
        validate(input);
        this.isContinue = convert(input);
    }

    public static UserInputContinue from(String input) {
        return new UserInputContinue(input);
    }

    public boolean is(boolean expected) {
        return Objects.equals(isContinue, expected);
    }

    public boolean isContinued() {
        return isContinue;
    }

    private void validate(String input) {
        if (Objects.isNull(input)) {
            throw new BusinessException(CONTINUE_EXCEPTION_MESSAGE);
        }

        if (input.length() != 1) {
            throw new BusinessException(CONTINUE_EXCEPTION_MESSAGE);
        }

        if (!(CONTINUE_TRUE_INPUT.equals(input) || CONTINUE_FALSE_INPUT.equals(input))) {
            throw new BusinessException(CONTINUE_EXCEPTION_MESSAGE);
        }
    }

    private boolean convert(String input) {
        return input.equals(CONTINUE_TRUE_INPUT);
    }

}
