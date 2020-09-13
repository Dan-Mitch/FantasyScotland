package model;

import java.util.HashMap;
import java.util.UUID;

/**
 * This class is used as a data transfer object to hold data about different leagues stored in the database.
 * <p>
 * It is under developed due to the the lack of private league functionity, which was left out due to time restictions. Since only one league exists,
 * a lot of the functionality related to calcualting the rankings and scores of teams is handled by the main model.
 * In the future, this class should be developed further to include all features and functionlality.
 * @author d_mit
 *
 *
 */
public class League {
	private UUID league_id;
	private String name;
	private HashMap<UUID,Integer> memberScores; //will use Ranking object in future
	
//	public void calculateRankings() {
//	}
	
	//___________________GETTERS & SETTERS___________________

	/**
	 * 
	 * @return the name of the league
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
	 * @return the league_id
	 */
	public UUID getLeague_id() {
		return league_id;
	}

	/**
	 * 
	 * @param league_id the league_id to set
	 */
	public void setLeague_id(UUID league_id) {
		this.league_id = league_id;
	}
	
	/**
	 * @return the memberScores
	 */
	public HashMap<UUID,Integer> getMemberScores() {
		return memberScores;
	}

	/**
	 * @param memberScores the memberScores to set
	 */
	public void setMemberScores(HashMap<UUID,Integer> memberScores) {
		this.memberScores = memberScores;
	}
}