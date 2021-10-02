package baseball;

import static baseball.Constant.*;

import java.util.Arrays;

public class Determine {
	private Integer[] randomNum;
	private int strike;
	private int ball;

	public Determine(Integer[] randomNum) {
		this.randomNum = randomNum;
	}

	public String hasDetermine(Integer[] userNum) {
		strike = 0;
		ball = 0;

		if (Arrays.deepEquals(randomNum, userNum)) {
			return 3+" "+STRIKE;
		}
		for (int i = 0; i < userNum.length; i++) {
			determine(userNum[i], i);
		}

		if (strike == 0 && ball == 0) {
			return NOTHING;
		}
		return getResult();
	}

	private void determine(Integer userNum, int index) {
		if (isStrike(userNum, index)) {
			strike++;
			return;
		}
		if (isBall(userNum)) {
			ball++;
			return;
		}
	}

	private boolean isStrike(Integer number, int index) {
		if (randomNum[index].equals(number)) {
			return true;
		}
		return false;
	}

	private boolean isBall(Integer number) {
		if (Arrays.asList(randomNum).contains(number)) {
			return true;
		}
		return false;
	}

	private String getResult() {
		String s = toResult(strike, STRIKE);
		String b = toResult(ball, BALL);
		if ("".equals(s)) {
			return b;
		}

		if ("".equals(b)) {
			return s;
		}

		return s + ", " + b;
	}

	private String toResult(int n, String text) {
		StringBuilder sb = new StringBuilder();
		if (n == 0) {
			return "";
		}
		sb.append(n);
		sb.append(" ");
		sb.append(text);
		return sb.toString();
	}
}
