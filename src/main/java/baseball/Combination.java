package baseball;

import static baseball.Constant.*;

import java.util.HashSet;
import java.util.Set;

import nextstep.utils.Randoms;

public class Combination {


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
