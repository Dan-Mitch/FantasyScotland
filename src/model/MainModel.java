package model;

import com.github.pabloo99.xmlsoccer.api.dto.GetTeamResultDto;

public class MainModel {
	private Clubs clubs;
	private Players players;
	
	
	public MainModel() {
		this.clubs = new Clubs();
		this.players = new Players();
	}
		
	public void buildPlayerRoster() {
		
	}
	
	public void selectPlayers() {
		
	}
	
	public static void main(String[] args) {
		MainModel model = new MainModel();
		System.out.println(model.clubs.getClubs().size());
		for(GetTeamResultDto club : model.clubs.getClubs()) {
			System.out.println(club.getName());
		}
		
	}
}