package model;

public class User {
	private String username;
	private Team team;
	
	public User(String un, String pw) {
		this.username = un;
		createTeam();
	}
	
	public void createTeam() {
		this.team = new Team(this);
	}
	
	public void loadTeam() {
		
	}
	
	public void addPlayerToTeam(Player p) {
		try {
			this.team.addPlayer(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getUsername() {
		return username;
	}
}
