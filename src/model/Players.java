package model;

import java.util.ArrayList;
import java.util.UUID;

public class Players {
	private ArrayList<Player> players;
//	private ArrayList<Defender> defenders;
//	private ArrayList<GoalKeeper> goalkeepers;
//	private ArrayList<Forward> forwards;
//	private ArrayList<Midfielder> midfielders;
	private int numOfPlayers;

	public Players(ArrayList<Player> roster) {
		this.players = roster;
//		this.defenders = new ArrayList<Defender>();
//		this.forwards = new ArrayList<Forward>();
//		this.midfielders = new ArrayList<Midfielder>();
//		this.goalkeepers = new ArrayList<GoalKeeper>();
//		
//			for(Player player: roster){
//				if(player.getPosition().equals("Defender")) {
//					Defender def = (Defender) player;
//					this.defenders.add(def);
//				}
//				else if(player.getPosition().equals("Goalkeeper")) {
//					GoalKeeper gk = (GoalKeeper) player;
//					this.goalkeepers.add(gk);
//				} 
//				else if(player.getPosition().equals("Forward")) {
//					Forward fw = (Forward) player;
//					this.forwards.add(fw);
//				} 
//				else if(player.getPosition().equals("Midfielder")) {
//					Midfielder mf = (Midfielder) player;
//					this.midfielders.add(mf);
//				} 
//			}
		this.numOfPlayers = players.size();
	}

	public int getNumOfPlayers() {
		return numOfPlayers;
	}
	
	public Player getPlayer(UUID id) {
		Player result = null;
		for(Player p : this.players) {
			if(p.getPlayer_id() == id) {
				result = p;
				break;
			}
		}
		return result;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	

}
