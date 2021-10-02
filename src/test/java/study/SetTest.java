package study;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {

	private Set<Integer> numbers;

	@BeforeEach
	public void setup() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	@DisplayName("size메서드를 활용해 Set의 크기를 롹인한다.")
	public void 요구사항_1_성공() throws Exception {
		Assertions.assertThat(numbers.size()).isEqualTo(3);
	}

	@Test
	public void 존재여부체크_성공() throws Exception {
	    Assertions.assertThat(numbers.contains(1)).isTrue();
		Assertions.assertThat(numbers.contains(2)).isTrue();
		Assertions.assertThat(numbers.contains(3)).isTrue();
	}

	@ParameterizedTest
	@DisplayName("ParameterizedTest를 활용해 중복 코드를 제거한다.")
	@ValueSource(ints = {1,2,3})
	public void 요구사항_2_성공(int i) throws Exception {
	    Assertions.assertThat(numbers.contains(i)).isTrue();
	}

	@ParameterizedTest
	@DisplayName("결과값이 true or false인 경우 반복 테스트")
	@CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
	public void 요구사항_3_성공(int i, boolean except) throws Exception {
	    Assertions.assertThat(numbers.contains(i)).isEqualTo(except);
	}
}
