package model;

import java.util.ArrayList;
import java.util.UUID;

import model.User;
import com.github.pabloo99.xmlsoccer.api.service.XmlSoccerService;
import com.github.pabloo99.xmlsoccer.client.XmlSoccerServiceImpl;
import com.github.pabloo99.xmlsoccer.api.dto.*;

import database.DatabaseLinker;

public class MainModel {
	private XmlSoccerService xmlSoccerService;
	private DatabaseLinker database;
	private Clubs clubs;
	private Players players;
	private Fixtures fixtures;
	private Leagues leagues;
	private User currentUser;
	public MainModel() {
		this.xmlSoccerService = new XmlSoccerServiceImpl();
		this.xmlSoccerService.setApiKey("ZBOBAXRYOHGALWSSPOVSNUYWPJDNLZWLAXBURALTOSGSDJETYA");
		this.xmlSoccerService.setServiceUrl("http://www.xmlsoccer.com/FootballDataDemo.asmx");
		
		this.database = new DatabaseLinker();
		
		this.clubs = new Clubs(database.loadClubs());
		this.fixtures = new Fixtures();
		this.leagues = new Leagues();
		this.players = new Players(database.loadPlayers());
	}
	
	public boolean authenticateUser(String email, String pass) {
		String id = this.database.authenticateUser(email, pass);
		if(id != null && !id.isEmpty()) {
			this.setCurrentUser(new User(email, UUID.fromString(id)));
			return true;
		}
		return false;
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
		System.err.println(team_id);
		if(team_id != null) {
			return true;
		}
		return false;
	}
	
	public void registerUser(String email, String pass) {;
		this.database.writeUser(email, pass);
		authenticateUser(email, pass);
	}
	
	public void registerTeam(UUID team_id, String name) {
		this.database.writeTeam(team_id, name, currentUser.getId());
	}
	
	public String addPlayerToNewTeam(UUID id, int position) {
			return this.currentUser.addPlayerToTeam(this.players.getPlayer(id), position);
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
