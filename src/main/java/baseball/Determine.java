package baseball;

import static baseball.Constant.*;

import java.util.Arrays;

public class Determine {
	private Integer[] randomNum;
	private Integer[] userNum;
	private int strike;
	private int ball;
	private boolean isOut;

	public Determine(Integer[] randomNum) {
		this.randomNum = randomNum;
	}

	public void setInit(Integer[] userNum) {
		this.userNum = userNum;
		this.strike = 0;
		this.ball = 0;
		this.isOut = false;
	}

	public boolean getIsOut() {
		return this.isOut;
	}

	public String hasDetermine() {
		if (isStrikeOut()) {
			return TOTAL_NUM +""+Status.STRIKE.getStatus();
		}
		for (int i = 0; i < userNum.length; i++) {
			determine(userNum[i], i);
		}
		if (strike == 0 && ball == 0) {
			return Status.NOTHING.getStatus();
		}
		return getResult();
	}

	private boolean isStrikeOut() {
		if (Arrays.deepEquals(randomNum, userNum)) {
			addStrike(TOTAL_NUM);
			return true;
		}
		return false;
	}

	private void determine(Integer userNum, int index) {
		if (isStrike(userNum, index)) {
			return;
		}
		if (isBall(userNum)) {
			return;
		}
	}

	private boolean isStrike(Integer number, int index) {
		if (randomNum[index].equals(number)) {
			addStrike(1);
			return true;
		}
		return false;
	}

	private boolean isBall(Integer number) {
		if (Arrays.asList(randomNum).contains(number)) {
			addBall();
			return true;
		}
		return false;
	}

	private void addStrike(int add) {
		this.strike = strike + add;
		if (this.strike == 3) {
			this.isOut = true;
		}
	}

	private void addBall() {
		this.ball = ball + 1;
	}

	private String getResult() {
		String s = toResult(strike, Status.STRIKE.getStatus());
		String b = toResult(ball, Status.BALL.getStatus());
		if ("".equals(s)) {
			return b;
		}
		if ("".equals(b)) {
			return s;
		}
		return s + " " + b;
	}

	private String toResult(int n, String text) {
		StringBuilder sb = new StringBuilder();
		if (n == 0) {
			return "";
		}
		sb.append(n);
		sb.append(text);
		return sb.toString();
	}
}
