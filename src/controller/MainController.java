package controller;

import model.MainModel;
import view.MainView;

public class MainController {

	private MainModel model;
	private MainView view;
	
	public MainController(MainModel m, MainView v) {
		this.model = m;
		this.view = v;
	}
	
	public static void main(String[] args) {
		MainModel m = new MainModel();
		MainController c = new MainController(m, new MainView(m));
		c.view.listGoalkeepers();
	}
}
