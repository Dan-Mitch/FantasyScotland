package controller;

import java.util.Scanner;

import model.MainModel;
import view.MainView;

public class MainController {

	private MainModel model;
	private MainView view;
	private Scanner systemInput = new Scanner(System.in);
	private int readInput;
	public MainController(MainModel m, MainView v) {
		this.model = m;
		this.view = v;
	}
	
	public void homeMenu() {
		
	}
	
	public void signedUpNewTeam() {
		
	}
	
	public static void main(String[] args) {
		MainModel m = new MainModel();
		MainController c = new MainController(m, new MainView(m));
		do {
			c.view.signInScreen();
			c.readInput = c.systemInput.nextInt();
			c.systemInput.nextLine();
			
			if(c.readInput == 1) {
				System.out.print("New Username:");
				String username = c.systemInput.nextLine();
				
				System.out.print(" New Password:");
				String pass = c.systemInput.nextLine();
				
				c.model.addNewUser(username, pass);
				
				//System.out.println(c.model.getUsers().get(0).getUsername());
			}
			
		}while(c.readInput != 4);
	}
}
