package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Club;
import model.Player;

public class DatabaseLinker {
	private final String url = "jdbc:postgresql://217.39.223.45:5433/fantasyscotland";
	private final String username = "postgres";
	private final String password = "postgres";
	Connection connection = null;

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
	
	public void writeTeam(UUID team_id, String name, UUID owner_id) {
		String query1 = "INSERT INTO team_details (team_id, name) VALUES ('" + team_id + "', '" + name + "')";
		String query2 = "INSERT INTO teams (team_id, owner_id) VALUES ('" + team_id + "', '" + owner_id + "')";

		openConnection();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query1);
			statement.executeUpdate();
			statement = connection.prepareStatement(query2);
			statement.executeUpdate();
			System.out.println("Write to database successful...");
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
	
	public ArrayList<Player> loadPlayers() {
		String query = "SELECT * FROM players";
		ArrayList<Player> players = new ArrayList<Player>();
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				Player player = new Player();
				player.setPlayer_id(UUID.fromString(result.getString("player_id")));
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
	
	public ArrayList<Club> loadScores() {
		String query = "SELECT * FROM scores";
		ArrayList<Club> clubs = new ArrayList<Club>();
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseLinker.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			closeConnection();
		}
		return clubs;
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
