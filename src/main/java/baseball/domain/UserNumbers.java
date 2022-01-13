package baseball.domain;

import baseball.exception.BusinessException;
import baseball.utils.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserNumbers {

    private static final String LENGTH_MESSAGE = "3자리의 숫자만 입력하세요.";
    private static final String DUPLICATE_MESSAGE = "중복된 숫자가 존재합니다.";

    private final Numbers numbers;

    private UserNumbers(String input) {
        validateLength(input);
        this.numbers = Numbers.of(convert(input));
    }

    public static UserNumbers of(String input) {
        return new UserNumbers(input);
    }

    public boolean is(Numbers numbers) {
        return this.numbers.equals(numbers);
    }

    public boolean determined(Numbers randomNumbers) {
        int countStrike = numbers.countStrike(randomNumbers);
        if (isStrikeOut(countStrike)) {
            System.out.println("3스트라이크");
            return true;
        }

        int countBall = numbers.countBall(randomNumbers);
        printResult(countStrike, countBall);
        return false;
    }

    private void validateLength(String input) {
        if (Objects.isNull(input)) {
            throw new BusinessException(LENGTH_MESSAGE);
        }
        if (input.length() != Constants.LENGTH) {
            throw new BusinessException(LENGTH_MESSAGE);
        }
    }

    private void validateDuplicate(List<Number> numbers, Number number) {
        if (numbers.contains(number)) {
            throw new BusinessException(DUPLICATE_MESSAGE);
        }
    }

    private List<Number> convert(String input) {
        String[] inputs = input.split("");
        List<Number> numbers = new ArrayList<>();
        for (String s : inputs) {
            Number n = Number.valueOfString(s);
            validateDuplicate(numbers, n);
            numbers.add(n);
        }
        return numbers;
    }

    private boolean isStrikeOut(int countStrike) {
        return countStrike == Constants.LENGTH;
    }

    private boolean isNothing(int countStrike, int countBall) {
        return countStrike == Constants.NON_MATCH_NUMBER && countBall == Constants.NON_MATCH_NUMBER;
    }

    private String makeResult(int countStrike, int countBall) {
        if (countStrike == Constants.NON_MATCH_NUMBER) {
            return String.format("%s볼", countBall);
        }

        if (countBall == Constants.NON_MATCH_NUMBER) {
            return String.format("%s스트라이크", countStrike);
        }

        return String.format("%s스트라이크 %s볼", countStrike, countBall);
    }

    private void printResult(int countStrike, int countBall) {
        if (isNothing(countStrike, countBall)) {
            System.out.println("낫싱");
            return;
        }
        System.out.println(makeResult(countStrike, countBall));
    }

}
