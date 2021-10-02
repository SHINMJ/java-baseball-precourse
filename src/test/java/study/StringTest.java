package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	
	@Test
	@DisplayName("\"1,2\" 를 split 했을 때 1,2로 잘 분리되는 지 확인한다.")
	public void 요구사항_1_split_성공() throws Exception {
		String text = "1,2";
		Assertions.assertThat(text.split(",")).contains("1","2");
	}
	
	@Test
	@DisplayName("\"1\"을 split 했을 때 \"1\" 만을 포함하는지 확인한다.")
	public void 요구사항_1_1만을_포함_성공() throws Exception {
		String text = "1";
		Assertions.assertThat(text.split(",")).containsExactly("1");
	}

	@Test
	@DisplayName("\"(1,2)\" 값이 주어졌을 때 substring()을 활용해 ()를 제거하고 \"1,2\"를 반환한다.")
	public void 요구사항_2_성공() throws Exception {
		String  text = "(1,2)";
		Assertions.assertThat(text.substring(1,text.length()-1)).isEqualTo("1,2");

	}

	@Test
	@DisplayName("두번째 위치의 문자를 성공적으로 가져온다.")
	public void 요구사항_3_성공() throws Exception {
		String text = "abc";
		Assertions.assertThat(text.charAt(1)).isEqualTo('b');
	}

	@Test
	@DisplayName("주어진 문자열 index를 넘어서는 위치값에 대새 StringIndexOutOfBoundsException을 발생시킨다.")
	public void 요구사항_3_실패() throws Exception {
	    String text = "abc";
		Assertions.assertThatThrownBy(() -> text.charAt(6))
			.isInstanceOf(IndexOutOfBoundsException.class)
			.hasMessageContaining("range: 6");

	}
}
