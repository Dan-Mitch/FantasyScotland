package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.UUID;

public class Team {
	private UUID team_id;
	private String name;
	private UUID owner_id;
	private HashMap<Integer, Player> squad;
	private Player captain;
	private double transferBudget;
	private int gkCount = 0;
	private int defCount = 0;
	private int midCount = 0;
	private int forCount = 0;
	
	public Team() {
		this.transferBudget = 60.0;
		this.owner_id = null;
		this.team_id = null;
		this.squad = new HashMap<Integer, Player>();
		Player p = new Player();
		p.setClub("Aberdeen");
		this.squad.put(7,  p);
		this.squad.put(2,  p);
	}

	public void removePlayer(Player p) {
		this.squad.remove(p);
	}

	public String addPlayer(Player p, int position) {
		this.squad.put(position, p);
		this.transferBudget = this.transferBudget - p.getPrice();
		if(transferBudget < 0) {
			return "You have exceeded the budget limit";
		}
		else if(clubLimitReached() != null) {
			return "Too many players from" + clubLimitReached() + " (Max 3).";
		}
		else {
			return "";
		}
	}
	
	public String clubLimitReached() {
		ArrayList<String> players_clubs = new ArrayList<String>();
		
		for(Player p : squad.values()) {
			players_clubs.add(p.getClub());
		}
		
		for( Club club : Clubs.clubs) {
			if(Collections.frequency(players_clubs, club.getName()) > 3) {
				return club.getName();
			}
		}
		return null;
	}

	public UUID getTeam_id() {
		return team_id;
	}

	public void setTeam_id(UUID team_id) {
		this.team_id = team_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(UUID owner_id) {
		this.owner_id = owner_id;
	}

	public HashMap<Integer, Player> getSquad() {
		return squad;
	}

	public void setSquad(HashMap<Integer, Player> squad) {
		this.squad = squad;
	}

	public Player getCaptain() {
		return captain;
	}

	public void setCaptain(Player captain) {
		this.captain = captain;
	}

	public double getTransferBudget() {
		return transferBudget;
	}

	public void setTransferBudget(double transferBudget) {
		this.transferBudget = transferBudget;
	}

	public int getGkCount() {
		return gkCount;
	}

	public void setGkCount(int gkCount) {
		this.gkCount = gkCount;
	}

	public int getDefCount() {
		return defCount;
	}

	public void setDefCount(int defCount) {
		this.defCount = defCount;
	}

	public int getMidCount() {
		return midCount;
	}

	public void setMidCount(int midCount) {
		this.midCount = midCount;
	}

	public int getForCount() {
		return forCount;
	}

	public void setForCount(int forCount) {
		this.forCount = forCount;
	}

}
