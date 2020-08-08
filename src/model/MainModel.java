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
	public static ArrayList<Club> clubs;
	private Players players;
	private Fixtures fixtures;
	private Leagues leagues;
	private User currentUser;
	public MainModel() {
		this.xmlSoccerService = new XmlSoccerServiceImpl();
		this.xmlSoccerService.setApiKey("ZBOBAXRYOHGALWSSPOVSNUYWPJDNLZWLAXBURALTOSGSDJETYA");
		this.xmlSoccerService.setServiceUrl("http://www.xmlsoccer.com/FootballDataDemo.asmx");
		
		this.database = new DatabaseLinker();
		
		this.clubs = database.loadClubs();
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
		if(team_id != null) {
			return true;
		}
		return false;
	}
	
	public void registerUser(String email, String pass) {;
		this.database.writeUser(email, pass);
		authenticateUser(email, pass);
	}
	
	public void registerTeam(String name) {
		User user = this.getCurrentUser();
		Team team = user.getTeam();
		team.setName(name);
		this.database.writeTeam(team.getTeam_id(), team.getOwner_id());
		this.database.writeTeamDetails(team.getTeam_id(), team.getName(), team.getTransferBudget(), team.getCaptain().getPlayer_id());
		for(Player p:team.getSquad().values()){
			this.database.writeTeamMembership(team.getTeam_id(), p.getPlayer_id());
		}
	}
	
	public String addPlayerToTeam(UUID id, int position) {
		Player player = this.players.getPlayer(id);
		player.setSelectable(false);
		return this.currentUser.addPlayerToTeam(player, position);
	}
	
	public String removePlayerFromTeam(int position) {
		UUID id = this.currentUser.removePlayerFromTeam(position);
		if( id != null) {
			Player player = this.players.getPlayer(id);
			player.setSelectable(true);
			return "Successfully removed player.";
		}
		return null;
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
