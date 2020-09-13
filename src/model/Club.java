package model;

/**
 * This class acts as a data transfer object for Club tuples in the database.
 * @author d_mit
 *
 */
public class Club {
	private int club_id;
	private String name;

	//___________________GETTERS & SETTERS___________________
	
	/**
	 * This method returns the integer id of the club.
	 * @return the integer id of the club
	 */
	public int getClub_id() {
		return club_id;
	}

	/**
	 * This method sets the integer id of the club.
	 * @param club_id the integer id of the club
	 */
	public void setClub_id(int club_id) {
		this.club_id = club_id;
	}

	/**
	 * This method returns the String name of the club.
	 * @return the name of the club
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the String name of the club.
	 * @param name the name of the club
	 */
	public void setName(String name) {
		this.name = name;
	}
}