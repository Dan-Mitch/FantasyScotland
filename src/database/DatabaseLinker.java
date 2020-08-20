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
import model.Team;
import model.User;

public class DatabaseLinker {
	private final String url = "jdbc:postgresql://217.39.217.31:5433/fantasyscotland";
	private final String username = "postgres";
	private final String password = "postgres";
	Connection connection = null;
	ArrayList<Player> players = new ArrayList<Player>();
	public DatabaseLinker() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Could not load class " + "org.postgresql.Driver");
			e.printStackTrace();
			return;
		}
	}

	public void writeUser(String email, String pass) {
		String query = "INSERT INTO users (email, password) VALUES ('" + email + "', crypt('" + pass
				+ "', gen_salt('bf')))";
		openConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.executeUpdate();
			System.out.println("Write to database successful...");
		} catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	public void writeTeam(UUID team_id, UUID owner_id) {
		String query = "INSERT INTO teams (team_id, owner_id) VALUES ('" + team_id + "', '" + owner_id + "')";

		openConnection();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
			System.out.println("Write to database successful...");
		} catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	public void writeTeamDetails(UUID team_id, String name, double budget, UUID captain_id) {
		String query = "INSERT INTO team_details (team_id, name, budget, captain_id) VALUES ('" + team_id + "', '" + name + "', '" + budget + "', '" + captain_id + "')";

		openConnection();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
			System.out.println("Write to database successful...");
		} catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	public void writeTeamMembership(UUID team_id, UUID player_id, int round, int position) {
		String query = "INSERT INTO team_membership (team_id, player_id, round, position) VALUES ('" + team_id + "', '" + player_id  + "', '" + round + "', '" + position + "')";

		openConnection();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
			System.out.println("Write to database successful...");
		} catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	public void writeLeagueMembership(UUID league_id, UUID team_id, int score) {
		String query = "INSERT INTO league_membership (league_id, team_id, score) VALUES ('" + league_id + "', '" + team_id  + "', '" + score + "')";

		openConnection();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
			System.out.println("Write to database successful...");
		} catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
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

	public String authenticateUser(String email, String pass) {
		String query = "SELECT user_id FROM users WHERE email='" + email + "' AND password = crypt('" + pass
				+ "', password)";
		String id = null;
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				System.out.println("User exists on database...");
				id = result.getString("user_id");
			} else {
				System.out.println("User does not exist on database...");
			}
		} catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return id;
	}
	
	public String doesUserExist(String email) {
		String query = "SELECT user_id FROM users WHERE email='" + email + "';";
		String id = null;
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				System.out.println("User exists on database...");
				id = result.getString("user_id");
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
	
	public UUID doesTeamExist(String email) {
		String query = "SELECT t.team_id FROM users as u, teams as t WHERE t.owner_id=u.user_id AND u.email='" + email + "'";
		UUID team_id = null;
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				System.out.println("Team exists on database...");
				team_id = UUID.fromString(result.getString("team_id"));
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
	
	public boolean doesFixtureExist(int fixture_id) {
		String query = "SELECT * FROM fixtures as f WHERE f.fixture_id='" + fixture_id + "'";
		boolean b = false;
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				b = true;
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
	
	public boolean doesScoreExist(int fixture_id) {
		String query = "SELECT * FROM scores as s WHERE s.fixture_id='" + fixture_id + "'";
		boolean b = false;
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				b = true;
			} else {
				System.err.println("Score does not exist on database...");
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
	
	public boolean doesPlayerPointsExist(UUID player_id, int round) {
		String query = "SELECT * FROM players_weekly_scores as p WHERE p.player_id='" + player_id + "' AND p.round ='" + round + "'";
		boolean b = false;
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				b = true;
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
	
	public boolean doesTeamPointsExist(UUID team_id, int round) {
		String query = "SELECT * FROM teams_weekly_scores as t WHERE t.team_id='" + team_id + "' AND t.round ='" + round + "'";
		boolean b = false;
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				b = true;
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
	

	
	public boolean doesTeamMembershipExist(UUID team_id, UUID player_id, int round) {
		String query = "SELECT * FROM team_membership as t WHERE t.player_id='" + player_id + "' AND t.team_id= '" + team_id + "' AND t.round ='" + round + "'";
		boolean b = false;
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				b = true;
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
	
	public boolean doesTeamExist(UUID team_id, int round) {
		String query = "SELECT * FROM team_membership as t WHERE t.team_id='" + team_id + "' AND t.round ='" + round + "'";
		boolean b = false;
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				b = true;
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
				league.setMemberScores(this.loadMembers(league_id));
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
				team = new Team(user_id);
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return this.loadTeamDetails(team_id, team, round);
	}
	
	public HashMap<Integer, Player> loadSquad(UUID team_id, int round) {
		String query = "SELECT * FROM team_membership as t WHERE t.team_id='" + team_id +"' AND t.round='" + round + "' ORDER BY t.position";
		HashMap<Integer, Player> squad = new HashMap<Integer, Player>();
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				Player x = null;
				for(Player p : this.players) {
					if(p.getPlayer_id().equals(UUID.fromString(result.getString("player_id")))) {
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
				team.setSquad(this.loadSquad(team_id, round));
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
				System.err.println("no score found for player_id " + player_id + " and round = " +round);
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return score;
	}
	
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
	
	public void updateTeamMembership(UUID team_id, UUID player_id, int round, int position) {
		String query = "UPDATE team_membership SET player_id = '"  + player_id + "' WHERE team_id ='" + team_id + "' AND round ='" + round + "' AND position='" + position + "'";
		PreparedStatement statement;
		openConnection();
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
			System.out.println("Update to database successful...");
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	public void updateTeamPositions(UUID team_id, UUID player_id, int round, int position) {
		String query = "UPDATE team_membership SET position = '"  + position + "' WHERE team_id ='" + team_id + "' AND round ='" + round + "' AND player_id='" + player_id + "'";
		PreparedStatement statement;
		openConnection();
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
			System.out.println("Update to database successful...");
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	public void updateTeamDetails(UUID team_id, double transferBudget, UUID captain_id) {
		String query = "UPDATE team_details SET budget = '"  + transferBudget + "', captain_id ='" + captain_id + "' WHERE team_id ='" + team_id + "'";
		PreparedStatement statement;
		openConnection();
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
			System.out.println("Update to database successful...");
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		
	}
	
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
	
	public void setTransfer(UUID team_id, boolean transfer) {
		String query = "UPDATE team_details SET transfer = '" + transfer + "' WHERE team_id = '" + team_id + "'";
		PreparedStatement statement;
		openConnection();
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
			System.out.println("Update to database successful...");
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	public void setTransferAll(boolean transfer) {
		String query = "UPDATE team_details SET transfer = '" + transfer + "'";
		PreparedStatement statement;
		openConnection();
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
			System.out.println("Update to database successful...");
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
	}
	
	public int getRankInLeague(UUID league_id, UUID team_id) {
		int rank = 0;
		String query = "SELECT rank FROM(WITH my_ranks AS (SELECT league_membership.*, row_number() OVER (ORDER BY score DESC) AS rank FROM league_membership WHERE league_id = '" + league_id + "')SELECT * FROM my_ranks WHERE rank >= 1 AND rank <= 100000 ORDER BY rank ASC) AS board WHERE team_id ='" + team_id + "'";
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
