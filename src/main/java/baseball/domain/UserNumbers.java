package baseball.domain;

import baseball.exception.BusinessException;
import baseball.utils.Constants;
import java.util.ArrayList;
import java.util.List;

public class UserNumbers {

    private static final String LENGTH_MESSAGE = "3자리의 숫자만 입력하세요.";
    private static final String DUPLICATE_MESSAGE = "중복된 숫자가 존재합니다.";

    private final Numbers numbers;
    private String result;

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
            this.result = "3스트라이크";
            return true;
        }

        int countBall = numbers.countBall(randomNumbers);
        determineResult(countStrike, countBall);
        return false;
    }

    public void printResult() {
        System.out.println(result);
    }

    private void validateLength(String input) {
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

    private void determineResult(int countStrike, int countBall) {
        if (isNothing(countStrike, countBall)) {
            this.result = "낫싱";
            return;
        }
        this.result = String.format("%s스트라이크 %s볼", countStrike, countBall);
    }
}
