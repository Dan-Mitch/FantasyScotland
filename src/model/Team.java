package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.UUID;

/**
 * This class acts as a data transfer object for all the teams stored in the database and also includes methods for interacting with the team while it is loaded in the model.
 * @author d_mit
 *
 */
public class Team {
	private UUID team_id;
	private String name;
	private UUID owner_id;
	private HashMap<Integer, Player> squad; //Represents the player and their position in the team (1-15) https://images.app.goo.gl/Z8ncopWxryYGFynY8
	private UUID captain_id; //chosen randomly on registration
	private double transferBudget;
	
	/**
	 * When the application is started, all team objects are first instanciated with their owner/user id set immediately. Other attributes are set afterwards by other methods.
	 * @param owner_id the uuid of the user who created the team
	 */
	public Team(UUID owner_id) {
		this.transferBudget = 60.0; //default budget for every team that registers (£60 million)
		this.owner_id = owner_id;
		this.team_id = null;
		this.squad = new HashMap<Integer, Player>();
	}

	/**
	 * This method is used when a user is creating a team for the first time. It is called to add a player object into the squad HashMap.
	 * @param p the Player object being added
	 * @param position the position in the squad the player is being assigned to
	 * @return a String message depicting wether or not the addition was permitted
	 */
	public String addPlayer(Player p, int position) {
		this.squad.put(position, p);
		this.transferBudget = this.transferBudget - p.getPrice(); 
		if(this.getTransferBudget() < 0) {
			return "You have exceeded the budget limit"; 
		}
		else if(duplicatePlayers() != null) {
			return duplicatePlayers() + " is in the squad more than once."; //uses helper method
		}
		else if(clubLimitReached() != null) {
			return "Too many players from " + clubLimitReached() + " (Max 3)."; //uses helper method
		}
		else {
			return "Successfully added player.";
		}
	}
	
	/**
	 * This method is used when a user is managing their team and wants to swap players on the field with players on the bench.
	 * @param player_in Player object being introduced onto pitch
	 * @param position_out integer position of player being substituted to sideline
	 * @return String message indicating player swap was successful
	 */
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
		return "Successfully swapped players.";
		
	}
	
	/**
	 * This method is used when a user is creating a team for the first time. It is called to remove a player from the team who has already been added in.
	 * @param position the integer position of the player being removed
	 * @return a String message depicting wether or not the removal was successful or more action was needed
	 */
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
	
	/**
	 * This is a helper method that is called when a player is being added or removed from a team. It stops duplicate players appearing in the squad.
	 * <p>
	 * It returns the name of the player who appears more than once in a squad.
	 * @return the name of the Player or null
	 */
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
	
	/**
	 * This is a helper method that is called when a player is being added or removed from a team. It stops there being more than three players from the same Scottish Premiership club, existing in the same team.
	 * @return the name of the Club where more than three players in the squad come from
	 */
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
	
	//___________________GETTERS & SETTERS___________________

	/**
	 * 
	 * @return team_id
	 */
	public UUID getTeam_id() {
		return team_id;
	}

	/**
	 * 
	 * @param team_id the team_id to set
	 */
	public void setTeam_id(UUID team_id) {
		this.team_id = team_id;
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name the name of the team to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return the id of the user who created the team
	 */
	public UUID getOwner_id() {
		return owner_id;
	}

	/**
	 * 
	 * @param owner_id the owner_id to set 
	 */
	public void setOwner_id(UUID owner_id) {
		this.owner_id = owner_id;
	}

	/**
	 * This method returns a HashMap of the numbered positions in a team and the Player objects in those positions.
	 * @return squad
	 */
	public HashMap<Integer, Player> getSquad() {
		return squad;
	}

	/**
	 * 
	 * @param squad the squad to set
	 */
	public void setSquad(HashMap<Integer, Player> squad) {
		this.squad = squad;
	}

	/**
	 * 
	 * @return captain_id
	 */
	public UUID getCaptain() {
		return captain_id;
	}
	
	/**
	 * 
	 * @param captain_id the captain_id to set
	 */
	public void setCaptain(UUID captain_id) {
		this.captain_id = captain_id;
	}
	
	/**
	 * Sets the captain for the team.
	 * @param position the position of the player in the squad who is being made captain
	 */
	public void setCaptain(int position) {
		this.captain_id = this.squad.get(position).getPlayer_id();
	}

	/**
	 * This method is called when a team is first created. It sets the captain to a random player in the squad.
	 */
	public void setRandomCaptain() {
		Random rand = new Random();
		int n = rand.nextInt(15) + 1; //random number between 1-15
		this.captain_id = this.getSquad().get(n).getPlayer_id();
	}

	/**
	 * 
	 * @return transfer budget of the team
	 */
	public double getTransferBudget() {
		int scale = (int) Math.pow(10, 2); //rounds to two decimal places
		return (double) Math.round(transferBudget * scale) / scale;
	}

	/**
	 * 
	 * @param transferBudget the transfer budget of the team to set
	 */
	public void setTransferBudget(double transferBudget) {
		this.transferBudget = transferBudget;
	}
}
