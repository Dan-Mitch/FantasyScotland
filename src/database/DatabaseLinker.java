package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

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

	public String authenticateUser(String email, String pass) {
		String query = "SELECT id FROM users WHERE email='" + email + "' AND password = crypt('" + pass
				+ "', password)";
		String id = null;
		openConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				System.out.println("User exists on database...");
				id = result.getString("id");
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
