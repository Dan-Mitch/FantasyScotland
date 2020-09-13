package model;

import java.util.UUID;

/**
 * This class acts as a data transfer object for the Player objects in the database.
 * @author d_mit
 *
 */
public class Player{
	private UUID player_id;
	private String name;
	private String position; //either Forward, Midfielder, Defender or Goalkeeper
	private double price;
	private int club_id;
	
	//___________________GETTERS & SETTERS___________________
	
	/**
	 * 
	 * @return player_id
	 */
	public UUID getPlayer_id() {
		return player_id;
	}

	/**
	 * 
	 * @param player_id the player_id to set
	 */
	public void setPlayer_id(UUID player_id) {
		this.player_id = player_id;
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * 
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * 
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * 
	 * @return club_id
	 */
	public int getClub_id() {
		return club_id;
	}

	/**
	 * 
	 * @param club_id the club_id to set
	 */
	public void setClub_id(int club_id) {
		this.club_id = club_id;
	}	
}