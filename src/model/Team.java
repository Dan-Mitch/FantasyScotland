package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.UUID;

public class Team {
	private UUID team_id;
	private String name;
	private UUID owner_id;
	private HashMap<Integer, Player> squad;
	private UUID captain_id;
	private double transferBudget;
	private HashMap<Integer, Integer> weeklyScores;
	private int totalScore;
	
	public Team(UUID owner_id) {
		this.transferBudget = 60.0;
		this.owner_id = owner_id;
		this.team_id = null;
		this.squad = new HashMap<Integer, Player>();
		this.weeklyScores = new HashMap<Integer, Integer>();
	}

	public String addPlayer(Player p, int position) {
		this.squad.put(position, p);
		this.transferBudget = this.transferBudget - p.getPrice();
		if(this.getTransferBudget() < 0) {
			return "You have exceeded the budget limit";
		}
		else if(duplicatePlayers() != null) {
			return duplicatePlayers() + " is in the squad more than once.";
		}
		else if(clubLimitReached() != null) {
			return "Too many players from " + clubLimitReached() + " (Max 3).";
		}
		else {
			return "Successfully added player.";
		}
	}
	
	public String swapPlayers(Player player_in, int position_out) {
		Player player_out = squad.get(position_out);
		int position_in = 0;
		for (Entry<Integer, Player> entry : this.squad.entrySet()) {
	        if (entry.getValue().equals(player_in)) {
	            position_in = entry.getKey();
	        }
	    }
		this.squad.replace(position_out, player_out, player_in);
		this.squad.replace(position_in, player_in, player_out);
		System.err.println("player_in:" + player_in);
		System.err.println("player_out:" + player_out);
		System.err.println("pos_in:" + position_in);
		System.err.println("pos_out:" + position_out);
		return "Successfully swapped players.";
		
	}
	
	public String removePlayer(int position) {
		Player p = this.squad.get(position);
		this.transferBudget = this.transferBudget + p.getPrice();
		this.squad.remove(position);
		if(this.getTransferBudget() < 0) {
			return "You have exceeded the budget limit";
		}
		else if(duplicatePlayers() != null) {
			return duplicatePlayers() + " is in the squad more than once.";
		}
		else if(clubLimitReached() != null) {
			return "Too many players from " + clubLimitReached() + " (Max 3).";
		}
		else {
			return "Successfully removed player.";
		}
	}
	
	
	public String duplicatePlayers() {
		ArrayList<Player> players = new ArrayList<Player>(this.getSquad().values());
		for(Player p : players) {
			int occ = Collections.frequency(players, p);
			if (occ > 1) {
				return p.getName();
			}
		}
		return null;
	}
	
	public String clubLimitReached() {
		ArrayList<Integer> players_clubs = new ArrayList<Integer>();
		
		for(Player p : squad.values()) {
			players_clubs.add(p.getClub_id());
		}
		
		for( Club club : MainModel.clubs) {
			if(Collections.frequency(players_clubs, club.getClub_id()) > 3) {
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

	public UUID getCaptain() {
		return captain_id;
	}
	
	public void setCaptain(UUID captain_id) {
		this.captain_id = captain_id;
	}
	
	public void setCaptain(int position) {
		this.captain_id = this.squad.get(position).getPlayer_id();
	}

	public void setRandomCaptain() {
		Random rand = new Random();
		int n = rand.nextInt(15) + 1;
		this.captain_id = this.getSquad().get(n).getPlayer_id();
	}

	public double getTransferBudget() {
		int scale = (int) Math.pow(10, 2);
		return (double) Math.round(transferBudget * scale) / scale;
	}

	public void setTransferBudget(double transferBudget) {
		this.transferBudget = transferBudget;
	}

	/**
	 * @return the totalScore
	 */
	public int getTotalScore() {
		return totalScore;
	}

	/**
	 * @param totalScore the totalScore to set
	 */
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public HashMap<Integer, Integer> getWeeklyScores() {
		return weeklyScores;
	}
}
