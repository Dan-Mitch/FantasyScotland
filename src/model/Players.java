package model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * This class holds the list of all players in the applciation as well as related methods for requesting information about 
 * individual players.
 * @author d_mit
 *
 */
public class Players {
	private ArrayList<Player> players;
	private int numOfPlayers;
	
	/**
	 * Full roster of players is loaded when application first starts. No more players are added to the list during runtime.
	 * @param roster
	 */
	public Players(ArrayList<Player> roster) {
		this.players = roster;

		this.numOfPlayers = players.size();
	}
	
	//___________________GETTERS & SETTERS___________________

	/**
	 * 
	 * @return the total number of players in the applciation
	 */
	public int getNumOfPlayers() {
		return numOfPlayers;
	}
	
	/**
	 * Returns a player object from the list if an id match can be made.
	 * @param id uuid of player 
	 * @return Player object or null
	 */
	public Player getPlayer(UUID id) {
		Player result = null;
		for(Player p : this.players) {
			if(p.getPlayer_id().equals(id)) {
				result = p;
				break;
			}
		}
		if(result == null) {
			System.err.println("Could not find player with that id: " + id);
	}
		return result;
	}
	
	/**
	 * Returns the uuid of a player if a String name match can be made.
	 * @param name the name of the player
	 * @return uuid of the player or null
	 */
	public UUID getID(String name) {
		UUID result = null;
		for(Player p : this.players) {
			if(p.getName().equals(name)) {
				result = p.getPlayer_id();
				break;
			}
		}
		if(result == null) {
				System.err.println("Could not find player with that name: " + name);
		}
		return result;
	}
	
	/**
	 * Returns the position of a player in the list if an id match can be made.
	 * @param id uuid of a player
	 * @return position of player or null
	 */
	public String getPosition(UUID id) {
		String position = null;
		for(Player p : this.players) {
			if(p.getPlayer_id().equals(id)) {
				position = p.getPosition();
				break;
			}
		}
		if(position == null) {
			System.err.println("Could not find player with that id: " + id);
		}
		return position;
	}
	
	/**
	 * Returns the position of a player in the list if an name match can be made.
	 * @param name name of the user
	 * @return position of player or null
	 */
	public String getPosition(String name) {
		String position = null;
		for(Player p : this.players) {
			if(p.getName().equals(name)) {
				position = p.getPosition();
				break;
			}
		}
		if(position == null) {
			System.err.println("Could not find player with that name: " + name);
		}
		return position;
	}

	/**
	 * 
	 * @return players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}
}