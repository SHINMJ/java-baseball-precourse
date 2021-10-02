package baseball;

import static baseball.Constant.*;

import java.util.LinkedHashSet;
import java.util.Set;

import nextstep.utils.Randoms;

public class Combination {
	public Combination() {
	}

	public Integer[] getNumber() {
		Set<Integer> numberSet = new LinkedHashSet<>();
		while (numberSet.size() < TOTAL_NUM) {
			int n = Randoms.pickNumberInRange(START_RANGE_NUM, END_RANGE_NUM);
			numberSet.add(n);
		}
		return numberSet.toArray(new Integer[0]);
	}
}
