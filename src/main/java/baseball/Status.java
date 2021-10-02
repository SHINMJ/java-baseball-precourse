package baseball;

public enum Status {

	NOTHING("nothing", "낫싱"),
	STRIKE("strike", "스트라이크"),
	BALL("ball", "볼");

	private final String key;
	private final String status;

	Status(String key, String status) {
		this.key = key;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
