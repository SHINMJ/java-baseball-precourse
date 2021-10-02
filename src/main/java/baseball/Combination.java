package baseball;

import java.util.HashSet;
import java.util.Set;

import nextstep.utils.Randoms;

public class Combination {
	private static final int START_RANGE_NUM = 1;
	private static final int END_RANGE_NUM = 9;
	private static final int TOTAL_NUM = 3;

	private Integer[] number;

	public Combination() {
		number = new Integer[3];
	}

	public Integer[] getNumber() {
		Set<Integer> numberSet = new HashSet<>();
		while (numberSet.size() < TOTAL_NUM) {
			int n = Randoms.pickNumberInRange(START_RANGE_NUM, END_RANGE_NUM);
			numberSet.add(n);
		}
		this.number = numberSet.toArray(new Integer[0]);
		return this.number;
	}
}
