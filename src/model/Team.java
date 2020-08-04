package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.UUID;

public class Team {
	private String name;
	private String owner_id;
	private HashMap<Integer, Player> squad;
	private Player captain;
	private int gkCount = 0;
	private int defCount = 0;
	private int midCount = 0;
	private int forCount = 0;
	
	public Team(String id) {
		this.owner_id = id;
		this.squad = new HashMap<Integer, Player>();
	}

	public void removePlayer(Player p) {
		this.squad.remove(p);
	}

	public void addPlayer(Player p) throws Exception {
		if(squad.size() >= 15) {
			throw new Exception("Hit player limit");
		}
		else if(p.getPosition().equals("GoalKeeper")) {
			if(gkCount == 0) {
				squad.put(1, p);
			}
			else if(gkCount == 1) {
				squad.put(12, p);
			}
			else if (gkCount == 2) {
				throw new Exception("Hit goalkeeper limit");
			}
		}
		else if(p.getPosition().equals("Defender")) {
			if(defCount == 0) {
				squad.put(3, p);
				defCount++;
			}
			else if(defCount == 1) {
				squad.put(5, p);
				defCount++;
			}
			else if(defCount == 2) {
				squad.put(4, p);
				defCount++;
			}
			else if(defCount == 3) {
				squad.put(2, p);
				defCount++;
			}
			else if(defCount == 4) {
				squad.put(13, p);
				defCount++;
			}
			else if(defCount == 5) {
				throw new Exception("Hit defender limit");
			}
		}
		else if(p.getPosition().equals("Midfielder")) {
			if(midCount == 0) {
				squad.put(11, p);
				midCount++;
			}
			else if(midCount == 1) {
				squad.put(8, p);
				midCount++;
			}
			else if(midCount == 2) {
				squad.put(6, p);
				midCount++;
			}
			else if(midCount == 3) {
				squad.put(7, p);
				midCount++;
			}
			else if(midCount == 4) {
				squad.put(14, p);
				midCount++;
			}
			else if(midCount == 5) {
				throw new Exception("Hit midfielder limit");
			}
		}
		else if(p.getPosition().equals("Forward")) {
			if(forCount == 0) {
				squad.put(10, p);
				forCount++;
			}
			else if(forCount == 1) {
				squad.put(9, p);
				forCount++;
			}
			else if(forCount == 2) {
				squad.put(15, p);
				forCount++;
			}
			else if(midCount == 3) {
				throw new Exception("Hit forward limit");
			}
		}
		checkClubLimit();
	}
	
	public void checkClubLimit() {
		ArrayList<UUID> club_ids = new ArrayList<UUID>();
		
		for(Player p : squad.values()) {
			club_ids.add(p.getClub_id());
		}
		
		for( Club club : Clubs.clubs) {
			if(Collections.frequency(club_ids, club.getClub_id()) > 3) {
				System.out.println("Error more than 3 players from same club!");
			}
		}
		
		
	}

//	public void activatePowerup{
//
//	}
//
//	public void activatePowerup{
//
//	}
//
//	public void activatePowerup{
//		
//	}

}
