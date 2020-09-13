package model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import database.DatabaseLinker;

/**
 * This class was implmented as a solution to the server request timeouts experienced when the application was deployed online.
 * <p>
 * The class operates as a thread that handles intensive database calls seperately from the main model. This fails to stop server request timeouts
 * but was left in as it was more readable and maintainable.
 * @author d_mit
 *
 */
public class HistoryThread implements Runnable {
	private DatabaseLinker database;
	private volatile HashMap<Integer,HashMap<Integer, Integer>> history;
	private UUID team_id;
	
	/**
	 * Constructor method takes the id of the team the history is being built for before establishing a connection with the database.
	 * @param team_id uuid of the team
	 */
	public HistoryThread(UUID team_id) {
		this.database = new DatabaseLinker();
		this.database.loadPlayers();
		this.team_id = team_id;
	}

	/**
	 * The thread runs the history builidng procedure and returns a hashmap of scores for players in the team each round.
	 */
	@Override
	public void run() {
		HashMap<Integer,HashMap<Integer, Integer>> history = new HashMap<Integer,HashMap<Integer, Integer>>(); //new empty hashmap with nested hashmap
		int lastRound = MainModel.getFixtures().whatsLastRound(); //gets last round so know what to iterate up to
		
		for(int i = 0; i<=lastRound;i++) { 
			int nullCount = 0; //number of people who didnt even appear in line up 
			HashMap<Integer, Integer> playersScores = new HashMap<Integer, Integer>();
			
			if(this.database.doesTeamExist(team_id, i)) { //checks if team was registered at that round, if not then skip
				HashMap<Integer, Player> squad = this.database.loadSquad(team_id, i);
				for(Map.Entry<Integer, Player> entry : squad.entrySet()) { //if team was registered, load the squad and get scores for each of the 11 players
					
					int position = entry.getKey();
					Player player = entry.getValue();
					if(this.database.doesPlayerPointsExist(player.getPlayer_id(), i+1)) {
						playersScores.put(position, this.database.getPlayerScoreIn(player.getPlayer_id(), i+1));
					}
					else {
						playersScores.put(entry.getKey(), null); //if player didnt have a score on database (i.e never appeared)
						nullCount++;
					}
				}
				if(nullCount >= 15) { 
					continue;
				}
				else {
					history.put(i+1, playersScores);
				}
			}
			else {
				continue;
			}
		}
		if(history.size() <= 0) { //if the whole team (including subs) didnt even appear on the bench, return null. This is usually the case with newly registered users.
			this.history = null;
		}
		else {
			this.history = history;
		}
	}
	
	//___________________GETTERS & SETTERS___________________

	/**
	 * @return the history a nested hashmap of a teams point history
	 */
	public HashMap<Integer,HashMap<Integer, Integer>> getHistory() {
		return history;
	}

}