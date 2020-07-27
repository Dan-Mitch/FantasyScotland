package model;

import com.github.pabloo99.xmlsoccer.api.dto.GetPlayersResultDto;
import com.github.pabloo99.xmlsoccer.api.dto.GetTeamResultDto;
import com.github.pabloo99.xmlsoccer.api.service.XmlSoccerService;
import com.github.pabloo99.xmlsoccer.client.XmlSoccerServiceImpl;

import java.util.ArrayList;

public class Players {
	private XmlSoccerService xmlSoccerService;
	private ArrayList<Player> roster;
	private int numOfPlayers;

	public Players(Clubs clubs) {
		this.xmlSoccerService = new XmlSoccerServiceImpl();
		xmlSoccerService.setApiKey("ZBOBAXRYOHGALWSSPOVSNUYWPJDNLZWLAXBURALTOSGSDJETYA");
		xmlSoccerService.setServiceUrl("http://www.xmlsoccer.com/FootballDataDemo.asmx");
		
		this.roster = new ArrayList<Player>();

		for (GetTeamResultDto club : clubs.clubs) {
			for(GetPlayersResultDto player: xmlSoccerService.getPlayersByTeam(club.getTeamId())){
				if(player.getPosition().equals("Defender")) {
					this.roster.add(new Defender(player));
				}
				else if(player.getPosition().equals("GoalKeeper")) {
					this.roster.add(new GoalKeeper(player));
				} 
				else if(player.getPosition().equals("Forward")) {
					this.roster.add(new Forward(player));
				} 
				else if(player.getPosition().equals("Midfielder")) {
					this.roster.add(new Midfielder(player));
				} 
			}
		}
		this.numOfPlayers = roster.size();
	}

	public ArrayList<Player> getRoster() {
		return roster;
	}

	public int getNumOfPlayers() {
		return numOfPlayers;
	}

}
