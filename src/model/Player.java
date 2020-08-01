package model;


import com.github.pabloo99.xmlsoccer.api.dto.GetPlayersResultDto;

public class Player{
	private GetPlayersResultDto stats;
	private String price;
	private int points;
	private int goals;
	private int assists;
	private int yellowCards;
	private int redCards;
	private int ownGoals;
	
	
	private boolean isInjured;
	private boolean isCaptain;
	private boolean isSelectable;
	
	
	public Player(GetPlayersResultDto stats) {
		this.stats = stats;
		this.price = stats.getSigning();
		
	}
	
	public void calcualteScore() {
		
	}

	public GetPlayersResultDto getStats() {
		return stats;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	public boolean isSelectable() {
		return isSelectable;
	}

	public void setSelectable(boolean isSelectable) {
		this.isSelectable = isSelectable;
	}

	public int getPoints() {
		return points;
	}

	public int getGoals() {
		return goals;
	}

	public int getAssists() {
		return assists;
	}

	public int getYellowCards() {
		return yellowCards;
	}

	public int getRedCards() {
		return redCards;
	}

	public int getOwnGoals() {
		return ownGoals;
	}
}
