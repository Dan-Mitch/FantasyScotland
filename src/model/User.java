package model;

import java.util.UUID;

public class User {
	private String email;
	private UUID id;
	private Team team;
	
	public User(String e, UUID id) {
		this.email = e;
		this.id = id;
		createTeam(this.id);
	}
	

	public String addPlayerToTeam(Player p, int position) {
			return this.team.addPlayer(p, position);
	}
	
	public String swapPlayersInTeam(Player p, int position) {
		return this.team.swapPlayers(p, position);
	}

	public String removePlayerFromTeam(int position) {
		return this.team.removePlayer(position);
	}
	
	public void createTeam(UUID id) {
		this.team = new Team(id);
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}

	public Team getTeam() {
		return team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
}
