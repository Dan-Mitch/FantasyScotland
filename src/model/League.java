package model;

import java.util.ArrayList;

public class League {
	private boolean isPrivate;
	private ArrayList<User>	participants;
	
	
	public void calculateRankings() {
		
	}


	/**
	 * @return the isPrivate
	 */
	public boolean isPrivate() {
		return isPrivate;
	}


	/**
	 * @param isPrivate the isPrivate to set
	 */
	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}


	/**
	 * @return the participants
	 */
	public ArrayList<User> getParticipants() {
		return participants;
	}


	/**
	 * @param participants the participants to set
	 */
	public void setParticipants(ArrayList<User> participants) {
		this.participants = participants;
	}
}
