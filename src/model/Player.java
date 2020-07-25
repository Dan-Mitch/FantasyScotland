package model;

public class Player {
	private String name;
	private String role;
	private String nationality;
	
	private int price;
	private int points;
	private int goals;
	private int assists;
	private int yellowCards;
	private int redCards;
	private int ownGoals;
	
	
	private boolean isInjured;
	private boolean isCaptain;
	
	private Club club;
	
	public Player(String n, String r, String nat, int price) {
		this.name = n;
		this.role = r;
		this.nationality = nat;
		this.price = price;
		
	}
	
	public void calcualteScore() {
		
	}
	
	public void sellPlayer() {
		
	}
	
	public void buyPlayer() {
		
	}
	
	public void makeCaptain(){
		
	}
	
	public void demoteCaptain() {
		
	}
}
