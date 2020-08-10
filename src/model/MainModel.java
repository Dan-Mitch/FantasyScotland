package model;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.UUID;

import model.User;

import database.DatabaseLinker;

public class MainModel {
	
	private DatabaseLinker database;
	public static ArrayList<Club> clubs;
	private Players players;
	private Fixtures fixtures;
	private Leagues leagues;
	private ArrayList<User> users;
	private String currentSeason;
	
	public MainModel(String season) {
		this.currentSeason = season;
		this.database = new DatabaseLinker();
		this.clubs = database.loadClubs();
		this.fixtures = new Fixtures();
		this.leagues = new Leagues();
		this.players = new Players(database.loadPlayers());
		this.users = new ArrayList<User>();
	}
	
	public UUID authenticateUser(String email, String pass) {
		String response = this.database.authenticateUser(email, pass);
		if (response != null && !response.isEmpty()) {
			UUID id = UUID.fromString(response);
			if(this.getUser(id) == null) {
				users.add(new User(email, id));
			}
			else {
				users.remove(this.getUserIndex(id));
				users.add(new User(email, id));
			}
			return id;
		}
		return null;
	}
	
	public boolean doesUserExist(String email) {
		String id = this.database.doesUserExist(email);
		if(id != null && !id.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public boolean doesTeamExist(String email) {
		UUID team_id = this.database.doesTeamExist(email);
		if(team_id != null) {
			return true;
		}
		return false;
	}
	
	public void registerUser(String email, String pass) {;
		this.database.writeUser(email, pass);
	}
	
	public void registerTeam(String name, UUID id) {
		User user = this.getUser(id);
		Team team = user.getTeam();
		if(name.contains("'")) {
			String newName = name.replace("'", "''");
			team.setName(newName);
		}else {
			team.setName(name);
		}
		team.setTeam_id(UUID.randomUUID());
		team.setRandomCaptain();
		this.database.writeTeamDetails(team.getTeam_id(), team.getName(), team.getTransferBudget(),
				team.getCaptain().getPlayer_id());
		this.database.writeTeam(team.getTeam_id(), team.getOwner_id());
		for (Entry<Integer, Player> entry : team.getSquad().entrySet()) {
			this.database.writeTeamMembership(team.getTeam_id(), entry.getValue().getPlayer_id(), entry.getKey());
		}
	}
	
	public String addPlayerToTeam(UUID id, int position, UUID user_id) {
		Player player = this.players.getPlayer(id);
		return this.getUser(user_id).addPlayerToTeam(player, position);
	}
	
	public String removePlayerFromTeam(int position, UUID user_id) {
			return this.getUser(user_id).removePlayerFromTeam(position);
	}
	
	public void loadTeam(UUID user_id) {
		Team team = this.database.loadTeam(user_id);
		User user = this.getUser(user_id);
		user.setTeam(team);
	}

	public Players getPlayers() {
		return players;
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public User getUser(UUID id) {
		for (User u : this.getUsers()) {
			if (u.getId().equals(id)) {
				return u;
			}
		}
		return null;
	}
	
	public int getUserIndex(UUID id) {
		ArrayList<User> u = this.getUsers();
		User user = this.getUser(id);
		return u.indexOf(user);
	}
}
