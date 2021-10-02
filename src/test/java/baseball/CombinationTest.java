package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CombinationTest {

	@Test
	@DisplayName("중복없는 3자리 Integer 배열 성공")
	public void random() throws Exception {
		Combination combination = new Combination();
		Integer[] number = combination.getNumber();
		Set<Integer> set = new HashSet<>(Arrays.asList(number));
		Assertions.assertThat(number.length).isEqualTo(set.size());
	}
}