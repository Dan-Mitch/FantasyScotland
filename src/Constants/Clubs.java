package constants;

public enum Clubs {
	
	ABERDEEN("#CF142B"),
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
	
	private String value;
	
	private Clubs(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
}