package view;

import model.GoalKeeper;
import model.MainModel;

public class MainView {
	private MainModel model;
	
	public MainView(MainModel m) {
		this.model = m;
	}
	
	public void signInScreen() {
		System.out.println("--------------------------------");
		System.out.println("|  Fantasy Scotland, ver. 0.1  |");
		System.out.println("--------------------------------");
		System.out.println("Please Choose an Option");
		System.out.println("	1.	New User");
		System.out.println("	2.	Existing User");
		System.out.println("	3. Quit");
		System.out.println("--------------------------------");
	}
	
	public void signedInTeamName(){
		System.out.println("--------------------------------");
		System.out.println("Welcome To Fantasy Scotland");
		System.out.println("Please Choose a Team Name!");
		System.out.println("--------------------------------");
	}
	
	public void signedInChooseTeam(){
		System.out.println("--------------------------------");
		System.out.println("Welcome To Fantasy Scotland");
		System.out.println("Please Choose Your Players!");
		System.out.println("--------------------------------");
	}
	
	public void signedInChooseGK(){
		System.out.println("--------------------------------");
		System.out.println("Welcome to Fantasy Scotland");
		System.out.println("Please Choose a Main Goalkeeper");
		System.out.println("--------------------------------");
	}
	
	public void listGoalkeepers(){
		int i = 1;
		System.out.println("--------------------------------");
		System.out.println("Welcome to Fantasy Scotland");
		System.out.println("--------------------------------");
		System.out.println("---------GoalKeeper List--------");
		System.out.println("There are " + this.model.getPlayers().getGoalkeepers().size() + " goalkeepers.");
		for(GoalKeeper gk : this.model.getPlayers().getGoalkeepers()) {
			System.out.println(i++ +". : " + gk.getStats().getName());
		}
		System.out.println("--------------------------------");
	}
}
