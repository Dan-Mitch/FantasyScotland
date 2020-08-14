package model;

import java.util.ArrayList;
import java.util.UUID;

public class League {
	private UUID league_id;
	private String name;
	private ArrayList<UUID> members;

	public void calculateRankings() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<UUID> getParticipants() {
		return members;
	}

	public void setParticipants(ArrayList<UUID> members) {
		this.members = members;
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

}
