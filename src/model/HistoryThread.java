package model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import database.DatabaseLinker;

public class HistoryThread implements Runnable {
	private DatabaseLinker database;
	private volatile HashMap<Integer,HashMap<Integer, Integer>> history;
	private UUID team_id;
	
	public HistoryThread(UUID team_id) {
		this.database = new DatabaseLinker();
		this.database.loadPlayers();
		this.team_id = team_id;
	}

	@Override
	public void run() {
		HashMap<Integer,HashMap<Integer, Integer>> history = new HashMap<Integer,HashMap<Integer, Integer>>();
		int lastRound = MainModel.getFixtures().whatsLastRound();
		
		for(int i = 0; i<=lastRound;i++) {
			int nullCount = 0;
			HashMap<Integer, Integer> playersScores = new HashMap<Integer, Integer>();
			
			if(this.database.doesTeamExist(team_id, i)) {
				HashMap<Integer, Player> squad = this.database.loadSquad(team_id, i);
				System.err.println(squad.toString());
				for(Map.Entry<Integer, Player> entry : squad.entrySet()) {
					
					int position = entry.getKey();
					Player player = entry.getValue();
					if(this.database.doesPlayerPointsExist(player.getPlayer_id(), i+1)) {
						playersScores.put(position, this.database.getPlayerScoreIn(player.getPlayer_id(), i+1));
					}
					else {
						playersScores.put(entry.getKey(), null);
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
		if(history.size() <= 0) {
			this.history = null;
		}
		else {
			this.history = history;
		}
	}

	/**
	 * @return the history
	 */
	public HashMap<Integer,HashMap<Integer, Integer>> getHistory() {
		return history;
	}

}
