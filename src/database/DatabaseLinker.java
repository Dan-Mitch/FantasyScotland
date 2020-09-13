package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Club;
import model.League;
import model.Player;
import model.Ranking;
import model.Team;
import model.User;
/**
 * The DatabaseLinker class is the main class in the model for interacting with the 
 * database for the applciation. It contains all the logic for connecting to the 
 * remote database, as well as all the queries for selecting and updating tables.
 * @author d_mit
 *
 */
public class DatabaseLinker {
	
	private final String url = "jdbc:postgresql://217.35.237.101:5433/fantasyscotland"; //url address of the remote database
	private final String username = "postgres"; //username for the database
	private final String password = "V:w/DrK$Hk]6whbd"; // password for the database
	private Connection connection = null;
	private ArrayList<Player> players = new ArrayList<Player>(); //private copy of the players for the databaselinekr class to reference as it cannot see the main model.
	
	//___________________CONSTRUCTOR METHOD___________________
	
	/**
	 * The DatabaseLinker constructor immediately searches for the driver 
	 * postgresql driver, inluded in the dependencies.
	 */
	public DatabaseLinker() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Could not load class " + "org.postgresql.Driver");
			e.printStackTrace();
			return;
		}
	}
	
	//___________________INSERTING METHODS___________________
	
	/**
	 * This method is called when the user first registers an account with the application.
	 * <p>
	 * It stores the email address as a varchar(64) and encrpts the password with the bf hashing algorithm
	 * before storing it as a varchar(64) also.
	 * @param email validated email string 
	 * @param pass unencrypted string 
	 */
	public void writeUser(String email, String pass) {
		String query = "INSERT INTO users (email, password) VALUES ('" + email + "', crypt('" + pass
				+ "', gen_salt('bf')))";
		openConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	/**
	 * This method is the first of three methods that are called when the user has finished registering an account and has
	 * created a team with valid players and name.
	 * <p>
	 * This method writes to a database table called team_details. It stores the main 
	 * identifying and other miscellaneous information about a team.
	 * @param team_id the uuid of the team
	 * @param name the name of the team
	 * @param budget the remaining budget of the team after team creation
	 * @param captain_id the randomly selected uuid of a player in the team
	 */
	public void writeTeamDetails(UUID team_id, String name, double budget, UUID captain_id) {
		String query = "INSERT INTO team_details (team_id, name, budget, captain_id) VALUES ('" + team_id + "', '" + name + "', '" + budget + "', '" + captain_id + "')";

		openConnection();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	/**
	 * This method is the second of three methods that are called when the user has finished registering an account and has
	 * created a team with valid players and name.
	 * <p>
	 * The teams table the query stores the values to, is used to identify what team belongs to a particular user.
	 * @param team_id the uuid of the team
	 * @param owner_id the uuid of the owner(user)
	 */
	public void writeTeam(UUID team_id, UUID owner_id) {
		String query = "INSERT INTO teams (team_id, owner_id) VALUES ('" + team_id + "', '" + owner_id + "')";

		openConnection();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	/**
	 * This is the last of three methods that are called when the user has finished registering an account and has
	 * created a team with valid players and name. 
	 * <p>
	 * The method writes a tuple for each of the 15 players in a team, after each round has finished.
	 * It helps to assert who was a member of a team during a particular round, and is used to develop 
	 * a points history of a team.
	 * @param team_id the uuid of the team
	 * @param player_id the uuid of the player
	 * @param round an integer of the round, for indicating when the player was a part of that team
	 * @param position an integer for indicating what position the player played in for a round
	 */
	public void writeTeamMembership(UUID team_id, UUID player_id, int round, int position) {
		String query = "INSERT INTO team_membership (team_id, player_id, round, position) VALUES ('" + team_id + "', '" + player_id  + "', '" + round + "', '" + position + "')";

		openConnection();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	/**
	 * This method is called to register a team with a new league.
	 * <p>
	 * The method is called immediately after a user registers a team,
	 * as every team msut be registered to the Public League. Each time a 
	 * user new user registers, their score is set at 0. 
	 * @param league_id is the uuid of the league being joined
	 * @param team_id is the uuid of the team joining the league
	 * @param score the score of the team in the league (initially 0)
	 */
	public void writeLeagueMembership(UUID league_id, UUID team_id, int score) {
		String query = "INSERT INTO league_membership (league_id, team_id, score) VALUES ('" + league_id + "', '" + team_id  + "', '" + score + "')";

		openConnection();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	/**
	 * This method is used to store all the previous fixtures that have already been played.
	 * <p>
	 * This method is called at the beginning of the score building process.  This ensures that the score building does not repeat the
	 * process for fixtures that have already been dealt with.
	 * @param fixture_id the integer id of the fixture (same as API)
	 * @param round integer indicating when fixture took place
	 * @param home_club integer id of the home club that played in the fixture (same as API)
	 * @param away_club	integer id of the away club that played in the fixture (same as API)
	 */
	public void writeFixture(int fixture_id, int round, int home_club, int away_club) {
		String query = "INSERT INTO fixtures (fixture_id, round, home_club, away_club) VALUES ('" + fixture_id + "', '" + round  + "', '" + home_club  + "', '" + away_club + "')";
		openConnection();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	/**
	 * This method is called when those scores need to be stored. Once a fixture has been stored in its respective database table, all of the match data associated with 
	 * that fixture is compiled and turned a score card for each individual player that participated in that 
	 * fixture. 
	 * <p>
	 * The method is called as part of the score building process.
	 * @param round integer indicating what round the fixture took place
	 * @param player_id the uuid of the player who's score card it is
	 * @param goals integer indicating the number of goals the player scored
	 * @param assists integer indicating the number of assists the player had
	 * @param red_cards integer indicating the number of red cards the player had
	 * @param yellow_cards integer indicating the number of yellow cards the player had
	 * @param appearances integer indicating if the player appeared on the pitch, '1' if they played on the pitch, '0' if they stayed on the bench
	 * @param clean_sheets integer indicating the number of clean sheets the player had (only relevant to goalkeeper, defender and midfielders)
	 * @param concede_two integer indicating if the team had conceded more than two goals (only relevant to goalkeepers, defenders and midfielders)
	 * @param own_goals integer indicating the number of own goals the player had
	 * @param fixture_id integer id indicating what fixture the score was for
	 */
	public void writeScore(int round, UUID player_id, int goals, int assists, int red_cards, int yellow_cards, int appearances, int clean_sheets, int concede_two, int own_goals, int fixture_id) {
		String query = "INSERT INTO scores (round, player_id, goals, assists, red_cards, yellow_cards, appearances, clean_sheets, concede_two, own_goals, fixture_id) VALUES ('" + round + "', '" + player_id  + "', '" + goals  + "', '" + assists + "', '" + red_cards + "', '" + yellow_cards + "', '" + appearances + "', '" + clean_sheets + "', '" + concede_two + "', '" + own_goals + "', '" + fixture_id + "')";
		openConnection();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	/**
	 * This method stores the calculated total points from the score card and stores it in 
	 * a separate table. 
	 * <p>
	 * The method is called as part of the score builidng process.
	 * @param player_id the uuid of the player
	 * @param round an integer indicating the round the points were for 
	 * @param score an integer of the total points that round
	 */
	public void writePlayerPoints(UUID player_id, int round, int score) {
		String query = "INSERT INTO players_weekly_scores (player_id, round, score) VALUES ('" + player_id + "', '" + round  + "', '" + score + "')";
		openConnection();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	/**
	 * This mehtod stores the weekly score of the team in the database.
	 * <p>
	 * It is called from a seperate method in the main model that deals with compling the teams scores. This score would
	 * be an accumulation of the 11 players who were fielded during a round.
	 * @param team_id uuid of the team
	 * @param round integer indicating the round 
	 * @param score integer indicating the total points
	 */
	public void writeTeamPoints(UUID team_id, int round, int score) {
		String query = "INSERT INTO teams_weekly_scores (team_id, round, score) VALUES ('" + team_id + "', '" + round  + "', '" + score + "')";
		openConnection();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	//___________________SELECTING METHODS___________________

	/**
	 * This authentication method will check if a user exists on the database when logging in, before allowing them to access the
	 * whole application.
	 * <p>
	 * If the user is not registed, then a null id is returned and the user is denied access. If they are registed on the databse,
	 * then the assoaicted user id is returned and used to select and display data relevant to the user logging in. 
	 * @param email the email string entered by the user 
	 * @param pass the password entered by the user
	 * @return the uuid of the user
	 */
	public String authenticateUser(String email, String pass) {
		String query = "SELECT user_id FROM users WHERE email='" + email + "' AND password = crypt('" + pass
				+ "', password)";
		String id = null;
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) { //if user exists then retrieve their user_id
				id = result.getString("user_id");
				System.out.println("User " + email +  " exists on database...");
			} else {
				System.out.println("User does not exist on database..."); //id stays as null
			}
		} catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return id;
	}
	
	/**
	 * This method checks to see if a user exists on the database during user registration.
	 * <p>
	 * It is different from the authentication method used during login, because it only searches for the users
	 * email address. This method is used to avoid users registering the same email address twice and creating duplicate 
	 * entries. It returns the id of the user or null if not found.
	 * @param email the email adrress String of the user
	 * @return the user's uuid
	 */
	public String doesUserExist(String email) {
		String query = "SELECT user_id FROM users WHERE email='" + email + "';";
		String id = null;
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				id = result.getString("user_id");
				System.out.println("User " + email +  " exists on database...");
			} else {
				System.err.println("User does not exist on database...");
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return id;
	}
	
	/**
	 * Used to indicate wether a user has completed the team creation process and is called after a user has been
	 * authenticated for login.
	 * <p>
	 * This method was introduced for the situations where a user may be interupted when making their account and 
	 * team. It allows the user to create their team separately from their account and reduces any errors related to
	 * empty teams. 
	 * @param email the email address of the user
	 * @return the uuid of the user's registered team
	 */
	public UUID doesTeamExist(String email) {
		String query = "SELECT t.team_id FROM users as u, teams as t WHERE t.owner_id=u.user_id AND u.email='" + email + "'";
		UUID team_id = null;
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				team_id = UUID.fromString(result.getString("team_id"));
				System.out.println("Team " + team_id + " exists on database...");
			} else {
				System.err.println("Team does not exist on database...");
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return team_id;
	}
	
	/**
	 * This method is used when builidng the points history of a team.
	 * <p>
	 * It is called to check when a team was registered on the database. A user may register a team at any point in the season
	 * so it was important to check through each of the rounds, and determine at what point the team was made to display the correct information.
	 * @param team_id the uuid of the team 
	 * @param round the integer of the round that the team is being checked to have existed in
	 * @return a boolean indicating if the team was present in a particular round
	 */
	public boolean doesTeamExist(UUID team_id, int round) {
		String query = "SELECT * FROM team_membership as t WHERE t.team_id='" + team_id + "' AND t.round ='" + round + "'";
		boolean b = false;
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				b = true;
				System.err.println("Team " + team_id + " exists on database in round " + round);
			} else {
				System.err.println("Team does not exist on database in round " + round);
				b = false;
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return b;
	}
	
	/**
	 * Used in the score builidng process to ensure that the same fixture is not being recorded more than once.
	 * <p>
	 * It is called as a conditional check, directly before the fixture is wrote to the database.
	 * @param fixture_id the uuid of the fixture
	 * @return a boolean indicating if the fixture is present in the database or not
	 */
	public boolean doesFixtureExist(int fixture_id) {
		String query = "SELECT * FROM fixtures as f WHERE f.fixture_id='" + fixture_id + "'";
		boolean b = false;
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				b = true;
				System.err.println("Fixture " + fixture_id + " exists on database...");
			} else {
				System.err.println("Fixture does not exist on database...");
				b = false;
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return b;
	}
	
	/**
	 * Used in the score builidng process to ensure that the same score is not being recorded more than once.
	 * @param fixture_id the uuid of the fixture
	 * @return a boolean indicating if the score is present in the database or not
	 */
	public boolean doesScoreExist(int fixture_id) {
		String query = "SELECT * FROM scores as s WHERE s.fixture_id='" + fixture_id + "'";
		boolean b = false;
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				b = true;
				System.err.println("Score exists on database...");
			} else {
				System.err.println("Score does not exist on database...");
				b = false;
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			b = false;
		} finally {
			closeConnection();
		}
		return b;
	}
	
	/**
	 * Used in the score builidng process to ensure that the same player weekly points score is not being recorded more than once.
	 * @param player_id uuid of the player
	 * @param round integer indicating the round of the score
	 * @return a boolean indicating if the player points is present in the database or not during that round
	 */
	public boolean doesPlayerPointsExist(UUID player_id, int round) {
		String query = "SELECT * FROM players_weekly_scores as p WHERE p.player_id='" + player_id + "' AND p.round ='" + round + "'";
		boolean b = false;
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				b = true;
				System.err.println("Player " + player_id + " weekly score exists on database...");
			} else {
				System.err.println("Player weekly score does not exist on database...");
				b = false;
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return b;
	}
	
	/**
	 * Used in the score builidng process to ensure that the same team weekly points score is not being recorded more than once.
	 * @param team_id uuid of the team 
	 * @param round integer indicating the round of the score
	 * @return a boolean indicating if the team points is present in the database or not during that round
	 */
	public boolean doesTeamPointsExist(UUID team_id, int round) {
		String query = "SELECT * FROM teams_weekly_scores as t WHERE t.team_id='" + team_id + "' AND t.round ='" + round + "'";
		boolean b = false;
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				b = true;
				System.err.println("Team " + team_id + " weekly score exists on database...");
			} else {
				System.err.println("Team weekly score does not exist on database...");
				b = false;
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return b;
	}
	
	/**
	 * Used in the score builidng process to ensure that the same team membership is not being recorded more than once.
	 * @param team_id the uuid of the team 
	 * @param player_id the uuid of the player
	 * @param round an integer indicating the round in which the player was a part of that team
	 * @return a boolean indicating if the team membership is present in the database or not during that round
	 */
	public boolean doesTeamMembershipExist(UUID team_id, UUID player_id, int round) {
		String query = "SELECT * FROM team_membership as t WHERE t.player_id='" + player_id + "' AND t.team_id= '" + team_id + "' AND t.round ='" + round + "'";
		boolean b = false;
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				b = true;
				System.err.println("Team " + team_id + " membership exists on database...");
			} else {
				System.err.println("Team membership does not exist on database...");
				b = false;
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return b;
	}
	
	/**
	 * This method is called when a user tries to access the transfer page of the interface.
	 * <p>
	 * It checks the boolean transfer attribute of team details for a particular user. This is handled by the database 
	 * because individual users can choose to spend their transfer credit for their team at any point before a round begins.
	 * @param team_id the uuid of the team 
	 * @return a boolean indicating if the team is allowed to make a transfer or not
	 */
	public boolean isTransferOn(UUID team_id) {
		boolean transferOn = false;
		String query = "SELECT t.transfer FROM team_details as t WHERE team_id ='" + team_id + "'";
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				transferOn = result.getBoolean("transfer");
			}
			else {
				System.err.println("no boolean found");
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return transferOn;
	}
	
	/**
	 * This is an initialisation method that is called when the application first starts.
	 * <p>
	 * It selects and loads all of the users recorded on the database and stores them in an arraylist that is
	 * then used by the main model.
	 * @return an arraylist of all the users regisered on the database
	 */
	public ArrayList<User> loadUsers() {
		String query = "SELECT * FROM users";
		ArrayList<User> users = new ArrayList<User>();
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				User user = new User(result.getString("email"),UUID.fromString(result.getString("user_id")));
				users.add(user);
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return users;
	}
	
	//--------------------------------------------UNUSED-------------------------------------------
	
	/**
	 * This is an initialisation method that is called when the application first starts.
	 * <p>
	 * It selects and loads all of the public and private leagues recorded on the database and stores them in an arraylist that is
	 * then used by the main model.
	 * <p>
	 * As private leagues were not fully implmented in the final version, this method was unused but left in for future work.
	 * @return an arraylist of all the leagues created and regisered on the database
	 */
	public ArrayList<League> loadLeagues() {
		String query = "SELECT * FROM leagues";
		ArrayList<League> leagues = new ArrayList<League>();
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				League league = new League();
				league.setName(result.getString("name"));
				UUID league_id = UUID.fromString(result.getString("league_id"));
				league.setLeague_id(league_id);
				league.setMemberScores(this.loadMembers(league_id)); //separate method called for builidng
				leagues.add(league);
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return leagues;
	}
	
	/**
	 * This method is called as part of the initialsiation. It is called by the loadLeagues() method
	 * which loads each of participating memebers into the League objects.
	 * <p>
	 * It builds a HashMap of all the participating users and their current scores in that league.
	 * <p>
	 *  As private leagues were not fully implmented in the final version, this method was unused but left in for future work.
	 * @param league_id
	 * @return
	 */
	public HashMap<UUID,Integer> loadMembers(UUID league_id) {
		String query = "SELECT * FROM league_membership as l WHERE l.league_id='" + league_id +"';";
		HashMap<UUID,Integer> members = new HashMap<UUID,Integer>();
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				members.put(UUID.fromString(result.getString("team_id")), result.getInt("score"));
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return members;
	}
	
	//^^^^----------------------------------------UNUSED---------------------------------------^^^^
	
	/**
	 * This is an initialisation method that is called when the application first starts.
	 * <p>
	 * It selects and loads all of the players recorded on the database and stores them in an arraylist that is used by the databaselinker class,
	 * the arraylist is also returned for use in the main model.
	 * @return an arraylist of all the players stored in the database
	 */
	public ArrayList<Player> loadPlayers() {
		String query = "SELECT * FROM players";
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				Player player = new Player();
				UUID player_id = UUID.fromString(result.getString("player_id"));
				player.setPlayer_id(player_id);
				player.setName(result.getString("name"));
				player.setPosition(result.getString("position"));
				player.setPrice(result.getDouble("price"));
				player.setClub_id(Integer.parseInt(result.getString("club_id")));
				players.add(player);
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return players;
	}
	
	/**
	 * This is an initialisation method that is called when the application first starts.
	 * <p>
	 * It selects and loads all of the clubs recorded on the database and stores them in an arraylist that is
	 * then used by the main model.
	 * @return an arraylist of all the clubs stored in the database
	 */
	public ArrayList<Club> loadClubs() {
		String query = "SELECT * FROM clubs";
		ArrayList<Club> clubs = new ArrayList<Club>();
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				Club club = new Club();
				club.setClub_id(Integer.parseInt(result.getString("club_id")));
				club.setName(result.getString("name"));
				clubs.add(club);
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return clubs;
	}
	
	/**
	 * This method is the first of three methods that are called by the model to return all infomration about a team. It is called when the user
	 * logs in and when writing team scores.
	 * <p>
	 * This method simply searches the teams table for a user's team's team_id before using that id to make another call to other database
	 * methods that return further data. It creates an empty team object and passes it to the loadTeamDetails() method.
	 * @param user_id the uuid of the user
	 * @param round an integer of the previous round in which the team was last stored
	 * @return a Team object
	 */
	public Team loadTeam(UUID user_id, int round) {
		String query = "SELECT * FROM teams as t WHERE t.owner_id ='" + user_id + "';";
		Team team = null;
		UUID team_id = null;
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				team_id = UUID.fromString(result.getString("team_id"));
				team = new Team(user_id); //creates a new empty team object and sets the user_id
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return this.loadTeamDetails(team_id, team, round); //passes team_id, new team object with set user_id and round param
	}
	
	/**
	 * This is the second method called when returning team information.
	 * <p>
	 * This method helps to collect the other identifying information such as the name, remaining budget, captain's id and trasfer boolean, it uses the team_id from loadTeam() to search the 
	 * team_details table.
	 * @param team_id uuid of the team
	 * @param team the newly instantiated team object passed from loadTeam()
	 * @param round an integer of the previous round in which the team was last stored
	 * @return a Team object
	 */
	public Team loadTeamDetails(UUID team_id, Team team, int round) {
		String query = "SELECT * FROM team_details as t WHERE t.team_id ='" + team_id + "'";
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				team.setName(result.getString("name"));
				team.setTeam_id(team_id);
				team.setTransferBudget(result.getDouble("budget"));
				team.setSquad(this.loadSquad(team_id, round)); //calls another method to build hashmap
				team.setCaptain(UUID.fromString(result.getString("captain_id")));
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return team;
	}
	
	/**
	 * This is the last of three methods called when returning team information.
	 * <p>
	 * It searches through the team membership table using the team_id and the latest round integer
	 * to build an hashmap of the most up to date squad for a team, with each of their associated positions.
	 * @param team_id the uuid of the team 
	 * @param round an integer of the previous round in which the team was last stored
	 * @return a HashMap with 15 players and their associated positions in the team at that round
	 */
	public HashMap<Integer, Player> loadSquad(UUID team_id, int round) {
		String query = "SELECT * FROM team_membership as t WHERE t.team_id='" + team_id +"' AND t.round='" + round + "' ORDER BY t.position";
		HashMap<Integer, Player> squad = new HashMap<Integer, Player>();
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				Player x = null;
				for(Player p : this.players) { //uses the local player arraylist stored in databaselinker class (this)
					if(p.getPlayer_id().equals(UUID.fromString(result.getString("player_id")))) { //if player exists
						x = p;
					}
				}
				int position = result.getInt("position");
				squad.put(position, x);
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return squad;
	}
	
	/**
	 * This method is used to help build the points history. It is called to return the score a player attained 
	 * during a particular week.
	 * @param player_id the uuid of the player
	 * @param round an integer indicating from what round the score should be returned for
	 * @return the total score of the player from a particular round
	 */
	public int getPlayerScoreIn(UUID player_id, int round) {
		int score = 0;
		String query = "SELECT * FROM players_weekly_scores as p WHERE p.player_id ='" + player_id + "' AND p.round ='" + round + "'";
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if(result.next()) {
				score = result.getInt("score");
			}
			else {
				System.err.println("No score found for player_id " + player_id + " in round = " +round);
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return score;
	}
	
	/**
	 * This method is also called as part of the team score building process in the model after the schedule update.
	 * <p>
	 * The method compilies all of the individual player scores in the player_weekly_scores table and calculates a total.
	 * @param team_id the uuid of the team 
	 * @param round the round integer the score is being calucalted for
	 * @return the total weekly score integer for the team that round
	 */
	public int calculateTeamScore(UUID team_id, int round) {
		int weeklyScore = 0;
		String query = "SELECT SUM(p.score) FROM players_weekly_scores as p WHERE p.round ='" + round + "' AND p.player_id IN (SELECT t.player_id FROM team_membership as t WHERE round ='" + (round-1) + "' AND t.team_id ='" + team_id + "' ORDER BY t.position LIMIT 11)";
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if(result.next()) {
				weeklyScore = result.getInt("sum");
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return weeklyScore;
	}	
	
	/**
	 * This method is called as part of the team score builidng. It is used to fetch the previously recorded league score
	 * so it can be appended with the latest team score.
	 * <p>
	 * A user could join a league at any time and have different scores for each one.
	 * @param team_id the uuid of the team
	 * @return a HashMap of the previously recorded scores for a team participating in different leagues
	 */
	public HashMap<UUID, Integer> getPreviousLeagueScores(UUID team_id ){
		HashMap<UUID, Integer> scores = new HashMap<UUID, Integer>();
		String query = "SELECT * FROM league_membership WHERE team_id='" + team_id + "'";
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				scores.put(UUID.fromString(result.getString("league_id")), result.getInt("score"));
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return scores;
	}
	
	/**
	 * This method returns the postion of a team in a particular league.
	 * <p>
	 * This information is displayed on the HomeScreen
	 * @param league_id the uuid of the league 
	 * @param team_id the uuid of the team
	 * @return the ranked position of a team in a league table
	 */
	public int getRankInLeague(UUID league_id, UUID team_id) {
		int rank = 0;
		String query = "SELECT rank FROM(WITH ranks AS (SELECT league_membership.*, row_number() OVER (ORDER BY score DESC) AS rank FROM league_membership WHERE league_id = '" + league_id + "')SELECT * FROM ranks WHERE rank >= 1 AND rank <= 100000 ORDER BY rank ASC) AS board WHERE team_id ='" + team_id + "'"; 
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				rank = result.getInt("rank");
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return rank;
	}
	
	/**
	 * This method is used for returning the the full ranked leaderboard of the Global public league.
	 * <p>
	 * It is used to display the full leaderboard implemented into the LeagueScreeen.
	 * @return an arraylist of all all the rankings for the players in the public league.
	 */
	public ArrayList<Ranking> getPublicRankings() {
		ArrayList<Ranking> rankings = new ArrayList<Ranking>();
		String query ="WITH ranks AS (SELECT t.name, t.team_id, l.score, row_number() OVER (ORDER BY score DESC) AS rank FROM league_membership as l, team_details as t WHERE l.league_id = '3573e359-7c59-4d43-90c9-52d3ba04a66e' AND t.team_id = l.team_id)SELECT * FROM ranks WHERE rank >= 1 AND rank <= 10000000 ORDER BY rank ASC";
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				Ranking ranking = new Ranking();
				ranking.setRank(result.getInt("rank"));
				ranking.setScore(result.getInt("score"));
				ranking.setTeamName(result.getString("name"));
				ranking.setTeam_id(UUID.fromString(result.getString("team_id")));
				rankings.add(ranking);
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return rankings;
	}
	
	/**
	 * This method is used for calculating and displaying the average score of all the teams
	 * in the Global public league.
	 * <p>
	 * This infomartion is dispalyed on the HomeScreen.
	 * @return integer of average score in public league
	 */
	public int getGlobalAverage() {
		int globalAverage = 0;
		String query = "SELECT CAST(AVG(NULLIF(l.score,0)) AS DECIMAL(10,1)) FROM league_membership as l WHERE l.league_id = '3573e359-7c59-4d43-90c9-52d3ba04a66e'";
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				globalAverage = result.getInt("avg");
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return globalAverage;
	}
	
	/**
	 * This method is used for calculating and displaying the highest score of all the teams
	 * in the Global public league.
	 * <p>
	 * This infomartion is dispalyed on the HomeScreen.
	 * @return integer of highest score in public league
	 */
	public int getGlobalMax() {
		int globalMax = 0;
		String query = "SELECT CAST(MAX(l.score) AS DECIMAL(10,1)) FROM league_membership as l WHERE l.league_id = '3573e359-7c59-4d43-90c9-52d3ba04a66e'";
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				globalMax = result.getInt("max");
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return globalMax;
	}
	
	/**
	 * This method returns the all time total score for a particular team.
	 * <p>
	 * It is called when the user logs in, and is displayed on the HomeScreen.
	 * @param team_id uuid of the team
	 * @return integer of total score in public league for a particular team
	 */
	public int getTeamTotal(UUID team_id) {
		int teamTotal = 0;
		String query = "SELECT CAST(SUM(t.score) AS DECIMAL(10,1)) FROM teams_weekly_scores as t WHERE t.team_id ='" + team_id + "'";
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				teamTotal= result.getInt("sum");
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return teamTotal;
	}
	
	//___________________UPDATING METHODS___________________
	
	/**
	 * This method is called when a user decides to update their team by making a transfer from the TransferScreen. The user selects a player
	 * to swap out and another to swap in. Since this happens between rounds, an update must be made to the table using the current round integer.
	 * @param team_id uuid of the team 
	 * @param player_id uuid of the player being transfered in
	 * @param round the integer of the current round
	 * @param position the position integer of the player being swapped out
	 */
	public void updateTeamMembership(UUID team_id, UUID player_id, int round, int position) {
		String query = "UPDATE team_membership SET player_id = '"  + player_id + "' WHERE team_id ='" + team_id + "' AND round ='" + round + "' AND position='" + position + "'";
		PreparedStatement statement;
		openConnection();
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	/**
	 * This method is called when a user decides they want to manage their team of existing players. No
	 * new players are introduced into the team but instead the positions are changed around as substitions are made.
	 * @param team_id uuid of the team being managed
	 * @param player_id uuid of the players being substituted
	 * @param round the integer of the current round
	 * @param position the position integer of the player being substituted
	 */
	public void updateTeamPositions(UUID team_id, UUID player_id, int round, int position) {
		String query = "UPDATE team_membership SET position = '"  + position + "' WHERE team_id ='" + team_id + "' AND round ='" + round + "' AND player_id='" + player_id + "'";
		PreparedStatement statement;
		openConnection();
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	/**
	 * This method is called when a user decided to either make a transfer or manage their team.
	 * <p>
	 * It is used in the manage screen to store any changes made to the selected captain and in the transfer screen
	 * to update any changes to the transfer budget from new players brought in.
	 * @param team_id the uuid of the team
	 * @param transferBudget the remaining transfer budget of the team
	 * @param captain_id the uuid of the teams captain
	 */
	public void updateTeamDetails(UUID team_id, double transferBudget, UUID captain_id) {
		String query = "UPDATE team_details SET budget = '"  + transferBudget + "', captain_id ='" + captain_id + "' WHERE team_id ='" + team_id + "'";
		PreparedStatement statement;
		openConnection();
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	/**
	 * This method is called in the team score building process, after the team scores for the current round have been comiled, and
	 * the previous league score has been fetched. The model calucaltes a new score and then calls this method to update.
	 * @param league_id the uuid of the league
	 * @param team_id the uuid of the team
	 * @param score the newly calculated score for a team in a league
	 */
	public void updateLeagueScore(UUID league_id, UUID team_id, int score) {
		String query = "UPDATE league_membership SET score ='" + score + "' WHERE league_id='" + league_id + "' AND team_id='" + team_id + "'";
		openConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	/**
	 * This method is called when a user has finished making a transfer. As each team is only allowed
	 * to make one transfer between rounds, the transfer boolean is set to false so no more transfers
	 * can be made till the next round commences.
	 * @param team_id the uuid of the team 
	 * @param transfer a boolean for permitting transfer activity 
	 */
	public void setTransfer(UUID team_id, boolean transfer) {
		String query = "UPDATE team_details SET transfer = '" + transfer + "' WHERE team_id = '" + team_id + "'";
		PreparedStatement statement;
		openConnection();
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	/**
	 * This method is called by the scheduleBlock and scheduleUpdate methods in the model when a round of fixtures has started or finished, respectively.
	 * <p>
	 * Depending on wether the round has started or finished, the transfer boolean for all teams in the database is set to false to deny transfer activity, or to true to enable it.
	 * @param transfer a boolean for permitting or deny transfer activity
	 */
	public void setTransferAll(boolean transfer) {
		String query = "UPDATE team_details SET transfer = '" + transfer + "'";
		PreparedStatement statement;
		openConnection();
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	//___________________CONNECTION METHODS___________________
	
	private void openConnection() {
		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection to database successful...");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void closeConnection() {
		try {
			connection.close();
			System.out.println("Disconnection from database successful...");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}