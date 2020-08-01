package model;

import java.util.ArrayList;
import model.User;
import com.github.pabloo99.xmlsoccer.api.dto.GetTeamResultDto;

import database.DatabaseLinker;

public class MainModel {
	private DatabaseLinker database;
	private Clubs clubs;
	private Players players;
	private Fixtures fixtures;
	private Leagues leagues;
	private User currentUser;
	
	public MainModel() {
		this.database = new DatabaseLinker();
		this.clubs = new Clubs();
		this.fixtures = new Fixtures();
		this.leagues = new Leagues();
		this.players = new Players(this.clubs);
	}
	
	public void initialise() {
		
	}
	
	public boolean authenticateUser(String email, String pass) {
		String id = this.database.authenticateUser(email, pass);
		if(id != null && !id.isEmpty()) {
			this.setCurrentUser(new User(email, id));
			return true;
		}
		return false;
	}
	
	public void registerUser(String email, String pass) {;
		this.database.writeUser(email, pass);
	}
	
	public void createNewTeam() {
		this.currentUser.createTeam();
	}
	
	public String addPlayerToNewTeam(int id) {
		try {
			this.currentUser.addPlayerToTeam(this.players.getPlayer(id));
		} catch (Exception e) {
			return "Too many players";
		}
		return "";
	}
	
	public Clubs getClubs() {
		return clubs;
	}

	public Players getPlayers() {
		return players;
	}


	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}
