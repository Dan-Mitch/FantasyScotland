package model;

import java.util.UUID;

public class User {
	private String email;
	private UUID id;
	private Team team;
	
	public User(String e, UUID id) {
		this.email = e;
		this.id = id;
		this.team = new Team();
	}
	

	public String addPlayerToTeam(Player p, int position) {
			return this.team.addPlayer(p, position);
	}
	
	public void removePlayerFromTeam(Player p) {
		this.team.removePlayer(p);
	}
	
	public void loadTeam(Team team) {
		this.team = team;
		this.team.makeTeamNonSelectable();
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
