package model;

import java.util.UUID;

public class Score {
	private int round;
	private UUID player_id;
	private int goals;
	private int assists;
	private int red_cards;
	private int yellow_cards;
	private int apps;
	private int clean_sheets;
	private int concede_Two;
	private int own_goals;
	private int fixture_id;
	
	Score(){
		
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public UUID getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(UUID player_id) {
		this.player_id = player_id;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getRed_cards() {
		return red_cards;
	}

	public void setRed_cards(int red_cards) {
		this.red_cards = red_cards;
	}

	public int getYellow_cards() {
		return yellow_cards;
	}

	public void setYellow_cards(int yellow_cards) {
		this.yellow_cards = yellow_cards;
	}

	public int getApps() {
		return apps;
	}

	public void setApps(int apps) {
		this.apps = apps;
	}

	public int getClean_sheets() {
		return clean_sheets;
	}

	public void setClean_sheets(int clean_sheets) {
		this.clean_sheets = clean_sheets;
	}

	public int getConcede_Two() {
		return concede_Two;
	}

	public void setConcede_Two(int concede_Two) {
		this.concede_Two = concede_Two;
	}

	public int getOwn_goals() {
		return own_goals;
	}

	public void setOwn_goals(int own_goals) {
		this.own_goals = own_goals;
	}

	public int getFixture_id() {
		return fixture_id;
	}

	public void setFixture_id(int fixture_id) {
		this.fixture_id = fixture_id;
	}
}


