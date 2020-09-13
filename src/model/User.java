package model;

import java.util.UUID;

/**
 * This class acts as a data transfer object for each of the users in the database. It also contains methods for interacting with the user's created team.
 * @author d_mit
 *
 */
public class User {
	private String email;
	private UUID id;
	private Team team;
	
	/**
	 * 
	 * @param e the email of the user
	 * @param id the uuid of the user
	 */
	public User(String e, UUID id) {
		this.email = e;
		this.id = id;
		createTeam(this.id);
	}
	
	/**
	 * This method is called when a user is creating a team for the first time and is adding a player into the team.
	 * @param p the Player object being added
	 * @param position the position in the squad the player is being assigned to
	 * @return a String message depicting wether or not the addition was permitted
	 */
	public String addPlayerToTeam(Player p, int position) {
			return this.team.addPlayer(p, position);
	}
	
	/**
	 * This method is used when a user is managing their team and wants to swap players on the field with players on the bench.
	 * @param p Player object being introduced onto pitch
	 * @param position integer position of player being substituted to sideline
	 * @return String message indicating player swap was successful
	 */
	public String swapPlayersInTeam(Player p, int position) {
		return this.team.swapPlayers(p, position);
	}

	/**
	 * This method is used when a user is creating a team for the first time. It is called to remove a player from the team who has already been added in.
	 * @param position the integer position of the player being removed
	 * @return a String message depicting wether or not the removal was successful or more action was needed
	 */
	public String removePlayerFromTeam(int position) {
		return this.team.removePlayer(position);
	}
	
	//___________________GETTERS & SETTERS___________________
	
	/**
	 * Called when a User is first instantiated.
	 * @param id the uuid of the owner (user) of the team
	 */
	public void createTeam(UUID id) {
		this.team = new Team(id);
	}
	
	/**
	 * 
	 * @return the uuid of the user
	 */
	public UUID getId() {
		return id;
	}
	
	/**
	 * 
	 * @return the email address of the user
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @return the Team object owned by the user
	 */
	public Team getTeam() {
		return team;
	}
	
	/**
	 * 
	 * @param team the Team object that is being assigned to a user
	 */
	public void setTeam(Team team) {
		this.team = team;
	}
}
