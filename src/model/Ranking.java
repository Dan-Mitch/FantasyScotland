package model;

import java.util.UUID;

/**
 * This class is used to store the infomation about a team and its ranking on the public leaderboard.
 * @author d_mit
 *
 */
public class Ranking {
	private String teamName;
	private UUID team_id;
	private int score; 
	private int rank;
	
	//___________________GETTERS & SETTERS___________________
	
	/**
	 * 
	 * @return score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * 
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * 
	 * @return rank
	 */
	public int getRank() {
		return rank;
	}
	
	/**
	 * 
	 * @param rank the rank to set
	 */
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