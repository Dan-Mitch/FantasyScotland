package Constants;

public enum Scores {
	
	GOAL_FOR(2),
	GOAL_MID(3),
	GOAL_DEF(4),
	GOAL_GK(8),
	ASSIST(1),
	PENALTY(1),
	CLEAN_GK(5),
	CLEAN_DEF(3),
	CLEAN_MID(1),
	CONCEDE2_GK(-3),
	CONCEDE2_DEF(-2),
	CONCEDE2_MID(-1),
	RED_CARD(-3),
	YELLOW_CARD(-1),
	OWN_GOAL(-2);
	
	private int value;
	
	private Scores(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
}
