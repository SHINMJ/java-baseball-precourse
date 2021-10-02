package baseball;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

class CombinationTest {

	@Test
	@DisplayName("중복없는 3자리 Integer 배열 성공")
	public void random() throws Exception {
		Combination combination = new Combination();
		Integer[] number = combination.getNumber();
		Set<Integer> set = new HashSet<>(Arrays.asList(number));
		Assertions.assertThat(number.length).isEqualTo(set.size());
	}

	@Test
	@DisplayName("중복없는 3자리 mock 사용")
	public void 정해진_random() throws Exception {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
				.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(1, 3, 5);
			Combination c = new Combination();
			Integer[] n = c.getNumber();
			Integer[] e = new Integer[]{1,3,5};
			for (int i = 0; i < n.length; i++) {
				Assertions.assertThat(n[i]).isEqualTo(e[i]);
			}
		}

	}
}