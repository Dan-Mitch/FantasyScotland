package model;

import java.util.ArrayList;
import model.User;
import com.github.pabloo99.xmlsoccer.api.dto.GetTeamResultDto;

public class MainModel {
	private Clubs clubs;
	private Players players;
	private ArrayList<User> users;
	private ArrayList<League> leagues;
	//fixtures arraylist
	
	public MainModel() {
		this.clubs = new Clubs();
		this.players = new Players(this.clubs);
		this.users = new ArrayList<User>();
	}
	
	public void addNewUser(String username, String pass) {
		this.users.add(new User(username, pass));
	}


	public Clubs getClubs() {
		return clubs;
	}

	public Players getPlayers() {
		return players;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public ArrayList<League> getLeagues() {
		return leagues;
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
