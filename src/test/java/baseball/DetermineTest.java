package baseball;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DetermineTest {

	private Integer[] random;
	private Determine determine;

	@BeforeEach
	public void setup() {
		random = new Integer[]{1,2,3};
		determine = new Determine(random);
	}

	@Test
	public void 스트라이크3_성공() throws Exception {
		String s = determine.hasDetermine(random);
		Assertions.assertThat(s).isEqualTo("3 스트라이크");
	}

	@Test
	public void 스트라이크1_볼2_성공() throws Exception {
		Integer[] user = new Integer[]{1,3,2};
		String s = determine.hasDetermine(user);
		Assertions.assertThat(s).isEqualTo("1 스트라이크, 2 볼");
	}

	@ParameterizedTest
	@CsvSource(value = {"4,5,6:낫싱", "3,1,6:2 볼", "2,3,1:3 볼", "4,2,5:1 스트라이크", "1,2,3:3 스트라이크"}, delimiter = ':')
	public void 여러상황_성공(String user, String expect) {
		String[] split = user.split(",");
		Integer[] integers = Arrays.stream(split).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
		String s = determine.hasDetermine(integers);
		Assertions.assertThat(s).isEqualTo(expect);
	}

}