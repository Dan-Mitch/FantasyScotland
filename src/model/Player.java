package model;

import java.util.UUID;

public class Player{
	private UUID player_id;
	private String name;
	private String position;
	private double price;
	private String club;
	private int points;
	private int goals;
	private int assists;
	private int yellowCards;
	private int redCards;
	private int ownGoals;
	private int apps;
	private int clean_sheets;
	
	
	
	private boolean isInjured;
	private boolean isCaptain;
	private boolean isSelectable;
	
	
	public Player() {

	}
	
	public UUID getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(UUID player_id) {
		this.player_id = player_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
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

	public int getYellowCards() {
		return yellowCards;
	}

	public void setYellowCards(int yellowCards) {
		this.yellowCards = yellowCards;
	}

	public int getRedCards() {
		return redCards;
	}

	public void setRedCards(int redCards) {
		this.redCards = redCards;
	}

	public int getOwnGoals() {
		return ownGoals;
	}

	public void setOwnGoals(int ownGoals) {
		this.ownGoals = ownGoals;
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

	public boolean isInjured() {
		return isInjured;
	}

	public void setInjured(boolean isInjured) {
		this.isInjured = isInjured;
	}

	public boolean isCaptain() {
		return isCaptain;
	}

	public void setCaptain(boolean isCaptain) {
		this.isCaptain = isCaptain;
	}

	private static double round (double value, int precision) {
	    int scale = (int) Math.pow(10, precision);
	    return (double) Math.round(value * scale) / scale;
	}
}
