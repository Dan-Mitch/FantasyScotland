package model;

import java.util.HashMap;
import java.util.UUID;

public class League {
	private UUID league_id;
	private String name;
	private HashMap<UUID,Integer> memberScores;

	public void calculateRankings() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the league_id
	 */
	public UUID getLeague_id() {
		return league_id;
	}

	/**
	 * @param league_id the league_id to set
	 */
	public void setLeague_id(UUID league_id) {
		this.league_id = league_id;
	}

	/**
	 * @return the memberScores
	 */
	public HashMap<UUID,Integer> getMemberScores() {
		return memberScores;
	}

	/**
	 * @param memberScores the memberScores to set
	 */
	public void setMemberScores(HashMap<UUID,Integer> memberScores) {
		this.memberScores = memberScores;
	}

}
