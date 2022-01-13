package baseball.ui;

import baseball.domain.Numbers;
import baseball.domain.UserInputContinue;
import baseball.domain.UserNumbers;
import baseball.exception.BusinessException;
import nextstep.utils.Console;

public class PlayGame {

    private Numbers randomNumbers;
    private UserNumbers userNumbers;

    public PlayGame() {
        this.randomNumbers = Numbers.createRandomNumbers();
    }

    public void playing() {
        boolean isStrike = false;
        while (!isStrike) {
            inputUserNumbers();
            isStrike = determined();
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다. 게임 끝!!");
    }

    public boolean isContinue() {
        return inputContinue().isContinued();
    }

    private void inputUserNumbers() {
        System.out.print("숫자를 입력해주세요: ");
        String readLine = Console.readLine();
        try {
            this.userNumbers = UserNumbers.of(readLine);
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            inputUserNumbers();
        }
    }

    private boolean determined() {
        return userNumbers.determined(randomNumbers);
    }

    private UserInputContinue inputContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String readLine = Console.readLine();
        try {
            return UserInputContinue.from(readLine);
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            return inputContinue();
        }
    }

}
