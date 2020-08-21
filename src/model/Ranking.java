package model;

import java.util.UUID;

public class Ranking {
	private String teamName;
	private UUID team_id;
	private int score; 
	private int rank;
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}
	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	/**
	 * @return the team_id
	 */
	public UUID getTeam_id() {
		return team_id;
	}
	/**
	 * @param team_id the team_id to set
	 */
	public void setTeam_id(UUID team_id) {
		this.team_id = team_id;
	}
}
