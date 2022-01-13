package baseball.domain;

import baseball.utils.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import nextstep.utils.Randoms;

public final class Numbers {

    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers createRandomNumbers() {
        List<Number> numbers = new ArrayList<>();
        while (numbers.size() < Constants.LENGTH) {
            numbers = addRandomNumbers(numbers, pickRandomNumber());
        }
        return new Numbers(numbers);
    }

    public static Numbers of(List<Number> numbers) {
        return new Numbers(numbers);
    }

    public int size() {
        return numbers.size();
    }

    int countStrike(Numbers target) {
        if (numbers.equals(target)) {
            return Constants.LENGTH;
        }

        int strike = 0;
        for (int i = 0; i < numbers.size(); i++) {
            strike += isStrike(i, target);
        }
        return strike;
    }

    int countBall(Numbers target) {
        int ball = 0;

        for (int i = 0; i < numbers.size(); i++) {
            ball += countTargetBall(target, i);
        }
        return ball;
    }

    private int countTargetBall(Numbers target, int index) {
        int ball = 0;
        for (int i = 0; i < target.size(); i++) {
            ball += isBall(index, i, target);
        }
        return ball;
    }

    private int isBall(int index, int targetIndex, Numbers target) {
        if (index == targetIndex) {
            return 0;
        }
        if (equalsAnotherIndexNumber(index, targetIndex, target)) {
            return 1;
        }
        return 0;
    }

    private boolean equalsAnotherIndexNumber(int index, int targetIndex, Numbers target) {
        return numbers.get(index).equals(target.numbers.get(targetIndex));
    }

    private int isStrike(int index, Numbers target) {
        if (equalsIndexNumber(index, target)) {
            return 1;
        }
        return 0;
    }

    private boolean equalsIndexNumber(int index, Numbers target) {
        return numbers.get(index).equals(target.numbers.get(index));
    }

    private static List<Number> addRandomNumbers(List<Number> numbers, Number number) {
        if (numbers.contains(number)) {
            return numbers;
        }
        numbers.add(number);
        return numbers;
    }

    private static Number pickRandomNumber() {
        int pickNumberInRange = Randoms.pickNumberInRange(Constants.MIN_VALUE, Constants.MAX_VALUE);
        return Number.valueOf(pickNumberInRange);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Numbers other = (Numbers) o;
        return numbers.equals(other.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

}
