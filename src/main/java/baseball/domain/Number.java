package baseball.domain;

import baseball.exception.BusinessException;
import baseball.utils.Constants;
import java.util.Objects;

public final class Number {
    private static final String NUMBER_FORMAT_MESSAGE = "1~9까지의 숫자만 입력 가능합니다.";

    private final Integer number;

    private Number(Integer number) {
        validate(number);
        this.number = number;
    }

    public static Number valueOf(Integer number) {
        return new Number(number);
    }

    public static Number valueOfString(String number) {
        return new Number(parseInt(number));
    }

    private void validate(Integer number) {
        if (number < Constants.MIN_VALUE || number > Constants.MAX_VALUE) {
            throw new BusinessException(NUMBER_FORMAT_MESSAGE);
        }
    }

    private static Integer parseInt(String number) {
        try {
            return Integer.parseInt(number);
        }catch (NumberFormatException e) {
            throw new BusinessException(NUMBER_FORMAT_MESSAGE);
        }
    }

    public boolean is(Integer number) {
        return Objects.equals(this.number, number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number other = (Number) o;
        return number.equals(other.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Number{" +
            "number=" + number +
            '}';
    }
}
