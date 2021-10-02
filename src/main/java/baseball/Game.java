package baseball;

import static baseball.Constant.*;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nextstep.utils.Console;

public class Game {

	private Combination combination;
	private Determine determine;

	public Game() {
	}

	protected void setInit() {
		this.combination = new Combination();
		this.determine = new Determine(combination.getNumber());
	}

	public void playGame() {
		setInit();
		while (true) {
			if (recursive()) {
				System.out.println(Messages.COMPLETE.getMessage());
				break;
			}
		}
	}

	private boolean recursive() {
		String input = readUserInput(Messages.INPUT);
		if (!isValidate(input)) {
			return recursive();
		}
		determine.setInit(convertIntegerArray(input));
		String r = determine.hasDetermine();
		System.out.println(r);
		return determine.getIsOut();
	}

	public boolean isNewGame() {
		String i = "";
		while (true) {
			i = readUserInput(Messages.END);
			if (validAskNewGameInput(i)) {
				break;
			}
			System.out.println(Messages.END_ERROR.getMessage());
		}
		return "1".equals(i);
	}

	private String readUserInput(Messages text) {
		System.out.println(text.getMessage());
		return Console.readLine();
	}

	private boolean validAskNewGameInput(String input) {
		if (input.length() > 1) {
			return false;
		}
		return Arrays.asList(NEW_GAME_ANSWERS).contains(input);
	}

	private Integer[] convertIntegerArray(String input) {
		String[] s = input.split("");
		Integer[] i = new Integer[TOTAL_NUM];
		for (int j = 0; j < s.length; j++) {
			i[j] = Integer.parseInt(s[j]);
		}
		return i;
	}

	private boolean isValidate(String input) {
		if (findMatches(Pattern.compile(REG_EXP), input)) {
			return true;
		}
		System.out.println(Messages.INPUT_ERROR.getMessage());
		return false;
	}

	private boolean findMatches(Pattern pattern, CharSequence input) {
		Matcher m = pattern.matcher(input);
		return m.find();
	}

}
