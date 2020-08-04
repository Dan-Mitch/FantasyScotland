package model;

import java.util.UUID;

public class Club {
	private UUID club_id;
	private String name;

	public Club() {
		
	}

	public UUID getClub_id() {
		return club_id;
	}

	public void setClub_id(UUID club_id) {
		this.club_id = club_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}


