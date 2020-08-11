package model;

import java.util.ArrayList;
import java.util.UUID;

public class Players {
	private ArrayList<Player> players;
	private int numOfPlayers;

	public Players(ArrayList<Player> roster) {
		this.players = roster;

		this.numOfPlayers = players.size();
	}

	public int getNumOfPlayers() {
		return numOfPlayers;
	}
	
	public Player getPlayer(UUID id) {
		Player result = null;
		for(Player p : this.players) {
			if(p.getPlayer_id().equals(id)) {
				result = p;
				break;
			}
		}
		return result;
	}
	
	public UUID getID(String name) {
		UUID result = null;
		for(Player p : this.players) {
			if(p.getName().equals(name)) {
				result = p.getPlayer_id();
				break;
			}
		}
		return result;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	

}
