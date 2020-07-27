package model;

public class User {
	private String username;
	private String password;
	private Team team;
	
	public User(String un, String pw) {
		this.username = un;
		this.password = pw;
		chooseTeam();
	}
	
	public void chooseTeam() {
		this.team = new Team();
	}
}
