package baseball;

import static baseball.Constant.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        Game g = new Game();
        while (true) {
            g.playGame();
            if (!g.isNewGame()) {
                break;
            }
        }
    }





}
