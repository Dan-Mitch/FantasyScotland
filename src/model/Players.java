package model;

import com.github.pabloo99.xmlsoccer.api.dto.GetPlayersResultDto;
import com.github.pabloo99.xmlsoccer.api.dto.GetTeamResultDto;
import com.github.pabloo99.xmlsoccer.api.service.XmlSoccerService;
import com.github.pabloo99.xmlsoccer.client.XmlSoccerServiceImpl;

import java.util.ArrayList;

public class Players {
	private XmlSoccerService xmlSoccerService;
	private ArrayList<Player> roster;
	private ArrayList<Defender> defenders;
	private ArrayList<GoalKeeper> goalkeepers;
	private ArrayList<Forward> forwards;
	private ArrayList<Midfielder> midfielders;
	private int numOfPlayers;

	public Players(Clubs clubs) {
		this.xmlSoccerService = new XmlSoccerServiceImpl();
		xmlSoccerService.setApiKey("ZBOBAXRYOHGALWSSPOVSNUYWPJDNLZWLAXBURALTOSGSDJETYA");
		xmlSoccerService.setServiceUrl("http://www.xmlsoccer.com/FootballDataDemo.asmx");
		
		this.roster = new ArrayList<Player>();
		this.defenders = new ArrayList<Defender>();
		this.forwards = new ArrayList<Forward>();
		this.midfielders = new ArrayList<Midfielder>();
		this.goalkeepers = new ArrayList<GoalKeeper>();
		
		for (GetTeamResultDto club : clubs.clubs) {
			for(GetPlayersResultDto player: xmlSoccerService.getPlayersByTeam(club.getTeamId())){
				if(player.getPosition().equals("Defender")) {
					Defender def = new Defender(player);
					this.roster.add(def);
					this.defenders.add(def);
				}
				else if(player.getPosition().equals("Goalkeeper")) {
					GoalKeeper gk = new GoalKeeper(player);
					this.roster.add(gk);
					this.goalkeepers.add(gk);
				} 
				else if(player.getPosition().equals("Forward")) {
					Forward fw = new Forward(player);
					this.roster.add(fw);
					this.forwards.add(fw);
				} 
				else if(player.getPosition().equals("Midfielder")) {
					Midfielder mf = new Midfielder(player);
					this.roster.add(mf);
					this.midfielders.add(mf);
				} 
			}
		}
		this.numOfPlayers = roster.size();
	}

	public ArrayList<Defender> getDefenders() {
		return defenders;
	}

	public ArrayList<GoalKeeper> getGoalkeepers() {
		return goalkeepers;
	}

	public ArrayList<Forward> getForwards() {
		return forwards;
	}

	public ArrayList<Midfielder> getMidfielders() {
		return midfielders;
	}

	public ArrayList<Player> getRoster() {
		return roster;
	}
	
	public Player getPlayer(int id) {
		for(Player p : this.roster) {
			if(id == p.getStats().getId()) {
				return p;
			}
		}
		return null;
	}

	public int getNumOfPlayers() {
		return numOfPlayers;
	}

}
