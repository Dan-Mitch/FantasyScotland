package model;

public class User {
	private String username;
	private String password;
	private Team team;
	
	public User(String un, String pw) {
		this.username = un;
		this.password = pw;
		createTeam();
	}
	
	public void createTeam() {
		this.team = new Team(this);
	}
	
	public void addPlayerToTeam(Player p) {
		try {
			this.team.addPlayer(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
