package model;

import java.util.UUID;

/**
 * This class acts as a data transfer object for Score objects in the database.
 * @author d_mit
 *
 */
public class Score {
	private int round; //the round in which the score was developed
	private UUID player_id;
	private int goals;
	private int assists;
	private int red_cards;
	private int yellow_cards;
	private int apps; //appearances 
	private int clean_sheets;
	private int concede_Two; //conceded more than two goals
	private int own_goals;
	private int fixture_id;

	//___________________GETTERS & SETTERS___________________
	
	/**
	 * 
	 * @return round
	 */
	public int getRound() {
		return round;
	}

	/**
	 * 
	 * @param round the round to set
	 */
	public void setRound(int round) {
		this.round = round;
	}

	/**
	 * 
	 * @return player_id
	 */
	public UUID getPlayer_id() {
		return player_id;
	}

	/**
	 * 
	 * @param player_id the player_id to set
	 */
	public void setPlayer_id(UUID player_id) {
		this.player_id = player_id;
	}

	/**
	 * 
	 * @return goals
	 */
	public int getGoals() {
		return goals;
	}

	/**
	 * 
	 * @param goals the goals to set
	 */
	public void setGoals(int goals) {
		this.goals = goals;
	}

	/**
	 * 
	 * @return assists
	 */
	public int getAssists() {
		return assists;
	}

	/**
	 * 
	 * @param assists the assists to set
	 */
	public void setAssists(int assists) {
		this.assists = assists;
	}

	/**
	 * 
	 * @return red_cards
	 */
	public int getRed_cards() {
		return red_cards;
	}

	/**
	 * 
	 * @param red_cards the red_cards to set
	 */
	public void setRed_cards(int red_cards) {
		this.red_cards = red_cards;
	}

	/**
	 * 
	 * @return yellow_cards
	 */
	public int getYellow_cards() {
		return yellow_cards;
	}

	/**
	 * 
	 * @param yellow_cards the yellow_cards to set
	 */
	public void setYellow_cards(int yellow_cards) {
		this.yellow_cards = yellow_cards;
	}

	/**
	 * 
	 * @return the appearances
	 */
	public int getApps() {
		return apps;
	}

	/**
	 * 
	 * @param apps the appearances to set
	 */
	public void setApps(int apps) {
		this.apps = apps;
	}

	/**
	 * 
	 * @return clean_sheets
	 */
	public int getClean_sheets() {
		return clean_sheets;
	}

	/**
	 * 
	 * @param clean_sheets the clean_sheets to set
	 */
	public void setClean_sheets(int clean_sheets) {
		this.clean_sheets = clean_sheets;
	}

	/**
	 * Returns 1 or 0, indicating wether a player conceded more than two goals in a fixture.
	 * @return concede_Two
	 */
	public int getConcede_Two() {
		return concede_Two;
	}

	/**
	 * Indicating wether a player conceded more than two goals in a fixture.
	 * @param concede_Two the concede_Two to set
	 */
	public void setConcede_Two(int concede_Two) {
		this.concede_Two = concede_Two;
	}

	/**
	 * 
	 * @return own_goals
	 */
	public int getOwn_goals() {
		return own_goals;
	}

	/**
	 * 
	 * @param own_goals the own_goals to set
	 */
	public void setOwn_goals(int own_goals) {
		this.own_goals = own_goals;
	}

	/**
	 * 
	 * @return fixture_id
	 */
	public int getFixture_id() {
		return fixture_id;
	}

	/**
	 * 
	 * @param fixture_id the fixture_id to set
	 */
	public void setFixture_id(int fixture_id) {
		this.fixture_id = fixture_id;
	}
}