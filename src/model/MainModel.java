package model;

import java.util.ArrayList;
import model.User;
import com.github.pabloo99.xmlsoccer.api.dto.GetTeamResultDto;

public class MainModel {
	private Clubs clubs;
	private Players players;
	private Fixtures fixtures;
	private Leagues leagues;
	private User currentUser;
	
	public MainModel() {
		this.clubs = new Clubs();
		this.fixtures = new Fixtures();
		this.leagues = new Leagues();
		this.players = new Players(this.clubs);
	}
	
	public void checkDatabaseUser() {
		
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

//	public static void main(String[] args) {
//		MainModel model = new MainModel();
//		System.out.println(model.clubs.clubs.size());
//		for (GetTeamResultDto club : model.clubs.clubs) {
//			System.out.println(club.getName());
//		}
//		System.out.println(model.players.getRoster().get(1).getStats().getName());
//	}

}
