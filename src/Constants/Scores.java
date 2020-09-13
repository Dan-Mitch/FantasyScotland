package Constants;
/**
 * 	This enumartion class stores all the seperate integers that are 
 * associated with the different match event actions that can happen
 * in a fixture.
 * @author d_mit
 *
 */
public enum Scores {
	APPEARANCE(1),
	GOAL_FOR(2),
	GOAL_MID(3),
	GOAL_DEF(4),
	GOAL_GK(8),
	ASSIST(1),
	CLEAN_GK(5),	//clean sheet (no goals scored against)	
	CLEAN_DEF(3), 	//clean sheet (no goals scored against)	
	CLEAN_MID(1),	//clean sheet (no goals scored against)	
	CONCEDE2_GK(-3),  //concede more than two goals
	CONCEDE2_DEF(-2), //concede more than two goals
	CONCEDE2_MID(-1), //concede more than two goals
	RED_CARD(-3),
	YELLOW_CARD(-1),
	OWN_GOAL(-2);
	
	private int value;
	
	private Scores(int value) {
		this.value = value;
	}
	
	/**
	 * Getter method for returning the assosiated score value.
	 * @return the score integer value of the match event action
	 */
	public int getValue() {
		return this.value;
	}
	
}
