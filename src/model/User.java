package model;

public class User {
	private String email;
	private String id;
	private Team team;
	
	public User(String e, String id) {
		this.email = e;
		this.id = id;
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
}
