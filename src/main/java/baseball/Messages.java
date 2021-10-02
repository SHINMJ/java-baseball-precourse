package baseball;

public enum Messages {

	COMPLETE("3개의 숫자를 모두 맞히셨습니다. 게임 끝!!"),
	INPUT("숫자를 입력해 주세요 : "),
	INPUT_ERROR("[ERROR] 1-9까지 3자리 수 숫자만 입력가능합니다."),
	END("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
	END_ERROR("1 or 2 만 입력가능 합니다.");

	private final String message;

	Messages(String message) {
		this.message = message;
	}
}
