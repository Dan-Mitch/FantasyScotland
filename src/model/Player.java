package model;

import java.util.HashMap;
import java.util.UUID;

public class Player{
	private UUID player_id;
	private String name;
	private String position;
	private double price;
	private int club_id;
	private boolean isSelectable;
	private HashMap<Integer, Integer> weeklyScores;
	
	public Player() {
		this.isSelectable = true;
		this.weeklyScores = new HashMap<Integer, Integer>();
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

	public int getClub_id() {
		return club_id;
	}

	public void setClub_id(int club_id) {
		this.club_id = club_id;
	}

//	private static double round (double value, int precision) {
//	    int scale = (int) Math.pow(10, precision);
//	    return (double) Math.round(value * scale) / scale;
//	}

	public boolean isSelectable() {
		return isSelectable;
	}

	public void setSelectable(boolean isSelectable) {
		this.isSelectable = isSelectable;
	}

	public HashMap<Integer, Integer> getWeeklyScores() {
		return weeklyScores;
	}

	public void setWeeklyScores(HashMap<Integer, Integer> weeklyScores) {
		this.weeklyScores = weeklyScores;
	}	
}
