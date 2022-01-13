package baseball;

import baseball.ui.PlayGame;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        boolean isContinue = true;
        while (isContinue) {
            PlayGame playGame = new PlayGame();
            playGame.playing();
            isContinue = playGame.isContinue();
        }
    }
}
