package baseball;

import baseball.ui.PlayGame;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        while (true) {
            PlayGame playGame = new PlayGame();
            playGame.playing();
            if (!playGame.isContinue()) {
                break;
            }
        }
    }
}
